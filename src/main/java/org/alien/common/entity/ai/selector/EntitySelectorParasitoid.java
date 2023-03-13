package org.alien.common.entity.ai.selector;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.avp.common.AVPItems;
import org.predator.common.PredatorItems;

import java.util.ArrayList;
import java.util.List;

public class EntitySelectorParasitoid implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorParasitoid instance = new EntitySelectorParasitoid();
    private static final List<Item> blacklistedHelmets = new ArrayList<>();

    static
    {
        blacklistedHelmets.add(PredatorItems.BIOMASK_CELTIC);
        blacklistedHelmets.add(AVPItems.MK_50_HELMET);
    }

    @Override
    public boolean apply(EntityLivingBase potentialTarget)
    {
        if (isTargetBlacklistedType(potentialTarget)) return false;
        if (isNonHostOrCarryingEmbryo(potentialTarget)) return false;
        if (isTargetWearingProtectiveHeadgear(potentialTarget)) return false;
        if (potentialTarget.isChild()) return false;

        return true;
    }

    private static boolean isTargetWearingProtectiveHeadgear(EntityLivingBase potentialTarget) {
        if (potentialTarget instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) potentialTarget;
            ItemStack headwear = Inventories.getHelmSlotItemStack(player);

            return headwear != null && blacklistedHelmets.contains(headwear.getItem()) && headwear.getItem() != Items.AIR || ((EntityPlayer) potentialTarget).capabilities.isCreativeMode;
        }
        return false;
    }

    private static boolean isNonHostOrCarryingEmbryo(EntityLivingBase potentialTarget) {
        OrganismImpl organism = (OrganismImpl) potentialTarget.getCapability(Provider.CAPABILITY, null);

        if (potentialTarget instanceof Host)
        {
            Host host = (Host) potentialTarget;

            if (!host.canHostParasite() || !host.canParasiteAttach())
            {
                return true;
            }
        }

        return organism != null && organism.hasEmbryo();
    }

    private static boolean isTargetBlacklistedType(EntityLivingBase potentialTarget) {
        ArrayList<Class<?>> blacklist = Parasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : blacklist)
        {
            if (c.isInstance(potentialTarget))
            {
                return true;
            }
        }
        return false;
    }
}
