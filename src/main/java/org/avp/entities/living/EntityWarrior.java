package org.avp.entities.living;

import org.avp.api.parasitoidic.IMaturable;
import org.avp.client.Sounds;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityWarrior extends EntityXenomorph implements IMob, IMaturable
{
    public EntityWarrior(World world)
    {
        super(world);
        this.experienceValue = 175;
        this.setSize(1.0F, 2.5F);
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(50.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(4.0D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.ALIEN_DEATH.event();
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityPraetorian.class;
    }

    @Override
    public int getMaturityLevel()
    {
        return 1024 * 12;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }
}
