/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2018 ASX **/
package org.avp;

import org.apache.logging.log4j.Logger;
import org.avp.client.KeybindHandler;
import org.avp.client.Renders;
import org.avp.client.Resources;
import org.avp.client.Sounds;
import org.avp.world.CapabilityHandler;
import org.avp.world.hives.HiveHandler;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IMod;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.ModContainer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.event.FMLServerStoppedEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(name = AliensVsPredator.Properties.NAME, modid = AliensVsPredator.Properties.ID, dependencies = AliensVsPredator.Properties.DEPENDENCIES)
public class AliensVsPredator implements IMod
{
    public static class Properties
    {
        public static final String NAME         = "AliensVsPredator";
        public static final String ID           = "avp";
        public static final String DEPENDENCIES = "required-after:mdxlib";
        public static final String DOMAIN       = ID + ":";
    }

    @Mod.Instance(AliensVsPredator.Properties.ID)
    private static AliensVsPredator instance;

    private static BlockHandler     blocks;
    private static ItemHandler      items;

    @Override
    public ModContainer container()
    {
        return Game.getModContainer(AliensVsPredator.Properties.ID);
    }

    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
        console().pre(event);
        settings().pre(event);
        tabs().pre(event);
        capabilities().pre(event);
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
        crafting().init(event);
        interfaces().init(event);
        events().init(event);
        commands().init(event);
        playermodehandler().init(event);
        schematics().init(event);
        entities().init(event);
    }

    @SideOnly(Side.CLIENT)
    @Mod.EventHandler
    public void initClient(FMLInitializationEvent event)
    {
        renderers().init(event);
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

    @EventHandler
    public void onServerStopped(FMLServerStoppedEvent event)
    {
        HiveHandler.instance.clearCaches();
    }

    public static AliensVsPredator instance()
    {
        return AliensVsPredator.instance;
    }

    public static Console console()
    {
        return Console.instance;
    }

    public static Logger log()
    {
        return Console.logger;
    }
    
    public static ItemHandler items()
    {
        return items == null ? items = new ItemHandler() : items;
    }

    public static BlockHandler blocks()
    {
        return blocks == null ? blocks = new BlockHandler() : blocks;
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

    public static Sounds sounds()
    {
        return Sounds.instance;
    }

    public static GuiHandler interfaces()
    {
        return GuiHandler.instance;
    }

    public static CraftingHandler crafting()
    {
        return CraftingHandler.instance;
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

    public static CreativeTab tabs()
    {
        return CreativeTab.instance;
    }
}
