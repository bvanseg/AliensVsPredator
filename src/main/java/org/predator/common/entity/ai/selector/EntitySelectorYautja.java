package org.predator.common.entity.ai.selector;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.SpeciesEngineer;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.item.firearm.ItemFirearm;
import org.lib.predicate.EntitySelectorBase;
import org.predator.common.item.ItemDisc;
import org.predator.common.item.ItemPlasmaCannon;
import org.predator.common.item.ItemShuriken;
import org.predator.common.item.ItemWristbracer;

public class EntitySelectorYautja extends EntitySelectorBase
{
    public static final EntitySelectorYautja instance = new EntitySelectorYautja();

    @Override
    public boolean test(Entity entity)
    {
        if (!super.test(entity)) return false;

        if (entity instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) entity;
            ItemStack stack = player.getHeldItemMainhand();

            if (stack != null)
            {
                Item item = stack.getItem();

                if (item != null)
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
