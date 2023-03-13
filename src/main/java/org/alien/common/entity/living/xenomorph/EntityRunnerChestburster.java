package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.INascentic;
import org.alien.common.world.hive.HiveMember;

public class EntityRunnerChestburster extends EntityChestburster implements IMob, INascentic, HiveMember
{
    private Class<? extends Entity> matureState;

    public EntityRunnerChestburster(World world)
    {
        super(world);
        this.matureState = EntityRunnerDrone.class;
        this.setSize(1.0F, 1.0F);
        this.experienceValue = 16;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(14.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.6499999761581421D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(32.0D);
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return this.matureState;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_RUNNER_BURSTER);
    }
}
