package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.avp.common.world.dimension.acheron.WorldGeneratorAcheron;
import org.avp.common.world.worldgen.WorldGenerator;
import org.avp.common.world.worldgen.WorldGeneratorDerelict;

public class WorldHandler implements IInitEvent
{
    public static final WorldHandler instance = new WorldHandler();
    private SaveHandler saveHandler;
    private IWorldGenerator worldGeneratorAcheron;
    private IWorldGenerator worldGeneratorDerelict;

    public WorldHandler()
    {
        this.saveHandler = new SaveHandler();
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        GameRegistry.registerWorldGenerator(new WorldGenerator(), 1);
        GameRegistry.registerWorldGenerator(this.setWorldGeneratorAcheron(new WorldGeneratorAcheron()), 1);
        GameRegistry.registerWorldGenerator(this.worldGeneratorDerelict = new WorldGeneratorDerelict(), 1);
    }

    public WorldGeneratorDerelict getWorldGeneratorDerelict()
    {
        return (WorldGeneratorDerelict) worldGeneratorDerelict;
    }

    public SaveHandler getSaveHandler()
    {
        return saveHandler;
    }

    public IWorldGenerator getWorldGeneratorAcheron()
    {
        return worldGeneratorAcheron;
    }

    public IWorldGenerator setWorldGeneratorAcheron(IWorldGenerator worldGeneratorAcheron)
    {
        this.worldGeneratorAcheron = worldGeneratorAcheron;
        return worldGeneratorAcheron;
    }
}
