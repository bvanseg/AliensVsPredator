package org.avp.fabric.service;

import net.minecraft.world.item.CreativeModeTab;

import java.util.function.Supplier;

import org.avp.common.service.CreativeModeTabRegistry;
import org.avp.common.util.GameObject;
import org.avp.fabric.common.registry.AVPDeferredCreativeTabRegistry;

/**
 * @author Boston Vanseghi
 */
public class FabricCreativeModeTabRegistry implements CreativeModeTabRegistry {

    @Override
    public GameObject<CreativeModeTab> register(String registryName, Supplier<CreativeModeTab> supplier) {
        var gameObject = new GameObject<>(registryName, supplier);
        AVPDeferredCreativeTabRegistry.enqueue(gameObject);
        return gameObject;
    }
}
