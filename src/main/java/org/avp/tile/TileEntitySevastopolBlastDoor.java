package org.avp.tile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.avp.AliensVsPredator;

import net.minecraft.util.math.BlockPos;

public class TileEntitySevastopolBlastDoor extends TileEntityBlastdoor
{
    public TileEntitySevastopolBlastDoor()
    {
        super();
        this.identifier = "SBD" + (1000 + new Random().nextInt(8999));
    }
    
    @Override
    public BlockPos[] defaultSet()
    {
        List<BlockPos> set = new ArrayList<BlockPos>();
        BlockPos pos = new BlockPos(0, 0, 0);

        set.add(pos.add(1, 0, 0));
        set.add(pos.add(0, 1, 0));
        set.add(pos.add(0, 2, 0));
        set.add(pos.add(1, 2, 0));
        set.add(pos.add(1, 1, 0));

        return set.toArray(new BlockPos[set.size()]);
    }
    
    @Override
    public float getDoorSpeed()
    {
        return 0.09F;
    }
    
    @Override
    public void playDoorOpenSound()
    {
        AliensVsPredator.sounds().BLASTDOOR_OPEN.playSound(world, pos, 1F, 2F);
    }
}
