package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.EntityAethon;

public class EntitySelectorAethon implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAethon instance = new EntitySelectorAethon();

    @Override
    public boolean test(EntityLivingBase target)
    {
        if (target instanceof EntityAethon)
            return false;
        if (target instanceof EntityPlayer && ((EntityPlayer)target).isCreative())
            return false;

        return true;
    }
}
