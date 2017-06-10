package org.avp.world.dimension.acheron.worldgen;

import java.util.Random;

import org.avp.AliensVsPredator;

import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkGenerator;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;

public class TerrainFormation2 extends WorldGenerator implements IWorldGenerator
{
    private static IBlockState block = AliensVsPredator.blocks().engineerrock0.getDefaultState();
    Block[] validBlocks = new Block[] { AliensVsPredator.blocks().unidirt
    };

    public boolean locationIsValidSpawn(World world, BlockPos pos)
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

    @Override
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
        ;
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (!locationIsValidSpawn(world, pos))
        {
            return false;
        }

        this.setBlock(world, pos,0, 4, 1, block);
        this.setBlock(world, pos,1, 3, 1, block);
        this.setBlock(world, pos,2, 2, 1, block);
        this.setBlock(world, pos,2, 3, 1, block);
        this.setBlock(world, pos,3, 1, 0, block);
        this.setBlock(world, pos,3, 1, 1, block);
        this.setBlock(world, pos,3, 1, 2, block);
        this.setBlock(world, pos,3, 2, 1, block);
        this.setBlock(world, pos,4, 0, 0, block);
        this.setBlock(world, pos,4, 0, 1, block);
        this.setBlock(world, pos,4, 0, 2, block);
        this.setBlock(world, pos,4, 1, 1, block);
        this.setBlock(world, pos,5, 0, 1, block);

        return true;
    }
}
