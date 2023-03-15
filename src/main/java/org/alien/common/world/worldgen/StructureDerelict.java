package org.alien.common.world.worldgen;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.Structure;
import net.minecraft.world.WorldServer;
import org.avp.common.StructureSchematics;

public class StructureDerelict extends Structure
{
    @Override
    public String getName()
    {
        return "Derelict";
    }

    public StructureDerelict(WorldServer world, Pos data)
    {
        super(StructureSchematics.instance.derelict, world, data);
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
