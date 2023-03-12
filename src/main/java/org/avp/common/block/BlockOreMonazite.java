package org.avp.common.block;

import java.util.Random;

import org.avp.AVP;

import com.asx.mdx.lib.world.block.BlockMaterial;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;

public class BlockOreMonazite extends BlockMaterial
{
    public BlockOreMonazite()
    {
        super(Material.IRON);
        this.setHardness(45F);
        this.setResistance(15F);
    }
    
    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        return AVP.items().neodymium;
    }
    
    @Override
    public int quantityDropped(IBlockState state, int fortune, Random random)
    {
        return (1 + random.nextInt(2)) + fortune;
    }
}
