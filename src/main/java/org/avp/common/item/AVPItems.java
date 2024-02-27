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
public final class AVPItems implements AVPRegistry {

    private static final AVPItems INSTANCE = new AVPItems();

    public static AVPItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(
        ForgeRegistries.ITEMS,
        AVPConstants.MOD_ID
    );

    private static final RegistryObject<Item> AMMO_AR = registerItem("ammo_ar");

    private static final RegistryObject<Item> AMMO_FLAMETHROWER = registerItem("ammo_flamethrower");

    private static final RegistryObject<Item> AMMO_PISTOL = registerItem("ammo_pistol");

    private static final RegistryObject<Item> AMMO_SMG = registerItem("ammo_smg");

    private static final RegistryObject<Item> AMMO_SNIPER = registerItem("ammo_sniper");

    public static final RegistryObject<Item> ROYAL_JELLY = registerItem("royal_jelly");

    private static final RegistryObject<Item> SILICA = registerItem("silica");

    private static RegistryObject<Item> registerItem(String name) {
        return ITEMS.register(
            name,
            () -> new Item(new Item.Properties().group(AVPItemGroups.MISCELLANEOUS_ITEM_GROUP))
        );
    }

    @Override
    public void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
