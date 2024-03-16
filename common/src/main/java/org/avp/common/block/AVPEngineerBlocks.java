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
public class AVPEngineerBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPEngineerBlocks INSTANCE = new AVPEngineerBlocks();

    public static AVPEngineerBlocks getInstance() {
        return INSTANCE;
    }

    public static final BlockBehaviour.Properties ENGINEER_SHIP_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    )
        .strength(100.0F, 1800.0F);

    public static GameObject<Block> ENGINEER_SHIP_BRICK;

    public static GameObject<Block> ENGINEER_SHIP_BRICK_1;

    public static GameObject<Block> ENGINEER_SHIP_BRICK_2;

    public static GameObject<Block> ENGINEER_SHIP_BRICK_3;

    public static GameObject<Block> ENGINEER_SHIP_COLUMN_1;

    public static GameObject<Block> ENGINEER_SHIP_COLUMN_2;

    public static GameObject<Block> ENGINEER_SHIP_FLOOR;

    public static GameObject<Block> ENGINEER_SHIP_GRAVEL;

    public static GameObject<Block> ENGINEER_SHIP_MATERIAL_0;

    public static GameObject<Block> ENGINEER_SHIP_MATERIAL_1;

    public static GameObject<Block> ENGINEER_SHIP_MATERIAL_2;

    public static GameObject<Block> ENGINEER_SHIP_ROCK;

    public static GameObject<Block> ENGINEER_SHIP_ROCK_1;

    public static GameObject<Block> ENGINEER_SHIP_ROCK_2;

    public static GameObject<Block> ENGINEER_SHIP_ROCK_3;

    public static GameObject<Block> ENGINEER_SHIP_WALL;

    public static GameObject<Block> ENGINEER_SHIP_WALL_1;

    public static GameObject<Block> ENGINEER_SHIP_WALL_2;

    public static GameObject<Block> ENGINEER_SHIP_WALL_3;

    public static GameObject<Block> ENGINEER_SHIP_WALL_4;

    private AVPEngineerBlocks() {}

    @Override
    public void register() {
        ENGINEER_SHIP_BRICK = registerEntry("engineer_ship_brick", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_1 = registerEntry("engineer_ship_brick_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_2 = registerEntry("engineer_ship_brick_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_BRICK_3 = registerEntry("engineer_ship_brick_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_COLUMN_1 = registerEntry("engineer_ship_column_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_COLUMN_2 = registerEntry("engineer_ship_column_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_FLOOR = registerEntry("engineer_ship_floor", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_GRAVEL = registerEntry("engineer_ship_gravel", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_0 = registerEntry("engineer_ship_material_0", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_1 = registerEntry("engineer_ship_material_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_MATERIAL_2 = registerEntry("engineer_ship_material_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK = registerEntry("engineer_ship_rock", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_1 = registerEntry("engineer_ship_rock_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_2 = registerEntry("engineer_ship_rock_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_ROCK_3 = registerEntry("engineer_ship_rock_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL = registerEntry("engineer_ship_wall", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_1 = registerEntry("engineer_ship_wall_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_2 = registerEntry("engineer_ship_wall_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_3 = registerEntry("engineer_ship_wall_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        ENGINEER_SHIP_WALL_4 = registerEntry("engineer_ship_wall_4", () -> new Block(ENGINEER_SHIP_PROPERTIES));
    }
}
