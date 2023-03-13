package org.alien.common.world.dimension.varda.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class VardaTree3Generator extends VardaTreeGenerator
{
    public VardaTree3Generator(boolean doBlockNotify)
    {
        super(doBlockNotify);
    }
    
    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (this.shouldNotGenerate(world, pos))
        {
            return false;
        }
        
        pos = pos.add(-5, 0, -3);
        
        this.setBlock(world, pos, 0, 4, 3, TREE_LEAVES);
        this.setBlock(world, pos, 0, 5, 3, TREE_LEAVES);
        this.setBlock(world, pos, 1, 2, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 3, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 3, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 4, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 4, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 5, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 5, 3, TREE_LOGS);
        this.setBlock(world, pos, 1, 5, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 6, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 4, 3, TREE_LOGS);
        this.setBlock(world, pos, 2, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 0, 1, TREE_LOGS);
        this.setBlock(world, pos, 3, 0, 5, TREE_LOGS);
        this.setBlock(world, pos, 3, 3, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 3, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 11, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 0, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 2, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 2, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 3, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 3, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 4, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 5, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 8, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 2, TREE_TENDONS);
        this.setBlock(world, pos, 4, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 4, TREE_TENDONS);
        this.setBlock(world, pos, 4, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 12, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 12, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 12, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 0, 2, TREE_TENDONS);
        this.setBlock(world, pos, 5, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 0, 4, TREE_TENDONS);
        this.setBlock(world, pos, 5, 1, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 2, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 3, 1, TREE_LOGS);
        this.setBlock(world, pos, 5, 3, 2, TREE_LOGS);
        this.setBlock(world, pos, 5, 3, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 3, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 4, 0, TREE_LOGS);
        this.setBlock(world, pos, 5, 4, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 4, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 4, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 5, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 5, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 6, 2, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 6, 4, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 7, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 7, 2, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 7, 4, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 2, TREE_TENDONS);
        this.setBlock(world, pos, 5, 8, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 8, 4, TREE_TENDONS);
        this.setBlock(world, pos, 5, 8, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 2, TREE_TENDONS);
        this.setBlock(world, pos, 5, 9, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 9, 4, TREE_TENDONS);
        this.setBlock(world, pos, 5, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 6, TREE_LEAVES);
        this.setBlock(world, pos, 5, 11, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 11, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 11, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 11, 5, TREE_LEAVES);
        this.setBlock(world, pos, 5, 12, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 12, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 12, 4, TREE_LEAVES);
        this.setBlock(world, pos, 6, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 6, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 6, 1, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 1, 4, TREE_LOGS);
        this.setBlock(world, pos, 6, 2, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 6, 3, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 3, 3, TREE_LOGS);
        this.setBlock(world, pos, 6, 4, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 5, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 8, 3, TREE_LOGS);
        this.setBlock(world, pos, 6, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 3, TREE_LOGS);
        this.setBlock(world, pos, 6, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 6, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 10, 2, TREE_TENDONS);
        this.setBlock(world, pos, 6, 10, 4, TREE_TENDONS);
        this.setBlock(world, pos, 6, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 4, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 5, TREE_LEAVES);
        this.setBlock(world, pos, 6, 12, 2, TREE_LEAVES);
        this.setBlock(world, pos, 6, 12, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 12, 4, TREE_LEAVES);
        this.setBlock(world, pos, 7, 0, 2, TREE_LOGS);
        this.setBlock(world, pos, 7, 0, 4, TREE_TENDONS);
        this.setBlock(world, pos, 7, 0, 5, TREE_LOGS);
        this.setBlock(world, pos, 7, 1, 2, TREE_LOGS);
        this.setBlock(world, pos, 7, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 7, 5, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 7, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 9, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 7, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 7, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 10, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 7, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 7, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 7, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 7, 11, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 11, 4, TREE_LEAVES);
        this.setBlock(world, pos, 8, 0, 1, TREE_LOGS);
        this.setBlock(world, pos, 8, 1, 4, TREE_LEAVES);
        this.setBlock(world, pos, 8, 2, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 8, 2, 4, TREE_LEAVES);
        this.setBlock(world, pos, 8, 3, 3, TREE_LEAVES);
        this.setBlock(world, pos, 8, 7, 3, TREE_LEAVES);
        this.setBlock(world, pos, 8, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 8, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 8, 10, 3, TREE_LEAVES);
        
        return true;
    }
}
