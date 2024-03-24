package org.avp.common.entity.living;

import mod.azure.azurelib.common.api.common.animatable.GeoEntity;
import mod.azure.azurelib.common.internal.common.core.animatable.instance.AnimatableInstanceCache;
import mod.azure.azurelib.common.internal.common.core.animation.AnimatableManager;
import mod.azure.azurelib.common.internal.common.util.AzureLibUtil;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.goal.LookAtPlayerGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.WaterAvoidingRandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.avp.common.sound.AVPSoundEvents;
import org.avp.common.tag.AVPEntityTags;

/**
 * @author Boston Vanseghi
 */
public class WarriorRunner extends Monster implements GeoEntity {

    private final AnimatableInstanceCache cache = AzureLibUtil.createInstanceCache(this);

    public WarriorRunner(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity entity) {
        this.playSound(AVPSoundEvents.ENTITY_XENOMORPH_ATTACK.get());
        return super.doHurtTarget(entity);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(8, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new WaterAvoidingRandomStrollGoal(this, 1.0));

        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0, true));
        this.targetSelector.addGoal(
            2,
            new NearestAttackableTargetGoal<>(
                this,
                LivingEntity.class,
                true,
                (livingEntity) -> !livingEntity.getType().is(AVPEntityTags.ALIENS)
            )
        );
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AVPSoundEvents.ENTITY_XENOMORPH_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AVPSoundEvents.ENTITY_XENOMORPH_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AVPSoundEvents.ENTITY_XENOMORPH_HURT.get();
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // TODO:
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return cache;
    }
}
