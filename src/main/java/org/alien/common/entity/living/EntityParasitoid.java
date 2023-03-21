package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.brain.parasitoid.ParasitoidBrain;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.world.capability.Organism.OrganismImpl;
import org.alien.common.world.capability.Organism.Provider;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.server.PacketAttachParasiteToEntity;
import org.lib.brain.Brainiac;
import org.lib.brain.impl.EntityBrainContext;
import org.lib.brain.impl.profile.BrainProfiles;

import java.util.List;

public class EntityParasitoid extends SpeciesAlien implements IMob, Parasitoid, Brainiac<ParasitoidBrain>
{
    private static final DataParameter<Boolean> FERTILE            = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    private static final DataParameter<Boolean> ATTACHED_TO_HOST   = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    public int                                 timeSinceInfertile = 0;
    public int                                  ticksOnHost        = 0;

    protected ParasitoidBrain brain;

    public EntityParasitoid(World world)
    {
        super(world);
    }

    @Override
    public ParasitoidBrain getBrain() {
        if (!this.world.isRemote && this.brain == null) {
            this.brain = new ParasitoidBrain(this);
        }
        return this.brain;
    }

    @Override
    protected void initEntityAI() {
        this.getBrain().init();
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FERTILE, true);
        this.getDataManager().register(ATTACHED_TO_HOST, false);
    }

    @Override
    protected boolean isMovementBlocked()
    {
        return !isFertile();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote) {
            if (this.isAttachedToHost()) {
                this.brain.setActiveProfile(BrainProfiles.PARASITOID_ATTACHED);
            } else if (!this.isFertile()) {
                this.brain.setActiveProfile(BrainProfiles.PARASITOID_INFERTILE);
            }

            this.brain.update(new EntityBrainContext(this.getBrain(), this));

            this.negateFallDamage();

            if (this.getTicksOnHost() > this.getDetachTime())
            {
                this.detachFromHost();
            }
        }

        // left client-side so the facehugger can stop riding if ATTACHED_TO_HOST is false.
        if (!this.isAttachedToHost() && this.isRiding()) {
            this.detachFromHost();
        }
    }

    @Override
    public int getTicksOnHost()
    {
        return this.ticksOnHost;
    }

    @Override
    public int getDetachTime()
    {
        return (2 * 60) * 20;
    }

    @Override
    public void detachFromHost()
    {
        if(!(this.getRidingEntity() instanceof EntityPlayer) && this.getRidingEntity() instanceof EntityLivingBase) {
            ((EntityLiving) this.getRidingEntity()).setNoAI(false);

            if (this.getRidingEntity() instanceof Brainiac) {
                ((Brainiac<?>)this.getRidingEntity()).setBrainDisabled(false);
            }
        }
        this.dismountRidingEntity();
        this.setNoAI(true);
        this.dataManager.set(ATTACHED_TO_HOST, false);
    }

    @Override
    protected void collideWithNearbyEntities()
    {
        if(this.isFertile()) 
        {
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
            list.forEach(this::collideWithEntity);
        }
    }

    @Override
    public void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);

        if (!this.world.isRemote && this.isFertile() && this.canAttach(entity))
        {
            AVPNetworking.instance.sendToAll(new PacketAttachParasiteToEntity(this.getEntityId(), entity.getEntityId()));
            this.attachToEntity(entity);
        }
    }

    @Override
    public boolean isAttachedToHost()
    {
        return this.dataManager.get(ATTACHED_TO_HOST);
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        return (entity instanceof EntityLivingBase) && EntitySelectorParasitoid.instance.test((EntityLivingBase) entity);
    }

    @Override
    public void attachToEntity(Entity target)
    {
        if (Entities.getEntityRiddenBy(target) == null && target instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) target;

            this.startRiding(living);
            this.dataManager.set(ATTACHED_TO_HOST, true);
            this.implantEmbryo(living);
        }
    }

    @Override
    public void implantEmbryo(EntityLivingBase living)
    {
        OrganismImpl organism = (OrganismImpl) living.getCapability(Provider.CAPABILITY, null);
        organism.impregnate(living);
        if(this.getImplantSound() != null)
            this.playSound(this.getImplantSound(), 0.5F, 1F);
        organism.syncWithClients(living);
        this.setFertility(false);
    }

    @Override
    public boolean isFertile()
    {
        return this.getDataManager().get(FERTILE);
    }

    @Override
    public void setFertility(boolean value)
    {
        this.getDataManager().set(FERTILE, value);
    }

    @Override
    protected boolean canTriggerWalking()
    {
        return false;
    }

    @Override
    public boolean attackEntityFrom(DamageSource source, float attackStrength)
    {
    	if(source == DamageSource.IN_WALL && (this.isAttachedToHost() || !this.isFertile()))
    		return false;
    	
        return super.attackEntityFrom(source, attackStrength);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        return false;
    }

    @Override
    public boolean isPotionApplicable(PotionEffect effect)
    {
        return effect.getPotion() != MobEffects.POISON && super.isPotionApplicable(effect);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        Parasitoid.readFromNBT(this, nbt);
        this.timeSinceInfertile = nbt.getInteger("timeOfInfertility");
        this.dataManager.set(ATTACHED_TO_HOST, nbt.getBoolean("isAttachedToHost"));
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        Parasitoid.writeToNBT(this, nbt);
        nbt.setInteger("timeOfInfertility", this.timeSinceInfertile);
        nbt.setBoolean("isAttachedToHost", this.isAttachedToHost());
        return super.writeToNBT(nbt);
    }
    
    public SoundEvent getImplantSound()
    {
        return null;
    }

    @Override
    public boolean canBreatheUnderwater() {
        return true;
    }
}
