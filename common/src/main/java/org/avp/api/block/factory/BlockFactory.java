package org.avp.api.block.factory;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

@FunctionalInterface
public interface BlockFactory {

    Block create(BlockBehaviour.Properties properties);
}
