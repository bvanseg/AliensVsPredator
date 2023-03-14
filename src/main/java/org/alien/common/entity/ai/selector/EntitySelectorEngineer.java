package org.alien.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.alien.common.entity.living.SpeciesAlien;
import org.avp.common.entity.living.EntityCombatSynthetic;
import org.avp.common.entity.living.EntityMarine;
import org.predator.common.entity.living.SpeciesYautja;

public class EntitySelectorEngineer implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorEngineer instance = new EntitySelectorEngineer();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        if (target instanceof SpeciesAlien)
            return true;
        if (target instanceof SpeciesYautja)
            return true;
        if (target instanceof EntityMarine)
            return true;
        if (target instanceof EntityCombatSynthetic)
            return true;

        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;

            if (player.capabilities.isCreativeMode)
            {
                return false;
            }
        }

        return false;
    }
}
