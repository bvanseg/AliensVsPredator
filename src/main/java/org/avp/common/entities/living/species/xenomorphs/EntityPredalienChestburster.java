package org.avp.common.entities.living.species.xenomorphs;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAvoidEntity;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.avp.client.Sounds;
import org.avp.common.ItemHandler;
import org.avp.common.api.parasitoidic.INascentic;
import org.avp.common.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entities.ai.PatchedEntityAIWander;
import org.avp.common.entities.living.EntityMarine;
import org.avp.common.entities.living.species.engineer.EntityEngineer;
import org.avp.common.entities.living.species.yautja.EntityYautjaWarrior;
import org.avp.common.world.hives.rework.HiveMember;

public class EntityPredalienChestburster extends EntityChestburster implements IMob, INascentic, HiveMember
{
    private Class<? extends Entity> matureState;

    public EntityPredalienChestburster(World world)
    {
        super(world);
        this.matureState = EntityPredalien.class;
        this.setSize(1.0F, 0.4F);
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
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.CHESTBURSTER_DEATH.event();
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.CHESTBURSTER_HURT.event();
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return this.matureState;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }

    @Override
    public int getMaturityLevel()
    {
        return 12800;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerPredalienBurster);
    }
}
