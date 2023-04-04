package org.avp.common;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienItems;
import org.avp.common.config.ModelConfig;
import org.predator.common.PredatorItems;
import org.predator.common.block.init.PredatorBlocks;
import org.weapon.common.item.init.WeaponItems;

public class AVPCreativeTabs implements IPreInitEvent
{
    public static final AVPCreativeTabs instance = new AVPCreativeTabs();

    private AVPCreativeTabs() {}
    
    public static final CreativeTabs MAIN               = new CreativeTabs("main") {
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
    public static final CreativeTabs BLOCKS             = new CreativeTabs("blocks") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(Game.instance.getItem(PredatorBlocks.SHIP_DECOR_2));
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
                                                                return new ItemStack(AlienItems.SUMMONER_FACEHUGGER);
                                                            }

                                                            public String getTranslationKey()
                                                            {
                                                                return "Mobs";
                                                            }
                                                        };
    public static CreativeTabs ENTITIES_WIP;
    public static final CreativeTabs GUN_PARTS      = new CreativeTabs("gunparts") {
                                                            @Override
                                                            public ItemStack createIcon()
                                                            {
                                                                return new ItemStack(WeaponItems.ITEM_M56SG_STOCK);
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
        if (ModelConfig.getInstance().getGeneral().experimentalFeatures)
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
