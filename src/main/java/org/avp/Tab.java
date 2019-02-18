package org.avp;

import com.asx.mdx.lib.util.Game;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tab
{
    public static final CreativeTabs MAIN               = new CreativeTabs("main") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.helmTitanium);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Main";
                                                            }
                                                        };
    public static final CreativeTabs BLOCKS             = new CreativeTabs("blocks") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(Game.getItem(BlockHandler.ship5));
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Blocks";
                                                            }
                                                        };
    public static final CreativeTabs ENTITIES           = new CreativeTabs("summoners") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.summonerFacehugger);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Mobs";
                                                            }
                                                        };
    public static final CreativeTabs ENTITIES_WIP = new CreativeTabs("summoners_wip") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.summonerBabyhead);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Mobs (Incomplete)";
                                                            }
                                                        };
    public static final CreativeTabs GUN_PARTS      = new CreativeTabs("gunparts") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.itemM56SGStock);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Gun Parts";
                                                            }
                                                        };
    public static final CreativeTabs CRAFTING        = new CreativeTabs("crafting") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.itemLedDisplay);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Crafting";
                                                            }
                                                        };
}
