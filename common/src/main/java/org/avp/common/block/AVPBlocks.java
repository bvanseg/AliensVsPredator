package org.avp.common.block;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.api.Tuple;
import org.avp.api.block.BlockData;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPBlocks {

    private static final List<Tuple<GameObject<Block>, BlockData>> ENTRIES = new ArrayList<>();

    public static final BlockBehaviour.Properties ALUMINUM_PROPERTIES = BlockBehaviour.Properties.ofFullCopy(
        Blocks.IRON_BLOCK
    );

    public static final GameObject<Block> ALUMINUM_BLOCK;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    public static List<Tuple<GameObject<Block>, BlockData>> getEntries() {
        return ENTRIES;
    }

    protected static GameObject<Block> register(String registryName, BlockData blockData) {
        var gameObject = Services.BLOCK_REGISTRY.register(registryName, blockData::create);
        ENTRIES.add(new Tuple<>(gameObject, blockData));
        return gameObject;
    }

    private AVPBlocks() {}

    static {
        ALUMINUM_BLOCK = register("aluminum_block", BlockData.simple(ALUMINUM_PROPERTIES));
    }
}
