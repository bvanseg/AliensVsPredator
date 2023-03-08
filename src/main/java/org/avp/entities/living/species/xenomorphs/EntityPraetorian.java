package org.avp.entities.living.species.xenomorphs;

import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IMaturable;
import org.avp.client.Sounds;
import org.avp.entities.living.species.SpeciesXenomorph;
import org.avp.world.hives.rework.HiveMember;

import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPraetorian extends SpeciesXenomorph implements IMaturable, HiveMember
{
    public EntityPraetorian(World world)
    {
        super(world);
        this.experienceValue = 300;
        this.setSize(1.0F, 3.0F);
        
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(100.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(5.0D);
        this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1F);
    }

    @Override
    protected SoundEvent getHurtSound(DamageSource damageSourceIn)
    {
        return Sounds.PRAETORIAN_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.PRAETORIAN_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.PRAETORIAN_DEATH.event();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityMatriarch.class;
    }

    @Override
    public int getMaturityLevel()
    {
        return 1024 * 16;
    }

    @Override
    public int getMaturityTime()
    {
        return (30 * 60) * 20;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerPraetorian);
    }
}
