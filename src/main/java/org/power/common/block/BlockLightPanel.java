package org.power.common.block;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import org.power.common.tile.TileEntityLightPanel;

public class BlockLightPanel extends ElectricalBlock
{
    public BlockLightPanel(Material material)
    {
        super(material);
        this.setLightOpacity(0);
        this.lightEmittedWhenPowered = 15;
    }
    
    @Override
    public boolean isTranslucent(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean isBlockNormalCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isTopSolid(IBlockState state)
    {
        return false;
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
        return new TileEntityLightPanel();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
