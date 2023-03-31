package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.Worlds;
import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.entity.ItemDrop;
import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.IAnimated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.api.maturity.MaturityEntries;
import org.alien.common.api.maturity.MaturityEntry;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.alien.common.entity.EntityAcidPool;
import org.avp.common.AVPDamageSources;

import java.util.UUID;

public abstract class SpeciesAlien extends EntityMob implements IMob, RoyalOrganism, IAnimated
{
    private static final DataParameter<Integer> JELLY_LEVEL       = EntityDataManager.createKey(SpeciesAlien.class, DataSerializers.VARINT);
    private UUID                                signature;
    protected boolean                           jellyLimitOverride;
    protected boolean                           isDependant       = false;

    /** Animations **/
    public int                                  frame;
    private int                                 animationTick;
    protected Animation animation         =     NO_ANIMATION;
    protected boolean                           isAnimationPaused = false;

    public float growthProgress;
    public boolean growthInitialized = false;

    protected SpeciesAlien(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.jellyLimitOverride = false;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(JELLY_LEVEL, this.getJellyLevelStart());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
        this.writeAlienToNBT(nbt);
    }

    public void writeAlienToNBT(NBTTagCompound nbt)
    {
        nbt.setString("HiveSignature", signature != null ? this.signature.toString() : "");
        nbt.setInteger("JellyLevel", this.getJellyLevel());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
        this.readAlienFromNBT(nbt);
    }

    public void readAlienFromNBT(NBTTagCompound nbt)
    {
        this.signature = Worlds.uuidFromNBT(nbt, "HiveSignature");
        this.setJellyLevel(nbt.getInteger("JellyLevel"));
    }

    @Override
    public void onKillEntity(EntityLivingBase entity)
    {
        super.onKillEntity(entity);
        this.setJellyLevel(this.getJellyLevel() + 250);
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    protected void spawnAcidPool()
    {
        EntityAcidPool entity = new EntityAcidPool(this.world);
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.world.spawnEntity(entity);
    }
    
    @Override
    public boolean attackEntityFrom(DamageSource source, float amount)
    {
        if(!this.world.isRemote && this.getHealth() > amount && source != DamageSource.IN_WALL && !source.isProjectile() && !source.isMagicDamage() && (this.getMaxHealth() * 0.25 <= amount || this.rand.nextInt(30) == 0))
            this.spawnAcidPool();
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        if (!this.world.isRemote)
        {
            if (damagesource != DamageSource.ON_FIRE && damagesource != DamageSource.IN_FIRE && damagesource != AVPDamageSources.FLAMETHROWER)
            {
                this.spawnAcidPool();
            }

            int adjustedLevel = this.getJellyLevel() / 4;

            if (!this.jellyLimitOverride)
            {
                adjustedLevel = Math.min(adjustedLevel, 64);
            }

            if (this.isDependant)
            {
                new ItemDrop(100, new ItemStack(AlienItems.ITEM_ROYAL_JELLY, adjustedLevel)).tryDrop(this);
            }
        }
    }

    public boolean isReadyToMature(RoyalOrganism jellyProducer)
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(this.getClass()).orElse(null);
        if (maturityEntry == null) return false;
        RoyalOrganism ro = this;
        return maturityEntry.getEntityClass() != null &&
                maturityEntry.getRequiredJellyLevel() > 0 &&
                ro.getJellyLevel() >= maturityEntry.getRequiredJellyLevel();
    }

    public void mature()
    {
        MaturityEntry maturityEntry = MaturityEntries.getEntryFor(this.getClass()).orElse(null);
        if (maturityEntry == null) return;
        SpeciesAlien alien = (SpeciesAlien) Entities.constructEntity(this.world, maturityEntry.getEntityClass());
        NBTTagCompound tag = new NBTTagCompound();

        alien.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
        this.world.spawnEntity(alien);
        this.writeAlienToNBT(tag);
        alien.readAlienFromNBT(tag);
        alien.setJellyLevel(this.getJellyLevel() - maturityEntry.getRequiredJellyLevel());
        // TODO: Create a shell of the original entity.
        this.setDead();
    }

    protected void onPickupJelly(EntityItem entityItem)
    {
        this.setJellyLevel(this.getJellyLevel() + (entityItem.getItem().getCount() * 100));
        entityItem.setDead();
    }

    protected void updateAnimations()
    {
        frame++;

        if (getActiveAnimation() != NO_ANIMATION)
        {
            if (!this.isAnimationPaused())
            {
                animationTick++;
            }

            if (animationTick >= animation.getDuration())
            {
                onAnimationFinish(animation);
            }
        }
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        this.updateAnimations();

        if (this.canProduceJelly())
        {
            this.produceJelly();
        }

        if (!this.world.isRemote)
        {
            if (this.ticksExisted % 20 == 0)
            {
                if (this.isReadyToMature(this))
                {
                    this.mature();
                }
            }
        }
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);

        if (key == JELLY_LEVEL && !this.growthInitialized) {
            this.growthProgress = this.getJellyLevel();
            this.growthInitialized = true;
        }
    }

    @Override
    public boolean startRiding(Entity entityIn) {
        if (entityIn instanceof EntityBoat || entityIn instanceof EntityMinecart) {
            return false;
        }
        return super.startRiding(entityIn);
    }

    @Override
    public boolean canProduceJelly()
    {
        return this.world.getTotalWorldTime() % this.getJellyProductionRate() == 0;
    }

    @Override
    public int getJellyProductionRate()
    {
        return 8 * 20;
    }

    @Override
    public void produceJelly()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                // this.setJellyLevel(this.getJellyLevel() + 20);
            }
        }
    }

    @Override
    public int getJellyLevel()
    {
        return this.getDataManager().get(JELLY_LEVEL);
    }

    @Override
    public void setJellyLevel(int level)
    {
        this.getDataManager().set(JELLY_LEVEL, level);
    }

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount)
    {
        return type == EnumCreatureType.MONSTER;
    }

    protected void negateFallDamage()
    {
        this.fallDistance = 0F;
    }

    protected int getJellyLevelStart()
    {
        return 0;
    }

    @Override
    protected void despawnEntity()
    {
        ;
    }

    /** Animation Dependent **/

    @Override
    public int getAnimationTick()
    {
        return this.animationTick;
    }

    @Override
    public void setAnimationTick(int tick)
    {
        this.animationTick = tick;
    }

    @Override
    public Animation getActiveAnimation()
    {
        return this.animation;
    }

    @Override
    public void setActiveAnimation(Animation animation)
    {
        this.animation = animation;
        setAnimationTick(0);
    }

    @Override
    public Animation[] getAnimations()
    {
        return new Animation[] {};
    }

    @Override
    public boolean isAnimationPaused()
    {
        return this.isAnimationPaused;
    }

    @Override
    public void pauseAnimation()
    {
        this.isAnimationPaused = true;
    }

    @Override
    public void playAnimation()
    {
        this.isAnimationPaused = false;
    }

    protected void onAnimationFinish(Animation animation)
    {
        /** If the set animation duration is 0, do not expire. **/
        if (animation.getDuration() > 0)
        {
            setActiveAnimation(NO_ANIMATION);
        }
    }
}
