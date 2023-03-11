package org.avp.block;

import java.util.Random;

import org.avp.block.properties.UnlistedPropertyBlockstate;
import org.avp.tile.TileEntityHiveResin;
import org.avp.tile.TileEntityHiveResin.ResinVariant;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.property.IExtendedBlockState;
import net.minecraftforge.common.property.IUnlistedProperty;

public class BlockHiveResin extends Block
{
    public static final IUnlistedProperty<IBlockState> PARENT_BLOCK = new UnlistedPropertyBlockstate();
    
    public BlockHiveResin(Material material)
    {
        super(material);
    }

    @Override
    protected BlockStateContainer createBlockState()
    {
        return new BlockStateContainer.Builder(this).add(PARENT_BLOCK).build();
    }

    @Override
    public IBlockState getExtendedState(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        if (state != null && state instanceof IExtendedBlockState)
        {
            IExtendedBlockState extendedState = ((IExtendedBlockState) state);
            TileEntity tile = world.getTileEntity(pos);

            if (tile != null && tile instanceof TileEntityHiveResin)
            {
                TileEntityHiveResin resin = (TileEntityHiveResin) tile;
                Block reflection = resin.getParentBlock();
                IBlockState reflectionState = reflection != null ? reflection.getStateFromMeta(resin.getParentBlockMeta()) : null;

                return extendedState.withProperty(PARENT_BLOCK, reflectionState);
            }
        }

        return state;
    }

    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
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
    public int getFireSpreadSpeed(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }

    @Override
    public int getFlammability(IBlockAccess world, BlockPos pos, EnumFacing face)
    {
        return 5;
    }

    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityHiveResin();
    }

    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        evaluateNeighbors(worldIn, pos);
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, facing, hitX, hitY, hitZ);
    }
    
    @Override
    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
    }
    
    @Override
    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(worldIn, pos, state);
        evaluateNeighbors(worldIn, pos);
    }
    
    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor)
    {
        evaluateNeighbors(world, pos);
        super.onNeighborChange(world, pos, neighbor);
    }
    
    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        evaluateNeighbors(worldIn, pos);
    }

    public void evaluateNeighbors(IBlockAccess world, BlockPos pos)
    {
        TileEntityHiveResin te = (TileEntityHiveResin) world.getTileEntity(pos);

        if (te != null)
        {
            if (te.variant == null)
            {
                te.variant = ResinVariant.fromId(1 + new Random().nextInt(ResinVariant.values().length));
            }

            ResinVariant variant = te.variant;

            te.bottomBlock = world.getBlockState(pos.add(0, -1, 0)).getBlock();
            te.topBlock = world.getBlockState(pos.add(0, 1, 0)).getBlock();

            te.northBlock = world.getBlockState(pos.add(variant.nX, 0, variant.nZ)).getBlock();
            te.northTopBlock = world.getBlockState(pos.add(variant.nX, 1, variant.nZ)).getBlock();
            te.northBottomBlock = world.getBlockState(pos.add(variant.nX, -1, variant.nZ)).getBlock();

            te.southBlock = world.getBlockState(pos.add(variant.sX, 0, variant.sZ)).getBlock();
            te.southTopBlock = world.getBlockState(pos.add(variant.sX, 1, variant.sZ)).getBlock();
            te.southBottomBlock = world.getBlockState(pos.add(variant.sX, -1, variant.sZ)).getBlock();

            te.eastBlock = world.getBlockState(pos.add(variant.eX, 0, variant.eZ)).getBlock();
            te.eastTopBlock = world.getBlockState(pos.add(variant.eX, 1, variant.eZ)).getBlock();
            te.eastBottomBlock = world.getBlockState(pos.add(variant.eX, -1, variant.eZ)).getBlock();

            te.westBlock = world.getBlockState(pos.add(variant.wX, 0, variant.wZ)).getBlock();
            te.westTopBlock = world.getBlockState(pos.add(variant.wX, 1, variant.wZ)).getBlock();
            te.westBottomBlock = world.getBlockState(pos.add(variant.wX, -1, variant.wZ)).getBlock();
        }
    }
}
