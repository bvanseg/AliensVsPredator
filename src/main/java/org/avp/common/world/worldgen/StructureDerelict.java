package org.avp.common.world.worldgen;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Structure;
import net.minecraft.world.WorldServer;
import org.avp.AVP;

public class StructureDerelict extends Structure
{
    @Override
    public String getName()
    {
        return "Derelict";
    }

    public StructureDerelict(WorldServer world, Pos data)
    {
        super(AVP.schematics().derelict, world, data);
    }

    @Override
    public void onProcessing()
    {
        ;
    }

    @Override
    public void onProcessingComplete()
    {
        ;
    }
}
