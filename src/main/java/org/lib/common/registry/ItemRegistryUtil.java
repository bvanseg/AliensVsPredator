package org.lib.common.registry;

import com.asx.mdx.client.render.Renderers;
import net.minecraft.item.Item;
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

    public static void registerItemIcon(Item item) {
        if (FMLCommonHandler.instance().getSide() != Side.CLIENT) return;

        Renderers.registerIcon(item);
    }

    public static void registerItemWithIcon(Item item) {
        registerItem(item);
        registerItemIcon(item);
    }
}
