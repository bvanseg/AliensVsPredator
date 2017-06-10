package org.avp;

import com.arisux.mdx.lib.game.Game;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTab
{
    public static CreativeTabs tabMain        = new CreativeTabs("main")
                                              {
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
    public static CreativeTabs tabBlocks      = new CreativeTabs("blocks")
                                              {
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
    public static CreativeTabs tabEntities    = new CreativeTabs("summoners")
                                              {
                                                  @Override
                                                  public Item getTabIconItem()
                                                  {
                                                      return AliensVsPredator.items().summoners.itemSummonerFacehugger;
                                                  }

                                                  public String getTranslatedTabLabel()
                                                  {
                                                      return "Mobs";
                                                  }
                                              };
    public static CreativeTabs tabEntitiesIncomplete = new CreativeTabs("summoners_wip")
                                              {
                                                  @Override
                                                  public Item getTabIconItem()
                                                  {
                                                      return AliensVsPredator.items().summoners.itemSummonerBabyhead;
                                                  }

                                                  public String getTranslatedTabLabel()
                                                  {
                                                      return "Mobs (Incomplete)";
                                                  }
                                              };
    public static CreativeTabs tabGunParts    = new CreativeTabs("gunparts")
                                              {
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
    public static CreativeTabs tabRecipeItems = new CreativeTabs("recipeitems")
                                              {
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
