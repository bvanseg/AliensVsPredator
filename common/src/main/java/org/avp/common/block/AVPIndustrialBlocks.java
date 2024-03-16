package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPIndustrialBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPIndustrialBlocks INSTANCE = new AVPIndustrialBlocks();

    public static AVPIndustrialBlocks getInstance() {
        return INSTANCE;
    }

    public static final BlockBehaviour.Properties INDUSTRIAL_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    );

    public static GameObject<Block> INDUSTRIAL_BRICK;

    public static GameObject<Block> INDUSTRIAL_FLOOR_GRILL;

    public static GameObject<Block> INDUSTRIAL_GLASS;

    public static GameObject<Block> INDUSTRIAL_LAMP;

    public static GameObject<Block> INDUSTRIAL_METAL_PANEL_0;

    public static GameObject<Block> INDUSTRIAL_METAL_PANEL_1;

    public static GameObject<Block> INDUSTRIAL_METAL_PANEL_2;

    public static GameObject<Block> INDUSTRIAL_VENT;

    public static GameObject<Block> INDUSTRIAL_WALL;

    public static GameObject<Block> INDUSTRIAL_WALL_HAZARD;

    private AVPIndustrialBlocks() {}

    @Override
    public void register() {
        INDUSTRIAL_BRICK = registerEntry("industrial_brick", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_FLOOR_GRILL = registerEntry("industrial_floor_grill", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_GLASS = registerEntry("industrial_glass", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_LAMP = registerEntry("industrial_lamp", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_0 = registerEntry("industrial_metal_panel_0", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_1 = registerEntry("industrial_metal_panel_1", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_2 = registerEntry("industrial_metal_panel_2", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_VENT = registerEntry("industrial_vent", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL = registerEntry("industrial_wall", () -> new Block(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_HAZARD = registerEntry("industrial_wall_hazard", () -> new Block(INDUSTRIAL_PROPERTIES));
    }
}
