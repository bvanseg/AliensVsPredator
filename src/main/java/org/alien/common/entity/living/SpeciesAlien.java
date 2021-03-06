package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.Worlds;
import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.IAnimated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.alien.common.entity.AlienCreatureTypes;
import org.alien.common.entity.EntityAcidPool;
import org.alien.common.entity.ai.brain.AlienBrain;
import org.avp.common.AVPDamageSources;
import org.lib.brain.Brainiac;
import org.lib.common.entity.IntegerDataHandle;

import java.util.UUID;

/**
 * @author Ri5ux
 */
public abstract class SpeciesAlien extends EntityMob implements IAnimated, Brainiac<AlienBrain<? extends SpeciesAlien>> {
    private static final DataParameter<Integer> JELLY_LEVEL = EntityDataManager.createKey(SpeciesAlien.class, DataSerializers.VARINT);

    public final IntegerDataHandle jellyLevel = new IntegerDataHandle(this, JELLY_LEVEL);

    private UUID signature;

    /**
     * Animations
     **/
    private int animationTick;
    protected Animation animation = NO_ANIMATION;
    protected boolean isAnimationPaused = false;

    public float growthProgress;
    public boolean growthInitialized = false;

    private AlienBrain<? extends SpeciesAlien> brain;

    protected SpeciesAlien(World world) {
        super(world);
        this.jumpMovementFactor = 0.2F;
    }

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount) {
        // If not using custom creature type, fall back on default super behavior.
        if (AlienCreatureTypes.getAlienCreatureType() == EnumCreatureType.MONSTER)
            return super.isCreatureType(type, forSpawnCount);

        // Otherwise, override for the alien creature type. If we do not do this, the superclass will check against assignable
        // classes on the creature
        return type == AlienCreatureTypes.getAlienCreatureType();
    }

    @Override
    public AlienBrain<? extends SpeciesAlien> getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = this.createNewBrain();
            this.brain.init();
        }
        return this.brain;
    }

    public abstract AlienBrain<? extends SpeciesAlien> createNewBrain();

    @Override
    protected void entityInit() {
        super.entityInit();
        this.getDataManager().register(JELLY_LEVEL, this.getJellyLevelStart());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt) {
        super.writeEntityToNBT(nbt);
        this.writeAlienToNBT(nbt);
    }

    public void writeAlienToNBT(NBTTagCompound nbt) {
        nbt.setString("HiveSignature", signature != null ? this.signature.toString() : "");
        nbt.setInteger("JellyLevel", this.jellyLevel.get());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.readAlienFromNBT(nbt);
    }

    public void readAlienFromNBT(NBTTagCompound nbt) {
        this.signature = Worlds.uuidFromNBT(nbt, "HiveSignature");
        this.jellyLevel.set(nbt.getInteger("JellyLevel"));
    }

    @Override
    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        this.jellyLevel.add(25);
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    protected void spawnAcidPool() {
        EntityAcidPool entity = new EntityAcidPool(this.world);
        entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
        this.world.spawnEntity(entity);
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float amount) {
        if (!this.world.isRemote && this.getHealth() > amount && source != DamageSource.IN_WALL && !source.isProjectile() && !source.isMagicDamage() && (this.getMaxHealth() * 0.25 <= amount || this.rand.nextInt(30) == 0))
            this.spawnAcidPool();
        return super.attackEntityFrom(source, amount);
    }

    @Override
    public void onDeath(DamageSource damagesource) {
        super.onDeath(damagesource);

        if (!this.world.isRemote) {
            if (damagesource != DamageSource.ON_FIRE && damagesource != DamageSource.IN_FIRE && damagesource != AVPDamageSources.FLAMETHROWER) {
                this.spawnAcidPool();
            }
        }
    }

    protected void updateAnimations() {
        if (getActiveAnimation() != NO_ANIMATION) {
            if (!this.isAnimationPaused()) {
                animationTick++;
            }

            if (animationTick >= animation.getDuration()) {
                onAnimationFinish(animation);
            }
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.getBrain().update();
        }

        this.updateAnimations();
    }

    @Override
    public void notifyDataManagerChange(DataParameter<?> key) {
        super.notifyDataManagerChange(key);

        if (key == JELLY_LEVEL && !this.growthInitialized) {
            this.growthProgress = this.jellyLevel.get();
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

    protected void negateFallDamage() {
        this.fallDistance = 0F;
    }

    protected int getJellyLevelStart() {
        return 0;
    }

    @Override
    protected void despawnEntity() {
    }

    /**
     * Animation Dependent
     **/

    @Override
    public int getAnimationTick() {
        return this.animationTick;
    }

    @Override
    public void setAnimationTick(int tick) {
        this.animationTick = tick;
    }

    @Override
    public Animation getActiveAnimation() {
        return this.animation;
    }

    @Override
    public void setActiveAnimation(Animation animation) {
        this.animation = animation;
        setAnimationTick(0);
    }

    @Override
    public Animation[] getAnimations() {
        return new Animation[]{};
    }

    @Override
    public boolean isAnimationPaused() {
        return this.isAnimationPaused;
    }

    @Override
    public void pauseAnimation() {
        this.isAnimationPaused = true;
    }

    @Override
    public void playAnimation() {
        this.isAnimationPaused = false;
    }

    protected void onAnimationFinish(Animation animation) {
        /** If the set animation duration is 0, do not expire. **/
        if (animation.getDuration() > 0) {
            setActiveAnimation(NO_ANIMATION);
        }
    }
}
