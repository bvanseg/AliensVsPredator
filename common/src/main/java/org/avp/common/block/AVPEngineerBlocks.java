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
public class AVPEngineerBlocks {

    public static final BlockBehaviour.Properties ENGINEER_SHIP_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    )
        .strength(100.0F, 1800.0F);

    public static final GameObject<Block> ENGINEER_SHIP_BRICK;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_1;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_1_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_1_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_1_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_2;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_2_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_2_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_2_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_3;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_3_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_3_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_3_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_COLUMN_1;

    public static final GameObject<Block> ENGINEER_SHIP_COLUMN_2;

    public static final GameObject<Block> ENGINEER_SHIP_FLOOR;

    public static final GameObject<Block> ENGINEER_SHIP_GRAVEL;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_0;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_0_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_0_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_0_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_1;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_1_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_1_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_1_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_2;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_2_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_2_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_2_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_1;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_2;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_3;

    public static final GameObject<Block> ENGINEER_SHIP_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_1;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_1_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_1_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_1_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_2;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_2_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_2_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_2_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_3;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_3_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_3_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_3_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_4;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_4_SLAB;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_4_STAIRS;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_4_WALL;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPEngineerBlocks() {}

    static {
        ENGINEER_SHIP_BRICK = AVPBlocks.register("engineer_ship_brick", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_SLAB = AVPBlocks.register(
            "engineer_ship_brick_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_BRICK, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_STAIRS = AVPBlocks.register(
            "engineer_ship_brick_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_BRICK, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_WALL = AVPBlocks.register(
            "engineer_ship_brick_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_BRICK, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_BRICK_1 = AVPBlocks.register("engineer_ship_brick_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_1_SLAB = AVPBlocks.register(
            "engineer_ship_brick_1_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_BRICK_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_1_STAIRS = AVPBlocks.register(
            "engineer_ship_brick_1_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_BRICK_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_1_WALL = AVPBlocks.register(
            "engineer_ship_brick_1_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_BRICK_1, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_BRICK_2 = AVPBlocks.register("engineer_ship_brick_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_2_SLAB = AVPBlocks.register(
            "engineer_ship_brick_2_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_BRICK_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_2_STAIRS = AVPBlocks.register(
            "engineer_ship_brick_2_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_BRICK_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_2_WALL = AVPBlocks.register(
            "engineer_ship_brick_2_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_BRICK_2, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_BRICK_3 = AVPBlocks.register("engineer_ship_brick_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_3_SLAB = AVPBlocks.register(
            "engineer_ship_brick_3_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_BRICK_3, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_3_STAIRS = AVPBlocks.register(
            "engineer_ship_brick_3_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_BRICK_3, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_BRICK_3_WALL = AVPBlocks.register(
            "engineer_ship_brick_3_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_BRICK_3, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_COLUMN_1 = AVPBlocks.register(
            "engineer_ship_column_1",
            BlockData.simple(ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_COLUMN_2 = AVPBlocks.register(
            "engineer_ship_column_2",
            BlockData.simple(ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_FLOOR = AVPBlocks.register("engineer_ship_floor", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_GRAVEL = AVPBlocks.register("engineer_ship_gravel", BlockData.simple(ENGINEER_SHIP_PROPERTIES));

        ENGINEER_SHIP_MATERIAL_0 = AVPBlocks.register(
            "engineer_ship_material_0",
            BlockData.simple(ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_0_SLAB = AVPBlocks.register(
            "engineer_ship_material_0_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_MATERIAL_0, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_0_STAIRS = AVPBlocks.register(
            "engineer_ship_material_0_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_MATERIAL_0, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_0_WALL = AVPBlocks.register(
            "engineer_ship_material_0_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_MATERIAL_0, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_MATERIAL_1 = AVPBlocks.register(
            "engineer_ship_material_1",
            BlockData.simple(ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_1_SLAB = AVPBlocks.register(
            "engineer_ship_material_1_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_MATERIAL_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_1_STAIRS = AVPBlocks.register(
            "engineer_ship_material_1_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_MATERIAL_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_1_WALL = AVPBlocks.register(
            "engineer_ship_material_1_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_MATERIAL_1, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_MATERIAL_2 = AVPBlocks.register(
            "engineer_ship_material_2",
            BlockData.simple(ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_2_SLAB = AVPBlocks.register(
            "engineer_ship_material_2_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_MATERIAL_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_2_STAIRS = AVPBlocks.register(
            "engineer_ship_material_2_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_MATERIAL_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_MATERIAL_2_WALL = AVPBlocks.register(
            "engineer_ship_material_2_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_MATERIAL_2, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_ROCK = AVPBlocks.register("engineer_ship_rock", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_1 = AVPBlocks.register("engineer_ship_rock_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_2 = AVPBlocks.register("engineer_ship_rock_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_3 = AVPBlocks.register("engineer_ship_rock_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));

        ENGINEER_SHIP_WALL = AVPBlocks.register("engineer_ship_wall", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_SLAB = AVPBlocks.register(
            "engineer_ship_wall_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_WALL, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_STAIRS = AVPBlocks.register(
            "engineer_ship_wall_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_WALL, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_WALL = AVPBlocks.register(
            "engineer_ship_wall_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_WALL, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_WALL_1 = AVPBlocks.register("engineer_ship_wall_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_1_SLAB = AVPBlocks.register(
            "engineer_ship_wall_1_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_WALL_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_1_STAIRS = AVPBlocks.register(
            "engineer_ship_wall_1_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_WALL_1, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_1_WALL = AVPBlocks.register(
            "engineer_ship_wall_1_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_WALL_1, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_WALL_2 = AVPBlocks.register("engineer_ship_wall_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_2_SLAB = AVPBlocks.register(
            "engineer_ship_wall_2_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_WALL_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_2_STAIRS = AVPBlocks.register(
            "engineer_ship_wall_2_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_WALL_2, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_2_WALL = AVPBlocks.register(
            "engineer_ship_wall_2_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_WALL_2, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_WALL_3 = AVPBlocks.register("engineer_ship_wall_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_3_SLAB = AVPBlocks.register(
            "engineer_ship_wall_3_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_WALL_3, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_3_STAIRS = AVPBlocks.register(
            "engineer_ship_wall_3_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_WALL_3, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_3_WALL = AVPBlocks.register(
            "engineer_ship_wall_3_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_WALL_3, ENGINEER_SHIP_PROPERTIES)
        );

        ENGINEER_SHIP_WALL_4 = AVPBlocks.register("engineer_ship_wall_4", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_4_SLAB = AVPBlocks.register(
            "engineer_ship_wall_4_slab",
            BlockDataUtils.slab(ENGINEER_SHIP_WALL_4, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_4_STAIRS = AVPBlocks.register(
            "engineer_ship_wall_4_stairs",
            BlockDataUtils.stairs(ENGINEER_SHIP_WALL_4, ENGINEER_SHIP_PROPERTIES)
        );
        ENGINEER_SHIP_WALL_4_WALL = AVPBlocks.register(
            "engineer_ship_wall_4_wall",
            BlockDataUtils.wall(ENGINEER_SHIP_WALL_4, ENGINEER_SHIP_PROPERTIES)
        );
    }

}
