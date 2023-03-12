package org.avp.common;

import java.io.File;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.world.SchematicLoader;
import com.asx.mdx.lib.world.storage.Schematic;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.AVP;

public class Schematics implements IInitEvent
{
    public static final Schematics instance         = new Schematics();
    public static final File       baseSchematicDir = new File("schematics/avp/");
    public Schematic               schematicTest;
    public Schematic               derelict;
    public Schematic               derelictOld;

    @Override
    public void init(FMLInitializationEvent event)
    {
        if (!baseSchematicDir.exists())
        {
            baseSchematicDir.mkdirs();
        }

        this.schematicTest = SchematicLoader.load(new File(baseSchematicDir, "test.schematic"), AVP.class.getResource("/assets/avp/schematics/test.schematic"));
        this.derelict = SchematicLoader.load(new File(baseSchematicDir, "derelict.schematic"), AVP.class.getResource("/assets/avp/schematics/derelict.schematic"));
        this.derelictOld = SchematicLoader.load(new File(baseSchematicDir, "derelictold.schematic"), AVP.class.getResource("/assets/avp/schematics/derelictold.schematic"));
    }
}
