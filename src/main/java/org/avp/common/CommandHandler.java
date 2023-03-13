package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import org.avp.common.command.CommandPlayerMode;
import org.avp.common.command.CommandSettings;

public class CommandHandler implements IInitEvent
{
    public static final CommandHandler instance = new CommandHandler();
    private CommandPlayerMode commandPlayerMode;
    private CommandSettings commandSettings;

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
