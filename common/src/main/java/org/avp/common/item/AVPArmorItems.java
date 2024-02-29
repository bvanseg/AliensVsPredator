package org.avp.common.item;

import net.minecraft.world.item.Item;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPArmorItems implements AVPRegistry {

    private static final AVPArmorItems INSTANCE = new AVPArmorItems();

    public static AVPArmorItems getInstance() {
        return INSTANCE;
    }

    private AVPArmorItems() {}

    @Override
    public void register() {
        Services.ITEM_REGISTRY.register("armor_celtic_body", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_celtic_boots", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_celtic_helmet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_celtic_leggings", () -> new Item(new Item.Properties()));

        Services.ITEM_REGISTRY.register("armor_mk50_body", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_mk50_boots", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_mk50_helmet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_mk50_leggings", () -> new Item(new Item.Properties()));

        Services.ITEM_REGISTRY.register("armor_pressure_body", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_pressure_boots", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_pressure_helmet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_pressure_leggings", () -> new Item(new Item.Properties()));

        Services.ITEM_REGISTRY.register("armor_tactical_body", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_tactical_boots", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_tactical_helmet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_tactical_leggings", () -> new Item(new Item.Properties()));

        Services.ITEM_REGISTRY.register("armor_xeno_body", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_xeno_boots", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_xeno_helmet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("armor_xeno_leggings", () -> new Item(new Item.Properties()));


    }
}
