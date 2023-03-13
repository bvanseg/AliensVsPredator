package org.lib;

import com.asx.mdx.lib.client.Renderers;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.AVP;
import org.avp.common.Tab;

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
            if (!AVP.settings().areExperimentalFeaturesEnabled()) {
                return;
            } else {
                item.setCreativeTab(Tab.ENTITIES_WIP);
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
