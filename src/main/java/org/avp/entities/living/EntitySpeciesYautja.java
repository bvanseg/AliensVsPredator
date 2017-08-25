package org.avp.entities.living;

import org.avp.DamageSources;
import org.avp.EntityItemDrops;
import org.avp.api.parasitoidic.IHost;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.item.ItemDisc;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemPlasmaCannon;
import org.avp.item.ItemShuriken;
import org.avp.item.ItemWristbracer;

import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public abstract class EntitySpeciesYautja extends EntityMob implements IHost, Predicate<EntityLivingBase>
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(EntitySpeciesYautja.class, DataSerializers.BOOLEAN);

    public EntitySpeciesYautja(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.setSize(1.0F, 2.5F);
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityLivingBase.class, 1D, true));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityMob.class, 16F));
        this.tasks.addTask(2, new EntityAIWander(this, 0.8D));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.6F));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, false, false, this));
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
    }
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack stack = player.getHeldItemMainhand();

            if (stack != null)
            {
                Item item = stack.getItem();

                if (stack != null)
                {
                    if (item instanceof ItemSword || item instanceof ItemFirearm || item instanceof ItemWristbracer || item instanceof ItemPlasmaCannon || item instanceof ItemBow || item instanceof ItemDisc || item instanceof ItemShuriken)
                    {
                        return true;
                    }
                }
            }
        }

        if ((entity instanceof EntitySpeciesAlien) || (entity instanceof EntitySpeciesEngineer) || (entity instanceof EntityMarine))
        {
            return true;
        }

        return false;
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        int damage = 6;

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
        if (entity instanceof IMob && this.rand.nextInt(20) == 0 && !(entity instanceof EntitySpeciesYautja))
        {
            this.setAttackTarget((EntityLivingBase) entity);
            this.setRevengeTarget((EntityLivingBase) entity);
        }

        super.collideWithEntity(entity);
    }

    @Override
    public boolean isInWater()
    {
        return super.isInWater();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.YAUTJA_LIVING.event();
    }

    @Override
    protected SoundEvent getHurtSound()
    {
        return Sounds.YAUTJA_HURT.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.YAUTJA_DEATH.event();
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        EntityItemDrops.PREDATOR_ARTIFACT.tryDrop(this);
        EntityItemDrops.PLASMACANNON.tryDrop(this);
        EntityItemDrops.WRISTBRACER.tryDrop(this);
        EntityItemDrops.WRISTBRACER_BLADES.tryDrop(this);

        if (damagesource == DamageSources.wristbracer)
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this, 25);
        }
        else
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this);
        }
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
        this.setWearingMask(tag.getBoolean("WearingMask"));
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound tag)
    {
        super.writeEntityToNBT(tag);
        tag.setBoolean("WearingMask", this.isWearingMask());
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

    @Override
    public boolean canParasiteAttach()
    {
        return !this.isWearingMask();
    }
    
    @Override
    public boolean canHostParasite()
    {
        return true;
    }
}
