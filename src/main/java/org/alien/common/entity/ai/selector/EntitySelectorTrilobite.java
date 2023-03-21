package org.alien.common.entity.ai.selector;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;

public class EntitySelectorTrilobite extends EntitySelectorBase
{
    public static final EntitySelectorTrilobite instance = new EntitySelectorTrilobite();

    @Override
    public boolean test(Entity target)
    {
        if (!super.test(target)) return false;

        if (!Predicates.IS_PARASITOID_TARGET.test(target)) return false;
        if (!Predicates.IS_VALID_HOST.test(target)) return false;
        if (Predicates.EMBRYO_CARRIER.test(target)) return false;
        if (Predicates.IS_CHILD.test(target)) return false;

        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;
            ItemStack headwear = Inventories.getHelmSlotItemStack(player);

            if (headwear != null && headwear.getItem() != Items.AIR)
            {
                return false;
            }
        }

        return true;
    }
}
