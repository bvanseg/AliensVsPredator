package org.avp.api.block.drop;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.function.BiFunction;
import java.util.function.Supplier;

import org.avp.api.block.drop.impl.ItemBlockDrop;
import org.avp.api.block.drop.impl.OtherBlockDrop;
import org.avp.api.block.drop.key.BlockDropKey;
import org.avp.api.block.drop.key.BlockDropKeys;

public class BlockDrops {

    public static final BlockDrop SELF = new BlockDrop(BlockDropKeys.SELF);

    public static final BiFunction<BlockDropKey, Supplier<Block>, BlockDrop> OTHER = OtherBlockDrop::new;

    public static final BiFunction<BlockDropKey, Supplier<Item>, BlockDrop> ITEM = ItemBlockDrop::new;

    private BlockDrops() {
        throw new UnsupportedOperationException();
    }
}
