package org.alien.common.world.dimension;

import com.google.common.base.Predicate;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import org.alien.common.block.init.AlienBlocks;
import org.alien.common.block.init.AlienVardaBlocks;

public class GenerationFilters
{
    public static final Predicate<IBlockState> STONE = state -> {
        if (state.getBlock() == AlienVardaBlocks.UNISTONE)
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
        if (state.getBlock() == AlienVardaBlocks.UNIDIRT)
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
        if (state.getBlock() == AlienVardaBlocks.UNISAND)
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
