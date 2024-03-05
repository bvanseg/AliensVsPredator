package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPIndustrialBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPIndustrialBlocks INSTANCE = new AVPIndustrialBlocks();

    public static AVPIndustrialBlocks getInstance() {
        return INSTANCE;
    }

    private AVPIndustrialBlocks() {}

    @Override
    public void register() {
        registerEntry("industrial_glass", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
