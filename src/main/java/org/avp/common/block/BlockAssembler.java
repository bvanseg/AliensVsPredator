package org.avp.common.block;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.avp.common.tile.TileEntityAssembler;

public class BlockAssembler extends Block
{
    public BlockAssembler(Material material)
    {
        super(material);
    }
    
    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing side, float hitX, float hitY, float hitZ)
    {
        if (!world.isRemote)
        {
            TileEntityAssembler tile = (TileEntityAssembler) world.getTileEntity(pos);

            if (tile != null)
            {
                tile.openGui(player);
            }
        }
        
        return true;
    }
    
    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state)
    {
        Inventories.dropItemsInAt((TileEntityAssembler) world.getTileEntity(pos), world, pos);
        super.breakBlock(world, pos, state);
    }
    
    @Override
    public TileEntity createTileEntity(World world, IBlockState state)
    {
        return new TileEntityAssembler();
    }
    
    @Override
    public boolean hasTileEntity(IBlockState state)
    {
        return true;
    }
}
