package org.power.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import org.power.common.tile.TileEntitySolarPanel;

public class BlockSolarPanel extends Block
{
    public BlockSolarPanel(Material material)
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
        return new TileEntitySolarPanel();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
