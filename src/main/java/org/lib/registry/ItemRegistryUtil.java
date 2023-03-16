package org.lib.registry;

import com.asx.mdx.client.render.Renderers;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.AVPSettings;

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
            if (!AVPSettings.instance.areExperimentalFeaturesEnabled()) {
                return;
            } else {
                item.setCreativeTab(AVPCreativeTabs.ENTITIES_WIP);
            }
        }

        item.setTranslationKey(item.getRegistryName().getNamespace() + ":" + item.getRegistryName().getPath());
        ForgeRegistries.ITEMS.register(item);

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            Renderers.registerIcon(item);
        }
    }
}
