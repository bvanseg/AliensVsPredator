package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPParadiseBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

    public static final GameObject<Block> PARADISE_DIRT;

    public static final GameObject<Block> PARADISE_DIRT_MOSSY;

    public static final GameObject<Block> PARADISE_DIRT_PODZOL;

    public static final GameObject<Block> PARADISE_GRASS;

    public static final GameObject<Block> PARADISE_LEAVES_LARGE;

    public static final GameObject<Block> PARADISE_LEAVES_MEDIUM;

    public static final GameObject<Block> PARADISE_LEAVES_SMALL;

    public static final GameObject<Block> PARADISE_LOG_LARGE;

    public static final GameObject<Block> PARADISE_LOG_MEDIUM;

    public static final GameObject<Block> PARADISE_LOG_SMALL;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    public static List<GameObject<Block>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, Supplier<Block> blockSupplier) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockSupplier);
        ENTRIES.add(gameObject);
        return gameObject;
    }

    private AVPParadiseBlocks() {}

    static {
        PARADISE_DIRT = register("paradise_dirt", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_MOSSY = register("paradise_dirt_mossy", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_PODZOL = register("paradise_dirt_podzol", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_GRASS = register("paradise_grass", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_LARGE = register("paradise_leaves_large", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_MEDIUM = register(
            "paradise_leaves_medium",
            () -> new Block(BlockBehaviour.Properties.of())
        );
        PARADISE_LEAVES_SMALL = register("paradise_leaves_small", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_LARGE = register("paradise_log_large", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_MEDIUM = register("paradise_log_medium", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_SMALL = register("paradise_log_small", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
