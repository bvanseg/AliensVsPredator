package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPTempleBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPTempleBlocks INSTANCE = new AVPTempleBlocks();

    public static AVPTempleBlocks getInstance() {
        return INSTANCE;
    }

    public final BlockBehaviour.Properties TEMPLE_BRICK_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(3.0F, 6.0F);

    public final BlockBehaviour.Properties TEMPLE_SKULLS_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.BONE_BLOCK
    )
        .strength(3.0F, 6.0F);

    public static GameObject<Block> TEMPLE_BRICK;
    public static GameObject<Block> TEMPLE_BRICK_CHESTBURSTER;
    public static GameObject<Block> TEMPLE_BRICK_FACEHUGGER;
    public static GameObject<Block> TEMPLE_BRICK_SINGLE;
    public static GameObject<Block> TEMPLE_FLOOR;
    public static GameObject<Block> TEMPLE_SKULLS;
    public static GameObject<Block> TEMPLE_TEMPLE_TILE;
    public static GameObject<Block> TEMPLE_WALL_BASE;

    private AVPTempleBlocks() {}

    @Override
    public void register() {
        TEMPLE_BRICK = registerEntry("temple_brick", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_CHESTBURSTER = registerEntry("temple_brick_chestburster", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_FACEHUGGER = registerEntry("temple_brick_facehugger", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_BRICK_SINGLE = registerEntry("temple_brick_single", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_FLOOR = registerEntry("temple_floor", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_SKULLS = registerEntry("temple_skulls", () -> new Block(TEMPLE_SKULLS_PROPERTIES));
        TEMPLE_TEMPLE_TILE = registerEntry("temple_tile", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        TEMPLE_WALL_BASE = registerEntry("temple_wall_base", () -> new Block(TEMPLE_BRICK_PROPERTIES));
    }
}
