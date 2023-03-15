package org.alien.common.world.worldgen;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Structure;
import net.minecraft.world.WorldServer;
import org.avp.common.Schematics;

public class StructureDerelict extends Structure
{
    @Override
    public String getName()
    {
        return "Derelict";
    }

    public StructureDerelict(WorldServer world, Pos data)
    {
        super(Schematics.instance.derelict, world, data);
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
