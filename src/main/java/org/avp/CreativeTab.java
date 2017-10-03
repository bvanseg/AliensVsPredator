package org.avp;

import com.arisux.mdx.lib.game.Game;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
    public static final CreativeTabs tabMain               = new CreativeTabs("main") {
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
    public static final CreativeTabs tabBlocks             = new CreativeTabs("blocks") {
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
    public static final CreativeTabs tabEntities           = new CreativeTabs("summoners") {
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
    public static final CreativeTabs tabEntitiesIncomplete = new CreativeTabs("summoners_wip") {
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
    public static final CreativeTabs tabGunParts           = new CreativeTabs("gunparts") {
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
    public static final CreativeTabs tabRecipeItems        = new CreativeTabs("recipeitems") {
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
