package org.alien.common.entity.living.species223ode;

import com.asx.mdx.common.minecraft.Pos;
import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.client.AlienSounds;
import org.alien.common.AlienItems;
import org.alien.common.api.parasitoidic.Nascentic;
import org.alien.common.entity.ai.brain.DeaconBrain;
import org.alien.common.entity.living.Species223ODe;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.avp.common.AVPDamageSources;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;

public class EntityDeacon extends Species223ODe implements Nascentic, Brainiac<DeaconBrain>
{
    private DeaconBrain brain;

    public EntityDeacon(World world)
    {
        super(world);

        this.experienceValue = 100;
        this.jumpMovementFactor = 1.0F;
        this.setSize(0.6F, 1.8F);
        this.isDependant = false;
    }

    @Override
    public DeaconBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new DeaconBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
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
    public void onUpdate() {
        super.onUpdate();

        if (!this.world.isRemote) {
            this.brain.update();
        }
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
    public void grow(EntityLivingBase host)
    {
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);
    }

    @Override
    public void vitalize(EntityLivingBase host)
    {
        OrganismImpl organism = (OrganismImpl) host.getCapability(Provider.CAPABILITY, null);
        Pos safeLocation = Entities.getSafeLocationAround(this, new Pos((int) host.posX, (int) host.posY, (int) host.posZ));

        if (safeLocation == null)
        {
            safeLocation = new Pos((int) host.posX, (int) host.posY, (int) host.posZ);
        }

        this.setLocationAndAngles(safeLocation.x(), safeLocation.y(), safeLocation.z(), 0.0F, 0.0F);
        host.world.spawnEntity(this);
        organism.removeEmbryo();
        host.getActivePotionEffects().clear();
        host.attackEntityFrom(AVPDamageSources.causeDeaconBursterDamage(this, host), 100000F);
    }

    @Override
    public void produceJelly()
    {
        if (!this.world.isRemote && this.world.getTotalWorldTime() % 20 == 0)
        {
            this.setJellyLevel(this.getJellyLevel() + 20);
        }
    }
    
    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_DEACON);
    }
}
