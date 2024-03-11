package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPEngineerBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPEngineerBlocks INSTANCE = new AVPEngineerBlocks();

    public static AVPEngineerBlocks getInstance() {
        return INSTANCE;
    }

    public static final BlockBehaviour.Properties ENGINEER_SHIP_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .strength(100.0F, 1800.0F);

    private AVPEngineerBlocks() {}

    @Override
    public void register() {
        registerEntry("engineer_ship_brick", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_brick_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_brick_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_brick_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_column_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_column_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_floor", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_gravel", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_material_0", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_material_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_material_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_rock", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_rock_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_rock_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_rock_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_wall", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_wall_1", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_wall_2", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_wall_3", () -> new Block(ENGINEER_SHIP_PROPERTIES));
        registerEntry("engineer_ship_wall_4", () -> new Block(ENGINEER_SHIP_PROPERTIES));
    }
}
