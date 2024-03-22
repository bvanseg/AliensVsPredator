package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.api.block.BlockDataUtils;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPIndustrialBlocks {

    private static final List<Tuple<GameObject<Block>, BlockData>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties INDUSTRIAL_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
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

    public static List<Tuple<GameObject<Block>, BlockData>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, BlockData blockData) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockData::create);
        ENTRIES.add(new Tuple<>(gameObject, blockData));
        return gameObject;
    }

    private AVPIndustrialBlocks() {}

    static {
        INDUSTRIAL_BRICK = register("industrial_brick", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_BRICK_SLAB = register("industrial_brick_slab", BlockDataUtils.slab(INDUSTRIAL_BRICK, INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_BRICK_STAIRS = register("industrial_brick_stairs", BlockDataUtils.stairs(INDUSTRIAL_BRICK, INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_FLOOR_GRILL = register("industrial_floor_grill", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_GLASS = register("industrial_glass", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_LAMP = register("industrial_lamp", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_0 = register("industrial_metal_panel_0", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_0_SLAB = register(
            "industrial_metal_panel_0_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_0, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_0_STAIRS = register(
            "industrial_metal_panel_0_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_0, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_1 = register("industrial_metal_panel_1", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_1_SLAB = register(
            "industrial_metal_panel_1_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_1, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_1_STAIRS = register(
            "industrial_metal_panel_1_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_1, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_2 = register("industrial_metal_panel_2", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_METAL_PANEL_2_SLAB = register(
            "industrial_metal_panel_2_slab",
            BlockDataUtils.slab(INDUSTRIAL_METAL_PANEL_2, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_METAL_PANEL_2_STAIRS = register(
            "industrial_metal_panel_2_stairs",
            BlockDataUtils.stairs(INDUSTRIAL_METAL_PANEL_2, INDUSTRIAL_PROPERTIES)
        );
        INDUSTRIAL_VENT = register("industrial_vent", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL = register("industrial_wall", BlockData.simple(INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_SLAB = register("industrial_wall_slab", BlockDataUtils.slab(INDUSTRIAL_WALL, INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_STAIRS = register("industrial_wall_stairs", BlockDataUtils.stairs(INDUSTRIAL_WALL, INDUSTRIAL_PROPERTIES));
        INDUSTRIAL_WALL_HAZARD = register("industrial_wall_hazard", BlockData.simple(INDUSTRIAL_PROPERTIES));
    }
}
