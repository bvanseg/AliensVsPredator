package org.avp.api.block.drop.impl;

import net.minecraft.world.level.block.Block;
import org.avp.api.block.drop.BlockDrop;
import org.avp.api.block.drop.key.BlockDropKey;

import java.util.function.Supplier;

public class OtherBlockDrop extends BlockDrop {

    private final Supplier<Block> blockSupplier;

    public OtherBlockDrop(BlockDropKey blockDropKey, Supplier<Block> blockSupplier) {
        super(blockDropKey);
        this.blockSupplier = blockSupplier;
    }

    public Supplier<Block> getOtherSupplier() {
        return blockSupplier;
    }
}
