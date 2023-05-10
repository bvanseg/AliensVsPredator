package org.prometheus.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.alien.common.entity.living.SpeciesAlien;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.lib.common.predicate.EntitySelectorBase;
import org.predator.common.entity.living.SpeciesYautja;

public class EntitySelectorEngineer extends EntitySelectorBase
{
    public static final EntitySelectorEngineer instance = new EntitySelectorEngineer();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (target instanceof SpeciesAlien) return true;
        if (target instanceof SpeciesYautja) return true;
        if (target instanceof EntityMarine) return true;
        if (target instanceof EntityCombatSynthetic) return true;

        return false;
    }
}
