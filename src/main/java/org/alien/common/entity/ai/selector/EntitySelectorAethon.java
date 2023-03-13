package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.EntityAethon;

public class EntitySelectorAethon implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorAethon instance = new EntitySelectorAethon();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof EntityAethon)
            return false;
        if (target instanceof EntityPlayer && ((EntityPlayer)target).isCreative())
            return false;

        return true;
    }
}
