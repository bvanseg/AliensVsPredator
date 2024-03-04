package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPPaddingBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPPaddingBlocks INSTANCE = new AVPPaddingBlocks();

    public static AVPPaddingBlocks getInstance() {
        return INSTANCE;
    }

    private AVPPaddingBlocks() {}

    @Override
    public void register() {
        registerEntry("padding_orange_panel", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_orange_pipes", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_orange_square", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_orange_tiles", () -> new Block(BlockBehaviour.Properties.of()));

        registerEntry("padding_white_panel", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_white_pipes", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_white_square", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("padding_white_tiles", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
