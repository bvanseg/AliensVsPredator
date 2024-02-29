package org.avp.common.item;

import net.minecraft.world.item.Item;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPWeaponItems implements AVPRegistry {

    private static final AVPWeaponItems INSTANCE = new AVPWeaponItems();

    public static AVPWeaponItems getInstance() {
        return INSTANCE;
    }

    private AVPWeaponItems() {}

    @Override
    public void register() {
        Services.ITEM_REGISTRY.register("ammo_ar", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ammo_flamethrower", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ammo_pistol", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ammo_smg", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ammo_sniper", () -> new Item(new Item.Properties()));

        Services.ITEM_REGISTRY.register("weapon_88mod4_combat_pistol", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("weapon_ak_47", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("weapon_m4_carbine", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("weapon_m41a_pulse_rifle", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("weapon_m56_smartgun", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("weapon_sniper_rifle", () -> new Item(new Item.Properties()));
    }
}
