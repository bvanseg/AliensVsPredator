package org.avp.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
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
import org.avp.common.api.machines.Openable;
import org.avp.common.tile.TileEntityMedpod;


public class BlockMedpod extends Block
{
    public BlockMedpod(Material material)
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
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        TileEntity tileEntity = world.getTileEntity(pos);

        if (tileEntity != null && tileEntity instanceof Openable)
        {
            Openable openable = (Openable) tileEntity;
            openable.setOpen(!openable.isOpen());
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
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityMedpod();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }

    @Override
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        super.onBlockClicked(world, pos, playerIn);

        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityMedpod)
        {
            TileEntityMedpod medpod = (TileEntityMedpod) tile;

            if (medpod != null && medpod.getEntity() != null)
            {
                medpod.getEntity().setDead();
            }
        }
    }
}
