package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPOreBlocks implements AVPRegistry {

    private static final AVPOreBlocks INSTANCE = new AVPOreBlocks();

    public static AVPOreBlocks getInstance() {
        return INSTANCE;
    }

    private AVPOreBlocks() {}

    @Override
    public void register() {
        Services.BLOCK_REGISTRY.register("ore_bauxite", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("ore_cobalt", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("ore_lithium", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("ore_monazite", () -> new Block(BlockBehaviour.Properties.of()));
        Services.BLOCK_REGISTRY.register("ore_silica", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
