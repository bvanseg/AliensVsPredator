package org.alien.common.api.emybro;

import net.minecraft.entity.EntityLivingBase;

import java.util.Objects;

/**
 * @author Boston Vanseghi
 */
public class EmbryoKey {

    private final Class<? extends EntityLivingBase> parasiteClass;
    private final Class<? extends EntityLivingBase> hostClass;

    public EmbryoKey(EntityLivingBase parasite, EntityLivingBase host) {
        this(parasite.getClass(), host.getClass());
    }

    public EmbryoKey(Class<? extends EntityLivingBase> parasiteClass, Class<? extends EntityLivingBase> hostClass) {
        this.parasiteClass = parasiteClass;
        this.hostClass = hostClass;
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
