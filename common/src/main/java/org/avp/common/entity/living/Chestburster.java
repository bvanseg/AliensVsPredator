package org.avp.common.entity.living;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

import org.avp.common.sound.AVPSoundEvents;

/**
 * @author Boston Vanseghi
 */
public class Chestburster extends Monster {

    public Chestburster(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }

    @Override
    protected SoundEvent getDeathSound() {
        return AVPSoundEvents.ENTITY_CHESTBURSTER_DEATH.get();
    }

    @Override
    protected SoundEvent getHurtSound(@NotNull DamageSource damageSource) {
        return AVPSoundEvents.ENTITY_CHESTBURSTER_HURT.get();
    }
}
