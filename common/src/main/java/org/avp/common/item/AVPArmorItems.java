package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPArmorItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPArmorItems INSTANCE = new AVPArmorItems();

    public static AVPArmorItems getInstance() {
        return INSTANCE;
    }

    public final GameObject<Item> CELTIC_HELMET = registerEntry(
        "armor_celtic_helmet",
        () -> new Item(new Item.Properties())
    );

    private AVPArmorItems() {}

    @Override
    public void register() {
        registerEntry("armor_celtic_body", () -> new Item(new Item.Properties()));
        registerEntry("armor_celtic_boots", () -> new Item(new Item.Properties()));
        registerEntry("armor_celtic_leggings", () -> new Item(new Item.Properties()));

        registerEntry("armor_mk50_body", () -> new Item(new Item.Properties()));
        registerEntry("armor_mk50_boots", () -> new Item(new Item.Properties()));
        registerEntry("armor_mk50_helmet", () -> new Item(new Item.Properties()));
        registerEntry("armor_mk50_leggings", () -> new Item(new Item.Properties()));

        registerEntry("armor_pressure_body", () -> new Item(new Item.Properties()));
        registerEntry("armor_pressure_boots", () -> new Item(new Item.Properties()));
        registerEntry("armor_pressure_helmet", () -> new Item(new Item.Properties()));
        registerEntry("armor_pressure_leggings", () -> new Item(new Item.Properties()));

        registerEntry("armor_tactical_body", () -> new Item(new Item.Properties()));
        registerEntry("armor_tactical_boots", () -> new Item(new Item.Properties()));
        registerEntry("armor_tactical_helmet", () -> new Item(new Item.Properties()));
        registerEntry("armor_tactical_leggings", () -> new Item(new Item.Properties()));

        registerEntry("armor_xeno_body", () -> new Item(new Item.Properties()));
        registerEntry("armor_xeno_boots", () -> new Item(new Item.Properties()));
        registerEntry("armor_xeno_helmet", () -> new Item(new Item.Properties()));
        registerEntry("armor_xeno_leggings", () -> new Item(new Item.Properties()));
    }
}
