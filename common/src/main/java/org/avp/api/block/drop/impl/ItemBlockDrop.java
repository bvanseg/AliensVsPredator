package org.avp.api.block.drop.impl;

import net.minecraft.world.item.Item;
import org.avp.api.block.drop.BlockDrop;
import org.avp.api.block.drop.key.BlockDropKey;

import java.util.function.Supplier;

public class ItemBlockDrop extends BlockDrop {

    private final Supplier<Item> itemSupplier;

    public ItemBlockDrop(BlockDropKey blockDropKey, Supplier<Item> itemSupplier) {
        super(blockDropKey);
        this.itemSupplier = itemSupplier;
    }

    public Supplier<Item> getOtherSupplier() {
        return itemSupplier;
    }
}
