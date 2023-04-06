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

    private String impregnator;
    private Set<String> hosts;
    private String transitionary;
    private String adult;

    public ModelConfigEmbryoEntry() {}

    public ModelConfigEmbryoEntry(EmbryoEntry embryoEntry) {
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
                    if  ((hostClass == entry.getValue().getEntityClass() ||
                            hostClass.isAssignableFrom(entry.getValue().getEntityClass())) &&
                            entry.getValue().getRegistryName() != null
                    ) {
                        hostRegistryNames.add(entry.getValue().getRegistryName().toString());
                    }
                }
            }
        }

        this.hosts = hostRegistryNames;
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
