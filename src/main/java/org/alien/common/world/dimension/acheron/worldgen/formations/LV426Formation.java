package org.alien.common.world.dimension.acheron.worldgen.formations;

import com.asx.mdx.common.minecraft.Pos;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import org.alien.common.block.init.AlienBlocks;
import org.alien.common.block.init.AlienVardaBlocks;
import org.alien.common.world.worldgen.TerrainGenVariant;

import java.util.ArrayList;
import java.util.List;

public class LV426Formation extends TerrainGenVariant<LV426Formation>
{
    public LV426Formation()
    {
        this.addVariant(this);
    }

    @Override
    public IBlockState getBlock()
    {
        return AlienBlocks.LV_426_ROCK.getDefaultState();
    }

    @Override
    public Block[] getValidLocations()
    {
        return new Block[] { AlienVardaBlocks.UNIDIRT, AlienVardaBlocks.UNISTONE
        };
    }

    public Pos[] getOffsets()
    {
        List<Pos> set = new ArrayList<>();

        offset(set, 0, 9, 3);
        offset(set, 0, 9, 4);
        offset(set, 0, 9, 5);
        offset(set, 1, 7, 3);
        offset(set, 1, 7, 5);
        offset(set, 1, 8, 4);
        offset(set, 1, 9, 3);
        offset(set, 1, 9, 4);
        offset(set, 1, 9, 5);
        offset(set, 2, 0, 4);
        offset(set, 2, 6, 4);
        offset(set, 2, 7, 2);
        offset(set, 2, 7, 3);
        offset(set, 2, 7, 4);
        offset(set, 2, 7, 5);
        offset(set, 2, 7, 6);
        offset(set, 2, 8, 3);
        offset(set, 2, 8, 4);
        offset(set, 2, 8, 5);
        offset(set, 2, 9, 3);
        offset(set, 2, 9, 4);
        offset(set, 2, 9, 5);
        offset(set, 3, 0, 3);
        offset(set, 3, 0, 5);
        offset(set, 3, 1, 4);
        offset(set, 3, 2, 4);
        offset(set, 3, 3, 4);
        offset(set, 3, 5, 4);
        offset(set, 3, 6, 4);
        offset(set, 3, 6, 5);
        offset(set, 3, 7, 1);
        offset(set, 3, 7, 2);
        offset(set, 3, 7, 3);
        offset(set, 3, 7, 4);
        offset(set, 3, 7, 5);
        offset(set, 3, 7, 6);
        offset(set, 3, 7, 7);
        offset(set, 3, 8, 2);
        offset(set, 3, 8, 3);
        offset(set, 3, 8, 4);
        offset(set, 3, 8, 5);
        offset(set, 3, 8, 6);
        offset(set, 3, 9, 4);
        offset(set, 4, 0, 2);
        offset(set, 4, 0, 3);
        offset(set, 4, 0, 5);
        offset(set, 4, 0, 6);
        offset(set, 4, 1, 3);
        offset(set, 4, 1, 4);
        offset(set, 4, 1, 5);
        offset(set, 4, 2, 3);
        offset(set, 4, 2, 4);
        offset(set, 4, 2, 5);
        offset(set, 4, 3, 3);
        offset(set, 4, 3, 4);
        offset(set, 4, 3, 5);
        offset(set, 4, 4, 4);
        offset(set, 4, 5, 3);
        offset(set, 4, 5, 4);
        offset(set, 4, 5, 5);
        offset(set, 4, 6, 1);
        offset(set, 4, 6, 2);
        offset(set, 4, 6, 3);
        offset(set, 4, 6, 4);
        offset(set, 4, 6, 5);
        offset(set, 4, 6, 6);
        offset(set, 4, 6, 7);
        offset(set, 4, 7, 1);
        offset(set, 4, 7, 2);
        offset(set, 4, 7, 3);
        offset(set, 4, 7, 4);
        offset(set, 4, 7, 5);
        offset(set, 4, 7, 6);
        offset(set, 4, 7, 7);
        offset(set, 4, 8, 4);
        offset(set, 5, 0, 1);
        offset(set, 5, 0, 2);
        offset(set, 5, 0, 3);
        offset(set, 5, 0, 4);
        offset(set, 5, 0, 5);
        offset(set, 5, 0, 6);
        offset(set, 5, 0, 7);
        offset(set, 5, 1, 2);
        offset(set, 5, 1, 3);
        offset(set, 5, 1, 4);
        offset(set, 5, 1, 5);
        offset(set, 5, 1, 6);
        offset(set, 5, 2, 2);
        offset(set, 5, 2, 3);
        offset(set, 5, 2, 4);
        offset(set, 5, 2, 5);
        offset(set, 5, 2, 6);
        offset(set, 5, 3, 2);
        offset(set, 5, 3, 3);
        offset(set, 5, 3, 4);
        offset(set, 5, 3, 5);
        offset(set, 5, 3, 6);
        offset(set, 5, 4, 3);
        offset(set, 5, 4, 4);
        offset(set, 5, 4, 5);
        offset(set, 5, 5, 2);
        offset(set, 5, 5, 3);
        offset(set, 5, 5, 4);
        offset(set, 5, 5, 5);
        offset(set, 5, 5, 6);
        offset(set, 5, 6, 1);
        offset(set, 5, 6, 2);
        offset(set, 5, 6, 3);
        offset(set, 5, 6, 4);
        offset(set, 5, 6, 5);
        offset(set, 5, 6, 6);
        offset(set, 5, 6, 7);
        offset(set, 5, 7, 4);
        offset(set, 6, 0, 1);
        offset(set, 6, 0, 2);
        offset(set, 6, 0, 3);
        offset(set, 6, 0, 4);
        offset(set, 6, 0, 5);
        offset(set, 6, 0, 6);
        offset(set, 6, 0, 7);
        offset(set, 6, 1, 1);
        offset(set, 6, 1, 2);
        offset(set, 6, 1, 3);
        offset(set, 6, 1, 4);
        offset(set, 6, 1, 5);
        offset(set, 6, 1, 6);
        offset(set, 6, 1, 7);
        offset(set, 6, 2, 1);
        offset(set, 6, 2, 2);
        offset(set, 6, 2, 3);
        offset(set, 6, 2, 4);
        offset(set, 6, 2, 5);
        offset(set, 6, 2, 6);
        offset(set, 6, 2, 7);
        offset(set, 6, 3, 2);
        offset(set, 6, 3, 3);
        offset(set, 6, 3, 4);
        offset(set, 6, 3, 5);
        offset(set, 6, 3, 6);
        offset(set, 6, 4, 3);
        offset(set, 6, 4, 4);
        offset(set, 6, 4, 5);
        offset(set, 6, 5, 1);
        offset(set, 6, 5, 2);
        offset(set, 6, 5, 3);
        offset(set, 6, 5, 4);
        offset(set, 6, 5, 5);
        offset(set, 6, 5, 6);
        offset(set, 6, 5, 7);
        offset(set, 6, 6, 4);
        offset(set, 7, 0, 0);
        offset(set, 7, 0, 1);
        offset(set, 7, 0, 2);
        offset(set, 7, 0, 3);
        offset(set, 7, 0, 4);
        offset(set, 7, 0, 5);
        offset(set, 7, 0, 6);
        offset(set, 7, 0, 7);
        offset(set, 7, 0, 8);
        offset(set, 7, 1, 1);
        offset(set, 7, 1, 2);
        offset(set, 7, 1, 3);
        offset(set, 7, 1, 4);
        offset(set, 7, 1, 5);
        offset(set, 7, 1, 6);
        offset(set, 7, 1, 7);
        offset(set, 7, 2, 1);
        offset(set, 7, 2, 2);
        offset(set, 7, 2, 3);
        offset(set, 7, 2, 4);
        offset(set, 7, 2, 5);
        offset(set, 7, 2, 6);
        offset(set, 7, 2, 7);
        offset(set, 7, 3, 1);
        offset(set, 7, 3, 2);
        offset(set, 7, 3, 3);
        offset(set, 7, 3, 4);
        offset(set, 7, 3, 5);
        offset(set, 7, 3, 6);
        offset(set, 7, 3, 7);
        offset(set, 7, 4, 1);
        offset(set, 7, 4, 2);
        offset(set, 7, 4, 3);
        offset(set, 7, 4, 4);
        offset(set, 7, 4, 5);
        offset(set, 7, 4, 6);
        offset(set, 7, 4, 7);
        offset(set, 7, 5, 1);
        offset(set, 7, 5, 2);
        offset(set, 7, 5, 3);
        offset(set, 7, 5, 4);
        offset(set, 7, 5, 5);
        offset(set, 7, 5, 6);
        offset(set, 7, 5, 7);
        offset(set, 7, 6, 4);
        offset(set, 8, 0, 0);
        offset(set, 8, 0, 1);
        offset(set, 8, 0, 2);
        offset(set, 8, 0, 3);
        offset(set, 8, 0, 4);
        offset(set, 8, 0, 5);
        offset(set, 8, 0, 6);
        offset(set, 8, 0, 7);
        offset(set, 8, 0, 8);
        offset(set, 8, 1, 1);
        offset(set, 8, 1, 2);
        offset(set, 8, 1, 3);
        offset(set, 8, 1, 4);
        offset(set, 8, 1, 5);
        offset(set, 8, 1, 6);
        offset(set, 8, 1, 7);
        offset(set, 8, 2, 1);
        offset(set, 8, 2, 2);
        offset(set, 8, 2, 3);
        offset(set, 8, 2, 4);
        offset(set, 8, 2, 5);
        offset(set, 8, 2, 6);
        offset(set, 8, 2, 7);
        offset(set, 8, 3, 1);
        offset(set, 8, 3, 2);
        offset(set, 8, 3, 3);
        offset(set, 8, 3, 4);
        offset(set, 8, 3, 5);
        offset(set, 8, 3, 6);
        offset(set, 8, 3, 7);
        offset(set, 8, 4, 1);
        offset(set, 8, 4, 2);
        offset(set, 8, 4, 3);
        offset(set, 8, 4, 4);
        offset(set, 8, 4, 5);
        offset(set, 8, 4, 6);
        offset(set, 8, 4, 7);
        offset(set, 8, 5, 3);
        offset(set, 8, 5, 4);
        offset(set, 9, 0, 0);
        offset(set, 9, 0, 1);
        offset(set, 9, 0, 2);
        offset(set, 9, 0, 3);
        offset(set, 9, 0, 4);
        offset(set, 9, 0, 5);
        offset(set, 9, 0, 6);
        offset(set, 9, 0, 7);
        offset(set, 9, 0, 8);
        offset(set, 9, 1, 1);
        offset(set, 9, 1, 2);
        offset(set, 9, 1, 3);
        offset(set, 9, 1, 4);
        offset(set, 9, 1, 5);
        offset(set, 9, 1, 6);
        offset(set, 9, 1, 7);
        offset(set, 9, 2, 1);
        offset(set, 9, 2, 2);
        offset(set, 9, 2, 3);
        offset(set, 9, 2, 4);
        offset(set, 9, 2, 5);
        offset(set, 9, 2, 6);
        offset(set, 9, 2, 7);
        offset(set, 9, 3, 2);
        offset(set, 9, 3, 3);
        offset(set, 9, 3, 4);
        offset(set, 9, 3, 5);
        offset(set, 9, 3, 6);
        offset(set, 9, 4, 3);
        offset(set, 9, 4, 4);
        offset(set, 9, 4, 5);
        offset(set, 9, 5, 4);
        offset(set, 10, 0, 1);
        offset(set, 10, 0, 2);
        offset(set, 10, 0, 3);
        offset(set, 10, 0, 4);
        offset(set, 10, 0, 5);
        offset(set, 10, 0, 6);
        offset(set, 10, 0, 7);
        offset(set, 10, 1, 2);
        offset(set, 10, 1, 3);
        offset(set, 10, 1, 4);
        offset(set, 10, 1, 5);
        offset(set, 10, 1, 6);
        offset(set, 10, 2, 2);
        offset(set, 10, 2, 3);
        offset(set, 10, 2, 4);
        offset(set, 10, 2, 5);
        offset(set, 10, 2, 6);
        offset(set, 10, 3, 3);
        offset(set, 10, 3, 4);
        offset(set, 10, 3, 5);
        offset(set, 10, 4, 4);
        offset(set, 11, 0, 2);
        offset(set, 11, 0, 3);
        offset(set, 11, 0, 4);
        offset(set, 11, 0, 5);
        offset(set, 11, 0, 6);
        offset(set, 11, 1, 3);
        offset(set, 11, 1, 4);
        offset(set, 11, 1, 5);
        offset(set, 11, 2, 3);
        offset(set, 11, 2, 4);
        offset(set, 11, 2, 5);
        offset(set, 11, 3, 4);
        offset(set, 12, 0, 3);
        offset(set, 12, 0, 4);
        offset(set, 12, 0, 5);
        offset(set, 12, 1, 4);
        offset(set, 12, 2, 4);
        offset(set, 13, 0, 4);

        return set.toArray(new Pos[set.size()]);
    }
}