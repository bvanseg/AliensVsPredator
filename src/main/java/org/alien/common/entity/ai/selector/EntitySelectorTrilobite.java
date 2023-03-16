package org.alien.common.entity.ai.selector;

import com.asx.mdx.common.minecraft.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.alien.common.api.parasitoidic.Host;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;

import java.util.ArrayList;

public class EntitySelectorTrilobite implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorTrilobite instance = new EntitySelectorTrilobite();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        ArrayList<Class<?>> blacklist = Parasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : blacklist)
        {
            if (c.isInstance(target))
            {
                return false;
            }
        }

        OrganismImpl organism = (OrganismImpl) target.getCapability(Provider.CAPABILITY, null);

        if (target instanceof Host)
        {
            Host host = (Host) target;

            if (!host.canHostParasite() || !host.canParasiteAttach())
            {
                return false;
            }
        }

        if (organism != null && organism.hasEmbryo())
        {
            return false;
        }

        if (target instanceof EntityPlayer)
        {
            EntityPlayer player = (EntityPlayer) target;
            ItemStack headwear = Inventories.getHelmSlotItemStack(player);

            if (headwear != null && headwear.getItem() != Items.AIR || ((EntityPlayer) target).capabilities.isCreativeMode)
            {
                return false;
            }
        }

        if (!(target instanceof EntityLivingBase))
        {
            return false;
        }

        if (target instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) target;

            if (living.isChild())
            {
                return false;
            }
        }

        return true;
    }
}
