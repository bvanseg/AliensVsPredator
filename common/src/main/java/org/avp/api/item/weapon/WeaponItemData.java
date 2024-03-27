package org.avp.api.item.weapon;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class WeaponItemData {

    private final float accuracy;

    private final WeaponDamageType weaponDamageType;

    private final FireMode fireMode;

    private final float damage;

    private final int fireRateInTicks;

    private final int maxAmmunition;

    private final float recoil;

    private final int reloadTimeInTicks;

    private final GameObject<SoundEvent> fireFailSound;

    private final GameObject<SoundEvent> fireSound;

    private final GameObject<SoundEvent> reloadSound;

    public WeaponItemData(
        float accuracy,
        @NotNull WeaponDamageType weaponDamageType,
        @NotNull FireMode fireMode,
        float damage,
        int fireRateInTicks,
        int maxAmmunition,
        float recoil,
        int reloadTimeInTicks,
        @NotNull GameObject<SoundEvent> fireFailSound,
        @NotNull GameObject<SoundEvent> fireSound,
        @NotNull GameObject<SoundEvent> reloadSound
    ) {
        this.accuracy = accuracy;
        this.weaponDamageType = weaponDamageType;
        this.fireMode = fireMode;
        this.damage = damage;
        this.fireRateInTicks = fireRateInTicks;
        this.maxAmmunition = maxAmmunition;
        this.recoil = recoil;
        this.reloadTimeInTicks = reloadTimeInTicks;
        this.fireFailSound = fireFailSound;
        this.fireSound = fireSound;
        this.reloadSound = reloadSound;
    }

    public float getAccuracy() {
        return accuracy;
    }

    public WeaponDamageType getBulletDamageType() {
        return weaponDamageType;
    }

    public FireMode getFireMode() {
        return fireMode;
    }

    public float getDamage() {
        return damage;
    }

    public int getFireRateInTicks() {
        return fireRateInTicks;
    }

    public int getMaxAmmunition() {
        return maxAmmunition;
    }

    public float getRecoil() {
        return recoil;
    }

    public int getReloadTimeInTicks() {
        return reloadTimeInTicks;
    }

    public GameObject<SoundEvent> getFireFailSound() {
        return fireFailSound;
    }

    public GameObject<SoundEvent> getFireSound() {
        return fireSound;
    }

    public GameObject<SoundEvent> getReloadSound() {
        return reloadSound;
    }
}
