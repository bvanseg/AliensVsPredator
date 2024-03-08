package org.avp.common.sound;

import net.minecraft.sounds.SoundEvent;

import org.avp.common.AVPResources;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPSoundEvents implements AVPRegistry {

    private static final AVPSoundEvents INSTANCE = new AVPSoundEvents();

    public static AVPSoundEvents getInstance() {
        return INSTANCE;
    }

    private static GameObject<SoundEvent> register(String registryName) {
        var resourceLocation = AVPResources.location(registryName);
        return Services.SOUND_EVENT_REGISTRY.register(
            registryName,
            () -> SoundEvent.createVariableRangeEvent(resourceLocation)
        );
    }

    public static GameObject<SoundEvent> ENTITY_CHESTBURSTER_DEATH;
    public static GameObject<SoundEvent> ENTITY_CHESTBURSTER_HURT;
    public static GameObject<SoundEvent> ENTITY_PRAETORIAN_AMBIENT;
    public static GameObject<SoundEvent> ENTITY_PRAETORIAN_DEATH;
    public static GameObject<SoundEvent> ENTITY_PRAETORIAN_HURT;
    public static GameObject<SoundEvent> ENTITY_QUEEN_AMBIENT;
    public static GameObject<SoundEvent> ENTITY_QUEEN_AMBIENT_LOOP;
    public static GameObject<SoundEvent> ENTITY_QUEEN_DEATH;
    public static GameObject<SoundEvent> ENTITY_QUEEN_HURT;
    public static GameObject<SoundEvent> ENTITY_XENOMORPH_AMBIENT;
    public static GameObject<SoundEvent> ENTITY_XENOMORPH_ATTACK;
    public static GameObject<SoundEvent> ENTITY_XENOMORPH_DEATH;
    public static GameObject<SoundEvent> ENTITY_XENOMORPH_EAT;
    public static GameObject<SoundEvent> ENTITY_XENOMORPH_HURT;

    private AVPSoundEvents() {}

    @Override
    public void register() {
        ENTITY_CHESTBURSTER_DEATH = register("entity.chestburster.death");
        ENTITY_CHESTBURSTER_HURT = register("entity.chestburster.hurt");

        ENTITY_PRAETORIAN_AMBIENT = register("entity.praetorian.ambient");
        ENTITY_PRAETORIAN_DEATH = register("entity.praetorian.death");
        ENTITY_PRAETORIAN_HURT = register("entity.praetorian.hurt");

        ENTITY_QUEEN_AMBIENT = register("entity.queen.ambient");
        ENTITY_QUEEN_AMBIENT_LOOP = register("entity.queen.ambient.loop");
        ENTITY_QUEEN_DEATH = register("entity.queen.death");
        ENTITY_QUEEN_HURT = register("entity.queen.hurt");

        ENTITY_XENOMORPH_AMBIENT = register("entity.xenomorph.ambient");
        ENTITY_XENOMORPH_ATTACK = register("entity.xenomorph.attack");
        ENTITY_XENOMORPH_DEATH = register("entity.xenomorph.death");
        ENTITY_XENOMORPH_EAT = register("entity.xenomorph.eat");
        ENTITY_XENOMORPH_HURT = register("entity.xenomorph.hurt");
    }
}
