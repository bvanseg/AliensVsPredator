package org.avp.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import org.avp.common.AVPBlocks;

import java.util.Random;

public class BlockStalagmite extends Block
{
    public BlockStalagmite(Material material)
    {
        super(material);
        this.setTickRandomly(true);
    }

    @Override
    public boolean canPlaceBlockAt(World worldIn, BlockPos pos)
    {
        return super.canPlaceBlockAt(worldIn, pos) && this.canThisPlantGrowOn(worldIn.getBlockState(pos.add(0, -1, 0)));
    }

    protected boolean canThisPlantGrowOn(IBlockState state)
    {
        return state.getBlock() == AVPBlocks.UNIDIRT || state.getBlock() == AVPBlocks.UNISTONE || state.getMaterial() == Material.GROUND || state.getMaterial() == Material.ROCK;
    }

    @Override
    public void onNeighborChange(IBlockAccess access, BlockPos pos, BlockPos neighbor)
    {
        super.onNeighborChange(access, pos, neighbor);
        this.checkFlowerChange(access, access.getBlockState(pos), pos);
    }

    @Override
    public void updateTick(World world, BlockPos pos, IBlockState state, Random rand)
    {
        super.updateTick(world, pos, state, rand);
        this.checkFlowerChange(world, state, pos);
    }

    protected final void checkFlowerChange(IBlockAccess access, IBlockState state, BlockPos pos)
    {
        if (!this.canBlockStay(access, pos))
        {
            if (access instanceof World)
            {
                World world = (World) access;
                this.dropBlockAsItem(world, pos, state, 0);
                world.setBlockToAir(pos);
            }
        }
    }

    public boolean canBlockStay(IBlockAccess world, BlockPos pos)
    {
        return this.canThisPlantGrowOn(world.getBlockState(pos.add(0, -1, 0)));
    }
    
    @Override
    public boolean isOpaqueCube(IBlockState state)
    {
        return false;
    }
    
    @Override
    public BlockRenderLayer getRenderLayer()
    {
        return BlockRenderLayer.CUTOUT;
    }
    
    @Override
    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return null;
    }
    
    @Override
    public boolean isPassable(IBlockAccess worldIn, BlockPos pos)
    {
        return true;
    }
}
