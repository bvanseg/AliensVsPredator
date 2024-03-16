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
public class AVPOreBlocks extends AVPBlockBindingRegistry implements AVPRegistry {

    private static final AVPOreBlocks INSTANCE = new AVPOreBlocks();

    public static AVPOreBlocks getInstance() {
        return INSTANCE;
    }

    public final BlockBehaviour.Properties BAUXITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(3.2F, 2.6F);

    public final BlockBehaviour.Properties COBALT_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(50F, 20F);

    public final BlockBehaviour.Properties LITHIUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(4.2F, 5.4F);

    public final BlockBehaviour.Properties MONAZITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(45F, 15F);

    public final BlockBehaviour.Properties SILICA_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(2.2F, 1.4F);

    public static GameObject<Block> ORE_BAUXITE;
    public static GameObject<Block> ORE_COBALT;
    public static GameObject<Block> ORE_LITHIUM;
    public static GameObject<Block> ORE_MONAZITE;
    public static GameObject<Block> ORE_SILICA;
    public static GameObject<Block> RAW_BAUXITE_BLOCK;

    private AVPOreBlocks() {}

    @Override
    public void register() {
        ORE_BAUXITE = registerEntry("ore_bauxite", () -> new Block(BAUXITE_PROPERTIES));
        ORE_COBALT = registerEntry("ore_cobalt", () -> new Block(COBALT_PROPERTIES));
        ORE_LITHIUM = registerEntry("ore_lithium", () -> new Block(LITHIUM_PROPERTIES));
        ORE_MONAZITE = registerEntry("ore_monazite", () -> new Block(MONAZITE_PROPERTIES));
        ORE_SILICA = registerEntry("ore_silica", () -> new Block(SILICA_PROPERTIES));

        RAW_BAUXITE_BLOCK = registerEntry("raw_bauxite_block", () -> new Block(BAUXITE_PROPERTIES));
    }
}
