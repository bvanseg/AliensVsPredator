package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.block.state.properties.WoodType;
import org.avp.api.block.BlockData;
import org.avp.api.block.BlockDataUtils;
import org.avp.api.block.drop.BlockDrops;
import org.avp.api.block.drop.key.BlockDropKeys;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPParadiseBlocks {

    public static final GameObject<Block> PARADISE_DIRT;

    public static final GameObject<Block> PARADISE_DIRT_MOSSY;

    public static final GameObject<Block> PARADISE_DIRT_PODZOL;

    public static final GameObject<Block> PARADISE_FENCE_GATE_LARGE;

    public static final GameObject<Block> PARADISE_FENCE_GATE_MEDIUM;

    public static final GameObject<Block> PARADISE_FENCE_GATE_SMALL;

    public static final GameObject<Block> PARADISE_FENCE_LARGE;

    public static final GameObject<Block> PARADISE_FENCE_MEDIUM;

    public static final GameObject<Block> PARADISE_FENCE_SMALL;

    public static final GameObject<Block> PARADISE_GRASS;

    public static final GameObject<Block> PARADISE_LEAVES_LARGE;

    public static final GameObject<Block> PARADISE_LEAVES_MEDIUM;

    public static final GameObject<Block> PARADISE_LEAVES_SMALL;

    public static final GameObject<Block> PARADISE_LOG_LARGE;

    public static final GameObject<Block> PARADISE_LOG_LARGE_PLANKS;

    public static final GameObject<Block> PARADISE_LOG_MEDIUM;

    public static final GameObject<Block> PARADISE_LOG_MEDIUM_PLANKS;

    public static final GameObject<Block> PARADISE_LOG_SMALL;

    public static final GameObject<Block> PARADISE_LOG_SMALL_PLANKS;

    public static final GameObject<Block> PARADISE_SLAB_LARGE;

    public static final GameObject<Block> PARADISE_SLAB_MEDIUM;

    public static final GameObject<Block> PARADISE_SLAB_SMALL;

    public static final GameObject<Block> PARADISE_STAIRS_LARGE;

    public static final GameObject<Block> PARADISE_STAIRS_MEDIUM;

    public static final GameObject<Block> PARADISE_STAIRS_SMALL;

    public static final GameObject<Block> PARADISE_WOOD_LARGE;

    public static final GameObject<Block> PARADISE_WOOD_MEDIUM;

    public static final GameObject<Block> PARADISE_WOOD_SMALL;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPParadiseBlocks() {}

    static {
        PARADISE_DIRT = AVPBlocks.register("paradise_dirt", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_MOSSY = AVPBlocks.register(
            "paradise_dirt_mossy",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_DIRT_PODZOL = AVPBlocks.register(
            "paradise_dirt_podzol",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_GRASS = AVPBlocks.register(
            "paradise_grass",
            BlockData.builder(BlockBehaviour.Properties.of())
                .drop(BlockDrops.OTHER.apply(BlockDropKeys.OTHER, PARADISE_DIRT::get))
                .build()
        );

        PARADISE_LEAVES_LARGE = AVPBlocks.register(
            "paradise_leaves_large",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_LEAVES_MEDIUM = AVPBlocks.register(
            "paradise_leaves_medium",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_LEAVES_SMALL = AVPBlocks.register(
            "paradise_leaves_small",
            BlockData.simple(BlockBehaviour.Properties.of())
        );

        PARADISE_LOG_LARGE = AVPBlocks.register(
            "paradise_log_large",
            BlockDataUtils.pillar(BlockBehaviour.Properties.of())
        );
        PARADISE_LOG_LARGE_PLANKS = AVPBlocks.register(
            "paradise_log_large_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );

        PARADISE_LOG_MEDIUM = AVPBlocks.register(
            "paradise_log_medium",
            BlockDataUtils.pillar(BlockBehaviour.Properties.of())
        );
        PARADISE_LOG_MEDIUM_PLANKS = AVPBlocks.register(
            "paradise_log_medium_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );

        PARADISE_LOG_SMALL = AVPBlocks.register(
            "paradise_log_small",
            BlockDataUtils.pillar(BlockBehaviour.Properties.of())
        );
        PARADISE_LOG_SMALL_PLANKS = AVPBlocks.register(
            "paradise_log_small_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );

        PARADISE_FENCE_GATE_LARGE = AVPBlocks.register(
            "paradise_fence_gate_large",
            BlockDataUtils.fenceGate(PARADISE_LOG_LARGE_PLANKS, AVPWoodType.LARGE, BlockBehaviour.Properties.of())
        );
        PARADISE_FENCE_GATE_MEDIUM = AVPBlocks.register(
            "paradise_fence_gate_medium",
            BlockDataUtils.fenceGate(PARADISE_LOG_MEDIUM_PLANKS, AVPWoodType.MEDIUM, BlockBehaviour.Properties.of())
        );
        PARADISE_FENCE_GATE_SMALL = AVPBlocks.register(
            "paradise_fence_gate_small",
            BlockDataUtils.fenceGate(PARADISE_LOG_SMALL_PLANKS, AVPWoodType.SMALL, BlockBehaviour.Properties.of())
        );

        PARADISE_FENCE_LARGE = AVPBlocks.register(
            "paradise_fence_large",
            BlockDataUtils.fence(PARADISE_LOG_LARGE_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_FENCE_MEDIUM = AVPBlocks.register(
            "paradise_fence_medium",
            BlockDataUtils.fence(PARADISE_LOG_MEDIUM_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_FENCE_SMALL = AVPBlocks.register(
            "paradise_fence_small",
            BlockDataUtils.fence(PARADISE_LOG_SMALL_PLANKS, BlockBehaviour.Properties.of())
        );

        PARADISE_SLAB_LARGE = AVPBlocks.register(
            "paradise_slab_large",
            BlockDataUtils.slab(PARADISE_LOG_LARGE_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_SLAB_MEDIUM = AVPBlocks.register(
            "paradise_slab_medium",
            BlockDataUtils.slab(PARADISE_LOG_MEDIUM_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_SLAB_SMALL = AVPBlocks.register(
            "paradise_slab_small",
            BlockDataUtils.slab(PARADISE_LOG_SMALL_PLANKS, BlockBehaviour.Properties.of())
        );

        PARADISE_STAIRS_LARGE = AVPBlocks.register(
            "paradise_stairs_large",
            BlockDataUtils.stairs(PARADISE_LOG_LARGE_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_STAIRS_MEDIUM = AVPBlocks.register(
            "paradise_stairs_medium",
            BlockDataUtils.stairs(PARADISE_LOG_MEDIUM_PLANKS, BlockBehaviour.Properties.of())
        );
        PARADISE_STAIRS_SMALL = AVPBlocks.register(
            "paradise_stairs_small",
            BlockDataUtils.stairs(PARADISE_LOG_SMALL_PLANKS, BlockBehaviour.Properties.of())
        );

        PARADISE_WOOD_LARGE = AVPBlocks.register(
            "paradise_wood_large",
            BlockDataUtils.wood(PARADISE_LOG_LARGE, BlockBehaviour.Properties.of())
        );
        PARADISE_WOOD_MEDIUM = AVPBlocks.register(
            "paradise_wood_medium",
            BlockDataUtils.wood(PARADISE_LOG_MEDIUM, BlockBehaviour.Properties.of())
        );
        PARADISE_WOOD_SMALL = AVPBlocks.register(
            "paradise_wood_small",
            BlockDataUtils.wood(PARADISE_LOG_SMALL, BlockBehaviour.Properties.of())
        );
    }
}
