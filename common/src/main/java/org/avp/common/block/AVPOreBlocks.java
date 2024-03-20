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
public class AVPOreBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties BAUXITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(3.2F, 2.6F);

    public static final BlockBehaviour.Properties COBALT_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(50F, 20F);

    public static final BlockBehaviour.Properties LITHIUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
        .strength(4.2F, 5.4F);

    public static final BlockBehaviour.Properties MONAZITE_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(Blocks.STONE)
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

    public static List<GameObject<Block>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Block> register(String registryName, Supplier<Block> blockSupplier) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockSupplier);
        ENTRIES.add(gameObject);
        return gameObject;
    }

    private AVPOreBlocks() {}

    static {
        ORE_BAUXITE = register("ore_bauxite", () -> new Block(BAUXITE_PROPERTIES));
        ORE_COBALT = register("ore_cobalt", () -> new Block(COBALT_PROPERTIES));
        ORE_LITHIUM = register("ore_lithium", () -> new Block(LITHIUM_PROPERTIES));
        ORE_MONAZITE = register("ore_monazite", () -> new Block(MONAZITE_PROPERTIES));
        ORE_SILICA = register("ore_silica", () -> new Block(SILICA_PROPERTIES));

        RAW_BAUXITE_BLOCK = register("raw_bauxite_block", () -> new Block(BAUXITE_PROPERTIES));
    }
}
