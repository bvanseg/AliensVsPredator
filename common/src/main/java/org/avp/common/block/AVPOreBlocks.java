package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;

import org.avp.common.registry.AVPBlockBindingRegistry;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPOreBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPOreBlocks INSTANCE = new AVPOreBlocks();

    public static AVPOreBlocks getInstance() {
        return INSTANCE;
    }

    public final BlockBehaviour.Properties BAUXITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(3.2F, 2.6F)
        .sound(SoundType.STONE);

    public final BlockBehaviour.Properties COBALT_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(50F, 20F)
        .sound(SoundType.STONE);

    public final BlockBehaviour.Properties LITHIUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(4.2F, 5.4F)
        .sound(SoundType.STONE);

    public final BlockBehaviour.Properties MONAZITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(45F, 15F)
        .sound(SoundType.STONE);

    public final BlockBehaviour.Properties SILICA_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(2.2F, 1.4F)
        .sound(SoundType.STONE);

    private AVPOreBlocks() {}

    @Override
    public void register() {
        registerEntry("ore_bauxite", () -> new Block(BAUXITE_PROPERTIES));
        registerEntry("ore_cobalt", () -> new Block(COBALT_PROPERTIES));
        registerEntry("ore_lithium", () -> new Block(LITHIUM_PROPERTIES));
        registerEntry("ore_monazite", () -> new Block(MONAZITE_PROPERTIES));
        registerEntry("ore_silica", () -> new Block(SILICA_PROPERTIES));
    }
}
