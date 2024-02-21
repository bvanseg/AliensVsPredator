package org.avp;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Boston Vanseghi
 */
public final class AVPArmorItems implements AVPRegistry {
    private static final AVPArmorItems INSTANCE = new AVPArmorItems();

    public static AVPArmorItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> ARMOR_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    public static final RegistryObject<Item> CELTIC_BODY = registerItem("armor_celtic_body");
    public static final RegistryObject<Item> CELTIC_BOOTS = registerItem("armor_celtic_boots");
    public static final RegistryObject<Item> CELTIC_HELMET = registerItem("armor_celtic_helmet");
    public static final RegistryObject<Item> CELTIC_LEGGINGS = registerItem("armor_celtic_leggings");

    public static final RegistryObject<Item> MK50_BODY = registerItem("armor_mk50_body");
    public static final RegistryObject<Item> MK50_BOOTS = registerItem("armor_mk50_boots");
    public static final RegistryObject<Item> MK50_HELMET = registerItem("armor_mk50_helmet");
    public static final RegistryObject<Item> MK50_LEGGINGS = registerItem("armor_mk50_leggings");

    public static final RegistryObject<Item> PRESSURE_BODY = registerItem("armor_pressure_body");
    public static final RegistryObject<Item> PRESSURE_BOOTS = registerItem("armor_pressure_boots");
    public static final RegistryObject<Item> PRESSURE_HELMET = registerItem("armor_pressure_helmet");
    public static final RegistryObject<Item> PRESSURE_LEGGINGS = registerItem("armor_pressure_leggings");

    public static final RegistryObject<Item> TACTICAL_BODY = registerItem("armor_tactical_body");
    public static final RegistryObject<Item> TACTICAL_BOOTS = registerItem("armor_tactical_boots");
    public static final RegistryObject<Item> TACTICAL_HELMET = registerItem("armor_tactical_helmet");
    public static final RegistryObject<Item> TACTICAL_LEGGINGS = registerItem("armor_tactical_leggings");

    public static final RegistryObject<Item> XENO_BODY = registerItem("armor_xeno_body");
    public static final RegistryObject<Item> XENO_BOOTS = registerItem("armor_xeno_boots");
    public static final RegistryObject<Item> XENO_HELMET = registerItem("armor_xeno_helmet");
    public static final RegistryObject<Item> XENO_LEGGINGS = registerItem("armor_xeno_leggings");

    private static RegistryObject<Item> registerItem(String name) {
        // TODO: Use ArmorItem here.
        return ARMOR_ITEMS.register(name, () -> new Item(new Item.Properties().group(AVPItemGroups.ARMOR_ITEM_GROUP)));
    }

    @Override
    public void register() {
        ARMOR_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
