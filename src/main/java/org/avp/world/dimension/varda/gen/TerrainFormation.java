package org.avp.world.dimension.varda.gen;

import java.util.Random;

import org.avp.AliensVsPredator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class TerrainFormation extends WorldGenerator
{
    private static final IBlockState block       = AliensVsPredator.blocks().unidirt.getDefaultState();
    Block[]                          validBlocks = new Block[] { AliensVsPredator.blocks().unidirt
    };

    public boolean isLocationValid(World world, BlockPos pos)
    {
        int distanceToAir = 0;
        Block check = world.getBlockState(pos).getBlock();

        while (check != Blocks.AIR)
        {
            if (distanceToAir > 3)
            {
                return false;
            }

            distanceToAir++;
            check = world.getBlockState(pos.add(0, distanceToAir, 0)).getBlock();
        }

        pos = pos.add(0, distanceToAir - 1, 0);

        Block block = world.getBlockState(pos).getBlock();
        Block blockAbove = world.getBlockState(pos.add(0, 1, 0)).getBlock();
        Block blockBelow = world.getBlockState(pos.add(0, -1, 0)).getBlock();

        for (Block validBlock : validBlocks)
        {
            if (blockAbove != Blocks.AIR)
            {
                return false;
            }
            if (block == validBlock)
            {
                return true;
            }
            else if (block == Blocks.SNOW && blockBelow == validBlock)
            {
                return true;
            }
        }

        return false;
    }

    public void setBlock(World world, BlockPos posStart, int offsetX, int offsetY, int offsetZ, IBlockState state)
    {
        BlockPos pos = posStart.add(offsetX, offsetY, offsetZ);
        IBlockState s1 = world.getBlockState(pos);
        Block b1 = s1.getBlock();

        if (b1.isAir(s1, world, pos) || b1.isLeaves(s1, world, pos))
        {
            world.setBlockState(pos, state, 2);
        }
    }
    
    public boolean shouldNotGenerate(World world, BlockPos pos)
    {
        return (!isLocationValid(world, pos)) || (!isLocationValid(world, pos.add(2, 0, 0))) || (!isLocationValid(world, pos.add(2, 0, 2))) || (!isLocationValid(world, pos.add(0, 0, 2)));
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (this.shouldNotGenerate(world, pos))
        {
            return false;
        }

        this.setBlock(world, pos, 0, 0, 1, block);
        this.setBlock(world, pos, 0, 1, 1, block);
        this.setBlock(world, pos, 0, 2, 1, block);
        this.setBlock(world, pos, 0, 3, 1, block);
        this.setBlock(world, pos, 0, 4, 1, block);
        this.setBlock(world, pos, 1, 0, 0, block);
        this.setBlock(world, pos, 1, 0, 1, block);
        this.setBlock(world, pos, 1, 0, 2, block);
        this.setBlock(world, pos, 1, 1, 0, block);
        this.setBlock(world, pos, 1, 1, 1, block);
        this.setBlock(world, pos, 1, 1, 2, block);
        this.setBlock(world, pos, 1, 2, 0, block);
        this.setBlock(world, pos, 1, 2, 1, block);
        this.setBlock(world, pos, 1, 2, 2, block);
        this.setBlock(world, pos, 1, 3, 0, block);
        this.setBlock(world, pos, 1, 3, 1, block);
        this.setBlock(world, pos, 1, 3, 2, block);
        this.setBlock(world, pos, 1, 4, 0, block);
        this.setBlock(world, pos, 1, 4, 1, block);
        this.setBlock(world, pos, 1, 5, 0, block);
        this.setBlock(world, pos, 1, 5, 1, block);
        this.setBlock(world, pos, 1, 6, 1, block);
        this.setBlock(world, pos, 1, 7, 1, block);
        this.setBlock(world, pos, 1, 8, 1, block);
        this.setBlock(world, pos, 2, 0, 1, block);
        this.setBlock(world, pos, 2, 1, 1, block);
        this.setBlock(world, pos, 2, 2, 1, block);

        return true;
    }
}
