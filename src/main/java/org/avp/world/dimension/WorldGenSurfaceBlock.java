package org.avp.world.dimension;

import java.util.Random;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenSurfaceBlock extends WorldGenerator
{
    private IBlockState state;

    public WorldGenSurfaceBlock(IBlockState state)
    {
        this.state = state;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (worldIn.isAirBlock(position) && (!worldIn.provider.hasNoSky() || position.getY() < 255) && state.getBlock().canPlaceBlockAt(worldIn, position))
        {
            worldIn.setBlockState(position, this.state, 2);
        }

        return true;
    }
}
