package org.avp.common;

import com.asx.mdx.common.Game;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienItems;
import org.avp.common.config.ModelConfig;
import org.avp.common.item.init.AVPItems;
import org.predator.common.PredatorItems;
import org.predator.common.block.init.PredatorBlocks;
import org.prometheus.common.PrometheusItems;
import org.weapon.common.item.init.WeaponItems;

public class AVPCreativeTabs implements IPreInitEvent {
    public static final AVPCreativeTabs instance = new AVPCreativeTabs();

    private AVPCreativeTabs() {
    }

    public static final CreativeTabs MAIN = new CreativeTabs("main") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(PredatorItems.BIOMASK_CELTIC);
        }

        @Override
        public String getTranslationKey() {
            return "AVP: Main";
        }
    };
    public static final CreativeTabs BLOCKS = new CreativeTabs("blocks") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(Game.instance.getItem(PredatorBlocks.SHIP_DECOR_2));
        }

        @Override
        public String getTranslationKey() {
            return "AVP: Blocks";
        }
    };
    public static final CreativeTabs ENTITIES = new CreativeTabs("summoners") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AlienItems.SUMMONER_FACEHUGGER);
        }

        @Override
        public String getTranslationKey() {
            return "AVP: Mobs";
        }
    };
    public static CreativeTabs ENTITIES_WIP;
    public static final CreativeTabs GUN_PARTS = new CreativeTabs("gunparts") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(WeaponItems.ITEM_M56SG_STOCK);
        }

        @Override
        public String getTranslationKey() {
            return "AVP: Gun Parts";
        }
    };
    public static final CreativeTabs CRAFTING = new CreativeTabs("crafting") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(AVPItems.ITEM_LED_DISPLAY);
        }

        @Override
        public String getTranslationKey() {
            return "AVP: Crafting";
        }
    };

    @Override
    public void pre(FMLPreInitializationEvent event) {
        if (ModelConfig.getInstance().getGeneral().experimentalFeatures) {
            ENTITIES_WIP = new CreativeTabs("summoners_wip") {
                @Override
                public ItemStack createIcon() {
                    return new ItemStack(PrometheusItems.SUMMONER_BABYHEAD);
                }

                @Override
                public String getTranslationKey() {
                    return "AVP: Mobs (Incomplete)";
                }
            };
        }
    }
}
