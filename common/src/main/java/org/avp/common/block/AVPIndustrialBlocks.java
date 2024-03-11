package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
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

    public static final BlockBehaviour.Properties INDUSTRIAL_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK);

    private AVPIndustrialBlocks() {}

    @Override
    public void register() {
        registerEntry("industrial_brick", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_floor_grill", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_glass", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_lamp", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_metal_panel_0", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_metal_panel_1", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_metal_panel_2", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_vent", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_wall", () -> new Block(INDUSTRIAL_PROPERTIES));
        registerEntry("industrial_wall_hazard", () -> new Block(INDUSTRIAL_PROPERTIES));
    }
}
