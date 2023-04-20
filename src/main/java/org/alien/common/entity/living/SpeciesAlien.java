package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.Worlds;
import com.asx.mdx.common.minecraft.entity.animations.Animation;
import com.asx.mdx.common.minecraft.entity.animations.IAnimated;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityBoat;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import org.alien.common.api.parasitoidic.RoyalOrganism;
import org.alien.common.entity.EntityAcidPool;
import org.avp.common.AVPDamageSources;

import java.util.UUID;

/**
 * @author Ri5ux
 */
public abstract class SpeciesAlien extends EntityMob implements IMob, RoyalOrganism, IAnimated {
    private static final DataParameter<Integer> JELLY_LEVEL = EntityDataManager.createKey(SpeciesAlien.class, DataSerializers.VARINT);
    private UUID signature;
    protected boolean jellyLimitOverride;

    /**
     * Animations
     **/
    private int animationTick;
    protected Animation animation = NO_ANIMATION;
    protected boolean isAnimationPaused = false;

    public float growthProgress;
    public boolean growthInitialized = false;

    protected SpeciesAlien(World world) {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.jellyLimitOverride = false;
    }

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
        nbt.setInteger("JellyLevel", this.getJellyLevel());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt) {
        super.readEntityFromNBT(nbt);
        this.readAlienFromNBT(nbt);
    }

    public void readAlienFromNBT(NBTTagCompound nbt) {
        this.signature = Worlds.uuidFromNBT(nbt, "HiveSignature");
        this.setJellyLevel(nbt.getInteger("JellyLevel"));
    }

    @Override
    public void onKillEntity(EntityLivingBase entity) {
        super.onKillEntity(entity);
        this.setJellyLevel(this.getJellyLevel() + 250);
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

    protected void onPickupJelly(EntityItem entityItem) {
        this.setJellyLevel(this.getJellyLevel() + (entityItem.getItem().getCount() * 100));
        entityItem.setDead();
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
        this.updateAnimations();
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
    public int getJellyLevel() {
        return this.getDataManager().get(JELLY_LEVEL);
    }

    @Override
    public void setJellyLevel(int level) {
        this.getDataManager().set(JELLY_LEVEL, level);
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
