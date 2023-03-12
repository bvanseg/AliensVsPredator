package org.alien.common.entity.ai.selector;

import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import org.avp.common.api.parasitoidic.IHost;
import org.avp.common.api.parasitoidic.IParasitoid;
import org.avp.common.world.capabilities.IOrganism.Organism;
import org.avp.common.world.capabilities.IOrganism.Provider;

import java.util.ArrayList;

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
