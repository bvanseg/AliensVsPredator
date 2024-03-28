package org.avp.api.item.weapon;

import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

import org.avp.common.util.GameObject;

import java.util.List;
import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class WeaponItemData {

    private final float accuracy;

    private final WeaponDamageType weaponDamageType;

    private final List<FireMode> fireModes;

    private final float damage;

    private final float knockback;

    private final int maxAmmunition;

    private final int reloadTimeInTicks;

    private final GameObject<SoundEvent> fireFailSound;

    private final GameObject<SoundEvent> reloadSound;

    public WeaponItemData(
        float accuracy,
        @NotNull WeaponDamageType weaponDamageType,
        @NotNull List<FireMode> fireModes,
        float damage,
        float knockback,
        int maxAmmunition,
        int reloadTimeInTicks,
        @NotNull GameObject<SoundEvent> fireFailSound,
        @NotNull GameObject<SoundEvent> reloadSound
    ) {
        if (fireModes.isEmpty()) {
            throw new IllegalStateException("Weapons must have at least 1 fire mode!");
        }

        this.accuracy = Math.max(accuracy, 0);
        this.weaponDamageType = weaponDamageType;
        this.fireModes = fireModes;
        this.damage = Math.max(damage, 0);
        this.knockback = Math.max(knockback, 0);
        this.maxAmmunition = Math.max(maxAmmunition, 0);
        this.reloadTimeInTicks = Math.max(reloadTimeInTicks, 0);
        this.fireFailSound = fireFailSound;
        this.reloadSound = reloadSound;
    }

    public FireMode getFireMode(String identifier) {
        return this.getFireModes()
            .stream()
            .filter(mode -> Objects.equals(mode.identifier(), identifier))
            .findFirst()
            .orElse(this.getFireModes().get(0));
    }

    public float getAccuracy() {
        return accuracy;
    }

    public WeaponDamageType getBulletDamageType() {
        return weaponDamageType;
    }

    public List<FireMode> getFireModes() {
        return fireModes;
    }

    public float getDamage() {
        return damage;
    }

    public float getKnockback() {
        return knockback;
    }

    public int getMaxAmmunition() {
        return maxAmmunition;
    }

    public int getReloadTimeInTicks() {
        return reloadTimeInTicks;
    }

    public GameObject<SoundEvent> getFireFailSound() {
        return fireFailSound;
    }

    public GameObject<SoundEvent> getReloadSound() {
        return reloadSound;
    }
}
