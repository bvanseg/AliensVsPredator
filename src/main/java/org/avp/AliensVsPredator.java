/** AliensVsPredator Minecraft Mod - Copyright (C) 2012-2017 Arisux Technology Group **/
package org.avp;

import org.avp.client.KeybindHandler;
import org.avp.client.Renderers;
import org.avp.client.Resources;
import org.avp.client.Sounds;
import org.avp.client.render.block.ShapedModelLoader;
import org.avp.world.CapabilityHandler;
import org.avp.world.hives.HiveHandler;

import com.arisux.mdx.MDX;
import com.arisux.mdx.MDXModule;
import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IMod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.model.ModelLoaderRegistry;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
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

@Mod(name = "AliensVsPredator", modid = AliensVsPredator.ID, dependencies = "required-after:mdxlib")
public class AliensVsPredator implements IMod
{
    public static final String      ID = "avp";

    @Mod.Instance(AliensVsPredator.ID)
    private static AliensVsPredator instance;

    private ModContainer            container;

    @Override
    public ModContainer container()
    {
        return this.container == null ? this.container = Game.getModContainer(AliensVsPredator.ID) : this.container;
    }

    @Override
    public String domain()
    {
        return container().getModId() + ":";
    }

    public static AliensVsPredator instance()
    {
        return AliensVsPredator.instance;
    }

    public static ItemHandler items()
    {
        return ItemHandler.instance;
    }

    public static BlockHandler blocks()
    {
        return BlockHandler.instance;
    }

    public static OreDictionarySupport ores()
    {
        return OreDictionarySupport.instance;
    }

    public static FluidHandler fluids()
    {
        return FluidHandler.instance;
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

//    public static RenderTypes renderTypes()
//    {
//        return RenderTypes.instance;
//    }

    @SideOnly(Side.CLIENT)
    public static Renderers renderers()
    {
        return Renderers.instance;
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

    public static Properties properties()
    {
        return Properties.instance;
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

    public static CreativeTabs tabMain()
    {
        return CreativeTab.tabMain;
    }

    public static CreativeTabs tabBlocks()
    {
        return CreativeTab.tabBlocks;
    }

    public static CreativeTabs tabEntitiesIncomplete()
    {
        return CreativeTab.tabEntitiesIncomplete;
    }

    public static CreativeTabs tabEntities()
    {
        return CreativeTab.tabEntities;
    }

    public static CreativeTabs tabGunComponents()
    {
        return CreativeTab.tabGunParts;
    }

    public static CreativeTabs tabRecipeItems()
    {
        return CreativeTab.tabRecipeItems;
    }
    
    @Override
    @Mod.EventHandler
    public void pre(FMLPreInitializationEvent event)
    {
        if (!MDXModule.enable)
        {
            return;
        }

        MDX.log().info("[AliensVsPredator] Copyright(C) 2012-2017 ASX");
        MDX.log().info("[AliensVsPredator] Pre-Initialization");

        settings().pre(event);
        fluids().pre(event);
        items().pre(event);
        capabilities().pre(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            OBJLoader.INSTANCE.addDomain(AliensVsPredator.ID);
            ModelLoaderRegistry.registerLoader(new ShapedModelLoader());
            sounds().pre(event);
//            renderTypes().pre(event);
        }
    }

    @Override
    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        if (!MDXModule.enable)
        {
            return;
        }

        MDX.log().info("[AliensVsPredator] Initialization");

        network().init(event);
        dimensions().init(event);
        materials().init(event);
        items().init(event);
        blocks().init(event);
        ores().init(event);
        world().init(event);
        crafting().init(event);
        interfaces().init(event);
        events().init(event);
        commands().init(event);
        playermodehandler().init(event);
        schematics().init(event);
        entities().init(event);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            renderers().init(event);
        }
    }

    @Override
    @Mod.EventHandler
    public void post(FMLPostInitializationEvent event)
    {
        if (!MDXModule.enable)
        {
            return;
        }

        MDX.log().info("[AliensVsPredator] Post-Initialization");

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            keybinds().post(event);
        }
    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent event)
    {
        if (!MDXModule.enable)
        {
            return;
        }

        commands().onServerStarting(event);
    }

    @EventHandler
    public void onServerStopped(FMLServerStoppedEvent event)
    {
        HiveHandler.instance.clearCaches();
    }

    public boolean isDevCopy()
    {
        return true;
    }
}
