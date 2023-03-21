package org.alien.common.entity.ai.selector;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.avp.common.AVPItems;
import org.lib.common.predicate.EntitySelectorBase;
import org.lib.common.predicate.Predicates;
import org.predator.common.PredatorItems;

import java.util.ArrayList;
import java.util.List;

public class EntitySelectorParasitoid extends EntitySelectorBase
{
    public static final EntitySelectorParasitoid instance = new EntitySelectorParasitoid();
    private static final List<Item> HELMET_DENYLIST = new ArrayList<>();

    static
    {
        HELMET_DENYLIST.add(PredatorItems.BIOMASK_CELTIC);
        HELMET_DENYLIST.add(AVPItems.MK_50_HELMET);
    }

    @Override
    public boolean test(Entity potentialTarget)
    {
        if (!super.test(potentialTarget)) return false;

        if (!Predicates.IS_PARASITOID_TARGET.test(potentialTarget)) return false;
        if (!Predicates.IS_VALID_HOST.test(potentialTarget)) return false;
        if (Predicates.EMBRYO_CARRIER.test(potentialTarget)) return false;
        if (Predicates.IS_CHILD.test(potentialTarget)) return false;
        if (isTargetWearingProtectiveHeadgear(potentialTarget)) return false;

        return true;
    }

    private static boolean isTargetWearingProtectiveHeadgear(Entity potentialTarget) {
        if (potentialTarget instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) potentialTarget;
            ItemStack headwear = Inventories.getHelmSlotItemStack(player);

            return headwear != null && HELMET_DENYLIST.contains(headwear.getItem()) && headwear.getItem() != Items.AIR;
        }
        return false;
    }
}
