package org.power.common.block;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.power.common.tile.TileEntityCCFLTube;

public class BlockCCFLTube extends ElectricalBlock
{
    public BlockCCFLTube(Material material)
    {
        super(material);
        this.setLightOpacity(0);
        this.lightEmittedWhenPowered = 15;
    }
    
    @Override
    public boolean isTranslucent(IBlockState state)
    {
        return true;
    }
    
    @Override
    public boolean isBlockNormalCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public boolean isTopSolid(IBlockState state)
    {
        return false;
    }
    
    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);

        TileEntityCCFLTube ccfl = (TileEntityCCFLTube) world.getTileEntity(pos);

        if (ccfl != null)
        {
            ccfl.setRotationYAxis(Entities.getEntityFacingRotY(placer));
            ccfl.setRotationXAxis(Entities.getEntityFacingRotX(placer));
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
        return new TileEntityCCFLTube();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
