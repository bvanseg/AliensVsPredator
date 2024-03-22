package org.avp.common.service;

import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public interface BlockRegistry {

    GameObject<Block> register(String registryName, Supplier<Block> supplier);

    StairBlock createStairBlock(GameObject<Block> blockGameObject, BlockBehaviour.Properties properties);
}
