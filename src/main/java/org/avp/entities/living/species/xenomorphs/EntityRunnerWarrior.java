package org.avp.entities.living.species.xenomorphs;

import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IMaturable;
import org.avp.world.hives.rework.HiveMember;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityRunnerWarrior extends EntityWarrior implements IMaturable, HiveMember
{
    public EntityRunnerWarrior(World world)
    {
        super(world);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();

        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(40.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6D);
    }
    
    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityCrusher.class;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerRunnerWarrior);
    }
}
