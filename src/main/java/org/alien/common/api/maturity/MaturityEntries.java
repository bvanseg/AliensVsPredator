package org.alien.common.api.maturity;

import net.minecraft.entity.Entity;
import org.alien.JellyConstants;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;
import org.prometheus.common.entity.living.species223ode.EntityDeaconAdult;
import org.prometheus.common.entity.living.vardic.EntityBelugaburster;
import org.prometheus.common.entity.living.vardic.EntityBelugamorph;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.*;
import org.alien.common.entity.living.xenomorph.exotic.EntityDracomorph;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class MaturityEntries {
    private static final HashMap<Class<? extends Entity>, MaturityEntry> entityTypesToMaturityEntries = new HashMap<>();

    public static final MaturityEntry DEFAULT = new MaturityEntry(EntityDrone.class, JellyConstants.RAW_YIELD, (15 * 60) * 20);

    static {
        // Exotic Bursters
        entityTypesToMaturityEntries.put(EntityBelugaburster.class, new MaturityEntry(EntityBelugamorph.class, JellyConstants.RAW_YIELD, (8 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityDracoburster.class, new MaturityEntry(EntityDracomorph.class, JellyConstants.RAW_YIELD, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityPredalienChestburster.class, new MaturityEntry(EntityPredalien.class, JellyConstants.RAW_YIELD, (15 * 60) * 20));

        // Classic lineage
        entityTypesToMaturityEntries.put(EntityChestburster.class, new MaturityEntry(EntityDrone.class, JellyConstants.RAW_YIELD, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityDrone.class, new MaturityEntry(EntityWarrior.class, JellyConstants.RAW_YIELD * 2, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityWarrior.class, new MaturityEntry(EntityPraetorian.class, JellyConstants.RAW_YIELD * 3, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityPraetorian.class, new MaturityEntry(EntityMatriarch.class, JellyConstants.RAW_YIELD * 4, (30 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityQueenChestburster.class, new MaturityEntry(EntityMatriarch.class, JellyConstants.RAW_YIELD, (15 * 60) * 20));

        // Runner lineage
        entityTypesToMaturityEntries.put(EntityRunnerChestburster.class, new MaturityEntry(EntityRunnerDrone.class, JellyConstants.RAW_YIELD, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityRunnerDrone.class, new MaturityEntry(EntityRunnerWarrior.class, JellyConstants.RAW_YIELD * 2, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityRunnerWarrior.class, new MaturityEntry(EntityCrusher.class, JellyConstants.RAW_YIELD * 3, (15 * 60) * 20));

        // Promethean lineages
        entityTypesToMaturityEntries.put(EntityDeacon.class, new MaturityEntry(EntityDeaconAdult.class, JellyConstants.RAW_YIELD * 3, (15 * 60) * 20));
    }

    private MaturityEntries() {}

    public static Optional<MaturityEntry> getEntryFor(Class<? extends Entity> entityClass) {
        return Optional.ofNullable(entityTypesToMaturityEntries.get(entityClass));
    }

    public static int getRequiredJellyLevel(Class<? extends Entity> entityClass) {
        MaturityEntry entry = getEntryFor(entityClass).orElse(null);
        return entry != null ? entry.getRequiredJellyLevel() : 0;
    }
}
