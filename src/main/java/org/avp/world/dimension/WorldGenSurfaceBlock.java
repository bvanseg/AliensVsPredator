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
        for (int i = 0; i < 64; ++i)
        {
            BlockPos pos = position.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

            if (worldIn.isAirBlock(pos) && (!worldIn.provider.hasNoSky() || pos.getY() < 255) && state.getBlock().canPlaceBlockAt(worldIn, pos))
            {
                worldIn.setBlockState(pos, this.state, 2);
            }
        }

        return true;
    }
}