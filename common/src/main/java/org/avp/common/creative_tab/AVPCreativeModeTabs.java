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
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPCreativeModeTabs implements AVPRegistry {

    private static final AVPCreativeModeTabs INSTANCE = new AVPCreativeModeTabs();

    public static AVPCreativeModeTabs getInstance() {
        return INSTANCE;
    }

    private void registerCreativeModeTab(
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

    private Collection<ItemStack> itemsToItemStacks(List<GameObject<Item>> gameObjectList) {
        return gameObjectList.stream()
            .map(GameObject::get)
            .map(Item::getDefaultInstance)
            .toList();
    }

    private Collection<ItemStack> blocksToItemStacks(List<GameObject<Block>> gameObjectList) {
        return gameObjectList.stream()
            .map(GameObject::get)
            .map(Block::asItem)
            .map(Item::getDefaultInstance)
            .toList();
    }

    @Override
    public void register() {
        registerCreativeModeTab(
            "armor",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .icon(AVPArmorItems.getInstance().CELTIC_HELMET.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPArmorItems.getInstance().ENTRIES)
                    )
                )
        );

        registerCreativeModeTab(
            "blocks",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                .icon(AVPTempleBlocks.getInstance().TEMPLE_BRICK.get().asItem()::getDefaultInstance)
                .displayItems((itemDisplayParameters, output) -> {
                    output.acceptAll(blocksToItemStacks(AVPBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPEngineerBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPIndustrialBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPOreBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPPaddingBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPParadiseBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPTempleBlocks.getInstance().ENTRIES));
                    output.acceptAll(blocksToItemStacks(AVPYautjaShipBlocks.getInstance().ENTRIES));
                })
        );

        registerCreativeModeTab(
            "food",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
                .icon(AVPFoodItems.getInstance().DORITOS.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPFoodItems.getInstance().ENTRIES)
                    )
                )
        );

        registerCreativeModeTab(
            "electronics",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 3)
                .icon(AVPElectronicItems.getInstance().CPU.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPElectronicItems.getInstance().ENTRIES)
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
                .icon(AVPItems.getInstance().ROYAL_JELLY.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPItems.getInstance().ENTRIES)
                    )
                )
        );

        registerCreativeModeTab(
            "tools",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 0)
                .icon(AVPToolItems.getInstance().CELTIC_PICKAXE.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPToolItems.getInstance().ENTRIES)
                    )
                )
        );

        registerCreativeModeTab(
            "weapons",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 1)
                .icon(AVPWeaponItems.getInstance().AMMO_SMG.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        itemsToItemStacks(AVPWeaponItems.getInstance().ENTRIES)
                    )
                )
        );
    }
}
