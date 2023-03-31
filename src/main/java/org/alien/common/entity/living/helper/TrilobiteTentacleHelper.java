package org.alien.common.entity.living.helper;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagIntArray;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.species223ode.EntityTrilobite;

/**
 * @author Boston Vanseghi
 */
public final class TrilobiteTentacleHelper {

    private final EntityTrilobite trilobite;

    public TrilobiteTentacleHelper(EntityTrilobite trilobite) {
        this.trilobite = trilobite;
    }

    public void dropTentacle()
    {
        trilobite.dropItem(AlienItems.ITEM_RAW_TENTACLE, 1);
    }

    public int getAmountOfTentacles()
    {
        return 7;
    }

    public void detachTentacle()
    {
        int qty = getAmountOfTentacles();
        int[] tentacles = trilobite.getDetachedTentacles();

        if (tentacles == null || tentacles != null && tentacles.length < qty)
        {
            tentacles = new int[qty];
        }

        this.detachNextTentacleRandomly(tentacles, qty, -1);
        this.setDetachedTentacles(tentacles);
    }

    private int[] detachNextTentacleRandomly(int[] tentacles, int qty, int idx)
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
                        this.dropTentacle();
                    }

                    return tentacles;
                }
                else
                {
                    detachNextTentacleRandomly(tentacles, qty, randTentacle);
                }
            }
            else
            {
                detachNextTentacleRandomly(tentacles, qty, randTentacle);
            }
        }

        return tentacles;
    }

    public void setDetachedTentacles(int[] tentacles)
    {
        NBTTagCompound tag = new NBTTagCompound();
        tag.setTag("Tentacles", new NBTTagIntArray(tentacles));

        trilobite.getDataManager().set(EntityTrilobite.DETACHED_TENTACLES, tag);
    }
}
