package org.alien.common.api.maturity;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;
import org.alien.common.entity.living.vardic.EntityBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugamorph;
import org.alien.common.entity.living.xenomorph.*;
import org.alien.common.entity.living.xenomorph.burster.EntityDracoburster;
import org.alien.common.entity.living.xenomorph.burster.EntityPredalienChestburster;
import org.alien.common.entity.living.xenomorph.burster.EntityQueenChestburster;
import org.alien.common.entity.living.xenomorph.burster.EntityRunnerChestburster;
import org.alien.common.entity.living.xenomorph.exotic.EntityDracomorph;

import java.util.HashMap;
import java.util.Optional;

/**
 * @author Boston Vanseghi
 */
public class MaturityEntries {
    private static final HashMap<Class<? extends Entity>, MaturityEntry> entityTypesToMaturityEntries = new HashMap<>();

    public static final MaturityEntry DEFAULT = new MaturityEntry(EntityDrone.class, 6400, (15 * 60) * 20);

    static {
        // Bursters
        entityTypesToMaturityEntries.put(EntityBelugaburster.class, new MaturityEntry(EntityBelugamorph.class, 6400, (8 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityDracoburster.class, new MaturityEntry(EntityDracomorph.class, 12800, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityPredalienChestburster.class, new MaturityEntry(EntityPredalien.class, 12800, (15 * 60) * 20));

        // Classic lineage
        entityTypesToMaturityEntries.put(EntityDrone.class, new MaturityEntry(EntityWarrior.class, 1024 * 6, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityWarrior.class, new MaturityEntry(EntityPraetorian.class, 1024 * 12, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityPraetorian.class, new MaturityEntry(EntityMatriarch.class, 1024 * 16, (30 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityQueenChestburster.class, new MaturityEntry(EntityMatriarch.class, 12800, (15 * 60) * 20));

        // Runner lineage
        entityTypesToMaturityEntries.put(EntityRunnerChestburster.class, new MaturityEntry(EntityRunnerDrone.class, 1024 * 12, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityRunnerDrone.class, new MaturityEntry(EntityRunnerWarrior.class, 1024 * 6, (15 * 60) * 20));
        entityTypesToMaturityEntries.put(EntityRunnerWarrior.class, new MaturityEntry(EntityCrusher.class, 1024 * 12, (15 * 60) * 20));

        // Promethean lineages
        entityTypesToMaturityEntries.put(EntityDeacon.class, new MaturityEntry(EntityDeaconAdult.class, 6400, (15 * 60) * 20));
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
