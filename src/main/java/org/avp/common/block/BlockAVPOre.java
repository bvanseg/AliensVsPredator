package org.avp.common.block;

import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import org.avp.common.AVPItems;
import org.avp.common.block.init.AVPOreBlocks;
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;

import java.util.Random;

/**
 * @author Boston Vanseghi
 */
public class BlockAVPOre extends BasicBlock {

    public BlockAVPOre(String registryName, BlockProperties properties) {
        super(registryName, properties);
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {

        if (this == AVPOreBlocks.ORE_COBALT)
        {
            return AVPItems.ITEM_COBALT;
        }
        else if (this == AVPOreBlocks.ORE_MONAZITE)
        {
            return AVPItems.ITEM_NEODYMIUM;
        }
        else if (this == AVPOreBlocks.ORE_SILICON)
        {
            return AVPItems.ITEM_SILICON;
        }

        return super.getItemDropped(state, rand, fortune);
    }

    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random) {

        if (this == AVPOreBlocks.ORE_COBALT)
        {
            return 1 + fortune;
        }
        else if (this == AVPOreBlocks.ORE_MONAZITE)
        {
            return 1 + random.nextInt(2) + fortune;
        }
        else if (this == AVPOreBlocks.ORE_SILICON)
        {
            return 1 + random.nextInt(3) + fortune;
        }

        return super.quantityDropped(state, fortune, random);
    }
}
