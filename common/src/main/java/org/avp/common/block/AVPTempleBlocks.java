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
public class AVPTempleBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties TEMPLE_BRICK_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(3.0F, 6.0F);

    public static final BlockBehaviour.Properties TEMPLE_SKULLS_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.BONE_BLOCK
    )
        .strength(3.0F, 6.0F);

    public static final GameObject<Block> TEMPLE_BRICK;

    public static final GameObject<Block> TEMPLE_BRICK_CHESTBURSTER;

    public static final GameObject<Block> TEMPLE_BRICK_FACEHUGGER;

    public static final GameObject<Block> TEMPLE_BRICK_SINGLE;

    public static final GameObject<Block> TEMPLE_FLOOR;

    public static final GameObject<Block> TEMPLE_SKULLS;

    public static final GameObject<Block> TEMPLE_TEMPLE_TILE;

    public static final GameObject<Block> TEMPLE_WALL_BASE;

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

    private AVPTempleBlocks() {}

    static {
        TEMPLE_BRICK = register("temple_brick", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_CHESTBURSTER = register(
            "temple_brick_chestburster",
            () -> new Block(TEMPLE_BRICK_PROPERTIES)
        );
        TEMPLE_BRICK_FACEHUGGER = register("temple_brick_facehugger", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_SINGLE = register("temple_brick_single", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_FLOOR = register("temple_floor", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_SKULLS = register("temple_skulls", () -> new Block(TEMPLE_SKULLS_PROPERTIES));
        TEMPLE_TEMPLE_TILE = register("temple_tile", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_WALL_BASE = register("temple_wall_base", () -> new Block(TEMPLE_BRICK_PROPERTIES));
    }
}
