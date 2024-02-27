package org.avp.common.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import org.avp.AVPConstants;
import org.avp.AVPItemGroups;
import org.avp.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public final class AVPElectronicItems implements AVPRegistry {

    private static final AVPElectronicItems INSTANCE = new AVPElectronicItems();

    public static AVPElectronicItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> ELECTRONIC_ITEMS = new DeferredRegister<>(
        ForgeRegistries.ITEMS,
        AVPConstants.MOD_ID
    );

    private static final RegistryObject<Item> CAPACITOR = registerItem("capacitor");

    public static final RegistryObject<Item> CPU = registerItem("cpu");

    private static final RegistryObject<Item> DIODE = registerItem("diode");

    private static final RegistryObject<Item> INTEGRATED_CIRCUIT = registerItem("integrated_circuit");

    private static final RegistryObject<Item> LED = registerItem("led");

    private static final RegistryObject<Item> LED_DISPLAY = registerItem("led_display");

    private static final RegistryObject<Item> MOTHERBOARD = registerItem("motherboard");

    private static final RegistryObject<Item> POWER_SUPPLY = registerItem("power_supply");

    private static final RegistryObject<Item> RAM = registerItem("ram");

    private static final RegistryObject<Item> REGULATOR = registerItem("regulator");

    private static final RegistryObject<Item> RESISTOR = registerItem("resistor");

    private static final RegistryObject<Item> SSD = registerItem("ssd");

    private static final RegistryObject<Item> TRANSISTOR = registerItem("transistor");

    private static RegistryObject<Item> registerItem(String name) {
        return ELECTRONIC_ITEMS.register(
            name,
            () -> new Item(new Item.Properties().group(AVPItemGroups.ELECTRONICS_ITEM_GROUP))
        );
    }

    @Override
    public void register() {
        ELECTRONIC_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
