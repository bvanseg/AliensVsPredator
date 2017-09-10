package org.avp;

import com.arisux.mdx.lib.game.Game;
import com.arisux.mdx.lib.game.IPreInitEvent;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CreativeTab implements IPreInitEvent
{
    public static CreativeTab instance = new CreativeTab();

    public CreativeTabs       tabMain;
    public CreativeTabs       tabBlocks;
    public CreativeTabs       tabEntities;
    public CreativeTabs       tabEntitiesIncomplete;
    public CreativeTabs       tabGunParts;
    public CreativeTabs       tabRecipeItems;

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
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

        tabBlocks = new CreativeTabs("blocks") {
            @Override
            public Item getTabIconItem()
            {
                return Game.getItem(AliensVsPredator.blocks().engineercolumn1);
            }

            public String getTranslatedTabLabel()
            {
                return "Blocks";
            }
        };

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
