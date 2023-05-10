package org.prometheus.common.entity.living.helper;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import org.alien.common.AlienItems;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;
import org.predator.common.item.ItemWristbracer;

/**
 * @author Boston Vanseghi
 */
public final class TrilobiteTentacleHelper {

    public void dropTentacle(EntityTrilobite trilobite)
    {
        trilobite.dropItem(PrometheusItems.ITEM_RAW_TENTACLE, 1);
    }

    public int getAmountOfTentacles()
    {
        return 7;
    }

    public void detachTentacle(EntityTrilobite trilobite)
    {
        int qty = getAmountOfTentacles();
        int[] tentacles = trilobite.getDetachedTentacles();

        if (tentacles == null || tentacles.length < qty)
        {
            tentacles = new int[qty];
        }

        this.detachNextTentacleRandomly(trilobite, tentacles, qty, -1);
        this.setDetachedTentacles(trilobite, tentacles);
    }

    private int[] detachNextTentacleRandomly(EntityTrilobite trilobite, int[] tentacles, int qty, int idx)
    {
        int randTentacle = trilobite.getRNG().nextInt(qty);
        boolean canContinue = false;

        for (int t = 0; t < qty; t++)
        {
            if (tentacles[t] == 0)
            {
                canContinue = true;
                break;
            }
        }

        if (canContinue)
        {
            if (randTentacle != idx)
            {
                if (tentacles[randTentacle] == 0)
                {
                    tentacles[randTentacle] = 1;

                    if (!trilobite.world.isRemote)
                    {
                        this.dropTentacle(trilobite);
                    }

                    return tentacles;
                }
                else
                {
                    detachNextTentacleRandomly(trilobite, tentacles, qty, randTentacle);
                }
            }
            else
            {
                detachNextTentacleRandomly(trilobite, tentacles, qty, randTentacle);
            }
        }

        return tentacles;
    }

    public void setDetachedTentacles(EntityTrilobite trilobite, int[] tentacles)
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("Tentacles", new NBTTagIntArray(tentacles));

        trilobite.getDataManager().set(EntityTrilobite.DETACHED_TENTACLES, tag);
    }

    public void updateHitbox(EntityTrilobite trilobite)
    {
        if (trilobite.world.getTotalWorldTime() % 20 == 0)
        {
            if (!trilobite.isFertile() && trilobite.getRidingEntity() == null)
            {
                trilobite.height = 0.5F;
            }

            if (!trilobite.isFertile() && trilobite.getRidingEntity() != null)
            {
                trilobite.height = 3F;
            }

            int[] tentacles = trilobite.getDetachedTentacles();
            boolean hasAllTentacles = true;

            for (int i = 0; i < this.getAmountOfTentacles(); i++)
            {
                if (tentacles[i] == 1)
                {
                    hasAllTentacles = false;
                }
            }

            if (!hasAllTentacles)
            {
                trilobite.width = 2;
            }
        }
    }

    public void onHitByEntity(EntityTrilobite trilobite, Entity entity)
    {
        if (!trilobite.isFertile() && trilobite.getRidingEntity() == null)
        {
            if (entity instanceof EntityPlayer)
            {
                EntityPlayer player = (EntityPlayer) entity;
                ItemStack held = player.getHeldItemMainhand();

                if (held != null)
                {
                    if (held.getItem() instanceof ItemSword || held.getItem() instanceof ItemAxe || ItemWristbracer.equippedHasBlades(player))
                    {
                        this.detachTentacle(trilobite);
                    }
                }
            }
        }
    }
}
