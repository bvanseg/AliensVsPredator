package org.avp.fabric.service;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;

import java.util.function.Supplier;

import org.avp.common.AVPResources;
import org.avp.common.service.ItemRegistry;
import org.avp.common.util.GameObject;
import org.avp.fabric.common.registry.AVPDeferredItemRegistry;

/**
 * @author Boston Vanseghi
 */
public class FabricItemRegistry implements ItemRegistry {

    @Override
    public GameObject<Item> register(String registryName, Supplier<Item> supplier) {
        var gameObject = new GameObject<>(registryName, supplier);
        AVPDeferredItemRegistry.enqueue(gameObject);
        return gameObject;
    }
}
