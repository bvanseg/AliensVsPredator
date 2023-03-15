package org.avp.common.entity;

import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.avp.client.KeybindHandler;
import org.avp.common.AVPItems;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketFireAPC;

import java.util.List;

public class EntityAPC extends Entity
{
    private static final DataParameter<Integer> TIME_SINCE_HIT    = EntityDataManager.<Integer>createKey(EntityAPC.class, DataSerializers.VARINT);
    private static final DataParameter<Integer> FORWARD_DIRECTION = EntityDataManager.<Integer>createKey(EntityAPC.class, DataSerializers.VARINT);
    private static final DataParameter<Float>   DAMAGE_TAKEN      = EntityDataManager.<Float>createKey(EntityAPC.class, DataSerializers.FLOAT);
    private double                              speedMultiplier;

    @SideOnly(Side.CLIENT)
    private double                              velocityX;
    @SideOnly(Side.CLIENT)
    private double                              velocityY;
    @SideOnly(Side.CLIENT)
    private double                              velocityZ;
    private float                               tireRotation;
    private double                              tireSpinDirection = 1;
    private boolean                             accellerating     = false;
    private boolean                             reverse           = false;

    public EntityAPC(World worldIn)
    {
        super(worldIn);
        this.speedMultiplier = 0D;
        this.preventEntitySpawning = true;
        this.setSize(3F, 2F);
        this.ignoreFrustumCheck = true;
        this.stepHeight = 1.0F;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return true;
    }

    @Override
    protected void entityInit()
    {
        this.getDataManager().register(TIME_SINCE_HIT, 0);
        this.getDataManager().register(FORWARD_DIRECTION, 1);
        this.getDataManager().register(DAMAGE_TAKEN, 0F);
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entityIn)
    {
        return entityIn.getEntityBoundingBox();
    }

    @Override
    public boolean canBePushed()
    {
        return true;
    }

    public EntityAPC(World worldIn, double x, double y, double z)
    {
        this(worldIn);
        this.setPosition(x, y, z);
        this.motionX = 0.0D;
        this.motionY = 0.0D;
        this.motionZ = 0.0D;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
    }

    @Override
    public double getMountedYOffset()
    {
        return super.getMountedYOffset() + 0.5F;
    }

    @Override
    public void updatePassenger(Entity passenger)
    {
        if (this.isPassenger(passenger))
        {
            double distance = 0;
            double rotationYawRadians = Math.toRadians(this.rotationYaw);
            double driverX = (this.posX + (distance * (Math.cos(rotationYawRadians))));
            double driverZ = (this.posZ + (distance * (Math.sin(rotationYawRadians))));
            passenger.setPosition(driverX, this.posY + this.getMountedYOffset() + passenger.getYOffset(), driverZ);
        }
    }

    @Override
    public boolean attackEntityFrom(DamageSource dmgSource, float f)
    {
        if (this.isEntityInvulnerable(dmgSource))
        {
            return false;
        }
        else if (!this.world.isRemote && !this.isDead)
        {
            this.setForwardDirection(-this.getForwardDirection());
            this.setTimeSinceHit(10);
            this.setDamageTaken(this.getDamageTaken() + f * 10.0F);
            this.markVelocityChanged();
            boolean flag = dmgSource.getTrueSource() instanceof EntityPlayer && ((EntityPlayer) dmgSource.getTrueSource()).capabilities.isCreativeMode;

            if (flag || this.getDamageTaken() > 200.0F)
            {
                if (Entities.getEntityRiddenBy(this) != null)
                {
                    Entities.getEntityRiddenBy(this).startRiding(this);
                }

                if (!flag)
                {
                    this.dropItemWithOffset(AVPItems.ITEM_APC, 1, 0.0F);
                }

                this.setDead();
            }

            return true;
        }
        else
        {
            return true;
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void performHurtAnimation()
    {
        this.setForwardDirection(-this.getForwardDirection());
        this.setTimeSinceHit(10);
        this.setDamageTaken(this.getDamageTaken() * 11.0F);
    }

    @Override
    public boolean canBeCollidedWith()
    {
        return true;
    }

    @Override
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport)
    {
        if (this.isBeingRidden())
        {
            double rX = posX - this.posX;
            double rY = posY - this.posY;
            double rZ = posZ - this.posZ;
            double v = rX * rX + rY * rY + rZ * rZ;

            if (v <= 1.0D)
            {
                return;
            }
        }

        this.motionX = this.velocityX;
        this.motionY = this.velocityY;
        this.motionZ = this.velocityZ;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double x, double y, double z)
    {
        this.velocityX = this.motionX = x;
        this.velocityY = this.motionY = y;
        this.velocityZ = this.motionZ = z;
    }

    @SideOnly(Side.CLIENT)
    private void handleKeybindAction()
    {
        if (this.world.isRemote)
        {
            if (Game.minecraft().player.isRiding() && Game.minecraft().player.getRidingEntity() instanceof EntityAPC)
            {
                if (KeybindHandler.instance.specialPrimary.isPressed())
                {
                    AVPNetworking.instance.sendToServer(new PacketFireAPC());
                }
            }
        }
    }

    public enum Gear
    {
        GEAR1(0.15D), GEAR2(0.2D), GEAR3(0.3D), GEAR4(0.45D);

        public double maxSpeed = 0D;

        Gear(double maxSpeed)
        {
            this.maxSpeed = maxSpeed;
        }

        public double getMaxSpeed()
        {
            return maxSpeed;
        }

        public static Gear forVelocity(double v)
        {
            if (v > 0.2 && v < 0.37)
                return Gear.GEAR2;

            if (v > 0.37 && v < 0.55)
                return Gear.GEAR3;

            if (v > 0.55)
                return Gear.GEAR4;

            return GEAR1;
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        this.fallDistance = 0;
        
        if (this.world.isRemote)
        {
            this.handleKeybindAction();
        }

        if (this.getTimeSinceHit() > 0)
        {
            this.setTimeSinceHit(this.getTimeSinceHit() - 1);
        }

        if (this.getDamageTaken() > 0.0F)
        {
            this.setDamageTaken(this.getDamageTaken() - 1.0F);
        }

        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        double mass = -0.3D;
        double curVelocity = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
        double velocity1;
        double addedRotation;
        double prevPosX;
        double prevPosZ;

        if (mass < 1.0D)
        {
            velocity1 = mass * 2.0D - 1.0D;
            this.motionY += 0.03999999910593033D * velocity1;
        }
        else
        {
            if (this.motionY < 0.0D)
            {
                this.motionY /= 2.0D;
            }

            this.motionY += 0.007000000216066837D;
        }

        EntityLivingBase driver = (EntityLivingBase) Entities.getEntityRiddenBy(this);

        if (driver instanceof EntityLivingBase)
        {
            if (driver != null)
            {
                accellerating = driver.moveForward > 0.1;
                reverse = driver.moveForward < -0.1;
            }

            double maxAcceleration = Gear.forVelocity(Math.abs(curVelocity)).getMaxSpeed();
            double decelerationRate = 0.02D;
            double accelerationRate = 0.02D;

            if (curVelocity < 0.6)
            {
                decelerationRate = 0.006D;
            }

            if (curVelocity < 0.2)
            {
                decelerationRate = 0.01D;
            }

            if (reverse)
            {
                decelerationRate = 0.02D;
                maxAcceleration = 0.15D;
            }

            switch (Gear.forVelocity(Math.abs(curVelocity)))
            {
                case GEAR2:
                    accelerationRate = 0.01D;
                    break;
                case GEAR3:
                    accelerationRate = 0.003D;
                    break;
                case GEAR4:
                    accelerationRate = 0.006D;
                    break;
                default:
                    break;
            }

            boolean decellerating = false;

            if (accellerating)
            {
                if (this.speedMultiplier < maxAcceleration)
                {
                    this.speedMultiplier += accelerationRate;
                }
            }
            else if (reverse)
            {
                if (this.speedMultiplier > -maxAcceleration)
                {
                    this.speedMultiplier -= decelerationRate;
                }
            }
            else if (speedMultiplier > 0)
            {
                speedMultiplier -= decelerationRate;
                decellerating = true;
            }
            else if (speedMultiplier < 0)
            {
                speedMultiplier = 0F;
            }

            if (this.world.isRemote)
            {
                if (driver != null)
                {
                    if (driver.moveForward == 0)
                    {
                        tireSpinDirection = 1;
                    }
                    else
                    {
                        if (decellerating)
                        {
                            tireSpinDirection = Math.abs(driver.moveForward);
                        }
                        else
                        {
                            tireSpinDirection = -driver.moveForward;
                        }
                    }
                }

                this.tireRotation += Math.round(Math.abs(curVelocity) * 100) * tireSpinDirection;
                this.tireRotation = tireRotation % 360;
            }

            float mov = this.rotationYaw + 90;

            this.motionX += -Math.sin((double) (mov * (float) Math.PI / 180.0F)) * this.speedMultiplier;
            this.motionZ += Math.cos((double) (mov * (float) Math.PI / 180.0F)) * this.speedMultiplier;

            float baseTurnAcc = 10F;
            float turnAcceleration = curVelocity < 0.25 ? baseTurnAcc : baseTurnAcc / 1.5F;
            float turnSpeed = (float) (curVelocity * turnAcceleration);

            if (driver.moveStrafing > 0)
            {
                // LEFT
                this.rotationYaw = this.rotationYaw + (reverse ? +turnSpeed : -turnSpeed);
            }
            else if (driver.moveStrafing < 0)
            {
                // RIGHT
                this.rotationYaw = this.rotationYaw + (reverse ? -turnSpeed : +turnSpeed);
            }
        }
        else
        {
            ;
        }

        velocity1 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);

//        if (Entities.getEntityRiddenBy(this) == null)
//        {
//            this.motionX = 0;
//            this.motionY = 0;
//            this.motionZ = 0;
//        }
        
        this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.65D;
        this.motionY *= 0.94D;
        this.motionZ *= 0.65D;

        this.rotationPitch = 0.0F;
        addedRotation = (double) this.rotationYaw;
        prevPosX = this.prevPosX - this.posX;
        prevPosZ = this.prevPosZ - this.posZ;

        if (prevPosX * prevPosX + prevPosZ * prevPosZ > 0.001D)
        {
            addedRotation = (double) ((float) (Math.atan2(prevPosZ, prevPosX) * 180.0D / Math.PI));
        }

        double rotation = MathHelper.wrapDegrees(addedRotation - (double) this.rotationYaw);
        double rotIncr = 15.0D * Math.sqrt(motionX * motionX + motionZ * motionZ);

        if (rotation > rotIncr)
        {
            rotation = rotIncr;
        }

        if (rotation < -rotIncr)
        {
            rotation = -rotIncr;
        }

        this.setRotation(this.rotationYaw, this.rotationPitch);

        if (!this.world.isRemote)
        {
            List list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(1D, 0.0D, 1D));

            if (list != null && !list.isEmpty())
            {
                for (int k1 = 0; k1 < list.size(); ++k1)
                {
                    Entity entity = (Entity) list.get(k1);

                    if (entity != driver)
                    {
                        float hitDamage = (float) (40F * curVelocity);
                        entity.attackEntityFrom(DamageSource.GENERIC, hitDamage);
                    }

                    if (entity != Entities.getEntityRiddenBy(this) && entity.canBePushed() && entity instanceof EntityAPC)
                    {
                        entity.applyEntityCollision(this);
                    }
                }
            }
        }
    }

    @Override
    public void updateRidden()
    {
        super.updateRidden();

        if (Entities.getEntityRiddenBy(this) != null)
        {
            double oX = Math.cos((double) this.rotationYaw * Math.PI / 180.0D) * 0.4D;
            double oZ = Math.sin((double) this.rotationYaw * Math.PI / 180.0D) * 0.4D;
            Entities.getEntityRiddenBy(this).setPosition(this.posX + oX - 2.5F, this.posY + this.getMountedYOffset() + Entities.getEntityRiddenBy(this).getYOffset(), this.posZ + oZ + 0.25F);

            if (this.world.isRemote && Entities.getEntityRiddenBy(this) instanceof EntityPlayer)
            {
                if (Game.minecraft().gameSettings.thirdPersonView == 0)
                {
                    if (Game.minecraft().player == Entities.getEntityRiddenBy(this))
                    {
                        Game.minecraft().gameSettings.thirdPersonView = 1;
                    }
                }
            }
        }
    }

    @Override
    public float getCollisionBorderSize()
    {
        return 0F;
    }

    @Override
    public boolean processInitialInteract(EntityPlayer player, EnumHand hand)
    {
        if (Entities.getEntityRiddenBy(this) != null && Entities.getEntityRiddenBy(this) instanceof EntityPlayer && Entities.getEntityRiddenBy(this) != player)
        {
            return true;
        }
        else
        {
            if (!this.world.isRemote)
            {
                player.startRiding(this);
            }
            return true;
        }
    }

    @Override
    protected void updateFallState(double distanceFallenThisTick, boolean onGround, IBlockState state, BlockPos pos)
    {
        int x = MathHelper.floor(this.posX);
        int y = MathHelper.floor(this.posY);
        int z = MathHelper.floor(this.posZ);

        if (onGround)
        {
            if (this.fallDistance > 3.0F)
            {
                this.fall(this.fallDistance, 1F);

                if (!this.world.isRemote && !this.isDead)
                {
                    this.setDead();
                }

                this.fallDistance = 0.0F;
            }
        }
        else if (this.world.getBlockState(new BlockPos(x, y - 1, z)).getMaterial() != Material.WATER && distanceFallenThisTick < 0.0D)
        {
            this.fallDistance = (float) ((double) this.fallDistance - distanceFallenThisTick);
        }
    }

    public void setDamageTaken(float damage)
    {
        this.getDataManager().set(DAMAGE_TAKEN, damage);
    }

    public float getDamageTaken()
    {
        return this.getDataManager().get(DAMAGE_TAKEN);
    }

    public void setTimeSinceHit(int time)
    {
        this.getDataManager().set(TIME_SINCE_HIT, time);
    }

    public int getTimeSinceHit()
    {
        return this.getDataManager().get(TIME_SINCE_HIT);
    }

    public void setForwardDirection(int direction)
    {
        this.getDataManager().set(FORWARD_DIRECTION, direction);
    }

    public int getForwardDirection()
    {
        return this.getDataManager().get(FORWARD_DIRECTION);
    }

    public double getSpeedMultiplier()
    {
        return speedMultiplier;
    }

    public float getTireRotation()
    {
        return this.tireRotation;
    }

    public EntityLivingBase getDriver()
    {
        return (EntityLivingBase) Entities.getEntityRiddenBy(this);
    }

    public boolean isAccelerating()
    {
        return this.accellerating;
    }

    public boolean isReversing()
    {
        return this.reverse;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound compound)
    {
        ;
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound compound)
    {
        ;
    }
}
