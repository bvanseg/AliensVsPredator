package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPElectronicItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPElectronicItems INSTANCE = new AVPElectronicItems();

    public static AVPElectronicItems getInstance() {
        return INSTANCE;
    }

    public final GameObject<Item> CPU = registerEntry("cpu", () -> new Item(new Item.Properties()));

    private AVPElectronicItems() {}

    @Override
    public void register() {
        registerEntry("capacitor", () -> new Item(new Item.Properties()));
        registerEntry("diode", () -> new Item(new Item.Properties()));
        registerEntry("integrated_circuit", () -> new Item(new Item.Properties()));
        registerEntry("led", () -> new Item(new Item.Properties()));
        registerEntry("led_display", () -> new Item(new Item.Properties()));
        registerEntry("motherboard", () -> new Item(new Item.Properties()));
        registerEntry("power_supply", () -> new Item(new Item.Properties()));
        registerEntry("ram", () -> new Item(new Item.Properties()));
        registerEntry("regulator", () -> new Item(new Item.Properties()));
        registerEntry("resistor", () -> new Item(new Item.Properties()));
        registerEntry("ssd", () -> new Item(new Item.Properties()));
        registerEntry("transistor", () -> new Item(new Item.Properties()));
    }
}
