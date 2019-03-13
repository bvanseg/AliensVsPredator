package org.avp.entities.living;

import org.avp.DamageSources;
import org.avp.api.parasitoidic.INascentic;
import org.avp.client.Sounds;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityDeacon extends EntitySpecies223ODe implements INascentic
{
    public EntityDeacon(World world)
    {
        super(world);

        this.jumpMovementFactor = 0.02F;
        this.experienceValue = 100;
        this.setSize(0.8F, 1.8F);
        // this.ableToClimb = false;
        this.isDependant = false;

        this.tasks.addTask(0, new EntityAISwimming(this));

//         this.addStandardXenomorphAISet();
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
        return;
    }

    @Override
    public Class<? extends Entity> getMatureState()
    {
        return EntityDeaconAdult.class;
    }

    @Override
    public int getMaturityTime()
    {
        return (15 * 60) * 20;
    }

    @Override
    public int getMaturityLevel()
    {
        return 6400;
    }

    @Override
    public void grow(EntityLivingBase host)
    {
        Organism organism = (Organism) host.getCapability(Provider.CAPABILITY, null);
    }

    @Override
    public void vitalize(EntityLivingBase host)
    {
        Organism organism = (Organism) host.getCapability(Provider.CAPABILITY, null);
        Pos safeLocation = Entities.getSafeLocationAround(this, new Pos((int) host.posX, (int) host.posY, (int) host.posZ));

        if (safeLocation == null)
        {
            safeLocation = new Pos((int) host.posX, (int) host.posY, (int) host.posZ);
        }

        this.setLocationAndAngles(safeLocation.x(), safeLocation.y(), safeLocation.z(), 0.0F, 0.0F);
        host.world.spawnEntity(this);
        organism.removeEmbryo();
        host.getActivePotionEffects().clear();
        host.attackEntityFrom(DamageSources.causeDeaconBursterDamage(this, host), 100000F);
    }
}
