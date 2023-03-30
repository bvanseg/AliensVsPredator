package org.weapon.common.item.firearm.rework;

import org.avp.client.AVPSounds;
import org.weapon.common.item.firearm.rework.mode.FireModes;
import org.weapon.common.item.init.WeaponItems;

/**
 * @author Boston Vanseghi
 */
public class AVPFirearmProperties {

    private AVPFirearmProperties() {}

    public static final FirearmProperties AK47_PROPERTIES =
            new FirearmProperties.Builder(FireModes.AUTOMATIC)
                    .setMaxAmmunition(32)
                    .setReloadTimeInTicks(20 * 5)
                    .setRecoil(0.6F)
                    .setDamageMultiplier(1F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(1)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_AR)
                    .setFireSound(FireModes.AUTOMATIC, AVPSounds.WEAPON_GUNSHOT)
                    .build();

    public static final FirearmProperties M4_PROPERTIES =
            new FirearmProperties.Builder(FireModes.AUTOMATIC)
                    .setMaxAmmunition(24)
                    .setReloadTimeInTicks(20 * 6)
                    .setRecoil(0.5F)
                    .setDamageMultiplier(1F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(1)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_AR)
                    .setFireSound(FireModes.AUTOMATIC, AVPSounds.WEAPON_GUNSHOT)
                    .build();

    public static final FirearmProperties M41A_PULSE_RIFLE_PROPERTIES =
            new FirearmProperties.Builder(FireModes.QUAD_BURST, FireModes.AUTOMATIC)
                    .setMaxAmmunition(99)
                    .setReloadTimeInTicks(20 * 3)
                    .setRecoil(0.5F)
                    .setDamageMultiplier(1F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(10)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_AR)
                    .setFireSound(FireModes.QUAD_BURST, AVPSounds.WEAPON_PULSERIFLE)
                    // TODO: Set fire sound for automatic mode.
                    .build();

    public static final FirearmProperties M56SG_PROPERTIES =
            new FirearmProperties.Builder(FireModes.AUTOMATIC)
                    .setMaxAmmunition(500)
                    .setReloadTimeInTicks(20 * 6)
                    .setRecoil(0.2F)
                    .setDamageMultiplier(1F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(0)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_SMG)
                    .setFireSound(FireModes.AUTOMATIC, AVPSounds.WEAPON_M56SG)
                    .build();

    public static final FirearmProperties PISTOL_PROPERTIES =
            new FirearmProperties.Builder(FireModes.SEMI_AUTOMATIC)
                    .setMaxAmmunition(6)
                    .setReloadTimeInTicks(20)
                    .setRecoil(0.1F)
                    .setDamageMultiplier(1F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(6)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_PISTOL)
                    .setFireSound(FireModes.SEMI_AUTOMATIC, AVPSounds.WEAPON_GUNSHOT)
                    .build();

    public static final FirearmProperties SNIPER_PROPERTIES =
            new FirearmProperties.Builder(FireModes.SEMI_AUTOMATIC)
                    .setMaxAmmunition(6)
                    .setReloadTimeInTicks((20 * 7) + 10)
                    .setRecoil(1.5F)
                    .setDamageMultiplier(20F)
                    .setCanAim(true)
                    .setTickDelayBetweenShots(20)
                    .addConsumableItemForReload(WeaponItems.ITEM_AMMO_SNIPER)
                    .setFireSound(FireModes.SEMI_AUTOMATIC, AVPSounds.WEAPON_SNIPER)
                    .build();
}
