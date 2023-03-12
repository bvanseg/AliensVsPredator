package org.avp.entities.ai.alien;

import java.util.ArrayList;

import org.avp.api.parasitoidic.IHost;
import org.avp.api.parasitoidic.IParasitoid;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class EntitySelectorTrilobite implements Predicate<EntityLivingBase>
{
    public static final EntitySelectorTrilobite instance = new EntitySelectorTrilobite();

    @Override
    public boolean apply(EntityLivingBase target)
    {
        ArrayList<Class<?>> blacklist = IParasitoid.getDefaultEntityBlacklist();

        for (Class<?> c : blacklist)
        {
            if (c.isInstance(target))
            {
                return false;
            }
        }

        Organism organism = (Organism) target.getCapability(Provider.CAPABILITY, null);

        if (target instanceof IHost)
        {
            IHost host = (IHost) target;

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
