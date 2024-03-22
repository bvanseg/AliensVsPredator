package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.api.block.BlockDataUtils;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPTempleBlocks {

    private static final List<Tuple<GameObject<Block>, BlockData>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties TEMPLE_BRICK_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.STONE
    )
        .strength(3.0F, 6.0F);

    public static final BlockBehaviour.Properties TEMPLE_SKULLS_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.BONE_BLOCK
    )
        .strength(3.0F, 6.0F);

    public static final GameObject<Block> TEMPLE_BRICK;

    public static final GameObject<Block> TEMPLE_BRICK_SLAB;

    public static final GameObject<Block> TEMPLE_BRICK_STAIRS;

    public static final GameObject<Block> TEMPLE_BRICK_WALL;

    public static final GameObject<Block> TEMPLE_BRICK_CHESTBURSTER;

    public static final GameObject<Block> TEMPLE_BRICK_FACEHUGGER;

    public static final GameObject<Block> TEMPLE_BRICK_SINGLE;

    public static final GameObject<Block> TEMPLE_BRICK_SINGLE_SLAB;

    public static final GameObject<Block> TEMPLE_BRICK_SINGLE_STAIRS;

    public static final GameObject<Block> TEMPLE_BRICK_SINGLE_WALL;

    public static final GameObject<Block> TEMPLE_FLOOR;

    public static final GameObject<Block> TEMPLE_FLOOR_SLAB;

    public static final GameObject<Block> TEMPLE_FLOOR_STAIRS;

    public static final GameObject<Block> TEMPLE_FLOOR_WALL;

    public static final GameObject<Block> TEMPLE_SKULLS;

    public static final GameObject<Block> TEMPLE_TILE;

    public static final GameObject<Block> TEMPLE_TILE_SLAB;

    public static final GameObject<Block> TEMPLE_TILE_STAIRS;

    public static final GameObject<Block> TEMPLE_TILE_WALL;

    public static final GameObject<Block> TEMPLE_WALL_BASE;

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

    private AVPTempleBlocks() {}

    static {
        TEMPLE_BRICK = register("temple_brick", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_SLAB = register("temple_brick_slab", BlockDataUtils.slab(TEMPLE_BRICK, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_STAIRS = register("temple_brick_stairs",  BlockDataUtils.stairs(TEMPLE_BRICK, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_WALL = register("temple_brick_wall",  BlockDataUtils.wall(TEMPLE_BRICK, TEMPLE_BRICK_PROPERTIES));

        TEMPLE_BRICK_CHESTBURSTER = register("temple_brick_chestburster", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_FACEHUGGER = register("temple_brick_facehugger", BlockData.simple(TEMPLE_BRICK_PROPERTIES));

        TEMPLE_BRICK_SINGLE = register("temple_brick_single", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_SINGLE_SLAB = register("temple_brick_single_slab", BlockDataUtils.slab(TEMPLE_BRICK_SINGLE, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_SINGLE_STAIRS = register(
            "temple_brick_single_stairs", BlockDataUtils.stairs(TEMPLE_BRICK_SINGLE, TEMPLE_BRICK_PROPERTIES)
        );
        TEMPLE_BRICK_SINGLE_WALL = register(
            "temple_brick_single_wall", BlockDataUtils.wall(TEMPLE_BRICK_SINGLE, TEMPLE_BRICK_PROPERTIES)
        );

        TEMPLE_FLOOR = register("temple_floor", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_FLOOR_SLAB = register("temple_floor_slab", BlockDataUtils.slab(TEMPLE_FLOOR, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_FLOOR_STAIRS = register("temple_floor_stairs", BlockDataUtils.stairs(TEMPLE_FLOOR, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_FLOOR_WALL = register("temple_floor_wall", BlockDataUtils.wall(TEMPLE_FLOOR, TEMPLE_BRICK_PROPERTIES));

        TEMPLE_SKULLS = register("temple_skulls", BlockData.simple(TEMPLE_SKULLS_PROPERTIES));

        TEMPLE_TILE = register("temple_tile", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_TILE_SLAB = register("temple_tile_slab", BlockDataUtils.slab(TEMPLE_TILE, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_TILE_STAIRS = register("temple_tile_stairs", BlockDataUtils.stairs(TEMPLE_TILE, TEMPLE_BRICK_PROPERTIES));
        TEMPLE_TILE_WALL = register("temple_tile_wall", BlockDataUtils.wall(TEMPLE_TILE, TEMPLE_BRICK_PROPERTIES));

        TEMPLE_WALL_BASE = register("temple_wall_base", BlockData.simple(TEMPLE_BRICK_PROPERTIES));
    }
}
