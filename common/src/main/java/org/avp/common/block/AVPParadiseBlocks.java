package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPParadiseBlocks {

    private static final List<Tuple<GameObject<Block>, BlockData>> ENTRIES = new ArrayList<>();

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

    public static List<Tuple<GameObject<Block>, BlockData>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, BlockData blockData) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockData::create);
        ENTRIES.add(new Tuple<>(gameObject, blockData));
        return gameObject;
    }

    private AVPParadiseBlocks() {}

    static {
        PARADISE_DIRT = register("paradise_dirt", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_MOSSY = register("paradise_dirt_mossy", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_PODZOL = register("paradise_dirt_podzol", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_GRASS = register("paradise_grass", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_LARGE = register("paradise_leaves_large", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_MEDIUM = register(
            "paradise_leaves_medium",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_LEAVES_SMALL = register("paradise_leaves_small", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LOG_LARGE = register("paradise_log_large", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LOG_LARGE_PLANKS = register(
            "paradise_log_large_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_LOG_MEDIUM = register("paradise_log_medium", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LOG_MEDIUM_PLANKS = register(
            "paradise_log_medium_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
        PARADISE_LOG_SMALL = register("paradise_log_small", BlockData.simple(BlockBehaviour.Properties.of()));
        PARADISE_LOG_SMALL_PLANKS = register(
            "paradise_log_small_planks",
            BlockData.simple(BlockBehaviour.Properties.of())
        );
    }
}
