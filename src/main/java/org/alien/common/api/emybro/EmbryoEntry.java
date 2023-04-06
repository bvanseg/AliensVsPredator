package org.alien.common.api.emybro;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.world.Embryo;
import org.avp.common.config.ModelConfigEmbryoEntry;
import org.lib.common.FuncUtil;
import org.lib.common.StreamUtil;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Boston Vanseghi
 */
public class EmbryoEntry {

    private int gestationPeriod;
    private Class<? extends Entity> impregnator;
    private final Collection<Class<? extends Entity>> hosts;
    private Class<? extends Entity> transitionary;
    private final Class<? extends Entity> adult;

    private EmbryoEntry(Collection<Class<? extends Entity>> hosts, Class<? extends Entity> adult) {
        this.hosts = hosts;
        this.adult = adult;
        this.gestationPeriod = 20 * 60 * 5; // 5 Minutes
    }

    public Optional<Class<? extends Entity>> getImpregnator() {
        return Optional.ofNullable(this.impregnator);
    }

    public Collection<Class<? extends Entity>> getHosts() {
        return this.hosts;
    }

    public Optional<Class<? extends Entity>> getTransitionary() {
        return Optional.ofNullable(this.transitionary);
    }

    public Class<? extends Entity> getAdult() {
        return this.adult;
    }

    public int getGestationPeriod() {
        return this.gestationPeriod;
    }

    public static class Builder {

        private final EmbryoEntry embryoEntry;

        public Builder(Class<? extends Entity> adult) {
            this(new HashSet<>(), adult);
        }

        public Builder(ModelConfigEmbryoEntry configEmbryoEntry) {
            this(
                // Process the hosts string collection into a set of entity classes.
                StreamUtil.<String, Class<? extends Entity>>mapNotNull(
                        configEmbryoEntry.getHosts().stream(),
                        registryName -> FuncUtil.let(ForgeRegistries.ENTITIES.getValue(new ResourceLocation(registryName)), EntityEntry::getEntityClass)).collect(Collectors.toSet()
                ),
                // Process the adult registry name into an entity class.
                FuncUtil.<String, Class<? extends Entity>>let(
                        configEmbryoEntry.getAdult(),
                        registryName -> FuncUtil.let(ForgeRegistries.ENTITIES.getValue(new ResourceLocation(registryName)), EntityEntry::getEntityClass)
                )
            );

            this.setGestationPeriod(configEmbryoEntry.getGestationPeriod());

            this.setImpregnator(
                    FuncUtil.<String, Class<? extends Entity>>let(
                            configEmbryoEntry.getImpregnator(),
                            registryName -> FuncUtil.let(ForgeRegistries.ENTITIES.getValue(new ResourceLocation(registryName)), EntityEntry::getEntityClass)
                    )
            );

            this.setTransitionaryStage(
                    FuncUtil.<String, Class<? extends Entity>>let(
                            configEmbryoEntry.getTransitionary(),
                            registryName -> FuncUtil.let(ForgeRegistries.ENTITIES.getValue(new ResourceLocation(registryName)), EntityEntry::getEntityClass)
                    )
            );
        }

        public Builder(Collection<Class<? extends Entity>> hosts, Class<? extends Entity> adult) {
            this.embryoEntry = new EmbryoEntry(hosts, adult);
        }

        public Builder setImpregnator(Class<? extends Entity> impregnator) {
            this.embryoEntry.impregnator = impregnator;
            return this;
        }

        public Builder addHost(Class<? extends Entity> entityEntry) {
            this.embryoEntry.hosts.add(entityEntry);
            return this;
        }

        public Builder setTransitionaryStage(Class<? extends Entity> entityEntry) {
            this.embryoEntry.transitionary = entityEntry;
            return this;
        }

        public Builder setGestationPeriod(int gestationPeriod) {
            this.embryoEntry.gestationPeriod = gestationPeriod;
            return this;
        }

        public EmbryoEntry build() {
            return this.embryoEntry;
        }
    }

    public Embryo create(EmbryoKey embryoKey) {
        return new Embryo(this, embryoKey);
    }
}
