package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPBlocks INSTANCE = new AVPBlocks();

    public static AVPBlocks getInstance() {
        return INSTANCE;
    }

    public static final BlockBehaviour.Properties ALUMINUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK);

    private AVPBlocks() {}

    @Override
    public void register() {
        registerEntry("aluminum_block", () -> new Block(ALUMINUM_PROPERTIES));
    }
}
