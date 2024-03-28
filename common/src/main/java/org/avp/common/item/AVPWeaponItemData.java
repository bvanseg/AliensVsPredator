package org.avp.common.item;

import org.avp.api.item.weapon.FireModes;
import org.avp.api.item.weapon.WeaponDamageTypes;
import org.avp.api.item.weapon.WeaponItemData;
import org.avp.common.sound.AVPSoundEvents;

public class AVPWeaponItemData {

    // TODO:
    public static final WeaponItemData AK_47 = new WeaponItemData(
        1.0F,
        WeaponDamageTypes.MEDIUM,
        FireModes.AUTOMATIC,
        2F * 2,
        2,
        32,
        0.0F,
        20 * 5,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_SHOOT_FAIL,
        AVPSoundEvents.ITEM_WEAPON_AK_47_SHOOT,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_RELOAD
    );

    // TODO:
    public static final WeaponItemData FLAMETHROWER_SEVASTOPOL = new WeaponItemData(
        1.0F,
        WeaponDamageTypes.MEDIUM,
        FireModes.AUTOMATIC,
        1F,
        1,
        32,
        0.0F,
        20 * 5,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_SHOOT_FAIL,
        AVPSoundEvents.ITEM_WEAPON_FLAMETHROWER_SHOOT,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_RELOAD
    );

    // TODO:
    public static final WeaponItemData M41A_PULSE_RIFLE = new WeaponItemData(
        1.0F,
        WeaponDamageTypes.MEDIUM,
        FireModes.AUTOMATIC,
        4F * 2,
        10,
        99,
        1F,
        20 * 3,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_SHOOT_FAIL,
        AVPSoundEvents.ITEM_WEAPON_PULSE_RIFLE_SHOOT,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_RELOAD
    );

    // TODO:
    public static final WeaponItemData SHOTGUN = new WeaponItemData(
        1.0F,
        WeaponDamageTypes.MEDIUM,
        FireModes.SEMI_AUTOMATIC,
        8F * 2,
        20,
        6,
        1.5F,
        20 * 4,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_SHOOT_FAIL,
        AVPSoundEvents.ITEM_WEAPON_SHOTGUN_SHOOT,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_RELOAD
    );

    // TODO:
    public static final WeaponItemData SNIPER_RIFLE = new WeaponItemData(
        1.0F,
        WeaponDamageTypes.HEAVY,
        FireModes.SEMI_AUTOMATIC,
        15F * 2,
        30,
        6,
        1.5F,
        20 * 7 + 10,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_SHOOT_FAIL,
        AVPSoundEvents.ITEM_WEAPON_SNIPER_RIFLE_SHOOT,
        AVPSoundEvents.ITEM_WEAPON_GENERIC_RELOAD
    );

    private AVPWeaponItemData() {
        throw new UnsupportedOperationException();
    }
}
