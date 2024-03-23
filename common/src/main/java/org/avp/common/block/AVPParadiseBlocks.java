package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

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
    }
}
