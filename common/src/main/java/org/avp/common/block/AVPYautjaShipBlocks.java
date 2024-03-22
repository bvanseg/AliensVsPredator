package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPYautjaShipBlocks {

    public static final BlockBehaviour.Properties YAUTJA_SHIP_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    )
        .mapColor(MapColor.COLOR_RED)
        .strength(75.0F, 1500.0F);

    public static final GameObject<Block> YAUTJA_SHIP_BRICK;

    public static final GameObject<Block> YAUTJA_SHIP_DECOR_1;

    public static final GameObject<Block> YAUTJA_SHIP_DECOR_2;

    public static final GameObject<Block> YAUTJA_SHIP_DECOR_3;

    public static final GameObject<Block> YAUTJA_SHIP_PANEL;

    public static final GameObject<Block> YAUTJA_SHIP_SUPPORT_PILLAR;

    public static final GameObject<Block> YAUTJA_SHIP_WALL_BASE;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPYautjaShipBlocks() {}

    static {
        YAUTJA_SHIP_BRICK = AVPBlocks.register("yautja_ship_brick", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_DECOR_1 = AVPBlocks.register("yautja_ship_decor_1", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_DECOR_2 = AVPBlocks.register("yautja_ship_decor_2", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_DECOR_3 = AVPBlocks.register("yautja_ship_decor_3", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_PANEL = AVPBlocks.register("yautja_ship_panel", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_SUPPORT_PILLAR = AVPBlocks.register("yautja_ship_support_pillar", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
        YAUTJA_SHIP_WALL_BASE = AVPBlocks.register("yautja_ship_wall_base", BlockData.simple(YAUTJA_SHIP_PROPERTIES));
    }
}
