package org.alien.common.api.emybro;

import net.minecraft.entity.Entity;
import org.avp.AVP;

import java.util.HashMap;

/**
 * @author Boston Vanseghi
 */
public class EmbryoRegistry {
    private static final HashMap<EmbryoKey, EmbryoEntry> EMBRYO_ENTRIES = new HashMap<>();

    private EmbryoRegistry() {}

    public static void register(EmbryoEntry embryoEntry) {
        if(!embryoEntry.getImpregnator().isPresent()) {
            AVP.instance.getLogger().warn("Attempted to register an EmbryoEntry that has no impregnator! This entry will be ignored. Entry: {}", embryoEntry);
            return;
        }

        Class<? extends Entity> impregnatorClass = embryoEntry.getImpregnator().get();

        if (embryoEntry.getAdult() == null) {
            AVP.instance.getLogger().warn("An EmbryoEntry had a null adult! This entry will be ignored. Entry data: {}", embryoEntry);
            return;
        }

        // Compute all permutations of hosts for the impregnator type and map them to the respective embryo entry.
        embryoEntry.getHosts().forEach(hostClass -> {
            EmbryoKey embryoKey = new EmbryoKey(impregnatorClass, hostClass);

            EMBRYO_ENTRIES.compute(embryoKey, (key, value) -> {
               if (value != null) {
                   AVP.instance.getLogger().warn("An EmbryoEntry (adult {}) already exists for EmbryoKey ({}, {})!", value.getAdult(), impregnatorClass, hostClass);
               }

                return embryoEntry;
            });
        });
    }

    public static EmbryoEntry getEntry(EmbryoKey embryoKey) {
        return EMBRYO_ENTRIES.getOrDefault(embryoKey, EmbryoEntries.DRONE);
    }
}
