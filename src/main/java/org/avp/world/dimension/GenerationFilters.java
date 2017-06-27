package org.avp.world.dimension;

import org.avp.AliensVsPredator;

import com.google.common.base.Predicate;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

public class GenerationFilters
{
    public static final Predicate<IBlockState> STONE = new Predicate<IBlockState>()
    {
        @Override
        public boolean apply(IBlockState state)
        {
            if (state.getBlock() == AliensVsPredator.blocks().unistone)
            {
                return true;
            }

            if (state.getBlock() == Blocks.STONE)
            {
                return true;
            }

            return false;
        }
    };
    
    public static final Predicate<IBlockState> DIRT = new Predicate<IBlockState>()
    {
        @Override
        public boolean apply(IBlockState state)
        {
            if (state.getBlock() == AliensVsPredator.blocks().unidirt)
            {
                return true;
            }

            if (state.getBlock() == Blocks.DIRT)
            {
                return true;
            }

            return false;
        }
    };
    
    public static final Predicate<IBlockState> SAND = new Predicate<IBlockState>()
    {
        @Override
        public boolean apply(IBlockState state)
        {
            if (state.getBlock() == AliensVsPredator.blocks().unisand)
            {
                return true;
            }

            if (state.getBlock() == Blocks.SAND)
            {
                return true;
            }

            return false;
        }
    };
}
