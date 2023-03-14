package org.alien.common.world.dimension.varda.gen;

import net.minecraft.block.BlockDirt;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

import java.util.Random;

public class WorldGenSustainableOnDirt extends WorldGenerator
{
    private IBlockState state;

    public WorldGenSustainableOnDirt(IBlockState block)
    {
        this.state = block;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        BlockPos posRand = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));

        if (world.isAirBlock(posRand) && state.getBlock().canPlaceBlockAt(world, posRand) && world.getBlockState(posRand.down()).getBlock() instanceof BlockDirt)
        {
            world.setBlockState(posRand, this.state);
        }

        return true;
    }
}
