package org.avp.entities.living;

import org.avp.EntityItemDrops;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public abstract class EntitySpeciesEngineer extends EntityMob
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(EntitySpeciesEngineer.class, DataSerializers.BOOLEAN);
    
    public EntitySpeciesEngineer(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.setSize(1.0F, 2.5F);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, 0.800000011920929D, true));
        this.tasks.addTask(8, new EntityAIWander(this, 0.800000011920929D));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 0.4F));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySpeciesAlien.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntitySpeciesYautja.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityMarine.class, true));
        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        EntityItemDrops.NBT_DRIVE.tryDrop(this);
        EntityItemDrops.PHIAL.tryDrop(this);
        EntityItemDrops.PHIAL_EMPTY.tryDrop(this);
    }
    

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(160.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5199999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.85D);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        int damage = 5;

        if (this.isPotionActive(MobEffects.INSTANT_DAMAGE))
        {
            damage += 3 << this.getActivePotionEffect(MobEffects.INSTANT_DAMAGE).getAmplifier();
        }

        if (this.isPotionActive(MobEffects.WEAKNESS))
        {
            damage -= 2 << this.getActivePotionEffect(MobEffects.WEAKNESS).getAmplifier();
        }

        return entity.attackEntityFrom(DamageSource.causeMobDamage(this), damage);
    }

    @Override
    public int getTotalArmorValue()
    {
        return 7;
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(entity instanceof EntitySpeciesEngineer))
        {
            this.setAttackTarget((EntityLivingBase) entity);
            this.setRevengeTarget((EntityLivingBase) entity);
        }

        super.collideWithEntity(entity);
    }

    @Override
    public boolean isInWater()
    {
        return this.world.handleMaterialAcceleration(this.getEntityBoundingBox().expand(0.0D, -0.900000023841858D, 0.0D), Material.WATER, this);
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return null;
    }

    @Override
    protected SoundEvent getHurtSound()
    {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }

    @Override
    public boolean canDespawn()
    {
        return false;
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound tag)
    {
        super.readEntityFromNBT(tag);
        this.setWearingMask(tag.getBoolean("wearingMask"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean("wearingMask", this.isWearingMask());
    }

    public boolean isWearingMask()
    {
        return this.getDataManager().get(WEARING_MASK);
    }

    public void setWearingMask(boolean wearingMask)
    {
        if (!this.world.isRemote)
        {
            this.getDataManager().set(WEARING_MASK, wearingMask);
        }
    }
}
