package org.avp;

import java.io.File;

import com.arisux.mdx.MDX;
import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IMod;
import com.arisux.mdx.lib.world.storage.Schematic;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;



public class Schematics implements IInitEvent
{
    public static final Schematics instance = new Schematics();
    public static final File baseSchematicDir = new File("schematics/avp/");
    public Schematic schematicTest;
    public Schematic derelict;
    public Schematic derelictOld;

    @Override
    public void init(IMod mod, FMLInitializationEvent event)
    {
        if (!baseSchematicDir.exists())
        {
            baseSchematicDir.mkdirs();
        }

        this.schematicTest = MDX.loadSchematic(new File(baseSchematicDir, "test.schematic"), AliensVsPredator.class.getResource("/assets/avp/schematics/test.schematic"));
        this.derelict = MDX.loadSchematic(new File(baseSchematicDir, "derelict.schematic"), AliensVsPredator.class.getResource("/assets/avp/schematics/derelict.schematic"));
        this.derelictOld = MDX.loadSchematic(new File(baseSchematicDir, "derelictold.schematic"), AliensVsPredator.class.getResource("/assets/avp/schematics/derelictold.schematic"));
    }
}
