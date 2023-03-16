package org.alien.common.entity.living.vardic;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.google.common.base.Predicate;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.DeaconSharkBrain;
import org.alien.common.entity.living.SpeciesAlien;
import org.avp.common.entity.ai.helpers.EntityExtendedLookHelper;
import org.avp.common.entity.ai.pathfinding.PathNavigateSwimmer;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;

import java.util.List;

public class EntityDeaconShark extends SpeciesAlien implements Brainiac<DeaconSharkBrain>
{
    @Deprecated
    private final Predicate<EntityLivingBase> entitySelector = target -> !(target instanceof EntityDeaconShark) && EntityDeaconShark.this.canEntityBeSeen(target);
    private double                         distanceToTargetLastTick;

    private DeaconSharkBrain brain;

    public EntityDeaconShark(World worldIn)
    {
        super(worldIn);
        this.experienceValue = 10;
        this.setSize(2F, 1F);
        Entities.setMoveHelper(this, new EntityDeaconShark.DeaconSharkMoveHelper());
        Entities.setNavigator(this, new PathNavigateSwimmer(this, this.world));
        Entities.setLookHelper(this, new EntityExtendedLookHelper(this));
    }

    @Override
    public DeaconSharkBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new DeaconSharkBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(16.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update(new EntityBrainContext(this.getBrain(), this));
        }
    }

    @Override
    public boolean attackEntityAsMob(Entity target)
    {
        if (this.canEntityBeSeen(target) && this.getDistanceSq(target) < 2F)
        {
            return super.attackEntityAsMob(target);
        }

        return false;
    }

    @Override
    public int getTalkInterval()
    {
        return 160;
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public float getEyeHeight()
    {
        return this.height * 0.5F;
    }

    public EntityLivingBase findTarget()
    {
        List<? extends EntityLivingBase> targets =  world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(24, 32, 24));
        EntityLivingBase attackTarget = null;

        for (EntityLivingBase target : targets)
        {
            if (this.entitySelector.apply(target) && this.canEntityBeSeen(target))
            {
                attackTarget = target;
            }
        }
        
        targets.clear();

        return attackTarget;
    }

    @Override
    public void onLivingUpdate()
    {
        if (this.getAttackTarget() == null || this.getAttackTarget() != null && this.getAttackTarget().isDead || !(this.distanceToTargetLastTick - this.getDistanceSq(this.getAttackTarget()) > 0.1))
        {
            if (this.world.getTotalWorldTime() % 60 == 0)
            {
                this.setAttackTarget(this.findTarget());
            }
        }
        
        if (this.getAttackTarget() == null && this.getNavigator().getPath() != null)
        {
            this.getNavigator().clearPath();
        }
        
        if (this.getAttackTarget() != null)
        {
            this.distanceToTargetLastTick = this.getDistanceSq(this.getAttackTarget());
            this.getMoveHelper().setMoveTo(this.getAttackTarget().posX, this.getAttackTarget().posY, this.getAttackTarget().posZ, 1F);
        }

        if (this.world.isRemote)
        {
            if (this.getAttackTarget() != null)
            {
                this.getLookHelper().setLookPositionWithEntity(this.getAttackTarget(), 90.0F, 90.0F);
                this.getLookHelper().onUpdateLook();
            }
        }

        if (this.inWater)
        {
            this.setAir(300);
        }
        else if (this.onGround)
        {
            this.motionY += 0.5D;
            this.motionX += ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.rotationYaw = this.rand.nextFloat() * 360.0F;
            this.onGround = false;
            this.isAirBorne = true;
        }

        if (this.getAttackTarget() != null)
        {
            this.rotationYaw = this.rotationYawHead;
        }
        
        super.onLivingUpdate();
    }

    @Override
    protected boolean isValidLightLevel()
    {
        return true;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        if (!(this.posZ > 16 && this.posY <= 64 && this.world.getTotalWorldTime() % 80 == 0))
        {
            return false;
        }

        return this.world.checkNoEntityCollision(this.getEntityBoundingBox().expand(16, 32, 16));
    }

    @Override
    protected void despawnEntity()
    {
        if (!this.hasCustomName())
        {
            super.despawnEntity();
        }
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(entity instanceof EntityDeaconShark))
        {
            this.setAttackTarget((EntityLivingBase) entity);
            this.setRevengeTarget((EntityLivingBase) entity);
        }

        super.collideWithEntity(entity);
    }

    @Override
    public int getVerticalFaceSpeed()
    {
        return 180;
    }
    
    @Override
    public void travel(float strafe, float vertical, float forward)
    {
        if (!this.world.isRemote)
        {
            if (this.isInWater())
            {
                this.moveRelative(strafe, 1F, forward, 0.1F);
                this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
                this.motionX *= 0.8999999761581421D;
                this.motionY *= 0.8999999761581421D;
                this.motionZ *= 0.8999999761581421D;

                if (this.getAttackTarget() == null)
                {
                    this.motionY -= 0.005D;
                }
            }
            else
            {
                super.travel(strafe, vertical, forward);
            }
        }
        else
        {
            super.travel(strafe, vertical, forward);
        }
    }

    class DeaconSharkMoveHelper extends EntityMoveHelper
    {
        private final EntityDeaconShark shark = EntityDeaconShark.this;
        private double            posX;
        private double            posY;
        private double            posZ;
        private double            speed;

        public DeaconSharkMoveHelper()
        {
            super(EntityDeaconShark.this);
        }

        @Override
        public void setMoveTo(double posX, double posY, double posZ, double speed)
        {
            super.setMoveTo(posX, posY, posZ, speed);
            this.posX = posX;
            this.posY = posY;
            this.posZ = posZ;
            this.speed = speed;
        }

        @Override
        public void onUpdateMoveHelper()
        {
            if (this.isUpdating())
            {
                double posX = this.posX - this.shark.posX;
                double posY = this.posY - this.shark.posY;
                double posZ = this.posZ - this.shark.posZ;
                double velocity = posX * posX + posY * posY + posZ * posZ;
                velocity = MathHelper.sqrt(velocity);
                posY /= velocity;
                this.shark.rotationYaw = EntityExtendedLookHelper.updateRotationNew(this.shark.rotationYaw, (float) (Math.atan2(posZ, posX) * 180.0D / Math.PI) - 90.0F, 5.0F);
                this.shark.renderYawOffset = this.shark.rotationYaw;
                float speed = (float) (this.speed * this.shark.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.shark.setAIMoveSpeed(this.shark.getAIMoveSpeed() + (speed - this.shark.getAIMoveSpeed()) * 0.125F);
                double waveX = Math.sin((this.shark.ticksExisted + this.shark.getEntityId()) * 0.5D) * 0.05D;
                double waveY = Math.cos((this.shark.rotationYaw * (float) Math.PI / 180.0F));
                double waveZ = Math.sin((this.shark.rotationYaw * (float) Math.PI / 180.0F));
                this.shark.motionX += waveX * waveY;
                this.shark.motionZ += waveX * waveZ;
                waveX = Math.sin((this.shark.ticksExisted + this.shark.getEntityId()) * 0.75D) * 0.05D;
                this.shark.motionY += waveX * (waveZ + waveY) * 0.25D;
                this.shark.motionY += this.shark.getAIMoveSpeed() * posY * 0.1D;
                double offsetX = this.shark.posX + posX / velocity * 2.0D;
                double offsetY = this.shark.getEyeHeight() + this.shark.posY + posY / velocity * 1.0D;
                double offsetZ = this.shark.posZ + posZ / velocity * 2.0D;
                EntityLookHelper lookHelper = this.shark.getLookHelper();

                if (lookHelper instanceof EntityExtendedLookHelper)
                {
                    EntityExtendedLookHelper extendedLookHelper = (EntityExtendedLookHelper) lookHelper;
                    double lookX = extendedLookHelper.posX;
                    double lookY = extendedLookHelper.posY;
                    double lookZ = extendedLookHelper.posZ;

                    if (!extendedLookHelper.isLooking)
                    {
                        lookX = offsetX;
                        lookY = offsetY;
                        lookZ = offsetZ;
                    }

                    this.shark.getLookHelper().setLookPosition(lookX + (offsetX - lookX) * 0.125D, lookY + (offsetY - lookY) * 0.125D, lookZ + (offsetZ - lookZ) * 0.125D, 10.0F, 40.0F);
                }
            }
            else
            {
                this.shark.setAIMoveSpeed(0.0F);
            }
        }
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DEACON_SHARK);
    }
}
