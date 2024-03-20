package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class AVPPaddingBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

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

    public static List<GameObject<Block>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, Supplier<Block> blockSupplier) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockSupplier);
        ENTRIES.add(gameObject);
        return gameObject;
    }

    private AVPPaddingBlocks() {}

    static {
        PADDING_ORANGE_PANEL = register("padding_orange_panel", () -> new Block(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_PIPES = register("padding_orange_pipes", () -> new Block(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_SQUARE = register("padding_orange_square", () -> new Block(ORANGE_PADDING_PROPERTIES));
        PADDING_ORANGE_TILES = register("padding_orange_tiles", () -> new Block(ORANGE_PADDING_PROPERTIES));

        PADDING_WHITE_PANEL = register("padding_white_panel", () -> new Block(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_PIPES = register("padding_white_pipes", () -> new Block(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_SQUARE = register("padding_white_square", () -> new Block(WHITE_PADDING_PROPERTIES));
        PADDING_WHITE_TILES = register("padding_white_tiles", () -> new Block(WHITE_PADDING_PROPERTIES));
    }
}
