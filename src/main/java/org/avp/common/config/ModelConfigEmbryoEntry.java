package org.avp.common.config;

import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import org.alien.common.api.emybro.EmbryoEntry;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author Boston Vanseghi
 */
public class ModelConfigEmbryoEntry {

    private int gestationPeriod;
    private String impregnator;
    private Set<String> hosts;
    private String transitionary;
    private String adult;

    public ModelConfigEmbryoEntry() {}

    public ModelConfigEmbryoEntry(EmbryoEntry embryoEntry) {
        this.gestationPeriod = embryoEntry.getGestationPeriod();
        processImpregnator(embryoEntry);
        processHosts(embryoEntry);
        processTransitionary(embryoEntry);
        processAdult(embryoEntry);
    }

    private void processImpregnator(EmbryoEntry embryoEntry) {
        if (embryoEntry.getImpregnator().isPresent()) {
            Class<? extends Entity> impregnatorClass = embryoEntry.getImpregnator().get();
            EntityEntry entityEntry = EntityRegistry.getEntry(impregnatorClass);

            if (entityEntry != null && entityEntry.getRegistryName() != null) {
                this.impregnator = entityEntry.getRegistryName().toString();
            }
        }
    }

    private void processAdult(EmbryoEntry embryoEntry) {
        EntityEntry entityEntry = EntityRegistry.getEntry(embryoEntry.getAdult());

        if (entityEntry != null && entityEntry.getRegistryName() != null) {
            this.adult = entityEntry.getRegistryName().toString();
        }
    }

    private void processTransitionary(EmbryoEntry embryoEntry) {
        if (embryoEntry.getTransitionary().isPresent()) {
            Class<? extends Entity> embryoTransitionaryClass = embryoEntry.getTransitionary().get();
            EntityEntry entityEntry = EntityRegistry.getEntry(embryoTransitionaryClass);

            if (entityEntry != null && entityEntry.getRegistryName() != null) {
                this.transitionary = entityEntry.getRegistryName().toString();
            }
        }
    }

    private void processHosts(EmbryoEntry embryoEntry) {
        HashSet<String> hostRegistryNames = new HashSet<>();

        for (Class<? extends Entity> hostClass: embryoEntry.getHosts()) {
            EntityEntry hostEntry = EntityRegistry.getEntry(hostClass);

            if (hostEntry != null && hostEntry.getRegistryName() != null) {
                hostRegistryNames.add(hostEntry.getRegistryName().toString());
            } else {
                for (Map.Entry<ResourceLocation, EntityEntry> entry: ForgeRegistries.ENTITIES.getEntries()) {
                    if  ((hostClass == entry.getValue().getEntityClass() || // If the entry directly matches the host class
                            hostClass.isAssignableFrom(entry.getValue().getEntityClass())) && // Or if the entry is a subtype of the host class
                            entry.getValue().getRegistryName() != null && // And the entry's registry name does not equal null
                            embryoEntry.getNonHosts().stream().noneMatch(nonHost -> nonHost.isAssignableFrom(entry.getValue().getEntityClass())) // And the entry is not a subtype of the non host classes.
                    ) {
                        hostRegistryNames.add(entry.getValue().getRegistryName().toString());
                    }
                }
            }
        }

        this.hosts = hostRegistryNames;
    }

    public int getGestationPeriod() {
        return this.gestationPeriod;
    }

    public String getImpregnator() {
        return this.impregnator;
    }

    public Set<String> getHosts() {
        return this.hosts;
    }

    public String getTransitionary() {
        return this.transitionary;
    }

    public String getAdult() {
        return this.adult;
    }
}
