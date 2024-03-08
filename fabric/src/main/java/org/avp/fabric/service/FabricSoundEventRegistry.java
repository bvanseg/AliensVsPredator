package org.avp.fabric.service;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.sounds.SoundEvent;

import java.util.function.Supplier;

import org.avp.common.AVPResources;
import org.avp.common.service.SoundEventRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class FabricSoundEventRegistry implements SoundEventRegistry {

    @Override
    public GameObject<SoundEvent> register(String registryName, Supplier<SoundEvent> supplier) {
        var gameObject = new GameObject<>(supplier);
        var resourceLocation = AVPResources.location(registryName);
        var soundEvent = gameObject.get();
        Registry.register(BuiltInRegistries.SOUND_EVENT, resourceLocation, soundEvent);
        return gameObject;
    }
}
