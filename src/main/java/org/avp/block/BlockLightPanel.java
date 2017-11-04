package org.avp.block;

import org.avp.tile.TileEntityElectrical;
import org.avp.tile.TileEntityLightPanel;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockLightPanel extends Block
{
    public BlockLightPanel(Material material)
    {
        super(material);
        this.setLightOpacity(0);
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
    public boolean isFullyOpaque(IBlockState state)
    {
        return false;
    }
    
    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos)
    {
        TileEntity tile = world.getTileEntity(pos);
        
        if (tile instanceof TileEntityElectrical)
        {
            TileEntityElectrical e = (TileEntityElectrical) tile;
            
            if (e.isOperational())
            {
                return 15;
            }
        }
        
        return 0;
    }
    
    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, ItemStack heldItem, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        return super.onBlockActivated(worldIn, pos, state, playerIn, hand, heldItem, side, hitX, hitY, hitZ);
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
        return new TileEntityLightPanel();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
