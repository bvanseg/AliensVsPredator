package org.avp.entities.ai.alien;

import org.avp.entities.living.EntityMarine;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.SpeciesEngineer;
import org.avp.item.ItemDisc;
import org.avp.item.ItemFirearm;
import org.avp.item.ItemPlasmaCannon;
import org.avp.item.ItemShuriken;
import org.avp.item.ItemWristbracer;

import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

public class EntitySelectorYautja implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorYautja instance = new EntitySelectorYautja();

    @Override
    public boolean apply(EntityLivingBase entity)
    {
        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack stack = player.getHeldItemMainhand();

            if (stack != null)
            {
                Item item = stack.getItem();

                if (stack != null)
                {
                    if (item instanceof ItemSword || item instanceof ItemFirearm || item instanceof ItemWristbracer || item instanceof ItemPlasmaCannon || item instanceof ItemBow || item instanceof ItemDisc || item instanceof ItemShuriken)
                    {
                        return true;
                    }
                }
            }
        }

        if ((entity instanceof SpeciesAlien) || (entity instanceof SpeciesEngineer) || (entity instanceof EntityMarine))
        {
            return true;
        }

        return false;
    }
}
