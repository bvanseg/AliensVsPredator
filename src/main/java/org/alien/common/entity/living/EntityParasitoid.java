package org.alien.common.entity.living;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
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
import org.alien.common.api.emybro.EmbryoEntry;
import org.alien.common.api.emybro.EmbryoKey;
import org.alien.common.api.emybro.EmbryoRegistry;
import org.alien.common.api.parasitoidic.Parasitoid;
import org.alien.common.entity.ai.brain.parasitoid.ParasitoidBrain;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.AVPNetworking;
import org.avp.common.network.packet.client.PacketDismountRidingEntity;
import org.avp.common.network.packet.server.PacketAttachParasiteToEntity;
import org.lib.brain.Brainiac;

import java.util.List;

public class EntityParasitoid extends SpeciesAlien implements Parasitoid
{
    private static final DataParameter<Boolean> FERTILE = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    public int timeSinceInfertile = 0;
    public int ticksOnHost = 0;

    public EntityParasitoid(World world)
    {
        super(world);
    }

    @Override
    public ParasitoidBrain getBrain() {
        return (ParasitoidBrain) super.getBrain();
    }

    @Override
    public ParasitoidBrain createNewBrain() {
        return new ParasitoidBrain(this);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(FERTILE, true);
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
            this.negateFallDamage();

            if (this.getTicksOnHost() > this.getDetachTime())
            {
                this.detachFromHost();
            }

            // Keep attempting to implant an embryo so long as the parasite is fertile.
            if (this.isAttachedToHost() && this.isFertile()) {
                this.implantEmbryo((EntityLivingBase) this.getRidingEntity());
            }
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

        if (!this.world.isRemote) {
            AVPNetworking.instance.sendToAll(new PacketDismountRidingEntity(this.getEntityId()));
        }
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
        return this.isRiding() && this.getRidingEntity() instanceof EntityLivingBase;
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        return (entity instanceof EntityLivingBase) && EntitySelectorParasitoid.instance.test(entity);
    }

    @Override
    public void attachToEntity(Entity target)
    {
        if (Entities.getEntityRiddenBy(target) == null && target instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) target;
            this.startRiding(living);
        }
    }

    @Override
    public void implantEmbryo(EntityLivingBase living)
    {
        OrganismImpl organism = (OrganismImpl) living.getCapability(Provider.CAPABILITY, null);
        EmbryoKey embryoKey = new EmbryoKey(this, living);
        EmbryoEntry embryoEntry = EmbryoRegistry.getEntry(embryoKey);
        organism.setEmbryo(embryoEntry.create(embryoKey));
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

    private static final String TICKS_ON_HOST_NBT_KEY = "ticksOnHost";
    private static final String TIME_SINCE_INFERTILE_NBT_KEY = "timeOfInfertility";

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        Parasitoid.readFromNBT(this, nbt);
        this.ticksOnHost = nbt.getInteger(TICKS_ON_HOST_NBT_KEY);
        this.timeSinceInfertile = nbt.getInteger(TIME_SINCE_INFERTILE_NBT_KEY);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        Parasitoid.writeToNBT(this, nbt);
        nbt.setInteger(TICKS_ON_HOST_NBT_KEY, this.ticksOnHost);
        nbt.setInteger(TIME_SINCE_INFERTILE_NBT_KEY, this.timeSinceInfertile);
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

    @Override
    public void onDeath(DamageSource damageSource)
    {
        if (this.getRidingEntity() != null && this.getRidingEntity() instanceof EntityLiving)
        {
            EntityLiving living = (EntityLiving) this.getRidingEntity();
            living.setNoAI(false);

            if (living instanceof Brainiac) {
                ((Brainiac)living).setBrainDisabled(false);
            }
        }

        super.onDeath(damageSource);
    }
}
