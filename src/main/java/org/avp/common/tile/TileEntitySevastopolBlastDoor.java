package org.avp.common.tile;

import net.minecraft.block.Block;
import net.minecraft.util.math.BlockPos;
import org.avp.AVP;
import org.avp.common.AVPBlocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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
    public void playOpenSound()
    {
        AVP.sounds().BLASTDOOR_SEVASTOPOL_OPEN.playSound(world, pos, 1F, 1F);
    }
    
    @Override
    public void playCloseSound()
    {
        AVP.sounds().BLASTDOOR_SEVASTOPOL_CLOSE.playSound(world, pos, 1F, 1F);
    }
    
    @Override
    public Block getMultiBlockType()
    {
        return AVPBlocks.SEVASTOPOL_BLAST_DOOR;
    }
}
