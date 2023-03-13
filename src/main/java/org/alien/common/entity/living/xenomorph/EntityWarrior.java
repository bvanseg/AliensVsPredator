package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.avp.common.api.parasitoidic.IMaturable;
import org.avp.common.world.hive.HiveMember;

public class EntityWarrior extends SpeciesXenomorph implements IMob, IMaturable, HiveMember
{
    public EntityWarrior(World world)
    {
        super(world);
        this.experienceValue = 175;
        this.setSize(1.0F, 2.5F);
        this.tasks.addTask(0, new EntityAISwimming(this));
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
        return AlienSounds.ALIEN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.ALIEN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.ALIEN_DEATH.event();
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
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_WARRIOR);
    }
}
