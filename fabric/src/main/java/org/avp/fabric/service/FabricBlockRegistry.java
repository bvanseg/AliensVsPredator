package org.avp.fabric.service;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.avp.common.AVPResources;
import org.avp.common.service.BlockRegistry;
import org.avp.common.service.ItemRegistry;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class FabricBlockRegistry implements BlockRegistry {

    @Override
    public GameObject<Block> register(String registryName, Supplier<Block> supplier) {
        var gameObject = new GameObject<>(supplier);
        var resourceLocation = AVPResources.location(registryName);
        var block = gameObject.get();
        Registry.register(BuiltInRegistries.BLOCK, resourceLocation, block);
        Services.ITEM_REGISTRY.register(registryName, () -> new BlockItem(block, new Item.Properties()));
        return gameObject;
    }
}
