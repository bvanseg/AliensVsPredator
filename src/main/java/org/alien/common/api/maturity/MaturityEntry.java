package org.alien.common.api.maturity;

import net.minecraft.entity.Entity;

/**
 * @author Boston Vanseghi
 */
public class MaturityEntry {

    private final Class<? extends Entity> entityClass;
    private final int requiredJellyLevel;
    private final int timeUntilMaturity;

    public MaturityEntry(Class<? extends Entity> entityClass, int requiredJellyLevel) {
        this(entityClass, requiredJellyLevel, (int)(requiredJellyLevel * 2.8125));
    }

    public MaturityEntry(Class<? extends Entity> entityClass, int requiredJellyLevel, int timeUntilMaturity) {
        this.entityClass = entityClass;
        this.requiredJellyLevel = requiredJellyLevel;
        this.timeUntilMaturity = timeUntilMaturity;
    }

    public Class<? extends Entity> getEntityClass() {
        return entityClass;
    }

    public int getRequiredJellyLevel() {
        return requiredJellyLevel;
    }

    public int getMaturityTime() {
        return timeUntilMaturity;
    }
}
