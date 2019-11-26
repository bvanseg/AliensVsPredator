package org.avp.entities.living.species.xenomorphs;

import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IMaturable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRunnerDrone extends EntityDrone implements IMaturable
{
    public EntityRunnerDrone(World world)
    {
        super(world);
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(20.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.63D);
    }
    
    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityRunnerWarrior.class;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerRunnerDrone);
    }
}
