package org.avp;

import org.avp.command.CommandPlayerMode;
import org.avp.command.CommandSettings;

import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandHandler implements IInitEvent
{
    public static final CommandHandler instance = new CommandHandler();
    public CommandPlayerMode commandPlayerMode;
    public CommandSettings commandSettings;

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        event.registerServerCommand(this.commandPlayerMode = new CommandPlayerMode());
        event.registerServerCommand(this.commandSettings = new CommandSettings());
    }
}
