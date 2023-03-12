package org.alien.common.entity.living.xenomorphs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.common.ItemHandler;
import org.avp.common.api.parasitoidic.IMaturable;
import org.avp.common.world.hive.HiveMember;

public class EntityRunnerDrone extends EntityDrone implements IMaturable, HiveMember
{
    public EntityRunnerDrone(World world)
    {
        super(world);
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
