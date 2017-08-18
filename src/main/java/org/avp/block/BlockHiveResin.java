package org.avp.block;

import org.avp.tile.TileEntityHiveResin;
import org.avp.world.hives.HiveHandler;

import com.arisux.mdx.lib.world.Pos;
import com.arisux.mdx.lib.world.Pos.BlockDataStore;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockHiveResin extends Block
{
    public BlockHiveResin(Material material)
    {
        super(material);
        this.setLightLevel(0.1F);
    }

    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public EnumBlockRenderType getRenderType(IBlockState state)
    {
        return EnumBlockRenderType.MODEL;
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
    public void onBlockClicked(World world, BlockPos pos, EntityPlayer playerIn)
    {
        TileEntity tile = world.getTileEntity(pos);

        if (tile instanceof TileEntityHiveResin)
        {
            Pos coord = new Pos(pos);
            TileEntityHiveResin resin = (TileEntityHiveResin) tile;

            if (resin != null)
            {
                if (coord.isAnySurfaceNextTo(world, Blocks.FIRE))
                {
                    if (resin != null && resin.getBlockCovering() != null)
                    {
                        HiveHandler.instance.burntResin.add(new Pos(pos).store(new BlockDataStore(resin.getBlockCovering().getBlock(), (byte) 0)));
                    }
                }

                if (resin.getHive() != null)
                {
                    resin.getHive().getResinInHive().remove(resin);
                }
            }
        }

        super.onBlockClicked(world, pos, playerIn);
    }
}
