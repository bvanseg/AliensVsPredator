package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

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
public class AVPPaddingBlocks {

    private static final List<Tuple<GameObject<Block>, BlockData>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties ORANGE_PADDING_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.ORANGE_WOOL
    );

    public static final BlockBehaviour.Properties WHITE_PADDING_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.WHITE_WOOL
    );

    public static final GameObject<Block> PADDING_ORANGE_PANEL;

    public static final GameObject<Block> PADDING_ORANGE_PIPES;

    public static final GameObject<Block> PADDING_ORANGE_SQUARE;

    public static final GameObject<Block> PADDING_ORANGE_TILES;

    public static final GameObject<Block> PADDING_WHITE_PANEL;

    public static final GameObject<Block> PADDING_WHITE_PIPES;

    public static final GameObject<Block> PADDING_WHITE_SQUARE;

    public static final GameObject<Block> PADDING_WHITE_TILES;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    public static List<Tuple<GameObject<Block>, BlockData>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, BlockData blockData) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockData::create);
        ENTRIES.add(new Tuple<>(gameObject, blockData));
        return gameObject;
    }

    private AVPPaddingBlocks() {}

    static {
        PADDING_ORANGE_PANEL = register("padding_orange_panel", BlockData.simple(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_PIPES = register("padding_orange_pipes", BlockData.simple(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_SQUARE = register("padding_orange_square", BlockData.simple(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_TILES = register("padding_orange_tiles", BlockData.simple(ORANGE_PADDING_PROPERTIES));

        PADDING_WHITE_PANEL = register("padding_white_panel", BlockData.simple(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_PIPES = register("padding_white_pipes", BlockData.simple(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_SQUARE = register("padding_white_square", BlockData.simple(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_TILES = register("padding_white_tiles", BlockData.simple(WHITE_PADDING_PROPERTIES));
    }
}
