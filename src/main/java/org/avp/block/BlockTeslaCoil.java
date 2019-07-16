package org.avp.block;

import org.avp.tile.TileEntityCCFLTube;
import org.avp.tile.TileEntityTeslaCoil;

import com.asx.mdx.lib.world.entity.Entities;

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
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockTeslaCoil extends Block
{
    public BlockTeslaCoil(Material material)
    {
        super(material);
    }
    
    @Override
    public boolean isTranslucent(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isBlockNormalCube(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean isTopSolid(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, side, hitX, hitY, hitZ);
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityTeslaCoil teslaCoil = (TileEntityTeslaCoil) world.getTileEntity(pos);

        if (teslaCoil != null)
        {
            teslaCoil.setRotationYAxis(Entities.getEntityFacingRotY(placer));
            teslaCoil.setRotationXAxis(Entities.getEntityFacingRotX(placer));
            world.markBlockRangeForRenderUpdate(pos, pos);
        }
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
        return new TileEntityTeslaCoil();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
