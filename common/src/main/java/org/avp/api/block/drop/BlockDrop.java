package org.avp.api.block.drop;

import org.avp.api.block.drop.key.BlockDropKey;

public class BlockDrop {

    private final BlockDropKey blockDropKey;

    public BlockDrop(BlockDropKey blockDropKey) {
        this.blockDropKey = blockDropKey;
    }

    public BlockDropKey getBlockDropKey() {
        return blockDropKey;
    }
}
