package org.avp.entities.living.species.species223ode;

import org.avp.ItemHandler;
import org.avp.client.Sounds;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.entities.ai.PatchedEntityAIWander;
import org.avp.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.entities.living.species.Species223ODe;

import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityDeaconAdult extends Species223ODe
{
    public EntityDeaconAdult(World world)
    {
        super(world);

        this.jumpMovementFactor = 0.02F;
        this.experienceValue = 100;
        this.setSize(0.8F, 3.2F);
        this.isDependant = false;
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new PatchedEntityAIWander(this, 0.8D));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityCreature.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityLivingBase.class, 16F));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.6F));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityCreature>(this, EntityCreature.class, 0, false, false, EntitySelectorXenomorph.instance));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 0, false, false, EntitySelectorXenomorph.instance));
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
        return Sounds.PREQUELMORPH_HURT.event();
    }

    @Override
    protected SoundEvent getAmbientSound()
    {
        return Sounds.PREQUELMORPH_LIVING.event();
    }

    @Override
    protected SoundEvent getDeathSound()
    {
        return Sounds.PREQUELMORPH_DEATH.event();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);
    }
    
    @Override
    public void identifyHive()
    {
        ;
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerDeaconAdult);
    }
}
