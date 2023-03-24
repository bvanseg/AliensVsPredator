package org.alien.common.entity.living;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.alien.common.entity.ai.brain.EngineerBrain;
import org.avp.common.AVPItemDrops;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;

public abstract class SpeciesEngineer extends EntityMob implements Brainiac<EngineerBrain>
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(SpeciesEngineer.class, DataSerializers.BOOLEAN);

    private EngineerBrain brain;
    
    public SpeciesEngineer(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.setSize(1.0F, 2.5F);
    }

    @Override
    public EngineerBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new EngineerBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        AVPItemDrops.NBT_DRIVE.tryDrop(this);
        AVPItemDrops.PHIAL.tryDrop(this);
        AVPItemDrops.PHIAL_EMPTY.tryDrop(this);
    }
    

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }
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
        if (entity instanceof IMob && this.getRNG().nextInt(20) == 0 && !(entity instanceof SpeciesEngineer))
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
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return null;
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return null;
    }
    
    @Override
    protected void despawnEntity()
    {
        ;
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
