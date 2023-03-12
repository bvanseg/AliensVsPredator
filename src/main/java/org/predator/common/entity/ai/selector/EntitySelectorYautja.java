package org.predator.common.entity.ai.selector;

import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.avp.common.entities.living.EntityMarine;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesEngineer;
import org.avp.common.item.ItemDisc;
import org.avp.common.item.ItemPlasmaCannon;
import org.avp.common.item.ItemShuriken;
import org.avp.common.item.ItemWristbracer;
import org.avp.common.item.firearms.ItemFirearm;

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
