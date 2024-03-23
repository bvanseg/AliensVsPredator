package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.api.block.BlockData;
import org.avp.api.block.BlockDataUtils;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPIndustrialBlocks {

    public static final BlockBehaviour.Properties INDUSTRIAL_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    );

    public static final BlockBehaviour.Properties INDUSTRIAL_GLASS_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.GLASS
    );

    public static final GameObject<Block> INDUSTRIAL_BRICK;

    public static final GameObject<Block> INDUSTRIAL_BRICK_SLAB;

    public static final GameObject<Block> INDUSTRIAL_BRICK_STAIRS;

    public static final GameObject<Block> INDUSTRIAL_FLOOR_GRILL;

    public static final GameObject<Block> INDUSTRIAL_GLASS;

    public static final GameObject<Block> INDUSTRIAL_LAMP;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_0;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_0_SLAB;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_0_STAIRS;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_1;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_1_SLAB;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_1_STAIRS;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_2;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_2_SLAB;

    public static final GameObject<Block> INDUSTRIAL_METAL_PANEL_2_STAIRS;

    public static final GameObject<Block> INDUSTRIAL_VENT;

    public static final GameObject<Block> INDUSTRIAL_WALL;

    public static final GameObject<Block> INDUSTRIAL_WALL_SLAB;

    public static final GameObject<Block> INDUSTRIAL_WALL_STAIRS;

    public static final GameObject<Block> INDUSTRIAL_WALL_HAZARD;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPIndustrialBlocks() {}

    static {
        INDUSTRIAL_BRICK = AVPBlocks.register("industrial_brick", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_BRICK_SLAB = AVPBlocks.register(
            "industrial_brick_slab",
            BlockDataUtils.slab(INDUSTRIAL_BRICK, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_BRICK_STAIRS = AVPBlocks.register(
            "industrial_brick_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_BRICK, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_FLOOR_GRILL = AVPBlocks.register("industrial_floor_grill", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_GLASS = AVPBlocks.register(
            "industrial_glass",
            BlockDataUtils.transparent(INDUSTRIAL_GLASS_PROPERTIES)
        );
        INDUSTRIAL_LAMP = AVPBlocks.register("industrial_lamp", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_0 = AVPBlocks.register(
            "industrial_metal_panel_0",
            BlockData.simple(INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_0_SLAB = AVPBlocks.register(
            "industrial_metal_panel_0_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_0, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_0_STAIRS = AVPBlocks.register(
            "industrial_metal_panel_0_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_0, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_1 = AVPBlocks.register(
            "industrial_metal_panel_1",
            BlockData.simple(INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_1_SLAB = AVPBlocks.register(
            "industrial_metal_panel_1_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_1, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_1_STAIRS = AVPBlocks.register(
            "industrial_metal_panel_1_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_1, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_2 = AVPBlocks.register(
            "industrial_metal_panel_2",
            BlockData.simple(INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_2_SLAB = AVPBlocks.register(
            "industrial_metal_panel_2_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_2, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_2_STAIRS = AVPBlocks.register(
            "industrial_metal_panel_2_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_2, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_VENT = AVPBlocks.register("industrial_vent", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL = AVPBlocks.register("industrial_wall", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_SLAB = AVPBlocks.register(
            "industrial_wall_slab",
            BlockDataUtils.slab(INDUSTRIAL_WALL, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_WALL_STAIRS = AVPBlocks.register(
            "industrial_wall_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_WALL, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_WALL_HAZARD = AVPBlocks.register(
            "industrial_wall_hazard",
            BlockDataUtils.rotatedPillar(INDUSTRIAL_PROPERTIES)
        );
    }
}
