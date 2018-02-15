package org.avp;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IInitEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class CreativeTab implements IInitEvent
{
    public static final CreativeTab instance = new CreativeTab();

    public CreativeTabs             tabMain;
    public CreativeTabs             tabBlocks;
    public CreativeTabs             tabEntities;
    public CreativeTabs             tabEntitiesIncomplete;
    public CreativeTabs             tabGunParts;
    public CreativeTabs             tabRecipeItems;

    @Override
    public void init(FMLInitializationEvent event)
    {
        tabMain = new CreativeTabs("main") {
            @Override
            public Item getTabIconItem()
            {
                return AliensVsPredator.items().helmTitanium;
            }

            public String getTranslatedTabLabel()
            {
                return "Main";
            }
        };
        tabBlocks = new CreativeTabs("blocks") {
            @Override
            public Item getTabIconItem()
            {
                return Game.getItem(AliensVsPredator.blocks().ship5);
            }

            public String getTranslatedTabLabel()
            {
                return "Blocks";
            }
        };
        tabEntities = new CreativeTabs("summoners") {
            @Override
            public Item getTabIconItem()
            {
                return AliensVsPredator.items().summonerFacehugger;
            }

            public String getTranslatedTabLabel()
            {
                return "Mobs";
            }
        };
        tabEntitiesIncomplete = new CreativeTabs("summoners_wip") {
            @Override
            public Item getTabIconItem()
            {
                return AliensVsPredator.items().summonerBabyhead;
            }

            public String getTranslatedTabLabel()
            {
                return "Mobs (Incomplete)";
            }
        };
        tabGunParts = new CreativeTabs("gunparts") {
            @Override
            public Item getTabIconItem()
            {
                return AliensVsPredator.items().itemM56SGStock;
            }

            public String getTranslatedTabLabel()
            {
                return "Gun Components";
            }
        };
        tabRecipeItems = new CreativeTabs("recipeitems") {
            @Override
            public Item getTabIconItem()
            {
                return AliensVsPredator.items().itemLedDisplay;
            }

            public String getTranslatedTabLabel()
            {
                return "Recipe Items";
            }
        };
    }
}
