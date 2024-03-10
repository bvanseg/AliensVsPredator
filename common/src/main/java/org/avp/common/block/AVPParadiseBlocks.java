package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPParadiseBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPParadiseBlocks INSTANCE = new AVPParadiseBlocks();

    public static AVPParadiseBlocks getInstance() {
        return INSTANCE;
    }

    private AVPParadiseBlocks() {}

    @Override
    public void register() {
        registerEntry("paradise_dirt", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_dirt_mossy", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_dirt_podzol", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_grass", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_leaves_large", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_leaves_medium", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_leaves_small", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_log_large", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_log_medium", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("paradise_log_small", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
