package org.weapon.common.item.firearm.rework;

import com.asx.mdx.client.sound.Sound;
import net.minecraft.item.Item;
import org.weapon.common.item.firearm.rework.mode.FireMode;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Boston Vanseghi
 */
public class FirearmProperties {

    private static final AtomicInteger GLOBAL_FIREARM_PROPERTIES_ID = new AtomicInteger(0);
    private static final HashMap<Integer, FirearmProperties> firearmPropertiesById = new HashMap<>();

    private static synchronized int getNewFirearmPropertiesId(FirearmProperties firearmProperties) {
        int newId = GLOBAL_FIREARM_PROPERTIES_ID.getAndIncrement();
        firearmPropertiesById.put(newId, firearmProperties);
        return newId;
    }

    public static FirearmProperties getById(int firearmPropertiesId) {
        return firearmPropertiesById.get(firearmPropertiesId);
    }

    private final int id;

    private final FireMode defaultFireMode;
    private final Set<FireMode> fireModes;

    private int maxAmmunition;

    private int reloadTimeInTicks;

    private float recoil;

    private float damageMultiplier;

    private boolean canAim;

    private Map<FireMode, Sound> fireSounds;

    private Set<Item> consumablesForReload;

    private FirearmProperties(FireMode defaultFireMode, FireMode... fireModes) {
        this.id = getNewFirearmPropertiesId(this);

        HashSet<FireMode> fireModeSet = new HashSet<>();
        fireModeSet.add(defaultFireMode);
        fireModeSet.addAll(Arrays.asList(fireModes));

        this.defaultFireMode = defaultFireMode;
        this.fireModes = fireModeSet;
        this.maxAmmunition = 1;
        this.reloadTimeInTicks = 20 * 3; // 3 Seconds.
        this.recoil = 0F;
        this.damageMultiplier = 1F;
        this.canAim = false;
        this.fireSounds = Collections.emptyMap();
        this.consumablesForReload = Collections.emptySet();
    }

    /*
     * Getters
     */

    public int getId() {
        return this.id;
    }

    public FireMode getDefaultFireMode() {
        return this.defaultFireMode;
    }

    public Set<FireMode> getFireModes() {
        return this.fireModes;
    }

    public int getMaxAmmunition() {
        return this.maxAmmunition;
    }

    public int getReloadTimeInTicks() {
        return this.reloadTimeInTicks;
    }

    public float getRecoil() {
        return this.recoil;
    }

    public float getDamageMultiplier() {
        return this.damageMultiplier;
    }

    public boolean canAim() {
        return this.canAim;
    }

    public Map<FireMode, Sound> getFireSounds() {
        return Collections.unmodifiableMap(this.fireSounds);
    }

    public Set<Item> getConsumablesForReload() {
        return Collections.unmodifiableSet(this.consumablesForReload);
    }

    /*
     * Setters
     */

    private void setMaxAmmunition(int maxAmmunition) {
        this.maxAmmunition = maxAmmunition;
    }

    private void setReloadTimeInTicks(int reloadTimeInTicks) {
        this.reloadTimeInTicks = reloadTimeInTicks;
    }

    private void setRecoil(float recoil) {
        this.recoil = recoil;
    }

    private void setDamageMultiplier(float damageMultiplier) {
        this.damageMultiplier = damageMultiplier;
    }

    private void setCanAim(boolean canAim) {
        this.canAim = canAim;
    }

    private void setFireSounds(Map<FireMode, Sound> fireSounds) {
        this.fireSounds = fireSounds;
    }

    private void setConsumablesForReload(Set<Item> consumablesForReload) {
        this.consumablesForReload = consumablesForReload;
    }

    /*
     * Builder class.
     */

    public static class Builder {

        private final FirearmProperties firearmProperties;

        private final HashMap<FireMode, Sound> fireSounds = new HashMap<>();
        private final HashSet<Item> consumableItemsForReload = new HashSet<>();

        public Builder(FireMode fireMode, FireMode... fireModes) {
            this.firearmProperties = new FirearmProperties(fireMode, fireModes);
        }

        public Builder setMaxAmmunition(int maxAmmunition) {
            this.firearmProperties.setMaxAmmunition(maxAmmunition);
            return this;
        }

        public Builder setReloadTimeInTicks(int reloadTimeInTicks) {
            this.firearmProperties.reloadTimeInTicks = reloadTimeInTicks;
            return this;
        }

        public Builder setRecoil(float recoil) {
            this.firearmProperties.setRecoil(recoil);
            return this;
        }

        public Builder setDamageMultiplier(float damageMultiplier) {
            this.firearmProperties.setDamageMultiplier(damageMultiplier);
            return this;
        }

        public Builder setCanAim(boolean canAim) {
            this.firearmProperties.setCanAim(canAim);
            return this;
        }

        public Builder setFireSound(FireMode fireMode, Sound fireSound) {
            this.fireSounds.put(fireMode, fireSound);
            return this;
        }

        public Builder addConsumableItemForReload(Item consumable) {
            consumableItemsForReload.add(consumable);
            return this;
        }

        public FirearmProperties build() {
            this.firearmProperties.setFireSounds(this.fireSounds);
            this.firearmProperties.setConsumablesForReload(this.consumableItemsForReload);
            return this.firearmProperties;
        }
    }
}
