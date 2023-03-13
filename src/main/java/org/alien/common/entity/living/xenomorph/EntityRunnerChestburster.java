package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.engineer.EntityEngineer;
import org.avp.common.AVPItems;
import org.avp.common.api.parasitoidic.INascentic;
import org.avp.common.entity.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entity.ai.PatchedEntityAIWander;
import org.avp.common.entity.living.EntityMarine;
import org.avp.common.world.hive.HiveMember;
import org.predator.common.entity.living.yautja.EntityYautjaWarrior;

public class EntityRunnerChestburster extends EntityChestburster implements IMob, INascentic, HiveMember
{
    private Class<? extends Entity> matureState;

    public EntityRunnerChestburster(World world)
    {
        super(world);
        this.matureState = EntityRunnerDrone.class;
        this.setSize(1.0F, 1.0F);
        this.experienceValue = 16;
        
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityPlayer.class, 16.0F, 0.23F, 0.4F));
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityYautjaWarrior.class, 16.0F, 0.23F, 0.4F));
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityEngineer.class, 16.0F, 0.23F, 0.4F));
        this.tasks.addTask(1, new EntityAIAvoidEntity<>(this, EntityMarine.class, 16.0F, 0.23F, 0.4F));
        this.tasks.addTask(3, new EntityAICustomAttackOnCollide(this, 0.800000011920929D, true));
        this.tasks.addTask(8, new PatchedEntityAIWander(this, 0.800000011920929D));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 0.8F));
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
