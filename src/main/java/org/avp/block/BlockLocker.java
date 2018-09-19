package org.avp.block;

import org.avp.tile.TileEntityLocker;

import com.arisux.mdx.lib.world.entity.Entities;
import com.arisux.mdx.lib.world.tile.IRotatableYAxis;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLocker extends Block
{
    public BlockLocker(Material material)
    {
        super(material);
        setTickRandomly(true);
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
    public boolean isFullBlock(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        TileEntity tile = worldIn.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityLocker)
        {
            TileEntityLocker locker = (TileEntityLocker) tile;
            return locker.isOpen() ? null : blockState.getBoundingBox(worldIn, pos);
        }

        return blockState.getBoundingBox(worldIn, pos);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity != null && tileEntity instanceof TileEntityLocker)
        {
            TileEntityLocker tileEntityLocker = (TileEntityLocker) tileEntity;

            if (!player.isSneaking())
            {
                tileEntityLocker.openGui(player);
            }
            else
            {
                tileEntityLocker.setOpen(!tileEntityLocker.isOpen());
            }
        }

        return true;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof IRotatableYAxis && placer != null)
        {
            IRotatableYAxis rotatable = (IRotatableYAxis) tile;
            rotatable.setRotationYAxis(Entities.getEntityFacingRotY(placer));
        }
    }
    
    @Override
    public void onBlockClicked(World worldIn, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(worldIn, pos, playerIn);
        
        TileEntityLocker locker = (TileEntityLocker) worldIn.getTileEntity(pos);
        
        if (locker != null)
        {
            for (int i = locker.inventory.getSizeInventory(); i > 0; i--)
            {
                ItemStack stack = locker.inventory.getStackInSlot(i);
                
                if (stack != null)
                {
                    EntityItem entityItem = new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), stack);
                    worldIn.spawnEntity(entityItem); 
                }
            }
        }
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityLocker();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
