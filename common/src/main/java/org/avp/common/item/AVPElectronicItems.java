package org.avp.common.item;

import net.minecraft.world.item.Item;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPElectronicItems implements AVPRegistry {

    private static final AVPElectronicItems INSTANCE = new AVPElectronicItems();

    public static AVPElectronicItems getInstance() {
        return INSTANCE;
    }

    private AVPElectronicItems() {}

    @Override
    public void register() {
        Services.ITEM_REGISTRY.register("capacitor", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("cpu", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("diode", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("integrated_circuit", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("led", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("led_display", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("motherboard", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("power_supply", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ram", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("regulator", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("resistor", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ssd", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("transistor", () -> new Item(new Item.Properties()));
    }
}
