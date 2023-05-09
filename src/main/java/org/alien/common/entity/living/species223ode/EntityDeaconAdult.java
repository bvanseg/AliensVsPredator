package org.alien.common.entity.living.species223ode;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.brain.DeaconAdultBrain;
import org.alien.common.entity.living.Species223ODe;

public class EntityDeaconAdult extends Species223ODe
{

    public EntityDeaconAdult(World world)
    {
        super(world);

        this.jumpMovementFactor = 0.02F;
        this.experienceValue = 100;
        this.setSize(0.8F, 3.2F);
    }

    @Override
    public DeaconAdultBrain getBrain() {
        return (DeaconAdultBrain) super.getBrain();
    }

    @Override
    public DeaconAdultBrain createNewBrain() {
        return new DeaconAdultBrain(this);
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4700000238418579D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(3D);
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
        return new ItemStack(AlienItems.SUMMONER_DEACON_ADULT);
    }
}
