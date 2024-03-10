package org.avp.common.block;

import net.minecraft.world.level.block.Block;
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

    public final GameObject<Block> TEMPLE_BRICK = registerEntry(
        "temple_brick",
        () -> new Block(BlockBehaviour.Properties.of())
    );

    private AVPTempleBlocks() {}

    @Override
    public void register() {
        registerEntry("temple_brick_chestburster", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_brick_facehugger", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_brick_single", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_floor", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_skulls", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_tile", () -> new Block(BlockBehaviour.Properties.of()));
        registerEntry("temple_wall_base", () -> new Block(BlockBehaviour.Properties.of()));
    }
}
