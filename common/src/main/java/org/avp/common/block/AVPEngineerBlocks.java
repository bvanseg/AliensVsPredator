package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.common.service.Services;
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

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_1;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_2;

    public static final GameObject<Block> ENGINEER_SHIP_BRICK_3;

    public static final GameObject<Block> ENGINEER_SHIP_COLUMN_1;

    public static final GameObject<Block> ENGINEER_SHIP_COLUMN_2;

    public static final GameObject<Block> ENGINEER_SHIP_FLOOR;

    public static final GameObject<Block> ENGINEER_SHIP_GRAVEL;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_0;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_1;

    public static final GameObject<Block> ENGINEER_SHIP_MATERIAL_2;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_1;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_2;

    public static final GameObject<Block> ENGINEER_SHIP_ROCK_3;

    public static final GameObject<Block> ENGINEER_SHIP_WALL;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_1;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_2;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_3;

    public static final GameObject<Block> ENGINEER_SHIP_WALL_4;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPEngineerBlocks() {}

    static {
        ENGINEER_SHIP_BRICK = AVPBlocks.register("engineer_ship_brick", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_1 = AVPBlocks.register("engineer_ship_brick_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_2 = AVPBlocks.register("engineer_ship_brick_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_3 = AVPBlocks.register("engineer_ship_brick_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_COLUMN_1 = AVPBlocks.register("engineer_ship_column_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_COLUMN_2 = AVPBlocks.register("engineer_ship_column_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_FLOOR = AVPBlocks.register("engineer_ship_floor", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_GRAVEL = AVPBlocks.register("engineer_ship_gravel", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_0 = AVPBlocks.register("engineer_ship_material_0", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_1 = AVPBlocks.register("engineer_ship_material_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_2 = AVPBlocks.register("engineer_ship_material_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK = AVPBlocks.register("engineer_ship_rock", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_1 = AVPBlocks.register("engineer_ship_rock_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_2 = AVPBlocks.register("engineer_ship_rock_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_3 = AVPBlocks.register("engineer_ship_rock_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL = AVPBlocks.register("engineer_ship_wall", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_1 = AVPBlocks.register("engineer_ship_wall_1", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_2 = AVPBlocks.register("engineer_ship_wall_2", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_3 = AVPBlocks.register("engineer_ship_wall_3", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_4 = AVPBlocks.register("engineer_ship_wall_4", BlockData.simple(ENGINEER_SHIP_PROPERTIES));
    }

}
