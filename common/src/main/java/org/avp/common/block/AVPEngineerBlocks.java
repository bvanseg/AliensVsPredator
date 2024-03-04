package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPEngineerBlocks implements AVPRegistry {

    private static final AVPEngineerBlocks INSTANCE = new AVPEngineerBlocks();

    public static AVPEngineerBlocks getInstance() {
        return INSTANCE;
    }

    private AVPEngineerBlocks() {}

    @Override
    public void register() {
        Services.BLOCK_REGISTRY.register("engineer_ship_brick", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_brick_1", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_brick_2", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_brick_3", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_column_1", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_column_2", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_floor", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_gravel", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_material_0", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_material_1", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_material_2", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_rock", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_rock_1", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_rock_2", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_rock_3", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_wall", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_wall_1", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_wall_2", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_wall_3", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("engineer_ship_wall_4", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
