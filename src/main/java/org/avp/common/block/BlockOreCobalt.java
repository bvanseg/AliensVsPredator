package org.avp.common.block;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import org.avp.common.AVPItems;

import java.util.Random;

public class BlockOreCobalt extends BlockMaterial
{
    public BlockOreCobalt()
    {
        super(Material.IRON);
        this.setHardness(50F);
        this.setResistance(20F);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return AVPItems.ITEM_COBALT;
    }
    
    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return 1 + fortune;
    }
}
