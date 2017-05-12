package org.avp.block;

import org.avp.tile.TileEntityAmpule;

import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;


public class BlockAmpule extends Block implements ITileEntityProvider
{
    public BlockAmpule()
    {
        super(Material.IRON);
        this.setLightOpacity(2);
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityAmpule && placer != null)
        {
            TileEntityAmpule ampule = (TileEntityAmpule) tile;
            ampule.setDirection(getFacing(placer));
        }
    }

    public static EnumFacing getFacing(Entity entity)
    {
        int dir = MathHelper.floor((entity.rotationYaw / 90) + 0.5) & 3;
        return EnumFacing.getFront(dir);
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityAmpule();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
