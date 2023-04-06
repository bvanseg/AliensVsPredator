package org.alien.common.api.emybro;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import org.alien.common.world.Embryo;
import org.avp.AVP;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Boston Vanseghi
 */
public class EmbryoRegistry {
    private static final HashMap<EmbryoKey, EmbryoEntry> EMBRYO_ENTRIES = new HashMap<>();
    public static final HashMap<Integer, EmbryoEntry> EMBRYO_ENTRIES_BY_ID = new HashMap<>();
    private static final AtomicInteger nextAvailableId = new AtomicInteger(1);

    private EmbryoRegistry() {}

    public static void register(EmbryoEntry embryoEntry) {
        if(!embryoEntry.getImpregnator().isPresent()) return;

        Class<? extends EntityLivingBase> impregnatorClass = embryoEntry.getImpregnator().get();

        // Compute all permutations of hosts for the impregnator type and map them to the respective embryo entry.
        embryoEntry.getHosts().forEach(hostClass -> {
            EmbryoKey embryoKey = new EmbryoKey(impregnatorClass, hostClass);

            EMBRYO_ENTRIES.compute(embryoKey, (key, value) -> {
               if (value != null) {
                   AVP.instance.getLogger().warn("An EmbryoEntry already exists for EmbryoKey ({}, {})!", impregnatorClass, hostClass);
               }

                return embryoEntry;
            });
        });

        int id = nextAvailableId.getAndIncrement();
        EMBRYO_ENTRIES_BY_ID.putIfAbsent(id, embryoEntry);
    }

    public static EmbryoEntry getEntry(EmbryoKey embryoKey) {
        return EMBRYO_ENTRIES.getOrDefault(embryoKey, EmbryoEntries.DRONE);
    }

    public static EmbryoEntry findById(int id) {
        return EMBRYO_ENTRIES_BY_ID.get(id);
    }

    public static Embryo create(EntityLiving parasite, EntityLiving host) {
        // Create a key for the embryo entry lookup.
        EmbryoKey embryoKey = new EmbryoKey(parasite.getClass(), host.getClass());
        EmbryoEntry embryoEntry = getEntry(embryoKey);
        return embryoEntry.create();
    }
}
