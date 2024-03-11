package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import net.minecraft.world.level.material.MapColor;
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

    public static final BlockBehaviour.Properties YAUTJA_SHIP_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK)
        .mapColor(MapColor.COLOR_RED)
        .strength(75.0F, 1500.0F);

    private AVPYautjaShipBlocks() {}

    @Override
    public void register() {
        registerEntry("yautja_ship_brick", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_decor_1", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_decor_2", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_decor_3", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_panel", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_support_pillar", () -> new Block(YAUTJA_SHIP_PROPERTIES));
        registerEntry("yautja_ship_wall_base", () -> new Block(YAUTJA_SHIP_PROPERTIES));
    }
}
