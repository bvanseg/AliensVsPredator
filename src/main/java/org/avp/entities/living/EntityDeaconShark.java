package org.avp.entities.living;

import java.util.List;

import org.avp.entities.EntityAcidPool;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.helpers.EntityExtendedLookHelper;
import org.avp.entities.ai.pathfinding.PathNavigateSwimmer;

import com.asx.mdx.lib.world.entity.Entities;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.ai.EntityLookHelper;
import net.minecraft.entity.ai.EntityMoveHelper;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class EntityDeaconShark extends EntitySpeciesAlien
{
    private EntityAIWander                 wander;
    private EntityAIMoveTowardsRestriction moveTowardsRestriction;
    private double                         distanceToTargetLastTick;
    private Predicate<EntityLivingBase>                entitySelector = new Predicate<EntityLivingBase>()
                                                          {
                                                              @Override
                                                              public boolean apply(EntityLivingBase target)
                                                              {
                                                                  if (target instanceof EntityAcidPool)
                                                                  {
                                                                      return false;
                                                                  }
                                                                  
                                                                  return  !(target instanceof EntityDeaconShark) && EntityDeaconShark.this.canEntityBeSeen(target);
                                                              }
                                                          };

    public EntityDeaconShark(World worldIn)
    {
        super(worldIn);
        this.experienceValue = 10;
        this.setSize(2F, 1F);
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, 0.8D, true));
        this.tasks.addTask(5, moveTowardsRestriction = new EntityAIMoveTowardsRestriction(this, 1.0D));
        this.tasks.addTask(7, this.wander = new EntityAIWander(this, 1.0D));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
        this.tasks.addTask(8, new EntityAIWatchClosest(this, EntityDeaconShark.class, 12.0F, 0.01F));
        this.tasks.addTask(9, new EntityAILookIdle(this));
        this.moveTowardsRestriction.setMutexBits(3);
        this.wander.setMutexBits(3);
//        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<>(this, Entity.class, 10, true, false, entitySelector));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(3, new EntityAILeapAtTarget(this, 0.4F));
        Entities.setMoveHelper(this, new EntityDeaconShark.DeaconSharkMoveHelper());
        Entities.setNavigator(this, new PathNavigateSwimmer(this, this.world));
        Entities.setLookHelper(this, new EntityExtendedLookHelper(this));
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
        Entity attackTarget = null;
    
        for (EntityLivingBase target : targets)
        {
            if (this.entitySelector.apply(target) && this.canEntityBeSeen(target))
            {
                attackTarget = target;
            }
        }
        
        targets.clear();
        targets = null;

        return (EntityLivingBase) attackTarget;
    }

    @Override
    public void onLivingUpdate()
    {
        if (this.getAttackTarget() == null || this.getAttackTarget() != null && this.getAttackTarget().isDead || !(this.distanceToTargetLastTick - this.getDistanceSq(this.getAttackTarget()) > 0.1))
        {
            if (this.world.getWorldTime() % 60 == 0)
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
            this.motionX += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
            this.motionZ += (double) ((this.rand.nextFloat() * 2.0F - 1.0F) * 0.4F);
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
    protected void collideWithNearbyEntities()
    {
        super.collideWithNearbyEntities();
    }

    @Override
    protected boolean isValidLightLevel()
    {
        return true;
    }

    @Override
    public boolean getCanSpawnHere()
    {
        if (!(this.posZ > 16 && this.posY <= 64 && this.world.getWorldTime() % 80 == 0))
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
    public boolean attackEntityFrom(DamageSource source, float damage)
    {
        return super.attackEntityFrom(source, damage);
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
        private EntityDeaconShark shark = EntityDeaconShark.this;
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
                velocity = (double) MathHelper.sqrt(velocity);
                posY /= velocity;
                this.shark.rotationYaw = EntityExtendedLookHelper.updateRotationNew(this.shark.rotationYaw, (float) (Math.atan2(posZ, posX) * 180.0D / Math.PI) - 90.0F, 5.0F);
                this.shark.renderYawOffset = this.shark.rotationYaw;
                float speed = (float) (this.speed * this.shark.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).getAttributeValue());
                this.shark.setAIMoveSpeed(this.shark.getAIMoveSpeed() + (speed - this.shark.getAIMoveSpeed()) * 0.125F);
                double waveX = Math.sin((double) (this.shark.ticksExisted + this.shark.getEntityId()) * 0.5D) * 0.05D;
                double waveY = Math.cos((double) (this.shark.rotationYaw * (float) Math.PI / 180.0F));
                double waveZ = Math.sin((double) (this.shark.rotationYaw * (float) Math.PI / 180.0F));
                this.shark.motionX += waveX * waveY;
                this.shark.motionZ += waveX * waveZ;
                waveX = Math.sin((double) (this.shark.ticksExisted + this.shark.getEntityId()) * 0.75D) * 0.05D;
                this.shark.motionY += waveX * (waveZ + waveY) * 0.25D;
                this.shark.motionY += (double) this.shark.getAIMoveSpeed() * posY * 0.1D;
                double offsetX = this.shark.posX + posX / velocity * 2.0D;
                double offsetY = (double) this.shark.getEyeHeight() + this.shark.posY + posY / velocity * 1.0D;
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
}
