package org.avp.block;

import org.avp.tile.TileEntitySevastopolBlastDoor;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockSevastopolBlastDoor extends BlockBlastdoor
{
    public BlockSevastopolBlastDoor()
    {
        super(Material.IRON);
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntitySevastopolBlastDoor();
    }
}
