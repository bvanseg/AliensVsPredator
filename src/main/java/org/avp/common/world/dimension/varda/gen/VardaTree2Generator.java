package org.avp.common.world.dimension.varda.gen;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class VardaTree2Generator extends VardaTreeGenerator
{
    public VardaTree2Generator(boolean doBlockNotify)
    {
        super(doBlockNotify);
    }
    
    @Override
    public boolean generate(World world, Random rand, BlockPos pos)
    {
        if (shouldNotGenerate(world, pos))
        {
            return false;
        }
        
        pos = pos.add(-4, 0, -3);
        
        this.setBlock(world, pos, 0, 4, 1, TREE_LEAVES);
        this.setBlock(world, pos, 0, 5, 1, TREE_LEAVES);
        this.setBlock(world, pos, 0, 6, 1, TREE_LEAVES);
        this.setBlock(world, pos, 0, 7, 1, TREE_LEAVES);
        this.setBlock(world, pos, 0, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 1, 5, 1, TREE_LOGS);
        this.setBlock(world, pos, 1, 6, 1, TREE_LOGS);
        this.setBlock(world, pos, 1, 6, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 7, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 7, 1, TREE_TENDONS);
        this.setBlock(world, pos, 1, 7, 2, TREE_LEAVES);
        this.setBlock(world, pos, 1, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 1, 8, 1, TREE_TENDONS);
        this.setBlock(world, pos, 1, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 2, 1, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 2, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 3, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 3, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 4, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 4, 2, TREE_LOGS);
        this.setBlock(world, pos, 2, 4, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 5, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 5, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 6, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 7, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 2, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 2, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 2, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 0, 2, TREE_LOGS);
        this.setBlock(world, pos, 3, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 3, 1, 2, TREE_LOGS);
        this.setBlock(world, pos, 3, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 3, 3, TREE_LOGS);
        this.setBlock(world, pos, 3, 4, 3, TREE_TENDONS);
        this.setBlock(world, pos, 3, 4, 4, TREE_LOGS);
        this.setBlock(world, pos, 3, 5, 5, TREE_LOGS);
        this.setBlock(world, pos, 3, 6, 5, TREE_LOGS);
        this.setBlock(world, pos, 3, 6, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 7, 5, TREE_TENDONS);
        this.setBlock(world, pos, 3, 7, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 8, 5, TREE_TENDONS);
        this.setBlock(world, pos, 3, 8, 6, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 3, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 3, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 4, 0, 1, TREE_LOGS);
        this.setBlock(world, pos, 4, 0, 2, TREE_TENDONS);
        this.setBlock(world, pos, 4, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 0, 4, TREE_TENDONS);
        this.setBlock(world, pos, 4, 0, 5, TREE_LOGS);
        this.setBlock(world, pos, 4, 1, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 2, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 3, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 4, 2, TREE_TENDONS);
        this.setBlock(world, pos, 4, 4, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 4, 4, TREE_TENDONS);
        this.setBlock(world, pos, 4, 5, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 5, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 6, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 7, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 7, 3, TREE_LOGS);
        this.setBlock(world, pos, 4, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 4, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 8, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 9, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 2, TREE_LEAVES);
        this.setBlock(world, pos, 4, 10, 3, TREE_TENDONS);
        this.setBlock(world, pos, 4, 10, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 0, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 0, 4, TREE_LOGS);
        this.setBlock(world, pos, 5, 1, 4, TREE_LOGS);
        this.setBlock(world, pos, 5, 2, 3, TREE_LOGS);
        this.setBlock(world, pos, 5, 3, 3, TREE_LOGS);
        this.setBlock(world, pos, 5, 4, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 4, 2, TREE_LOGS);
        this.setBlock(world, pos, 5, 4, 3, TREE_TENDONS);
        this.setBlock(world, pos, 5, 5, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 5, 1, TREE_LOGS);
        this.setBlock(world, pos, 5, 6, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 6, 1, TREE_LOGS);
        this.setBlock(world, pos, 5, 7, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 7, 1, TREE_TENDONS);
        this.setBlock(world, pos, 5, 7, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 0, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 1, TREE_TENDONS);
        this.setBlock(world, pos, 5, 8, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 2, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 5, 9, 4, TREE_LEAVES);
        this.setBlock(world, pos, 5, 10, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 4, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 4, 4, TREE_LOGS);
        this.setBlock(world, pos, 6, 5, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 6, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 7, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 7, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 1, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 3, TREE_LEAVES);
        this.setBlock(world, pos, 6, 8, 5, TREE_LEAVES);
        this.setBlock(world, pos, 6, 9, 3, TREE_LEAVES);
        this.setBlock(world, pos, 7, 5, 5, TREE_LOGS);
        this.setBlock(world, pos, 7, 5, 6, TREE_LEAVES);
        this.setBlock(world, pos, 7, 6, 5, TREE_LOGS);
        this.setBlock(world, pos, 7, 6, 6, TREE_LEAVES);
        this.setBlock(world, pos, 7, 7, 4, TREE_LEAVES);
        this.setBlock(world, pos, 7, 7, 5, TREE_TENDONS);
        this.setBlock(world, pos, 7, 7, 6, TREE_LEAVES);
        this.setBlock(world, pos, 7, 8, 4, TREE_LEAVES);
        this.setBlock(world, pos, 7, 8, 5, TREE_TENDONS);
        this.setBlock(world, pos, 7, 8, 6, TREE_LEAVES);
        this.setBlock(world, pos, 8, 4, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 5, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 6, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 7, 5, TREE_LEAVES);
        this.setBlock(world, pos, 8, 8, 5, TREE_LEAVES);
        
        return true;
    }
}
