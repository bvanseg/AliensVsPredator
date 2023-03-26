package org.alien.common.world.dimension;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import org.alien.common.AlienBlocks;

public class GenerationFilters
{
    public static final Predicate<IBlockState> STONE = state -> {
        if (state.getBlock() == AlienBlocks.UNISTONE)
        {
            return true;
        }

        if (state.getBlock() == Blocks.STONE)
        {
            return true;
        }

        return false;
    };
    
    public static final Predicate<IBlockState> DIRT = state -> {
        if (state.getBlock() == AlienBlocks.UNIDIRT)
        {
            return true;
        }

        if (state.getBlock() == Blocks.DIRT)
        {
            return true;
        }

        return false;
    };
    
    public static final Predicate<IBlockState> SAND = state -> {
        if (state.getBlock() == AlienBlocks.UNISAND)
        {
            return true;
        }

        if (state.getBlock() == Blocks.SAND)
        {
            return true;
        }

        return false;
    };
}
