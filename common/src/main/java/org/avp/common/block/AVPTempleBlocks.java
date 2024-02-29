package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPTempleBlocks implements AVPRegistry {

    private static final AVPTempleBlocks INSTANCE = new AVPTempleBlocks();

    public static AVPTempleBlocks getInstance() {
        return INSTANCE;
    }

    private AVPTempleBlocks() {}

    @Override
    public void register() {
        Services.BLOCK_REGISTRY.register("temple_brick", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_brick_chestburster", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_brick_facehugger", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_brick_single", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_floor", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_tile", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("temple_wall_base", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
