package org.avp.entities.ai.alien;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.entities.living.species.SpeciesXenomorph;

import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityAIFindJelly extends EntityAIBase
{

    private SpeciesXenomorph xenomorph;
    private World            world;
    private boolean          hasPickedUpJelly;

    public EntityAIFindJelly(SpeciesXenomorph xenomorph)
    {
        super();
        this.xenomorph = xenomorph;
        this.world = xenomorph.world;
        this.hasPickedUpJelly = false;
    }

    @Override
    public boolean shouldExecute()
    {
        return xenomorph.getAttackTarget() == null;
    }

    @Override
    public void startExecuting()
    {
        super.startExecuting();
    }

    @Override
    public boolean shouldContinueExecuting()
    {
        return xenomorph.getAttackTarget() == null && !this.hasPickedUpJelly;
    }

    @Override
    public void resetTask()
    {
        super.resetTask();
        this.hasPickedUpJelly = false;
    }

    @Override
    public void updateTask()
    {
        super.updateTask();
        int range = 8;
        ArrayList<EntityItem> entityItemList = (ArrayList<EntityItem>) world.getEntitiesWithinAABB(EntityItem.class, new AxisAlignedBB(this.xenomorph.getPosition().add(-range, -8, -range), this.xenomorph.getPosition().add(range, 8, range)));

        if (!entityItemList.isEmpty())
        {
            EntityItem randomJelly = entityItemList.get(this.xenomorph.getRNG().nextInt(entityItemList.size()));

            if (!randomJelly.cannotPickup())
            {
                ItemStack stack = randomJelly.getItem();

                if (stack.getItem() == AliensVsPredator.items().itemRoyalJelly)
                {
                    if (this.xenomorph.canMoveToJelly() && this.xenomorph.isDependantOnHive())
                    {
                        this.xenomorph.getNavigator().setPath(this.xenomorph.getNavigator().getPathToEntityLiving(randomJelly), 1);
                    }

                    if (this.xenomorph.getDistanceSq(randomJelly) <= 1)
                    {
                        this.onPickupJelly(randomJelly);
                        this.hasPickedUpJelly = true;
                    }
                }
            }
        }
    }

    private void onPickupJelly(EntityItem entityItem)
    {
        this.xenomorph.setJellyLevel(this.xenomorph.getJellyLevel() + (entityItem.getItem().getCount() * 100));
        entityItem.setDead();
    }
}
