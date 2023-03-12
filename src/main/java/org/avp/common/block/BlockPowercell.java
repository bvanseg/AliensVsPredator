package org.avp.common.block;

import org.avp.common.tile.TileEntityPowercell;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;

public class BlockPowercell extends Block
{
    public BlockPowercell(Material material)
    {
        super(material);
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityPowercell();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
