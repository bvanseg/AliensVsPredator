package org.avp.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.api.block.factory.BlockFactories;
import org.avp.common.util.GameObject;

public class BlockDataUtils {

    public static BlockData transparent(BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).factory(BlockFactories.TRANSPARENT).build();
    }

    public static BlockData pillar(BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).factory(BlockFactories.ROTATED_PILLAR).build();
    }

    public static BlockData slab(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.SLAB).build();
    }

    public static BlockData stairs(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties)
            .parent(parentGameObject)
            .factory(BlockFactories.STAIRS.apply(parentGameObject))
            .build();
    }

    public static BlockData wall(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.WALL).build();
    }

    private BlockDataUtils() {
        throw new UnsupportedOperationException();
    }
}
