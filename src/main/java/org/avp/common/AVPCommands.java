package org.avp.common;

import com.asx.mdx.common.mods.IInitEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.avp.common.command.CommandSettings;

public class AVPCommands implements IInitEvent
{
    public static final AVPCommands instance = new AVPCommands();
    private CommandSettings commandSettings;

    private AVPCommands() {}

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(this.commandSettings = new CommandSettings());
    }
}
