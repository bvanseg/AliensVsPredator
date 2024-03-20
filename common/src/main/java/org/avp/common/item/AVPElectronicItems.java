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

    public static GameObject<Item> CAPACITOR;
    public static GameObject<Item> CPU;
    public static GameObject<Item> DIODE;
    public static GameObject<Item> INTEGRATED_CIRCUIT;
    public static GameObject<Item> LED;
    public static GameObject<Item> LED_DISPLAY;
    public static GameObject<Item> MOTHERBOARD;
    public static GameObject<Item> POWER_SUPPLY;
    public static GameObject<Item> RAM;
    public static GameObject<Item> REGULATOR;
    public static GameObject<Item> RESISTOR;
    public static GameObject<Item> SSD;
    public static GameObject<Item> TRANSISTOR;

    private AVPElectronicItems() {}

    @Override
    public void register() {
        CAPACITOR = registerEntry("capacitor", () -> new Item(new Item.Properties()));
        CPU = registerEntry("cpu", () -> new Item(new Item.Properties()));
        DIODE = registerEntry("diode", () -> new Item(new Item.Properties()));
        INTEGRATED_CIRCUIT = registerEntry("integrated_circuit", () -> new Item(new Item.Properties()));
        LED = registerEntry("led", () -> new Item(new Item.Properties()));
        LED_DISPLAY = registerEntry("led_display", () -> new Item(new Item.Properties()));
        MOTHERBOARD = registerEntry("motherboard", () -> new Item(new Item.Properties()));
        POWER_SUPPLY = registerEntry("power_supply", () -> new Item(new Item.Properties()));
        RAM = registerEntry("ram", () -> new Item(new Item.Properties()));
        REGULATOR = registerEntry("regulator", () -> new Item(new Item.Properties()));
        RESISTOR = registerEntry("resistor", () -> new Item(new Item.Properties()));
        SSD = registerEntry("ssd", () -> new Item(new Item.Properties()));
        TRANSISTOR = registerEntry("transistor", () -> new Item(new Item.Properties()));
    }
}
