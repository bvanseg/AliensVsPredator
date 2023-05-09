package org.power.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.power.common.tile.TileEntityWorkstation;

public class BlockWorkstation extends Block
{
    public BlockWorkstation(Material material)
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
        return new TileEntityWorkstation();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityWorkstation tile = (TileEntityWorkstation) world.getTileEntity(pos);

        if (tile != null)
        {
            tile.setDirection((byte) (MathHelper.floor(((placer.rotationYaw * 4F) / 360F) + 0.5D) & 3));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
    }
}
