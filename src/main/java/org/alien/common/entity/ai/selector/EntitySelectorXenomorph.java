package org.alien.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityWaterMob;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorXenomorph extends EntitySelectorBase
{
    public static final EntitySelectorXenomorph instance = new EntitySelectorXenomorph();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (Predicates.IS_ALIEN.test(target)) return false;
        if (Predicates.EMBRYO_CARRIER.test(target)) return false;
        if (Predicates.HAS_ATTACHED_PARASITE.test(target)) return false;
        
        if (target instanceof EntityWaterMob) {
            return target.isInWater() || target.isOverWater();
        }

        return !(target instanceof EntityBat);
    }
}
