package org.alien.common.entity.ai.selector;

import java.util.function.Predicate;
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
    public boolean test(EntityLivingBase target)
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
