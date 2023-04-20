package org.alien.common.world.dimension.varda.gen;

import net.minecraft.block.Block;
import net.minecraft.block.BlockLog.EnumAxis;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.IChunkGenerator;
import net.minecraft.world.gen.feature.WorldGenerator;
import net.minecraftforge.fml.common.IWorldGenerator;
import org.alien.common.block.BlockUnidentifiedLog;
import org.alien.common.block.init.AlienVardaBlocks;

import java.util.Random;

public class VardaTreeGenerator extends WorldGenerator implements IWorldGenerator
{
    public static final IBlockState TREE_TENDONS = AlienVardaBlocks.GIGER_TENDONS.getDefaultState();
    public static final IBlockState TREE_LOGS = AlienVardaBlocks.GIGER_LOG.getDefaultState().withProperty(BlockUnidentifiedLog.LOG_AXIS, EnumAxis.Y);
    public static final IBlockState TREE_LEAVES = AlienVardaBlocks.GIGER_LEAVES.getDefaultState();
    
    public VardaTreeGenerator(boolean doBlockNotify)
    {
        super(doBlockNotify);
    }
    
    protected Block[] getValidTargetBlocks()
    {
        return new Block[] { AlienVardaBlocks.UNIDIRT, AlienVardaBlocks.GIGER_SAPLING};
    }
    
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

        for (Block validBlock : getValidTargetBlocks())
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
    public void generate(Random random, int chunkX, int chunkZ, World world, IChunkGenerator chunkGenerator, IChunkProvider chunkProvider)
    {
    }

    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (this.shouldNotGenerate(world, pos))
        {
            return false;
        }

        pos = pos.add(-3, 0, -2);
        
        this.setBlock(world, pos, 0, 5, 2, TREE_LEAVES);
        this.setBlock(world, pos, 0, 6, 2, TREE_LEAVES);
        this.setBlock(world, pos, 0, 7, 2, TREE_LEAVES);
        this.setBlock(world, pos, 0, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 0, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 0, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 0, 0, TREE_LOGS);
        this.setBlock(world, pos, 1, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 1, 6, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 6, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 7, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 7, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 1, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 1, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 1, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 1, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 2, 0, 1, TREE_LOGS);
        this.setBlock(world, pos, 2, 0, 2, TREE_TENDONS);
        this.setBlock(world, pos, 2, 0, 3, TREE_LOGS);
        this.setBlock(world, pos, 2, 1, 1, TREE_LOGS);
        this.setBlock(world, pos, 2, 1, 3, TREE_LOGS);
        this.setBlock(world, pos, 2, 2, 2, TREE_LOGS);
        this.setBlock(world, pos, 2, 3, 2, TREE_LOGS);
        this.setBlock(world, pos, 2, 4, 3, TREE_LOGS);
        this.setBlock(world, pos, 2, 5, 3, TREE_LOGS);
        this.setBlock(world, pos, 2, 8, 2, TREE_LOGS);
        this.setBlock(world, pos, 2, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 2, TREE_LOGS);
        this.setBlock(world, pos, 2, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 2, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 2, 10, 1, TREE_TENDONS);
        this.setBlock(world, pos, 2, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 2, 10, 3, TREE_TENDONS);
        this.setBlock(world, pos, 2, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 2, 11, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 2, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 0, 1, TREE_TENDONS);
        this.setBlock(world, pos, 3, 0, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 3, 1, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 2, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 3, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 4, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 5, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 5, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 6, 1, TREE_LOGS);
        this.setBlock(world, pos, 3, 6, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 6, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 1, TREE_LOGS);
        this.setBlock(world, pos, 3, 7, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 7, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 1, TREE_TENDONS);
        this.setBlock(world, pos, 3, 8, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 8, 3, TREE_TENDONS);
        this.setBlock(world, pos, 3, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 1, TREE_TENDONS);
        this.setBlock(world, pos, 3, 9, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 9, 3, TREE_TENDONS);
        this.setBlock(world, pos, 3, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 11, 1, TREE_LEAVES);
        this.setBlock(world, pos, 3, 11, 2, TREE_TENDONS);
        this.setBlock(world, pos, 3, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 0, 2, TREE_TENDONS);
        this.setBlock(world, pos, 4, 0, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 2, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 3, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 4, 1, TREE_LOGS);
        this.setBlock(world, pos, 4, 5, 1, TREE_LOGS);
        this.setBlock(world, pos, 4, 8, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 1, TREE_TENDONS);
        this.setBlock(world, pos, 4, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 0, 1, TREE_LOGS);
        this.setBlock(world, pos, 5, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 5, 1, 1, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 7, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 7, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 6, 0, 0, TREE_LOGS);
        this.setBlock(world, pos, 6, 6, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 7, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 10, 2, TREE_LEAVES);

        return true;
    }
}
