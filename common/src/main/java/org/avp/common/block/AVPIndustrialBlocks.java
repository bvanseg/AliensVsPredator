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
        registerEntry("industrial_brick", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_floor_grill", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_glass", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_lamp", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_metal_panel_0", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_metal_panel_1", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_metal_panel_2", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_vent", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_wall", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("industrial_wall_hazard", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
