package org.avp.common.creative_tab;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;

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

    private GameObject<CreativeModeTab> registerCreativeModeTab(
        String registryName,
        Supplier<CreativeModeTab.Builder> creativeModeTabBuilderSupplier
    ) {
        var name = String.format("tab.%s.%s", AVPConstants.MOD_ID, registryName);
        return Services.CREATIVE_MODE_TAB_REGISTRY.register(
            name,
            () -> creativeModeTabBuilderSupplier.get()
                .title(Component.translatable(name))
                .build()
        );
    }

    @Override
    public void register() {
        registerCreativeModeTab(
            "armor",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 0)
                .icon(AVPArmorItems.getInstance().CELTIC_HELMET.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPArmorItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );

        registerCreativeModeTab(
            "blocks",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 1)
                .icon(AVPTempleBlocks.getInstance().TEMPLE_BRICK.get().asItem()::getDefaultInstance)
                .displayItems((itemDisplayParameters, output) -> {
                    output.acceptAll(
                        AVPEngineerBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                    output.acceptAll(
                        AVPIndustrialBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                    output.acceptAll(
                        AVPOreBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                    output.acceptAll(
                        AVPPaddingBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                    output.acceptAll(
                        AVPTempleBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                    output.acceptAll(
                        AVPYautjaShipBlocks.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Block::asItem)
                            .map(Item::getDefaultInstance)
                            .toList()
                    );
                })
        );

        registerCreativeModeTab(
            "food",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 2)
                .icon(AVPFoodItems.getInstance().DORITOS.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPFoodItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );

        registerCreativeModeTab(
            "electronics",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 3)
                .icon(AVPElectronicItems.getInstance().CPU.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPElectronicItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );

        registerCreativeModeTab(
            "entities",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 4)
                .icon(Items.EGG::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPSpawnEggItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );

        registerCreativeModeTab(
            "items",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.TOP, 5)
                .icon(AVPItems.getInstance().ROYAL_JELLY.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );

        registerCreativeModeTab(
            "weapons",
            () -> CreativeModeTab.builder(CreativeModeTab.Row.BOTTOM, 0)
                .icon(AVPWeaponItems.getInstance().AMMO_SMG.get()::getDefaultInstance)
                .displayItems(
                    (itemDisplayParameters, output) -> output.acceptAll(
                        AVPWeaponItems.getInstance().ENTRIES.stream()
                            .map(GameObject::get)
                            .map(Item::getDefaultInstance)
                            .toList()
                    )
                )
        );
    }
}
