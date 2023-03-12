package org.avp.entities.ai;

import org.avp.entities.living.EntityCombatSynthetic;
import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.entities.living.species.SpeciesYautja;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;

public class EntitySelectorCombatSynthetic implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorCombatSynthetic instance = new EntitySelectorCombatSynthetic();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof SpeciesAlien)
            return true;

        if (entity instanceof EntityMob)
            return true;

        if (entity instanceof SpeciesYautja)
            return true;

        if (entity instanceof EntityGolem)
            return true;

        if (entity instanceof SpeciesXenomorph)
            return true;

        if (entity instanceof EntityPlayer)
            return false;

        if (entity instanceof EntityMarine)
            return false;

        if (entity instanceof EntityCombatSynthetic)
            return false;
        
        return false;
    }
}
