package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPParadiseBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPParadiseBlocks INSTANCE = new AVPParadiseBlocks();

    public static AVPParadiseBlocks getInstance() {
        return INSTANCE;
    }

    public static GameObject<Block> PARADISE_DIRT;
    public static GameObject<Block> PARADISE_DIRT_MOSSY;
    public static GameObject<Block> PARADISE_DIRT_PODZOL;
    public static GameObject<Block> PARADISE_GRASS;
    public static GameObject<Block> PARADISE_LEAVES_LARGE;
    public static GameObject<Block> PARADISE_LEAVES_MEDIUM;
    public static GameObject<Block> PARADISE_LEAVES_SMALL;
    public static GameObject<Block> PARADISE_LOG_LARGE;
    public static GameObject<Block> PARADISE_LOG_MEDIUM;
    public static GameObject<Block> PARADISE_LOG_SMALL;

    private AVPParadiseBlocks() {}

    @Override
    public void register() {
        PARADISE_DIRT = registerEntry("paradise_dirt", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_MOSSY = registerEntry("paradise_dirt_mossy", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_DIRT_PODZOL = registerEntry("paradise_dirt_podzol", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_GRASS = registerEntry("paradise_grass", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_LARGE = registerEntry("paradise_leaves_large", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_MEDIUM = registerEntry("paradise_leaves_medium", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LEAVES_SMALL = registerEntry("paradise_leaves_small", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_LARGE = registerEntry("paradise_log_large", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_MEDIUM = registerEntry("paradise_log_medium", () -> new Block(BlockBehaviour.Properties.of()));
        PARADISE_LOG_SMALL = registerEntry("paradise_log_small", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
