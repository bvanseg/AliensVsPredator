package org.lib.predicate;

import net.minecraft.entity.Entity;

import javax.annotation.Nullable;
import java.util.function.Predicate;

public class EntitySelectorBase implements Predicate<Entity>
{
    public static final EntitySelectorBase instance = new EntitySelectorBase();

    @Override
    public boolean test(@Nullable Entity target)
    {
        if (!Predicates.IS_VALID_ENTITY.test(target)) return false;
        if (Predicates.IS_IMMORTAL_PLAYER.test(target)) return false;
        return true;
    }
}
