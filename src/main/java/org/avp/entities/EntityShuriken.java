package org.avp.entities;

import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;

import com.arisux.mdx.lib.game.GameSounds;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;

public class EntityShuriken extends Entity
{
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private Block inTile = Blocks.AIR;
    private boolean inGround = false;
    public boolean doesArrowBelongToPlayer = false;
    public int arrowShake = 0;
    public Entity shootingEntity;
    private int ticksInGround;
    private int ticksInAir = 0;
    public boolean arrowCritical = false;

    public EntityShuriken(World world)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
    }

    public EntityShuriken(World world, double posX, double posY, double posZ)
    {
        super(world);
        this.setSize(0.5F, 0.5F);
        this.setPosition(posX, posY, posZ);
    }

    public EntityShuriken(World world, EntityLivingBase entityliving, float velocity)
    {
        super(world);
        this.shootingEntity = entityliving;
        this.doesArrowBelongToPlayer = entityliving instanceof EntityPlayer;
        this.setSize(0.5F, 0.5F);
        this.setLocationAndAngles(entityliving.posX, entityliving.posY + entityliving.getEyeHeight(), entityliving.posZ, entityliving.rotationYaw, entityliving.rotationPitch);
        this.setPosition(this.posX, this.posY, this.posZ);
        this.setAim(shootingEntity, shootingEntity.rotationPitch, shootingEntity.rotationYaw, velocity, 1.0F);
    }

    @Override
    protected void entityInit()
    {
        ;
    }

    public void setAim(Entity shooter, float pitch, float yaw, float velocity, float inaccuracy)
    {
        float motionX = -MathHelper.sin(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        float motionY = -MathHelper.sin(pitch * 0.017453292F);
        float motionZ = MathHelper.cos(yaw * 0.017453292F) * MathHelper.cos(pitch * 0.017453292F);
        this.setArrowHeading((double) motionX, (double) motionY, (double) motionZ, velocity, inaccuracy);
        this.motionX += shooter.motionX;
        this.motionZ += shooter.motionZ;

        if (!shooter.onGround)
        {
            this.motionY += shooter.motionY;
        }
    }

    public void setArrowHeading(double motionX, double motionY, double motionZ, float velocity, float deviation)
    {
        float v = MathHelper.sqrt(motionX * motionX + motionY * motionY + motionZ * motionZ);
        motionX /= v;
        motionY /= v;
        motionZ /= v;
        motionX += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionY += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionZ += this.rand.nextGaussian() * 0.007499999832361937D * deviation;
        motionX *= velocity;
        motionY *= velocity;
        motionZ *= velocity;
        this.motionX = motionX * 1.1D;
        this.motionY = motionY * 1.1D;
        this.motionZ = motionZ * 1.1D;
        float f3 = MathHelper.sqrt(motionX * motionX + motionZ * motionZ);
        this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(motionX, motionZ) * 180.0D / Math.PI);
        this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(motionY, f3) * 180.0D / Math.PI);
        this.ticksInGround = 0;
    }

    @Override
    public void setVelocity(double d, double d1, double d2)
    {
        this.motionX = d;
        this.motionY = d1;
        this.motionZ = d2;

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float f = MathHelper.sqrt(d * d + d2 * d2);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(d, d2) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(d1, f) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            this.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.prevRotationPitch == 0.0F && this.prevRotationYaw == 0.0F)
        {
            float i = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);
            this.prevRotationPitch = this.rotationPitch = (float) (Math.atan2(this.motionY, i) * 180.0D / Math.PI);
        }

        BlockPos pos = new BlockPos(this.xTile, this.yTile, this.zTile);
        IBlockState blockstate = this.world.getBlockState(pos);
        Block block = blockstate.getBlock();

        if (block != Blocks.AIR)
        {
            if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
            {
                AxisAlignedBB box = blockstate.getBoundingBox(this.world, pos);

                if (box != null && box.isVecInside(new Vec3d(this.posX, this.posY, this.posZ)))
                {
                    this.inGround = true;
                }
            }
        }

        if (this.arrowShake > 0)
        {
            --this.arrowShake;
        }

        if (this.inGround)
        {
            if (block == this.inTile)
            {
                ++this.ticksInGround;

                if (this.ticksInGround == 1200)
                {
                    this.setDead();
                }
            }
            else
            {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.2F;
                this.motionY *= this.rand.nextFloat() * 0.2F;
                this.motionZ *= this.rand.nextFloat() * 0.2F;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        }
        else
        {
            ++this.ticksInAir;
            Vec3d var17 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3d Vec3dd1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);
            RayTraceResult result = this.world.rayTraceBlocks(var17, Vec3dd1, false, true, true);
            var17 = new Vec3d(this.posX, this.posY, this.posZ);
            Vec3dd1 = new Vec3d(this.posX + this.motionX, this.posY + this.motionY, this.posZ + this.motionZ);

            if (result != null)
            {
                Vec3dd1 = new Vec3d(result.hitVec.xCoord, result.hitVec.yCoord, result.hitVec.zCoord);
            }

            Entity entity = null;
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().addCoord(this.motionX, this.motionY, this.motionZ).expand(1.0D, 1.0D, 1.0D));
            double d = 0.0D;
            int f3;
            float f6;

            for (f3 = 0; f3 < list.size(); ++f3)
            {
                Entity f4 = list.get(f3);

                if (f4.canBeCollidedWith() && (f4 != this.shootingEntity || this.ticksInAir >= 5))
                {
                    f6 = 0.3F;
                    AxisAlignedBB k1 = f4.getEntityBoundingBox().expand(f6, f6, f6);
                    RayTraceResult f7 = k1.calculateIntercept(var17, Vec3dd1);

                    if (f7 != null)
                    {
                        double d1 = var17.distanceTo(f7.hitVec);

                        if (d1 < d || d == 0.0D)
                        {
                            entity = f4;
                            d = d1;
                        }
                    }
                }
            }

            if (entity != null)
            {
                result = new RayTraceResult(entity);
            }

            float velocity;

            if (result != null)
            {
                if (result.entityHit != null)
                {
                    velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int damage = (int) Math.ceil(velocity * 2.0D);

                    if (this.arrowCritical)
                    {
                        damage += this.rand.nextInt(damage / 2 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null)
                    {
                        damagesource = DamageSources.causeShurikenDamage(this);
                    }
                    else
                    {
                        damagesource = DamageSources.causeShurikenDamage(this.shootingEntity);
                    }

                    if (result.entityHit.attackEntityFrom(damagesource, damage))
                    {
                        if (result.entityHit instanceof EntityLivingBase)
                        {
                            ++((EntityLivingBase) result.entityHit).arrowHitTimer;
                        }

                        GameSounds.fxBowHit.playSound(this, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    }
                    else
                    {
                        this.motionX *= -0.10000000149011612D;
                        this.motionY *= -0.10000000149011612D;
                        this.motionZ *= -0.10000000149011612D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                }
                else
                {
                    this.xTile = (int) result.hitVec.xCoord;
                    this.yTile = (int) result.hitVec.yCoord;
                    this.zTile = (int) result.hitVec.zCoord;
                    this.inTile = block;
                    this.motionX = ((float) (result.hitVec.xCoord - this.posX));
                    this.motionY = ((float) (result.hitVec.yCoord - this.posY));
                    this.motionZ = ((float) (result.hitVec.zCoord - this.posZ));
                    velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / velocity * 0.05000000074505806D;
                    this.posY -= this.motionY / velocity * 0.05000000074505806D;
                    this.posZ -= this.motionZ / velocity * 0.05000000074505806D;
                    GameSounds.fxBowHit.playSound(this, 1.0F, 1.2F / (this.rand.nextFloat() * 0.2F + 0.9F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    this.arrowCritical = false;
                }
            }

            if (this.arrowCritical)
            {
                for (f3 = 0; f3 < 4; ++f3)
                {
                    this.world.spawnParticle(EnumParticleTypes.CRIT, this.posX + this.motionX * f3 / 4.0D, this.posY + this.motionY * f3 / 4.0D, this.posZ + this.motionZ * f3 / 4.0D, -this.motionX, -this.motionY + 0.2D, -this.motionZ);
                }
            }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            velocity = MathHelper.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 180.0D / Math.PI);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, velocity) * 180.0D / Math.PI); this.rotationPitch - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
            {
                ;
            }

            while (this.rotationPitch - this.prevRotationPitch >= 180.0F)
            {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F)
            {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F)
            {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * 0.2F;
            this.rotationYaw = this.prevRotationYaw + (this.rotationYaw - this.prevRotationYaw) * 0.2F;
            float var22 = 0.99F;
            f6 = 0.05F;

            if (this.isInWater())
            {
                for (int var24 = 0; var24 < 4; ++var24)
                {
                    float var25 = 0.25F;
                    this.world.spawnParticle(EnumParticleTypes.WATER_BUBBLE, this.posX - this.motionX * var25, this.posY - this.motionY * var25, this.posZ - this.motionZ * var25, this.motionX, this.motionY, this.motionZ);
                }

                var22 = 0.8F;
            }

            this.motionX *= var22;
            this.motionY *= var22;
            this.motionZ *= var22;
            this.motionY -= f6;
            this.setPosition(this.posX, this.posY, this.posZ);
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        tag.setShort("xTile", (short) this.xTile);
        tag.setShort("yTile", (short) this.yTile);
        tag.setShort("zTile", (short) this.zTile);
        tag.setByte("shake", (byte) this.arrowShake);
        tag.setByte("inGround", (byte) (this.inGround ? 1 : 0));
        tag.setBoolean("player", this.doesArrowBelongToPlayer);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        this.xTile = tag.getShort("xTile");
        this.yTile = tag.getShort("yTile");
        this.zTile = tag.getShort("zTile");
        this.arrowShake = tag.getByte("shake") & 255;
        this.inGround = tag.getByte("inGround") == 1;
        this.doesArrowBelongToPlayer = tag.getBoolean("player");
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer entityplayer)
    {
        if (!this.world.isRemote)
        {
            if (this.inGround && this.doesArrowBelongToPlayer && this.arrowShake <= 0)
            {
                if (entityplayer.inventory.addItemStackToInventory(new ItemStack(AliensVsPredator.items().itemShuriken, 1)))
                {
                    GameSounds.fxPop.playSound(this, 0.2F, ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.0F) * 2.0F);
                    entityplayer.onItemPickup(this, 1);
                    this.setDead();
                }
            }
        }
    }

    @Override
    public float getCollisionBorderSize()
    {
        return 1F;
    }
}
