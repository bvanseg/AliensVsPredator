package org.avp.api.block.factory;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.WoodType;

public class FenceGateBlockFactory implements BlockFactory {

    private final WoodType woodType;

    public FenceGateBlockFactory(WoodType woodType) {
        this.woodType = woodType;
    }

    @Override
    public Block create(BlockBehaviour.Properties properties) {
        return new FenceGateBlock(woodType, properties);
    }
}
