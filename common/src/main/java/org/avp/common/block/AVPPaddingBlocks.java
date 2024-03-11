package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public final BlockBehaviour.Properties ORANGE_PADDING_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.ORANGE_WOOL);
    public final BlockBehaviour.Properties WHITE_PADDING_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.WHITE_WOOL);

    private AVPPaddingBlocks() {}

    @Override
    public void register() {
        registerEntry("padding_orange_panel", () -> new Block(ORANGE_PADDING_PROPERTIES));
        registerEntry("padding_orange_pipes", () -> new Block(ORANGE_PADDING_PROPERTIES));
        registerEntry("padding_orange_square", () -> new Block(ORANGE_PADDING_PROPERTIES));
        registerEntry("padding_orange_tiles", () -> new Block(ORANGE_PADDING_PROPERTIES));

        registerEntry("padding_white_panel", () -> new Block(WHITE_PADDING_PROPERTIES));
        registerEntry("padding_white_pipes", () -> new Block(WHITE_PADDING_PROPERTIES));
        registerEntry("padding_white_square", () -> new Block(WHITE_PADDING_PROPERTIES));
        registerEntry("padding_white_tiles", () -> new Block(WHITE_PADDING_PROPERTIES));
    }
}
