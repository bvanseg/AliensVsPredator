package org.weapon.common.item.firearm.rework.mode;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Boston Vanseghi
 */
public class FireMode {

    private static final AtomicInteger GLOBAL_FIRE_MODE_ID = new AtomicInteger(0);
    private static final HashMap<Integer, FireMode> fireModesById = new HashMap<>();

    private static synchronized int getNewFireModeId(FireMode fireMode) {
        int newId = GLOBAL_FIRE_MODE_ID.getAndIncrement();
        fireModesById.put(newId, fireMode);
        return newId;
    }

    public static FireMode getById(int fireModeId) {
        return fireModesById.get(fireModeId);
    }

    private final int id;
    private final int shotsPerTriggerPull;
    private final boolean fullyAutomatic;
    private final boolean triggerPullRequiresReload;

    public FireMode(boolean fullyAutomatic, boolean triggerPullRequiresReload) {
        this(1, fullyAutomatic, triggerPullRequiresReload);
    }

    public FireMode(int shotsPerTriggerPull, boolean fullyAutomatic, boolean triggerPullRequiresReload) {
        this.id = getNewFireModeId(this);

        this.shotsPerTriggerPull = shotsPerTriggerPull;
        this.fullyAutomatic = fullyAutomatic;
        this.triggerPullRequiresReload = triggerPullRequiresReload;
    }

    public int getId() {
        return this.id;
    }

    public int getShotsPerTriggerPull() {
        return this.shotsPerTriggerPull;
    }

    public boolean isFullyAutomatic() {
        return this.fullyAutomatic;
    }

    public boolean doesTriggerPullRequireReload() {
        return this.triggerPullRequiresReload;
    }
}
