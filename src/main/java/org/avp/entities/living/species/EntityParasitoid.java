package org.avp.entities.living.species;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.ItemHandler;
import org.avp.api.parasitoidic.IHost;
import org.avp.api.parasitoidic.IParasitoid;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.packets.server.PacketAttachParasiteToEntity;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.entity.Entities;
import com.asx.mdx.lib.world.entity.player.inventory.Inventories;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.world.World;

public class EntityParasitoid extends SpeciesAlien implements IMob, IParasitoid
{
    private static final DataParameter<Boolean> FERTILE            = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    private int                                 ticksOnHost        = 0;

    public static ArrayList<Item>               blacklistedHelmets = new ArrayList();

    static
    {
        blacklistedHelmets.add(ItemHandler.helmTitanium);
        blacklistedHelmets.add(ItemHandler.mk50helmet);
    }

    public static Predicate<EntityLivingBase> impregnationSelector = new Predicate<EntityLivingBase>() {
                                                                         @Override
                                                                         public boolean apply(EntityLivingBase potentialTarget)
                                                                         {
                                                                             ArrayList<Class<?>> blacklist = IParasitoid.getDefaultEntityBlacklist();

                                                                             for (Class<?> c : blacklist)
                                                                             {
                                                                                 if (c.isInstance(potentialTarget))
                                                                                 {
                                                                                     return false;
                                                                                 }
                                                                             }

                                                                             Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

                                                                             if (potentialTarget instanceof IHost)
                                                                             {
                                                                                 IHost host = (IHost) potentialTarget;

                                                                                 if (!host.canHostParasite() || !host.canParasiteAttach())
                                                                                 {
                                                                                     return false;
                                                                                 }
                                                                             }

                                                                             if (organism != null && organism.hasEmbryo())
                                                                             {
                                                                                 return false;
                                                                             }

                                                                             if (potentialTarget instanceof EntityPlayer)
                                                                             {
                                                                                 EntityPlayer player = (EntityPlayer) potentialTarget;
                                                                                 ItemStack headwear = Inventories.getHelmSlotItemStack(player);

                                                                                 if (headwear != null && blacklistedHelmets.contains(headwear.getItem()) || ((EntityPlayer) potentialTarget).capabilities.isCreativeMode)
                                                                                 {
                                                                                     return false;
                                                                                 }
                                                                             }
                                                                             
                                                                             if (!(potentialTarget instanceof EntityLivingBase))
                                                                             {
                                                                                 return false;
                                                                             }

                                                                             if (potentialTarget instanceof EntityLiving)
                                                                             {
                                                                                 EntityLiving living = (EntityLiving) potentialTarget;

                                                                                 if (living.isChild())
                                                                                 {
                                                                                     return false;
                                                                                 }
                                                                             }

                                                                             return true;
                                                                         }
                                                                     };

    public EntityParasitoid(World world)
    {
        super(world);
        this.addTasks();
    }

    protected void addTasks()
    {
        this.tasks.addTask(0, new EntityAISwimming(this));
        this.tasks.addTask(3, new EntityAICustomAttackOnCollide(this, 0.55D, true));
        this.tasks.addTask(8, new EntityAIWander(this, 0.55D));
        this.targetTasks.addTask(2, new EntityAILeapAtTarget(this, 0.8F));
        // this.targetTasks.addTask(3, new EntityAINearestAttackableTarget<>(this, Entity.class, 0, false, false, this.getEntitySelector()));
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
        
        if(this.getAttackTarget() != null && !EntityParasitoid.impregnationSelector.apply(this.getAttackTarget()))
            this.setAttackTarget(null);
        
        if (!this.isFertile())
        {
            this.setNoAI(true);

            this.motionY -= 0.05F;
            this.motionY *= 0.98F;
            this.move(MoverType.SELF, 0, this.motionY, 0);
        }

        if (this.world.getTotalWorldTime() % 20 == 0)
        {
            if (isFertile())
            {
                ArrayList<EntityLivingBase> targetHosts = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(1.0D, 16.0D, 1.0D), this.getImpregnationEntitiySelector());

                if (targetHosts != null && targetHosts.size() > 0)
                {
                    Collections.sort(targetHosts, new EntityAINearestAttackableTarget.Sorter(this));

                    EntityLivingBase targetHost = targetHosts.get(0);
                    this.setAttackTarget(targetHost);

                    if (!targetHosts.contains(this.getAttackTarget()))
                    {
                        this.setAttackTarget(null);
                    }
                }
            }
        }

        this.negateFallDamage();

        if (this.isAttachedToHost())
        {
            this.ticksOnHost++;

            if (this.getRidingEntity() instanceof EntityLiving)
            {
                EntityLiving living = (EntityLiving) this.getRidingEntity();

                living.setNoAI(true);
                
                living.motionY -= 0.05F;
                living.motionY *= 0.98F;
                living.move(MoverType.SELF, 0, living.motionY, 0);

                this.rotationYawHead = living.rotationYawHead;
                this.rotationYaw = living.rotationYaw;
                this.prevRotationYawHead = living.prevRotationYawHead;
                this.prevRotationYaw = living.prevRotationYaw;
            }
            
            if(this.getRidingEntity() instanceof EntityPlayer && ((EntityPlayer)this.getRidingEntity()).capabilities.isCreativeMode)
            {
                Organism organism = (Organism) this.getRidingEntity().getCapability(Provider.CAPABILITY, null);
                organism.removeEmbryo();
                this.detachFromHost();
            }
        }

        if (this.getTicksOnHost() > this.getDetachTime())
        {
            this.detachFromHost();
        }
    }

    @Override
    public boolean canProduceJelly()
    {
        return this.world.getTotalWorldTime() % this.getJellyProductionRate() == 0 && this.isFertile() && this.getJellyLevel() <= 256;
    }

    @Override
    public Predicate<EntityLivingBase> getImpregnationEntitiySelector()
    {
        return EntityParasitoid.impregnationSelector;
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
        if(!(this.getRidingEntity() instanceof EntityPlayer) && this.getRidingEntity() instanceof EntityLivingBase)
            ((EntityLiving) this.getRidingEntity()).setNoAI(false);
        this.dismountRidingEntity();
        this.setNoAI(true);
    }

    @Override
    public boolean canMoveToJelly()
    {
        return false;
    }

    @Override
    protected void collideWithNearbyEntities()
    {
        if(this.isFertile()) 
        {
            List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox());
    
            if (list != null && !list.isEmpty())
            {
                for (int i = 0; i < list.size(); ++i)
                {
                    Entity entity = list.get(i);
    
                    this.collideWithEntity(entity);
                }
            }
        }
    }

    @Override
    public void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);

        if (!this.world.isRemote && this.isFertile() && this.canAttach(entity))
        {
            AliensVsPredator.network().sendToAll(new PacketAttachParasiteToEntity(this.getEntityId(), entity.getEntityId()));
            this.attachToEntity(entity);
        }
    }

    @Override
    public boolean isAttachedToHost()
    {
        return this.isRiding();
    }

    @Override
    public boolean canAttach(Entity entity)
    {
        if (entity instanceof EntityLivingBase)
        {
            return impregnationSelector.apply((EntityLivingBase) entity);
        }

        return false;
    }

    @Override
    public void attachToEntity(Entity target)
    {
        if (Entities.getEntityRiddenBy(target) == null && target instanceof EntityLivingBase)
        {
            EntityLivingBase living = (EntityLivingBase) target;

            this.startRiding(living);
            this.implantEmbryo(living);
        }
    }

    @Override
    public void implantEmbryo(EntityLivingBase living)
    {
        Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);
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
        return effect.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(effect);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        IParasitoid.readFromNBT(this, nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        IParasitoid.writeToNBT(this, nbt);
        return super.writeToNBT(nbt);
    }
    
    public SoundEvent getImplantSound()
    {
        return null;
    }
}
