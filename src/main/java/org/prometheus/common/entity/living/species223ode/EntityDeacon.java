package org.prometheus.common.entity.living.species223ode;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.prometheus.common.PrometheusItems;
import org.prometheus.common.entity.ai.brain.DeaconBrain;
import org.prometheus.common.entity.living.Species223ODe;

public class EntityDeacon extends Species223ODe {

    public EntityDeacon(World world)
    {
        super(world);

        this.experienceValue = 100;
        this.jumpMovementFactor = 1.0F;
        this.setSize(0.6F, 1.8F);
    }

    @Override
    public DeaconBrain getBrain() {
        return (DeaconBrain) super.getBrain();
    }

    @Override
    public DeaconBrain createNewBrain() {
        return new DeaconBrain(this);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4700000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(1.75D);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return AlienSounds.PREQUELMORPH_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return AlienSounds.PREQUELMORPH_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return AlienSounds.PREQUELMORPH_DEATH.event();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(PrometheusItems.SUMMONER_DEACON);
    }
}
