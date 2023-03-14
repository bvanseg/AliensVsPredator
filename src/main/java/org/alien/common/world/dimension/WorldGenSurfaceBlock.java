package org.alien.common.world.dimension;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSurfaceBlock extends WorldGenerator
{
    private final IBlockState state;

    public WorldGenSurfaceBlock(IBlockState state)
    {
        this.state = state;
    }

    @Override
    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        if (worldIn.isAirBlock(position) && (!worldIn.provider.isNether() || position.getY() < 255) && state.getBlock().canPlaceBlockAt(worldIn, position))
        {
            worldIn.setBlockState(position, this.state, 2);
        }

        return true;
    }
}
