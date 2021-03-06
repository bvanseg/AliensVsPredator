package org.prometheus.common.world.dimension.varda.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class VardaTallTreeGenerator extends VardaTreeGenerator
{
    public VardaTallTreeGenerator(boolean doBlockNotify)
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
        
        pos = pos.add(-4, 0, -4);
        
        this.setBlock(world, pos, 0, 10, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 11, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 12, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 13, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 14, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 15, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 16, 5, TREE_LEAVES);
        this.setBlock(world, pos, 0, 17, 5, TREE_LEAVES);
        this.setBlock(world, pos, 1, 17, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 17, 5, TREE_TENDONS);
        this.setBlock(world, pos, 1, 17, 6, TREE_LEAVES);
        this.setBlock(world, pos, 1, 18, 4, TREE_LEAVES);
        this.setBlock(world, pos, 1, 18, 5, TREE_LEAVES);
        this.setBlock(world, pos, 1, 18, 6, TREE_LEAVES);
        this.setBlock(world, pos, 1, 19, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 10, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 11, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 12, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 13, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 13, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 14, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 14, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 14, 7, TREE_LEAVES);
        this.setBlock(world, pos, 2, 15, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 15, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 15, 7, TREE_LEAVES);
        this.setBlock(world, pos, 2, 16, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 16, 5, TREE_LOGS);
        this.setBlock(world, pos, 2, 16, 7, TREE_LEAVES);
        this.setBlock(world, pos, 2, 17, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 17, 4, TREE_TENDONS);
        this.setBlock(world, pos, 2, 17, 5, TREE_TENDONS);
        this.setBlock(world, pos, 2, 17, 6, TREE_TENDONS);
        this.setBlock(world, pos, 2, 17, 7, TREE_LEAVES);
        this.setBlock(world, pos, 2, 18, 4, TREE_LEAVES);
        this.setBlock(world, pos, 2, 18, 5, TREE_TENDONS);
        this.setBlock(world, pos, 2, 18, 6, TREE_LEAVES);
        this.setBlock(world, pos, 2, 19, 4, TREE_LEAVES);
        this.setBlock(world, pos, 2, 19, 5, TREE_TENDONS);
        this.setBlock(world, pos, 2, 19, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 0, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 0, 8, TREE_LOGS);
        this.setBlock(world, pos, 3, 5, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 5, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 6, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 6, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 5, TREE_LOGS);
        this.setBlock(world, pos, 3, 8, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 12, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 13, 5, TREE_TENDONS);
        this.setBlock(world, pos, 3, 13, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 14, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 15, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 16, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 17, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 17, 5, TREE_TENDONS);
        this.setBlock(world, pos, 3, 17, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 17, 9, TREE_LEAVES);
        this.setBlock(world, pos, 3, 18, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 18, 5, TREE_LEAVES);
        this.setBlock(world, pos, 3, 18, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 19, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 0, 7, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 4, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 7, TREE_LOGS);
        this.setBlock(world, pos, 4, 6, 8, TREE_LEAVES);
        this.setBlock(world, pos, 4, 7, 5, TREE_LOGS);
        this.setBlock(world, pos, 4, 7, 8, TREE_LEAVES);
        this.setBlock(world, pos, 4, 8, 8, TREE_LEAVES);
        this.setBlock(world, pos, 4, 11, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 12, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 12, 5, TREE_TENDONS);
        this.setBlock(world, pos, 4, 13, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 14, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 14, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 15, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 15, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 16, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 16, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 17, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 17, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 17, 8, TREE_LEAVES);
        this.setBlock(world, pos, 4, 17, 9, TREE_TENDONS);
        this.setBlock(world, pos, 4, 17, 10, TREE_LEAVES);
        this.setBlock(world, pos, 4, 18, 8, TREE_LEAVES);
        this.setBlock(world, pos, 4, 18, 9, TREE_LEAVES);
        this.setBlock(world, pos, 4, 18, 10, TREE_LEAVES);
        this.setBlock(world, pos, 4, 19, 9, TREE_LEAVES);
        this.setBlock(world, pos, 5, 0, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 0, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 1, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 1, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 2, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 2, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 3, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 3, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 4, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 4, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 5, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 5, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 7, TREE_LOGS);
        this.setBlock(world, pos, 5, 8, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 8, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 8, 8, TREE_LOGS);
        this.setBlock(world, pos, 5, 9, 5, TREE_LOGS);
        this.setBlock(world, pos, 5, 9, 6, TREE_LOGS);
        this.setBlock(world, pos, 5, 9, 8, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 10, 5, TREE_TENDONS);
        this.setBlock(world, pos, 5, 10, 6, TREE_TENDONS);
        this.setBlock(world, pos, 5, 10, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 10, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 11, 5, TREE_TENDONS);
        this.setBlock(world, pos, 5, 11, 6, TREE_TENDONS);
        this.setBlock(world, pos, 5, 11, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 11, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 12, 7, TREE_TENDONS);
        this.setBlock(world, pos, 5, 12, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 12, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 13, 8, TREE_TENDONS);
        this.setBlock(world, pos, 5, 13, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 13, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 14, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 14, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 15, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 15, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 16, 9, TREE_LOGS);
        this.setBlock(world, pos, 5, 16, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 17, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 17, 2, TREE_TENDONS);
        this.setBlock(world, pos, 5, 17, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 17, 7, TREE_LEAVES);
        this.setBlock(world, pos, 5, 17, 8, TREE_TENDONS);
        this.setBlock(world, pos, 5, 17, 9, TREE_TENDONS);
        this.setBlock(world, pos, 5, 17, 10, TREE_TENDONS);
        this.setBlock(world, pos, 5, 17, 11, TREE_LEAVES);
        this.setBlock(world, pos, 5, 18, 1, TREE_LEAVES);
        this.setBlock(world, pos, 5, 18, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 18, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 18, 8, TREE_LEAVES);
        this.setBlock(world, pos, 5, 18, 9, TREE_TENDONS);
        this.setBlock(world, pos, 5, 18, 10, TREE_LEAVES);
        this.setBlock(world, pos, 5, 19, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 19, 8, TREE_LEAVES);
        this.setBlock(world, pos, 5, 19, 9, TREE_TENDONS);
        this.setBlock(world, pos, 5, 19, 10, TREE_LEAVES);
        this.setBlock(world, pos, 6, 0, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 0, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 1, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 1, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 2, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 2, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 3, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 3, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 4, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 4, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 5, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 5, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 5, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 6, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 6, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 6, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 7, 4, TREE_LOGS);
        this.setBlock(world, pos, 6, 7, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 7, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 7, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 3, TREE_LOGS);
        this.setBlock(world, pos, 6, 8, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 8, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 8, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 9, 5, TREE_LOGS);
        this.setBlock(world, pos, 6, 9, 6, TREE_LOGS);
        this.setBlock(world, pos, 6, 10, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 10, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 10, 5, TREE_TENDONS);
        this.setBlock(world, pos, 6, 10, 6, TREE_TENDONS);
        this.setBlock(world, pos, 6, 11, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 11, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 11, 5, TREE_TENDONS);
        this.setBlock(world, pos, 6, 11, 6, TREE_TENDONS);
        this.setBlock(world, pos, 6, 12, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 12, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 12, 4, TREE_TENDONS);
        this.setBlock(world, pos, 6, 13, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 13, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 13, 3, TREE_TENDONS);
        this.setBlock(world, pos, 6, 14, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 14, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 15, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 15, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 16, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 16, 2, TREE_LOGS);
        this.setBlock(world, pos, 6, 17, 0, TREE_LEAVES);
        this.setBlock(world, pos, 6, 17, 1, TREE_TENDONS);
        this.setBlock(world, pos, 6, 17, 2, TREE_TENDONS);
        this.setBlock(world, pos, 6, 17, 3, TREE_TENDONS);
        this.setBlock(world, pos, 6, 17, 4, TREE_LEAVES);
        this.setBlock(world, pos, 6, 17, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 17, 9, TREE_TENDONS);
        this.setBlock(world, pos, 6, 17, 10, TREE_LEAVES);
        this.setBlock(world, pos, 6, 18, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 18, 2, TREE_TENDONS);
        this.setBlock(world, pos, 6, 18, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 18, 8, TREE_LEAVES);
        this.setBlock(world, pos, 6, 18, 9, TREE_LEAVES);
        this.setBlock(world, pos, 6, 18, 10, TREE_LEAVES);
        this.setBlock(world, pos, 6, 19, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 19, 2, TREE_TENDONS);
        this.setBlock(world, pos, 6, 19, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 19, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 7, 0, 7, TREE_LOGS);
        this.setBlock(world, pos, 7, 1, 4, TREE_LOGS);
        this.setBlock(world, pos, 7, 1, 7, TREE_LOGS);
        this.setBlock(world, pos, 7, 7, 6, TREE_LOGS);
        this.setBlock(world, pos, 7, 12, 6, TREE_TENDONS);
        this.setBlock(world, pos, 7, 13, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 14, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 15, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 16, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 17, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 17, 2, TREE_TENDONS);
        this.setBlock(world, pos, 7, 17, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 17, 6, TREE_LEAVES);
        this.setBlock(world, pos, 7, 17, 9, TREE_LEAVES);
        this.setBlock(world, pos, 7, 18, 1, TREE_LEAVES);
        this.setBlock(world, pos, 7, 18, 2, TREE_LEAVES);
        this.setBlock(world, pos, 7, 18, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 19, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 0, 3, TREE_LOGS);
        this.setBlock(world, pos, 8, 0, 8, TREE_LOGS);
        this.setBlock(world, pos, 8, 8, 6, TREE_LOGS);
        this.setBlock(world, pos, 8, 13, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 13, 6, TREE_TENDONS);
        this.setBlock(world, pos, 8, 14, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 15, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 16, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 17, 2, TREE_LEAVES);
        this.setBlock(world, pos, 8, 17, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 17, 6, TREE_TENDONS);
        this.setBlock(world, pos, 8, 17, 7, TREE_LEAVES);
        this.setBlock(world, pos, 8, 18, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 18, 6, TREE_LEAVES);
        this.setBlock(world, pos, 8, 18, 7, TREE_LEAVES);
        this.setBlock(world, pos, 8, 19, 6, TREE_LEAVES);
        this.setBlock(world, pos, 9, 9, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 10, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 11, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 11, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 12, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 12, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 12, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 13, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 13, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 13, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 14, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 14, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 14, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 15, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 15, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 15, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 16, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 16, 6, TREE_LOGS);
        this.setBlock(world, pos, 9, 16, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 17, 4, TREE_LEAVES);
        this.setBlock(world, pos, 9, 17, 5, TREE_TENDONS);
        this.setBlock(world, pos, 9, 17, 6, TREE_TENDONS);
        this.setBlock(world, pos, 9, 17, 7, TREE_TENDONS);
        this.setBlock(world, pos, 9, 17, 8, TREE_LEAVES);
        this.setBlock(world, pos, 9, 18, 5, TREE_LEAVES);
        this.setBlock(world, pos, 9, 18, 6, TREE_TENDONS);
        this.setBlock(world, pos, 9, 18, 7, TREE_LEAVES);
        this.setBlock(world, pos, 9, 19, 5, TREE_LEAVES);
        this.setBlock(world, pos, 9, 19, 6, TREE_TENDONS);
        this.setBlock(world, pos, 9, 19, 7, TREE_LEAVES);
        this.setBlock(world, pos, 10, 17, 5, TREE_LEAVES);
        this.setBlock(world, pos, 10, 17, 6, TREE_TENDONS);
        this.setBlock(world, pos, 10, 17, 7, TREE_LEAVES);
        this.setBlock(world, pos, 10, 18, 5, TREE_LEAVES);
        this.setBlock(world, pos, 10, 18, 6, TREE_LEAVES);
        this.setBlock(world, pos, 10, 18, 7, TREE_LEAVES);
        this.setBlock(world, pos, 10, 19, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 10, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 11, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 12, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 13, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 14, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 15, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 16, 6, TREE_LEAVES);
        this.setBlock(world, pos, 11, 17, 6, TREE_LEAVES);
        
        return true;
    }
}
