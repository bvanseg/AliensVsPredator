package org.avp.block;

import org.avp.tile.TileEntityGunLocker;

import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockGunLocker extends BlockLocker
{
    public BlockGunLocker(Material material)
    {
        super(material);
        setTickRandomly(true);
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityGunLocker();
    }
    
    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(world, pos, playerIn);
        
        TileEntityGunLocker locker = (TileEntityGunLocker) world.getTileEntity(pos);
        
        if (locker != null)
        {
            for (int i = locker.inventory.getSizeInventory(); i > 0; i--)
            {
                ItemStack stack = locker.inventory.getStackInSlot(i);
                
                if (stack != null)
                {
                    EntityItem entityItem = new EntityItem(world, pos.getX(), pos.getY(), pos.getZ(), stack);
                    world.spawnEntity(entityItem);
                }
            }
        }
    }
}
