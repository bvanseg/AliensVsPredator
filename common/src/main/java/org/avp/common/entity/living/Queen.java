package org.avp.common.entity.living;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import org.avp.common.sound.AVPSoundEvents;

/**
 * @author Boston Vanseghi
 */
public class Queen extends Monster {

    public Queen(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity entity) {
        this.playSound(AVPSoundEvents.ENTITY_XENOMORPH_ATTACK.get());
        return super.doHurtTarget(entity);
    }

    @Nullable
    @Override
    protected SoundEvent getAmbientSound() {
        return AVPSoundEvents.ENTITY_QUEEN_AMBIENT.get();
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AVPSoundEvents.ENTITY_QUEEN_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AVPSoundEvents.ENTITY_QUEEN_HURT.get();
    }
}
