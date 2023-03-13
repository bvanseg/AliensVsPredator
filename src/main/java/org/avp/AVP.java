/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2019 ASX **/
package org.avp;

import com.asx.mdx.core.mods.IMod;
import com.asx.mdx.lib.util.Game;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.alien.client.AlienSounds;
import org.alien.common.AlienBlocks;
import org.alien.common.AlienItems;
import org.alien.common.DimensionHandler;
import org.alien.common.WorldHandler;
import org.apache.logging.log4j.Logger;
import org.avp.client.AVPSounds;
import org.avp.client.KeybindHandler;
import org.avp.client.Renders;
import org.avp.client.Resources;
import org.avp.client.render.BiomeColorHandler;
import org.avp.common.*;
import org.avp.common.network.AvpDataSerializers;
import org.avp.common.world.CapabilityHandler;
import org.predator.client.PredatorSounds;
import org.predator.common.PredatorBlocks;
import org.predator.common.PredatorItems;

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
        settings().pre(event);

        // Blocks
        AlienBlocks.instance.pre(event);
        PredatorBlocks.instance.pre(event);
        AVPBlocks.instance.pre(event);

        // Items
        AlienItems.instance.pre(event);
        PredatorItems.instance.pre(event);
        AVPItems.instance.pre(event);

        // Sounds
        AlienSounds.instance.pre(event);
        PredatorSounds.instance.pre(event);
        AVPSounds.instance.pre(event);

        console().pre(event);
        capabilities().pre(event);
        tabs().pre(event);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void preClient(FMLPreInitializationEvent event)
    {
        renderers().pre(event);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        console().init(event);
        network().init(event);
        dimensions().init(event);
        materials().init(event);
        world().init(event);
        interfaces().init(event);
        events().init(event);
        commands().init(event);
        playermodehandler().init(event);
        schematics().init(event);
        AvpDataSerializers.init();
        entities().init(event);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLInitializationEvent event)
    {
        renderers().init(event);
        biomeColors().init(event);
    }

    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event)
    {
        console().post(event);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void postClient(FMLPostInitializationEvent event)
    {
        keybinds().post(event);
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        commands().onServerStarting(event);
    }

    public static AVP instance()
    {
        return AVP.instance;
    }

    public static Console console()
    {
        return Console.instance;
    }

    public static Logger log()
    {
        return Console.logger;
    }
    
    @SideOnly(Side.CLIENT)
    public static BiomeColorHandler biomeColors()
    {
        return BiomeColorHandler.instance;
    }
    
    public static CraftingHandler crafting()
    {
        return CraftingHandler.instance;
    }

    public static MaterialHandler materials()
    {
        return MaterialHandler.instance;
    }

    public static EventHandlers events()
    {
        return EventHandlers.instance;
    }

    public static NetworkHandler network()
    {
        return NetworkHandler.instance;
    }

    public static DimensionHandler dimensions()
    {
        return DimensionHandler.instance;
    }

    public static WorldHandler world()
    {
        return WorldHandler.instance;
    }

    public static EntityHandler entities()
    {
        return EntityHandler.instance;
    }

    public static Tab tabs()
    {
        return Tab.instance;
    }

    @SideOnly(Side.CLIENT)
    public static Renders renderers()
    {
        return Renders.instance;
    }

    @SideOnly(Side.CLIENT)
    public static KeybindHandler keybinds()
    {
        return KeybindHandler.instance;
    }

    @SideOnly(Side.CLIENT)
    public static Resources resources()
    {
        return Resources.instance;
    }

    public static GuiHandler interfaces()
    {
        return GuiHandler.instance;
    }

    public static CapabilityHandler capabilities()
    {
        return CapabilityHandler.instance;
    }

    public static PlayerModeHandler playermodehandler()
    {
        return PlayerModeHandler.instance;
    }

    public static Schematics schematics()
    {
        return Schematics.instance;
    }

    public static CommandHandler commands()
    {
        return CommandHandler.instance;
    }

    public static Settings settings()
    {
        return Settings.instance;
    }
}
