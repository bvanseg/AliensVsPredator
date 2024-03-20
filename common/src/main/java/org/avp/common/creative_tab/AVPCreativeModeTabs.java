package org.avp.common.creative_tab;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;

import org.avp.common.AVPConstants;
import org.avp.common.block.*;
import org.avp.common.item.*;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public final class AVPCreativeModeTabs {

    private static void registerCreativeModeTab(
        String registryName,
        Supplier<CreativeModeTab.Builder> creativeModeTabBuilderSupplier
    ) {
        var name = String.format("tab.%s.%s", AVPConstants.MOD_ID, registryName);
        Services.CREATIVE_MODE_TAB_REGISTRY.register(
            name,
            () -> creativeModeTabBuilderSupplier.get()
                .title(Component.translatable(name))
                .build()
        );
    }

    private static Collection<ItemStack> itemsToItemStacks(List<GameObject<Item>> gameObjectList) {
        return gameObjectList.stream()
            .map(GameObject::get)
            .map(Item::getDefaultInstance)
            .toList();
    }

    private static Collection<ItemStack> blocksToItemStacks(List<GameObject<Block>> gameObjectList) {
        return gameObjectList.stream()
            .map(GameObject::get)
            .map(Block::asItem)
            .map(Item::getDefaultInstance)
            .toList();
    }

    public static void register() {
        registerCreativeModeTab(
            "armor",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .icon(AVPArmorItems.CELTIC_HELMET.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPArmorItems.getEntries())
                    )
                )
        );

        registerCreativeModeTab(
            "blocks",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                .icon(AVPTempleBlocks.TEMPLE_BRICK.get().asItem()::getDefaultInstance)
                .displayItems((itemDisplayParameters, output) -> {
                    output.acceptAll(blocksToItemStacks(AVPBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPEngineerBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPIndustrialBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPOreBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPPaddingBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPParadiseBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPTempleBlocks.getEntries()));
                    output.acceptAll(blocksToItemStacks(AVPYautjaShipBlocks.getEntries()));
                })
        );

        registerCreativeModeTab(
            "food",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
                .icon(AVPFoodItems.DORITOS.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPFoodItems.getEntries())
                    )
                )
        );

        registerCreativeModeTab(
            "electronics",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 3)
                .icon(AVPElectronicItems.CPU.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPElectronicItems.getEntries())
                    )
                )
        );

        registerCreativeModeTab(
            "entities",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 4)
                .icon(Items.EGG::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPSpawnEggItems.getInstance().ENTRIES)
                    )
                )
        );

        registerCreativeModeTab(
            "items",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 5)
                .icon(AVPItems.ROYAL_JELLY.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPItems.getEntries())
                    )
                )
        );

        registerCreativeModeTab(
            "tools",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 0)
                .icon(AVPToolItems.CELTIC_PICKAXE.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPToolItems.getEntries())
                    )
                )
        );

        registerCreativeModeTab(
            "weapons",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 1)
                .icon(AVPWeaponItems.AMMO_SMG.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPWeaponItems.getEntries())
                    )
                )
        );
    }

    private AVPCreativeModeTabs() {
        throw new UnsupportedOperationException();
    }
}
