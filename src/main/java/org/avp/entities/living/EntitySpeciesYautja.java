package org.avp.entities.living;

import org.avp.DamageSources;
import org.avp.EntityItemDrops;
import org.avp.api.parasitoidic.IHost;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.EntityAISuperjump;
import org.avp.item.ItemDisc;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemPlasmaCannon;
import org.avp.item.ItemShuriken;
import org.avp.item.ItemWristbracer;

import com.google.common.base.Predicate;

import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAIMoveTowardsTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public abstract class EntitySpeciesYautja extends EntityMob implements IHost, Predicate<EntityLivingBase>
{
    private static final DataParameter<Boolean> WEARING_MASK = EntityDataManager.createKey(EntitySpeciesYautja.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> DUCKING = EntityDataManager.createKey(EntitySpeciesYautja.class, DataSerializers.BOOLEAN);

    public EntitySpeciesYautja(World world)
    {
        super(world);
        this.experienceValue = 250;
        this.setSize(1.0F, 2.5F);
        
//        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(0, new EntityAICustomAttackOnCollide(this, EntityLivingBase.class, 0.9D, true));
        this.tasks.addTask(1, new EntityAIWander(this, 0.6D));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityLivingBase.class, 16F));
        this.targetTasks.addTask(0, new EntityAISuperjump(this, 1.0F));
        this.targetTasks.addTask(1, new EntityAIMoveTowardsTarget(this, 0.9D, 48));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAINearestAttackableTarget<EntityLivingBase>(this, EntityLivingBase.class, 0, false, false, this));
        this.jumpMovementFactor = 0.1F;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(80.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(6.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.75D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(48D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(WEARING_MASK, this.rand.nextBoolean());
        this.getDataManager().register(DUCKING, false);
    }
    
    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
        if (this.world.getWorldTime() % 10 == 0)
        {
            BlockPos aboveHead = this.getPosition().add(0, 3, 0);
            this.setDucking(this.world.getBlockState(aboveHead).getBlock() != Blocks.AIR);
            
            if (this.isDucking())
            {
                this.setSize(1.0F,  1.75F);
            }
            else
            {
                this.setSize(1.0F,  2.5F);
            }
        }
    }
    
    @Override
    public int getMaxFallHeight()
    {
        return 20;
    }
    
    @Override
    public void fall(float distance, float damageMultiplier)
    {
        int intensity = MathHelper.ceil((distance - 3.0F) * damageMultiplier);

        if (intensity > 0)
        {
            this.playSound(this.getFallSound(intensity), 1.0F, 1.0F);
            
            if (this.world.getWorldTime() % 4 == 0)
            this.playSound(this.getDeathSound(), 1.0F, 1.0F);
            
            int x = MathHelper.floor(this.posX);
            int y = MathHelper.floor(this.posY - 0.20000000298023224D);
            int z = MathHelper.floor(this.posZ);
            IBlockState state = this.world.getBlockState(new BlockPos(x, y, z));

            if (state.getMaterial() != Material.AIR)
            {
                SoundType soundtype = state.getBlock().getSoundType(state, world, new BlockPos(x, y, z), this);
                this.playSound(soundtype.getFallSound(), soundtype.getVolume() * 0.5F, soundtype.getPitch() * 0.75F);
            }
        }
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
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
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
        EntityItemDrops.SHURIKEN.tryDrop(this);
        EntityItemDrops.SILICON.tryDrop(this);
        EntityItemDrops.WRISTBRACER_BLADES.tryDrop(this);
        
        dropBiomaskAndSkull(damagesource);
    }
    
    protected void dropBiomaskAndSkull(DamageSource damagesource)
    {
        if (damagesource == DamageSources.wristbracer)
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this, 25);
            EntityItemDrops.BIOMASK.tryDrop(this, 25);
        }
        else
        {
            EntityItemDrops.SKULL_PREDATOR.tryDrop(this);
            EntityItemDrops.BIOMASK.tryDrop(this);
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

    public boolean isDucking()
    {
        return this.getDataManager().get(DUCKING);
    }

    public void setWearingMask(boolean wearingMask)
    {
        if (!this.world.isRemote)
        {
            this.getDataManager().set(WEARING_MASK, wearingMask);
        }
    }

    public void setDucking(boolean ducking)
    {
        if (!this.world.isRemote)
        {
            this.getDataManager().set(DUCKING, ducking);
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
