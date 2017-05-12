package org.avp.entities.living;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.avp.api.parasitoidic.IHost;
import org.avp.api.parasitoidic.IParasitoid;
import org.avp.entities.EntityLiquidPool;
import org.avp.entities.ai.EntityAICustomAttackOnCollide;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.arisux.mdxlib.lib.world.entity.Entities;
import com.google.common.base.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAILeapAtTarget;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityGolem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntitySnowman;
import net.minecraft.entity.monster.EntitySpider;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityParasitoid extends EntitySpeciesAlien implements IMob, IParasitoid
{
    private static final DataParameter<Boolean> FERTILE          = EntityDataManager.createKey(EntityParasitoid.class, DataSerializers.BOOLEAN);
    private int                                 ticksOnHost;

    public static Predicate<EntityLivingBase>   parasiteSelector = new Predicate<EntityLivingBase>()
                                                                 {
                                                                     @Override
                                                                     public boolean apply(EntityLivingBase potentialTarget)
                                                                     {
                                                                         Organism organism = (Organism) potentialTarget.getCapability(Provider.CAPABILITY, null);

                                                                         if (potentialTarget instanceof IHost)
                                                                         {
                                                                             IHost host = (IHost) potentialTarget;

                                                                             if (!host.canHostParasite() || !host.canParasiteAttach())
                                                                             {
                                                                                 return false;
                                                                             }
                                                                         }

                                                                         if (potentialTarget instanceof EntityLiquidPool)
                                                                         {
                                                                             return false;
                                                                         }

                                                                         if (potentialTarget instanceof IParasitoid)
                                                                         {
                                                                             return false;
                                                                         }

                                                                         if (organism != null && organism.hasEmbryo())
                                                                         {
                                                                             return false;
                                                                         }

                                                                         if (potentialTarget instanceof EntityPlayer && ((EntityPlayer) potentialTarget).capabilities.isCreativeMode)
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

                                                                         if (potentialTarget instanceof EntitySpeciesAlien)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntitySnowman)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntityGolem)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntitySkeleton)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntityZombie)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntitySpider)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntitySilverfish)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntityPigZombie)
                                                                             return false;

                                                                         if (potentialTarget instanceof EntityGhast)
                                                                             return false;

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
//        this.targetTasks.addTask(3, new EntityAINearestAttackableTarget(this, Entity.class, 0, false, false, this.getEntitySelector()));
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

        if (this.world.getWorldTime() % 20 == 0)
        {
            if (isFertile())
            {
                ArrayList<EntityLivingBase> targetHosts = (ArrayList<EntityLivingBase>) world.getEntitiesWithinAABB(EntityLivingBase.class, this.getEntityBoundingBox().expand(1.0D, 16.0D, 1.0D), parasiteSelector);

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

                living.motionX = 0;
                living.motionZ = 0;
                this.rotationYawHead = living.rotationYawHead;
                this.rotationYaw = living.rotationYaw;
                this.prevRotationYawHead = living.prevRotationYawHead;
                this.prevRotationYaw = living.prevRotationYaw;
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
        return this.world.getWorldTime() % this.getJellyProductionRate() == 0 && this.isFertile() && this.getJellyLevel() <= 256;
    }

    @Override
    public Predicate<EntityLivingBase> getEntitySelector()
    {
        return EntityParasitoid.parasiteSelector;
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
        this.dismountRidingEntity();
        this.targetTasks.taskEntries.clear();
        this.tasks.taskEntries.clear();
    }

    @Override
    public boolean canMoveToJelly()
    {
        return false;
    }

    @Override
    protected void collideWithNearbyEntities()
    {
        List<Entity> list = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(0.20000000298023224D, 0.0D, 0.20000000298023224D));

        if (list != null && !list.isEmpty())
        {
            for (int i = 0; i < list.size(); ++i)
            {
                Entity entity = (Entity) list.get(i);

                this.collideWithEntity(entity);
            }
        }
    }

    @Override
    public void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);

        if (this.isFertile() && this.canAttach(entity))
        {
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
            return parasiteSelector.apply((EntityLivingBase) entity);
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
        return super.attackEntityFrom(source, attackStrength);
    }

    @Override
    public boolean attackEntityAsMob(Entity entity)
    {
        return false;
    }

    public boolean isPotionApplicable(PotionEffect effect)
    {
        return effect.getPotion() == MobEffects.POISON ? false : super.isPotionApplicable(effect);
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        boolean isFertile = nbt.getInteger("IsFertile") == 1;
        this.setFertility(isFertile);
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        // TODO Auto-generated method stub
        super.writeEntityToNBT(nbt);
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        nbt.setInteger("IsFertile", this.isFertile() ? 1 : 0);
        return super.writeToNBT(nbt);
    }
}
