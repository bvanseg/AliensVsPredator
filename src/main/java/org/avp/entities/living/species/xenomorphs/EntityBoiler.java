package org.avp.entities.living.species.xenomorphs;

import org.avp.ItemHandler;
import org.avp.client.Sounds;
import org.avp.entities.living.species.SpeciesXenomorph;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityBoiler extends SpeciesXenomorph
{
    public EntityBoiler(World world)
    {
        super(world);
        this.experienceValue = 275;
        this.setSize(1.0F, 3.0F);
        
        
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.addStandardXenomorphAISet();
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(30.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5500000238418579D);
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
    public int getTotalArmorValue()
    {
        return 2;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.Experimental.summonerBoiler);
    }
}
