package org.alien.common.world.dimension.acheron.worldgen.formations;

import com.asx.mdx.lib.world.Pos;

import java.util.ArrayList;
import java.util.List;

public class LV426Formation5 extends LV426Formation
{
    public LV426Formation5()
    {
        ;
    }
    
    @Override
    public Pos[] getOffsets()
    {
        List<Pos> set = new ArrayList<Pos>();
        
		offset(set, 0, 0, 3);
		offset(set, 1, 0, 2);
		offset(set, 1, 0, 3);
		offset(set, 1, 0, 4);
		offset(set, 1, 1, 3);
		offset(set, 1, 5, 3);
		offset(set, 1, 6, 2);
		offset(set, 1, 6, 3);
		offset(set, 1, 6, 4);
		offset(set, 1, 7, 3);
		offset(set, 1, 8, 3);
		offset(set, 2, 0, 1);
		offset(set, 2, 0, 2);
		offset(set, 2, 0, 3);
		offset(set, 2, 0, 4);
		offset(set, 2, 0, 5);
		offset(set, 2, 1, 2);
		offset(set, 2, 1, 3);
		offset(set, 2, 1, 4);
		offset(set, 2, 2, 3);
		offset(set, 2, 4, 3);
		offset(set, 2, 5, 2);
		offset(set, 2, 5, 3);
		offset(set, 2, 5, 4);
		offset(set, 2, 6, 3);
		offset(set, 2, 7, 2);
		offset(set, 2, 7, 3);
		offset(set, 2, 7, 4);
		offset(set, 2, 8, 3);
		offset(set, 2, 9, 3);
		offset(set, 3, 0, 0);
		offset(set, 3, 0, 1);
		offset(set, 3, 0, 2);
		offset(set, 3, 0, 3);
		offset(set, 3, 0, 4);
		offset(set, 3, 0, 5);
		offset(set, 3, 0, 6);
		offset(set, 3, 1, 1);
		offset(set, 3, 1, 2);
		offset(set, 3, 1, 3);
		offset(set, 3, 1, 4);
		offset(set, 3, 1, 5);
		offset(set, 3, 2, 3);
		offset(set, 3, 3, 2);
		offset(set, 3, 3, 3);
		offset(set, 3, 3, 4);
		offset(set, 3, 4, 2);
		offset(set, 3, 4, 3);
		offset(set, 3, 4, 4);
		offset(set, 3, 5, 3);
		offset(set, 4, 0, 1);
		offset(set, 4, 0, 2);
		offset(set, 4, 0, 3);
		offset(set, 4, 0, 4);
		offset(set, 4, 0, 5);
		offset(set, 4, 1, 1);
		offset(set, 4, 1, 2);
		offset(set, 4, 1, 3);
		offset(set, 4, 1, 4);
		offset(set, 4, 1, 5);
		offset(set, 4, 2, 2);
		offset(set, 4, 2, 3);
		offset(set, 4, 2, 4);
		offset(set, 4, 3, 3);
		offset(set, 5, 0, 2);
		offset(set, 5, 0, 3);
		offset(set, 5, 0, 4);
		offset(set, 5, 1, 3);
		offset(set, 5, 2, 3);
		offset(set, 6, 0, 2);
		offset(set, 6, 0, 3);
		offset(set, 6, 0, 4);
		offset(set, 6, 1, 3);
		offset(set, 7, 0, 3);

        return set.toArray(new Pos[set.size()]);
    }
}