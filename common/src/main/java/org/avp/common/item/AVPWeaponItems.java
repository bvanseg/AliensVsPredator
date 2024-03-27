package org.avp.common.item;

import net.minecraft.world.item.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import org.avp.common.item.impl.AK47Item;
import org.avp.common.item.impl.FlamethrowerSevastopolItem;
import org.avp.common.item.impl.M41APulseRifleItem;
import org.avp.common.item.impl.SniperRifleItem;
import org.avp.common.service.Services;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPWeaponItems {

    private static final List<GameObject<Item>> ENTRIES = new ArrayList<>();

    public static final GameObject<Item> AMMO_AR;

    public static final GameObject<Item> AMMO_SMG;

    public static final GameObject<Item> AMMO_CHARGE_PACK;

    public static final GameObject<Item> AMMO_FLAMETHROWER;

    public static final GameObject<Item> AMMO_PISTOL;

    public static final GameObject<Item> AMMO_SNIPER;

    public static final GameObject<Item> GRENADE_INCENDIARY;

    public static final GameObject<Item> GRENADE_M40;

    public static final GameObject<Item> WEAPON_88MOD4_COMBAT_PISTOL;

    public static final GameObject<Item> WEAPON_AK_47;

    public static final GameObject<Item> WEAPON_FLAMETHROWER_SEVASTOPOL;

    public static final GameObject<Item> WEAPON_M4_CARBINE;

    public static final GameObject<Item> WEAPON_M41A_PULSE_RIFLE;

    public static final GameObject<Item> WEAPON_M56_SMARTGUN;

    public static final GameObject<Item> WEAPON_SNIPER_RIFLE;

    public static void forceInitialization() {
        // This method doesn't need to do anything
    }

    public static List<GameObject<Item>> getEntries() {
        return ENTRIES;
    }

    private static GameObject<Item> register(String registryName, Supplier<Item> itemSupplier) {
        var gameObject = Services.ITEM_REGISTRY.register(registryName, itemSupplier);
        ENTRIES.add(gameObject);
        return gameObject;
    }

    private AVPWeaponItems() {}

    static {
        AMMO_AR = register("ammo_ar", () -> new Item(new Item.Properties()));
        AMMO_SMG = register("ammo_smg", () -> new Item(new Item.Properties()));
        AMMO_CHARGE_PACK = register("ammo_charge_pack", () -> new Item(new Item.Properties()));
        AMMO_FLAMETHROWER = register("ammo_flamethrower", () -> new Item(new Item.Properties()));
        AMMO_PISTOL = register("ammo_pistol", () -> new Item(new Item.Properties()));
        AMMO_SNIPER = register("ammo_sniper", () -> new Item(new Item.Properties()));

        GRENADE_INCENDIARY = register("grenade_incendiary", () -> new Item(new Item.Properties()));
        GRENADE_M40 = register("grenade_m40", () -> new Item(new Item.Properties()));

        WEAPON_88MOD4_COMBAT_PISTOL = register("weapon_88mod4_combat_pistol", () -> new Item(new Item.Properties()));
        WEAPON_AK_47 = register("weapon_ak_47", () -> new AK47Item(new Item.Properties()));
        WEAPON_FLAMETHROWER_SEVASTOPOL = register("weapon_flamethrower_sevastopol", () -> new FlamethrowerSevastopolItem(new Item.Properties()));
        WEAPON_M4_CARBINE = register("weapon_m4_carbine", () -> new Item(new Item.Properties()));
        WEAPON_M41A_PULSE_RIFLE = register("weapon_m41a_pulse_rifle", () -> new M41APulseRifleItem(new Item.Properties()));
        WEAPON_M56_SMARTGUN = register("weapon_m56_smartgun", () -> new Item(new Item.Properties()));
        WEAPON_SNIPER_RIFLE = register("weapon_sniper_rifle", () -> new SniperRifleItem(new Item.Properties()));
    }
}
