package org.avp;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IPreInitEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTab implements IPreInitEvent
{
    public static final CreativeTab instance = new CreativeTab();

    public CreativeTabs             main;
    public CreativeTabs             blocks;
    public CreativeTabs             entities;
    public CreativeTabs             entitiesIncomplete;
    public CreativeTabs             gunComponents;
    public CreativeTabs             recipeItems;

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        main = new CreativeTabs("main") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(AliensVsPredator.items().helmTitanium);
            }

            public String getTranslatedTabLabel()
            {
                return "Main";
            }
        };
        blocks = new CreativeTabs("blocks") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(Game.getItem(AliensVsPredator.blocks().ship5));
            }

            public String getTranslatedTabLabel()
            {
                return "Blocks";
            }
        };
        entities = new CreativeTabs("summoners") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(AliensVsPredator.items().summonerFacehugger);
            }

            public String getTranslatedTabLabel()
            {
                return "Mobs";
            }
        };
        entitiesIncomplete = new CreativeTabs("summoners_wip") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(AliensVsPredator.items().summonerBabyhead);
            }

            public String getTranslatedTabLabel()
            {
                return "Mobs (Incomplete)";
            }
        };
        gunComponents = new CreativeTabs("gunparts") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(AliensVsPredator.items().itemM56SGStock);
            }

            public String getTranslatedTabLabel()
            {
                return "Gun Components";
            }
        };
        recipeItems = new CreativeTabs("recipeitems") {
            @Override
            public ItemStack createIcon()
            {
                return new ItemStack(AliensVsPredator.items().itemLedDisplay);
            }

            public String getTranslatedTabLabel()
            {
                return "Recipe Items";
            }
        };
    }
}
