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
public final class AVPWeaponItems implements AVPRegistry {
    private static final AVPWeaponItems INSTANCE = new AVPWeaponItems();

    public static AVPWeaponItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> WEAPON_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    public static final RegistryObject<Item> WEAPON_88MOD4_COMBAT_PISTOL = registerItem("weapon_88mod4_combat_pistol");
    public static final RegistryObject<Item> WEAPON_AK_47 = registerItem("weapon_ak_47");
    public static final RegistryObject<Item> WEAPON_M4_CARBINE = registerItem("weapon_m4_carbine");
    public static final RegistryObject<Item> WEAPON_M41A_PULSE_RIFLE = registerItem("weapon_m41a_pulse_rifle");
    public static final RegistryObject<Item> WEAPON_M56_SMARTGUN = registerItem("weapon_m56_smartgun");
    public static final RegistryObject<Item> WEAPON_SNIPER_RIFLE = registerItem("weapon_sniper_rifle");

    private static RegistryObject<Item> registerItem(String name) {
        return WEAPON_ITEMS.register(name, () -> new WeaponItem(new Item.Properties().group(AVPItemGroups.WEAPON_ITEM_GROUP)));
    }

    @Override
    public void register() {
        WEAPON_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
