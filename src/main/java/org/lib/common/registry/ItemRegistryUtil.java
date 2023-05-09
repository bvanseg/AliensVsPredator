package org.lib.common.registry;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.config.ModelConfig;

/**
 * @author Boston Vanseghi
 */
public class ItemRegistryUtil {

    private ItemRegistryUtil() {}

    public static void registerItem(Item item) {
        registerItem(item, false);
    }

    public static void registerItem(Item item, boolean isExperimental) {
        if (isExperimental) {
            if (!ModelConfig.getInstance().getGeneral().experimentalFeatures) {
                return;
            } else {
                item.setCreativeTab(AVPCreativeTabs.ENTITIES_WIP);
            }
        }

        item.setTranslationKey(item.getRegistryName().getNamespace() + ":" + item.getRegistryName().getPath());
        ForgeRegistries.ITEMS.register(item);
    }

    public static void registerItemModel(Item item) {
        if (FMLCommonHandler.instance().getSide() != Side.CLIENT) return;
        ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation(item.getRegistryName(), "inventory"));
    }

    public static void registerItemWithModel(Item item) {
        registerItem(item);
        registerItemModel(item);
    }
}
