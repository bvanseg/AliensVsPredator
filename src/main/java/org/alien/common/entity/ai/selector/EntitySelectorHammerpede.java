package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import org.lib.predicate.EntitySelectorBase;
import org.lib.predicate.Predicates;

// TODO: This class isn't yet used, do not delete
public class EntitySelectorHammerpede extends EntitySelectorBase
{
    public static final EntitySelectorHammerpede instance = new EntitySelectorHammerpede();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;
        return !Predicates.IS_ALIEN.test(target);
    }
}
