package org.power.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.world.World;
import org.power.common.tile.TileEntityRedstoneEmitter;

public class BlockRedstoneEmitter extends Block
{
    public BlockRedstoneEmitter(Material material)
    {
        super(material);
        this.setTickRandomly(true);
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
        return new TileEntityRedstoneEmitter();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
