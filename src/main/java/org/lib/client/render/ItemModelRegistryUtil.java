package org.lib.client.render;

import com.asx.mdx.client.render.Renderers;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.relauncher.Side;
import org.apache.commons.lang3.tuple.Pair;
import org.avp.common.config.ModelConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public final class ItemModelRegistryUtil {
    private ItemModelRegistryUtil() {}

    private static final List<Pair<IItemColor, Item>> itemColorHandlers = new ArrayList<>();

    public static void registerSpawnEggModel(Item item, int baseColor, int spotColor) {
        if (FMLCommonHandler.instance().getSide() != Side.CLIENT) return;
        itemColorHandlers.add(Pair.of((stack, tintIndex) -> tintIndex == 0 ? baseColor : spotColor, item));
        ModelLoader.setCustomModelResourceLocation(item, 0 , new ModelResourceLocation("spawn_egg", "inventory"));
    }

    public static List<Pair<IItemColor, Item>> getItemColorHandlers() {
        return itemColorHandlers;
    }

    public static void registerSummonerModel(Item itemSummoner, ItemRenderer<?> itemRenderer, int baseColor, int spotColor) {
        Objects.requireNonNull(itemSummoner);
        Objects.requireNonNull(itemRenderer);

        // Whether spawn egg item renders should be used as a fallback for summoners.
        boolean shouldUseSpawnEggFallbackRender = ModelConfig.getInstance().getGraphics().spawnEggSummoners;

        if (shouldUseSpawnEggFallbackRender) {
            registerSpawnEggModel(itemSummoner, baseColor, spotColor);
            return;
        }

        Renderers.registerItemRenderer(itemSummoner, itemRenderer);
    }
}
