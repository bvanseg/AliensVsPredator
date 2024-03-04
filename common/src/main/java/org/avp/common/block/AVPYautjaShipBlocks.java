package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPYautjaShipBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPYautjaShipBlocks INSTANCE = new AVPYautjaShipBlocks();

    public static AVPYautjaShipBlocks getInstance() {
        return INSTANCE;
    }

    private AVPYautjaShipBlocks() {}

    @Override
    public void register() {
        registerEntry("yautja_ship_brick", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_decor_1", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_decor_2", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_decor_3", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_panel", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_support_pillar", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("yautja_ship_wall_base", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
