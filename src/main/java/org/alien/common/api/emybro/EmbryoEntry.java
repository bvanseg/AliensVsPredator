package org.alien.common.api.emybro;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.world.Embryo;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class EmbryoEntry {

    private int id;
    private Class<? extends EntityLivingBase> impregnator;
    private final Collection<Class<? extends EntityLivingBase>> hosts;
    private Class<? extends EntityLivingBase> transitionary;
    private final Class<? extends EntityLivingBase> adult;

    private int gestationPeriod;

    private EmbryoEntry(Collection<Class<? extends EntityLivingBase>> hosts, Class<? extends EntityLivingBase> adult) {
        this.hosts = hosts;
        this.adult = adult;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<Class<? extends EntityLivingBase>> getImpregnator() {
        return Optional.ofNullable(this.impregnator);
    }

    public Collection<Class<? extends EntityLivingBase>> getHosts() {
        return this.hosts;
    }

    public Optional<Class<? extends EntityLivingBase>> getTransitionary() {
        return Optional.ofNullable(this.transitionary);
    }

    public Class<? extends EntityLivingBase> getAdult() {
        return this.adult;
    }

    public int getGestationPeriod() {
        return this.gestationPeriod;
    }

    public static class Builder {

        private final EmbryoEntry embryoEntry;

        public Builder(Class<? extends EntityLivingBase> adult) {
            this(new HashSet<>(), adult);
        }

        public Builder(Collection<Class<? extends EntityLivingBase>> hosts, Class<? extends EntityLivingBase> adult) {
            this.embryoEntry = new EmbryoEntry(hosts, adult);
        }

        public Builder setImpregnator(Class<? extends EntityLivingBase> impregnator) {
            this.embryoEntry.impregnator = impregnator;
            return this;
        }

        public Builder addHost(Class<? extends EntityLivingBase> entityEntry) {
            this.embryoEntry.hosts.add(entityEntry);
            return this;
        }

        public Builder setTransitionaryStage(Class<? extends EntityLivingBase> entityEntry) {
            this.embryoEntry.transitionary = entityEntry;
            return this;
        }

        public EmbryoEntry build() {
            return this.embryoEntry;
        }
    }

    public Embryo create() {
        return new Embryo(this.id);
    }
}
