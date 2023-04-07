package org.alien.common.api.emybro;

import net.minecraft.entity.Entity;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class EmbryoKey {

    private final Class<? extends Entity> parasiteClass;
    private final Class<? extends Entity> hostClass;

    public EmbryoKey(Entity parasite, Entity host) {
        this(parasite.getClass(), host.getClass());
    }

    public EmbryoKey(Class<? extends Entity> parasiteClass, Class<? extends Entity> hostClass) {
        this.parasiteClass = parasiteClass;
        this.hostClass = hostClass;
    }

    public Class<? extends Entity> getParasiteClass() {
        return this.parasiteClass;
    }

    public Class<? extends Entity> getHostClass() {
        return this.hostClass;
    }

    @Override
    public int hashCode() {
        return Objects.hash(parasiteClass, hostClass);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmbryoKey embryoKey = (EmbryoKey) o;
        return parasiteClass.equals(embryoKey.parasiteClass) && hostClass.equals(embryoKey.hostClass);
    }
}
