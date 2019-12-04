package org.avp.block;

import java.util.Random;

import org.avp.tile.plants.TileEntityPlant.PlantColor;
import org.avp.tile.plants.TileEntityPlant.PlantSize;
import org.avp.tile.plants.TileEntityTreeFern;

import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.block.BlockBush;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class BlockTreeFern extends BlockBush implements ITileEntityProvider
{
    public BlockTreeFern()
    {
        super(Material.PLANTS);
        this.setLightOpacity(2);
        this.setSoundType(SoundType.PLANT);
    }

    @Override
    public void onNeighborChange(IBlockAccess world, BlockPos pos, BlockPos neighbor)
    {
        super.onNeighborChange(world, pos, neighbor);

        if (!world.getBlockState(neighbor).isSideSolid(world, pos, EnumFacing.UP) && pos.down() == neighbor)
        {
            ((World) world).destroyBlock(pos, true);
        }
    }

    @Override
    public void onBlockAdded(World world, BlockPos pos, IBlockState state)
    {
        super.onBlockAdded(world, pos, state);

        TileEntity tile = (TileEntity) world.getTileEntity(pos);

        if (tile instanceof TileEntityTreeFern)
        {
            TileEntityTreeFern fern = (TileEntityTreeFern) tile;
            fern.setPlantSize(PlantSize.random(world));
            
            Random rand = new Random();
            fern.applyRandomOffset(rand);
            
            if (rand.nextInt(150) == 0)
            {
                fern.setPlantColor(TileEntityTreeFern.WHITE);
            }
            else
            {
                PlantColor color = TileEntityTreeFern.STANDARD_COLOR_GROUP[rand.nextInt(TileEntityTreeFern.STANDARD_COLOR_GROUP.length)];
                fern.setPlantColor(color);
            }
        }

        if (!world.getBlockState(pos.down()).isSideSolid(world, pos, EnumFacing.UP))
        {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    public void onBlockPlacedBy(World world, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack)
    {
        super.onBlockPlacedBy(world, pos, state, placer, stack);
        TileEntity tile = world.getTileEntity(pos);

        if (tile != null && tile instanceof TileEntityTreeFern && placer != null)
        {
            TileEntityTreeFern plant = (TileEntityTreeFern) tile;
            plant.setRotationYAxis(Entities.getEntityFacingRotY(placer));
        }
    }

    @Override
    public TileEntity createNewTileEntity(World worldIn, int meta)
    {
        return new TileEntityTreeFern();
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
