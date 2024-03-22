package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.api.block.drop.BlockDropUtils;
import org.avp.api.block.drop.BlockDrops;
import org.avp.common.item.AVPItems;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPOreBlocks {

    public static final BlockBehaviour.Properties BAUXITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.STONE
    )
        .strength(3.2F, 2.6F);

    public static final BlockBehaviour.Properties COBALT_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(50F, 20F);

    public static final BlockBehaviour.Properties LITHIUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.STONE
    )
        .strength(4.2F, 5.4F);

    public static final BlockBehaviour.Properties MONAZITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.STONE
    )
        .strength(45F, 15F);

    public static final BlockBehaviour.Properties SILICA_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(2.2F, 1.4F);

    public static final GameObject<Block> ORE_BAUXITE;

    public static final GameObject<Block> ORE_COBALT;

    public static final GameObject<Block> ORE_LITHIUM;

    public static final GameObject<Block> ORE_MONAZITE;

    public static final GameObject<Block> ORE_SILICA;

    public static final GameObject<Block> RAW_BAUXITE_BLOCK;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    private AVPOreBlocks() {}

    static {
        ORE_BAUXITE = AVPBlocks.register(
            "ore_bauxite",
            BlockData.builder(BAUXITE_PROPERTIES).drop(BlockDropUtils.ore(AVPItems.RAW_BAUXITE)).build()
        );
        ORE_COBALT = AVPBlocks.register("ore_cobalt",
            BlockData.builder(COBALT_PROPERTIES).drop(BlockDropUtils.ore(AVPItems.COBALT)).build()
        );
        ORE_LITHIUM = AVPBlocks.register("ore_lithium",
            BlockData.builder(LITHIUM_PROPERTIES).drop(BlockDropUtils.ore(AVPItems.INGOT_LITHIUM)).build()
        );
        ORE_MONAZITE = AVPBlocks.register("ore_monazite",
            BlockData.builder(MONAZITE_PROPERTIES).drop(BlockDropUtils.ore(AVPItems.NEODYMIUM)).build()
        );
        ORE_SILICA = AVPBlocks.register("ore_silica",
            BlockData.builder(SILICA_PROPERTIES).drop(BlockDropUtils.ore(AVPItems.SILICA)).build()
        );

        RAW_BAUXITE_BLOCK = AVPBlocks.register("raw_bauxite_block", BlockData.simple(BAUXITE_PROPERTIES));
    }
}
