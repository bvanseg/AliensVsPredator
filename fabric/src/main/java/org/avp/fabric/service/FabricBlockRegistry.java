package org.avp.fabric.service;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.avp.common.service.BlockRegistry;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;
import org.avp.fabric.common.registry.AVPDeferredBlockRegistry;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class FabricBlockRegistry implements BlockRegistry {

    @Override
    public GameObject<Block> register(String registryName, Supplier<Block> supplier) {
        var gameObject = new GameObject<>(registryName, supplier);
        var block = gameObject.get();
        AVPDeferredBlockRegistry.enqueue(gameObject);
        Services.ITEM_REGISTRY.register(registryName, () -> new BlockItem(block, new Item.Properties()));
        return gameObject;
    }
}
