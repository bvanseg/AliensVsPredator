package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPWeaponItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPWeaponItems INSTANCE = new AVPWeaponItems();

    public static AVPWeaponItems getInstance() {
        return INSTANCE;
    }

    public final GameObject<Item> AMMO_SMG = registerEntry("ammo_smg", () -> new Item(new Item.Properties()));

    private AVPWeaponItems() {}

    @Override
    public void register() {
        registerEntry("ammo_ar", () -> new Item(new Item.Properties()));
        registerEntry("ammo_charge_pack", () -> new Item(new Item.Properties()));
        registerEntry("ammo_flamethrower", () -> new Item(new Item.Properties()));
        registerEntry("ammo_pistol", () -> new Item(new Item.Properties()));
        registerEntry("ammo_sniper", () -> new Item(new Item.Properties()));

        registerEntry("grenade_incendiary", () -> new Item(new Item.Properties()));
        registerEntry("grenade_m40", () -> new Item(new Item.Properties()));

        registerEntry("weapon_88mod4_combat_pistol", () -> new Item(new Item.Properties()));
        registerEntry("weapon_ak_47", () -> new Item(new Item.Properties()));
        registerEntry("weapon_m4_carbine", () -> new Item(new Item.Properties()));
        registerEntry("weapon_m41a_pulse_rifle", () -> new Item(new Item.Properties()));
        registerEntry("weapon_m56_smartgun", () -> new Item(new Item.Properties()));
        registerEntry("weapon_sniper_rifle", () -> new Item(new Item.Properties()));
    }
}
