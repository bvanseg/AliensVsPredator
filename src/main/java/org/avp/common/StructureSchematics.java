package org.avp.common;

import com.asx.mdx.common.minecraft.storage.Schematic;
import com.asx.mdx.common.minecraft.structure.SchematicLoader;
import com.asx.mdx.common.mods.IInitEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.AVP;

import java.io.File;

public class StructureSchematics implements IInitEvent
{
    public static final StructureSchematics instance         = new StructureSchematics();
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
