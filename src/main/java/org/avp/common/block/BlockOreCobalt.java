package org.avp.common.block;

import java.util.Random;

import org.avp.AliensVsPredator;

import com.asx.mdx.lib.world.block.BlockMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

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
        return AliensVsPredator.items().cobalt;
    }
    
    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return 1 + fortune;
    }
}
