package org.avp;

import org.avp.world.dimension.acheron.WorldGeneratorAcheron;
import org.avp.world.worldgen.WorldGenerator;
import org.avp.world.worldgen.WorldGeneratorDerelict;

import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.game.IMod;

import net.minecraftforge.fml.common.IWorldGenerator;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

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
    public void init(IMod mod, FMLInitializationEvent event)
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
