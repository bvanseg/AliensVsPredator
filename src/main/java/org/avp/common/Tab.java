package org.avp.common;

import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.util.Game;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienItems;
import org.avp.AVP;
import org.predator.common.PredatorBlocks;
import org.predator.common.PredatorItems;

public class Tab implements IPreInitEvent
{
    public static Tab instance = new Tab();
    
    public static CreativeTabs MAIN               = new CreativeTabs("main") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(PredatorItems.BIOMASK_CELTIC);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Main";
                                                            }
                                                        };
    public static CreativeTabs BLOCKS             = new CreativeTabs("blocks") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(Game.getItem(PredatorBlocks.SHIP_5));
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Blocks";
                                                            }
                                                        };
    public static CreativeTabs ENTITIES           = new CreativeTabs("summoners") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(AlienItems.SUMMONER_FACEHUGGER);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Mobs";
                                                            }
                                                        };
    public static CreativeTabs ENTITIES_WIP;
    public static CreativeTabs GUN_PARTS      = new CreativeTabs("gunparts") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(AVPItems.ITEM_M56SG_STOCK);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Gun Parts";
                                                            }
                                                        };
    public static CreativeTabs CRAFTING        = new CreativeTabs("crafting") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(AVPItems.ITEM_LED_DISPLAY);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Crafting";
                                                            }
                                                        };
                                                        
    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        if (AVP.settings().areExperimentalFeaturesEnabled())
        {
            ENTITIES_WIP = new CreativeTabs("summoners_wip") {
                @Override
                public ItemStack createIcon()
                {
                    return new ItemStack(AlienItems.SUMMONER_BABYHEAD);
                }

                public String getTranslationKey()
                {
                    return "Mobs (Incomplete)";
                }
            };
        }
    }
}
