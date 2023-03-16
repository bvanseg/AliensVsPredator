package org.avp.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.avp.common.tile.TileEntityAmpule;

public class BlockAmpule extends Block implements ITileEntityProvider
{
    public static final AxisAlignedBB AMPULE_AABB = new AxisAlignedBB(0.25D, 0.0D, 0.25D, 0.75D, 1.0D, 0.75D);
    
    public BlockAmpule()
    {
        super(Material.IRON);
        this.setLightOpacity(2);
    }
    
    @Override
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos)
    {
        return AMPULE_AABB;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return AMPULE_AABB;
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityAmpule && placer != null)
        {
            TileEntityAmpule ampule = (TileEntityAmpule) tile;
            ampule.setRotationYAxis(Entities.getEntityFacingRotY(placer));
        }
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

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.INVISIBLE;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }

    @Override
    public boolean isFullCube(IBlockState state)
    {
        return false;
    }
}
