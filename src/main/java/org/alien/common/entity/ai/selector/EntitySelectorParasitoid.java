package org.alien.common.entity.ai.selector;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.alien.common.api.parasitoidic.IHost;
import org.alien.common.api.parasitoidic.IParasitoid;
import org.alien.common.world.capability.IOrganism.Organism;
import org.alien.common.world.capability.IOrganism.Provider;
import org.avp.common.AVPItems;
import org.predator.common.PredatorItems;

import java.util.ArrayList;

public class EntitySelectorParasitoid implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorParasitoid instance           = new EntitySelectorParasitoid();

    public static       ArrayList<Item>          blacklistedHelmets = new ArrayList<>();

    static
    {
        blacklistedHelmets.add(PredatorItems.BIOMASK_CELTIC);
        blacklistedHelmets.add(AVPItems.MK_50_HELMET);
    }

    @Override
    public boolean apply(EntityLivingBase potentialTarget)
    {
        ArrayList<Class<?>> blacklist = IParasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : blacklist)
        {
            if (c.isInstance(potentialTarget))
            {
                return false;
            }
        }

        Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

        if (potentialTarget instanceof IHost)
        {
            IHost host = (IHost) potentialTarget;

            if (!host.canHostParasite() || !host.canParasiteAttach())
            {
                return false;
            }
        }

        if (organism != null && organism.hasEmbryo())
        {
            return false;
        }

        if (potentialTarget instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) potentialTarget;
            ItemStack headwear = Inventories.getHelmSlotItemStack(player);

            if (headwear != null && blacklistedHelmets.contains(headwear.getItem()) && headwear.getItem() != Items.AIR  || ((EntityPlayer) potentialTarget).capabilities.isCreativeMode)
            {
                return false;
            }
        }
        
        if (!(potentialTarget instanceof EntityLivingBase))
        {
            return false;
        }

        if (potentialTarget instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) potentialTarget;

            if (living.isChild())
            {
                return false;
            }
        }

        return true;
    }
}
