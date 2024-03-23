package org.avp.api.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.properties.WoodType;
import org.avp.api.block.factory.BlockFactories;
import org.avp.common.util.GameObject;

public class BlockDataUtils {

    public static BlockData fence(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.FENCE).build();
    }

    public static BlockData fenceGate(GameObject<Block> parentGameObject, WoodType woodType, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.FENCE_GATE.apply(woodType)).build();
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

    public static BlockData transparent(BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).factory(BlockFactories.TRANSPARENT).build();
    }

    public static BlockData wall(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.WALL).build();
    }

    public static BlockData wood(GameObject<Block> parentGameObject, BlockBehaviour.Properties properties) {
        return BlockData.builder(properties).parent(parentGameObject).factory(BlockFactories.WOOD).build();
    }

    private BlockDataUtils() {
        throw new UnsupportedOperationException();
    }
}
