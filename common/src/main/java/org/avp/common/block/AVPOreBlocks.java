package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPOreBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPOreBlocks INSTANCE = new AVPOreBlocks();

    public static AVPOreBlocks getInstance() {
        return INSTANCE;
    }

    private AVPOreBlocks() {}

    @Override
    public void register() {
        registerEntry("ore_bauxite", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("ore_cobalt", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("ore_lithium", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("ore_monazite", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("ore_silica", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
