package org.avp.fabric.service;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import org.avp.common.AVPResources;
import org.avp.common.service.CreativeModeTabRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class FabricCreativeModeTabRegistry implements CreativeModeTabRegistry {

    @Override
    public GameObject<CreativeModeTab> register(String registryName, Supplier<CreativeModeTab> supplier) {
        var gameObject = new GameObject<>(registryName, supplier);
        var resourceLocation = AVPResources.location(registryName);
        var creativeModeTab = gameObject.get();
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, resourceLocation, creativeModeTab);
        return gameObject;
    }
}
