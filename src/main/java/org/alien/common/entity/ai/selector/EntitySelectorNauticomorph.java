package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorNauticomorph extends EntitySelectorBase
{
    public static final EntitySelectorNauticomorph instance = new EntitySelectorNauticomorph();

    @Override
    public boolean test(Entity entity)
    {
        if (!super.test(entity)) return false;

        if (Predicates.IS_ALIEN.test(entity)) return false;

        return true;
    }
}
