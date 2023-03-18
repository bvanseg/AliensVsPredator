package org.alien.common.entity.living.xenomorph;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.ai.brain.DroneBrain;
import org.alien.common.entity.ai.brain.XenomorphBrain;
import org.alien.common.entity.living.SpeciesXenomorph;
import org.alien.common.world.hive.HiveMember;

public class EntityDrone extends SpeciesXenomorph implements Maturable, HiveMember
{
    public EntityDrone(World world)
    {
        super(world);
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
    }

    @Override
    public XenomorphBrain getBrain() {
        if (this.brain == null) {
            this.brain = new DroneBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.53D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(2.0D);
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityWarrior.class;
    }

    @Override
    public int getMaturityLevel()
    {
        return 1024 * 6;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DRONE);
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
}
