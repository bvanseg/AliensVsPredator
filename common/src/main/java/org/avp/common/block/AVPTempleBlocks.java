package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
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

    public final BlockBehaviour.Properties TEMPLE_SKULLS_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.BONE_BLOCK)
        .strength(3.0F, 6.0F);

    public final GameObject<Block> TEMPLE_BRICK = registerEntry(
        "temple_brick",
        () -> new Block(TEMPLE_BRICK_PROPERTIES)
    );

    private AVPTempleBlocks() {}

    @Override
    public void register() {
        registerEntry("temple_brick_chestburster", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        registerEntry("temple_brick_facehugger", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        registerEntry("temple_brick_single", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        registerEntry("temple_floor", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        registerEntry("temple_skulls", () -> new Block(TEMPLE_SKULLS_PROPERTIES));
        registerEntry("temple_tile", () -> new Block(TEMPLE_BRICK_PROPERTIES));
        registerEntry("temple_wall_base", () -> new Block(TEMPLE_BRICK_PROPERTIES));
    }
}
