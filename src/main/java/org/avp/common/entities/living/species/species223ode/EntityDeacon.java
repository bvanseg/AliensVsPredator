package org.avp.common.entities.living.species.species223ode;

import org.avp.common.DamageSources;
import org.avp.common.ItemHandler;
import org.avp.common.api.parasitoidic.INascentic;
import org.avp.client.Sounds;
import org.avp.common.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.common.entities.ai.PatchedEntityAIWander;
import org.avp.common.entities.ai.alien.EntitySelectorXenomorph;
import org.avp.common.entities.living.species.Species223ODe;
import org.avp.common.world.capabilities.IOrganism.Organism;
import org.avp.common.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
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

public class EntityDeacon extends Species223ODe implements INascentic
{
    public EntityDeacon(World world)
    {
        super(world);

        this.experienceValue = 100;
        this.jumpMovementFactor = 1.0F;
        this.setSize(0.6F, 1.8F);
        this.isDependant = false;
    }
    
    @Override
    protected void initEntityAI() {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(1, new PatchedEntityAIWander(this, 0.8D));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityLiving.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAICustomAttackOnCollide(this, EntityPlayer.class, 1.0D, false));
        this.tasks.addTask(2, new EntityAIWatchClosest(this, EntityLivingBase.class, 16F));
        this.tasks.addTask(3, new EntityAILeapAtTarget(this, 0.6F));
        this.targetTasks.addTask(0, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityLiving>(this, EntityLiving.class, 0, false, false, EntitySelectorXenomorph.instance));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget<EntityPlayer>(this, EntityPlayer.class, 0, false, false, EntitySelectorXenomorph.instance));
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

    @Override
    public void produceJelly()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getTotalWorldTime() % 20 == 0)
            {
                this.setJellyLevel(this.getJellyLevel() + 20);
            }
        }
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(ItemHandler.summonerDeacon);
    }
}
