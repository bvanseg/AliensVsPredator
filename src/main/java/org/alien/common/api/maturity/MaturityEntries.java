package org.alien.common.api.maturity;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.vardic.EntityBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugamorph;
import org.alien.common.entity.living.xenomorph.*;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class MaturityEntries {
    private static final HashMap<Class<? extends Entity>, MaturityEntry> entityTypesToMaturityEntries = new HashMap<>();

    public static final MaturityEntry DEFAULT = new MaturityEntry(EntityDrone.class, 6400);

    static {
        // Bursters
        entityTypesToMaturityEntries.put(EntityBelugaburster.class, new MaturityEntry(EntityBelugamorph.class, 6400));
        entityTypesToMaturityEntries.put(EntityDracoburster.class, new MaturityEntry(EntityDracomorph.class, 12800));
        entityTypesToMaturityEntries.put(EntityPredalienChestburster.class, new MaturityEntry(EntityPredalien.class, 12800));

        // Classic lineage
        entityTypesToMaturityEntries.put(EntityDrone.class, new MaturityEntry(EntityWarrior.class, 1024 * 6));
        entityTypesToMaturityEntries.put(EntityWarrior.class, new MaturityEntry(EntityPraetorian.class, 1024 * 12));
        entityTypesToMaturityEntries.put(EntityPraetorian.class, new MaturityEntry(EntityMatriarch.class, 1024 * 16));
        entityTypesToMaturityEntries.put(EntityQueenChestburster.class, new MaturityEntry(EntityMatriarch.class, 12800));

        // Runner lineage
        entityTypesToMaturityEntries.put(EntityRunnerChestburster.class, new MaturityEntry(EntityRunnerDrone.class, 1024 * 12));
        entityTypesToMaturityEntries.put(EntityRunnerDrone.class, new MaturityEntry(EntityRunnerWarrior.class, 1024 * 6));
        entityTypesToMaturityEntries.put(EntityRunnerWarrior.class, new MaturityEntry(EntityCrusher.class, 1024 * 12));

        // Promethean lineages
        entityTypesToMaturityEntries.put(EntityDeacon.class, new MaturityEntry(EntityDeaconAdult.class, 6400));
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
