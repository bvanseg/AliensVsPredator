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
public class AVPBlocks {

    private static final List<GameObject<Block>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties ALUMINUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    );

    public static final GameObject<Block> ALUMINUM_BLOCK;

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

    private AVPBlocks() {}

    static {
        ALUMINUM_BLOCK = register("aluminum_block", () -> new Block(ALUMINUM_PROPERTIES));
    }
}
