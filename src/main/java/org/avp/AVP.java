/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2019 ASX **/
package org.avp;

import com.asx.mdx.core.mods.IMod;
import com.asx.mdx.lib.util.Game;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.Aliens;
import org.alien.common.AlienDimensions;
import org.apache.logging.log4j.Logger;
import org.avp.client.AVPSounds;
import org.avp.client.KeybindHandler;
import org.avp.client.Renders;
import org.avp.client.Resources;
import org.avp.common.*;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.world.CapabilityHandler;
import org.predator.Predators;

@Mod(name = AVP.Properties.NAME, modid = AVP.Properties.ID, dependencies = AVP.Properties.DEPENDENCIES)
public class AVP implements IMod
{
    public static class Properties
    {
        public static final String NAME         = "AliensVsPredator";
        public static final String ID           = "avp";
        public static final String DEPENDENCIES = "required-after:mdxlib";
        public static final String DOMAIN       = ID + ":";
    }

    @Mod.Instance(AVP.Properties.ID)
    private static AVP instance;

    @Override
    public ModContainer container()
    {
        return Game.getModContainer(AVP.Properties.ID);
    }

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
        // Config
        AVPSettings.instance.pre(event);

        Aliens.instance.pre(event);
        Predators.instance.pre(event);

        AVPBlocks.instance.pre(event);
        AVPItems.instance.pre(event);
        AVPSounds.instance.pre(event);

        // Misc.
        Console.instance.pre(event);
        CapabilityHandler.instance.pre(event);
        AVPCreativeTabs.instance.pre(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            Renders.instance.pre(event);
        }
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        Console.instance.init(event);
        AVPNetworking.instance.init(event);
        AVPMaterials.instance.init(event);
        AVPGui.instance.init(event);
        AVPEventHandlers.instance.init(event);
        AVPCommands.instance.init(event);
        PlayerModeHandler.instance.init(event);
        StructureSchematics.instance.init(event);
        AvpDataSerializers.instance.init(event);

        Aliens.instance.init(event);
        Predators.instance.init(event);

        AVPEntities.instance.init(event);
        AVPEntitySpawns.instance.init(event);
        AVPTileEntities.instance.init(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            Renders.instance.init(event);
        }
    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event)
    {
        Console.instance.post(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT) {
            KeybindHandler.instance.post(event);
        }
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        AVPCommands.instance.onServerStarting(event);
    }

    @Deprecated
    public static AVP instance()
    {
        return AVP.instance;
    }

    @Deprecated
    public static Logger log()
    {
        return Console.logger;
    }

    @Deprecated
    @SideOnly(Side.CLIENT)
    public static KeybindHandler keybinds()
    {
        return KeybindHandler.instance;
    }

    @Deprecated
    public static AVPGui interfaces()
    {
        return AVPGui.instance;
    }

    @Deprecated
    public static PlayerModeHandler playermodehandler()
    {
        return PlayerModeHandler.instance;
    }

    @Deprecated
    public static AVPSettings settings()
    {
        return AVPSettings.instance;
    }
}
