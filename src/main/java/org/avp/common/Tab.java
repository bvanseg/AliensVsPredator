package org.avp.common;

import com.asx.mdx.core.mods.IPreInitEvent;
import com.asx.mdx.lib.util.Game;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AliensVsPredator;

public class Tab implements IPreInitEvent
{
    public static Tab instance = new Tab();
    
    public static CreativeTabs MAIN               = new CreativeTabs("main") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(ItemHandler.biomaskCeltic);
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
                                                                return new ItemStack(Game.getItem(AVPBlocks.SHIP_5));
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
                                                                return new ItemStack(ItemHandler.summonerFacehugger);
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
                                                                return new ItemStack(ItemHandler.itemM56SGStock);
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
                                                                return new ItemStack(ItemHandler.itemLedDisplay);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Crafting";
                                                            }
                                                        };
                                                        
    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        if (AliensVsPredator.settings().areExperimentalFeaturesEnabled())
        {
            ENTITIES_WIP = new CreativeTabs("summoners_wip") {
                @Override
                public ItemStack createIcon()
                {
                    return new ItemStack(ItemHandler.Experimental.summonerBabyhead);
                }

                public String getTranslationKey()
                {
                    return "Mobs (Incomplete)";
                }
            };
        }
    }
}
