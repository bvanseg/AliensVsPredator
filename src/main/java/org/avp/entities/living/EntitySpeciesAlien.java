package org.avp.entities.living;

import java.util.ArrayList;
import java.util.UUID;

import org.avp.AliensVsPredator;
import org.avp.DamageSources;
import org.avp.api.parasitoidic.IMaturable;
import org.avp.api.parasitoidic.IRoyalOrganism;
import org.avp.entities.EntityAcidPool;
import org.avp.world.hives.HiveHandler;
import org.avp.world.hives.XenomorphHive;

import com.arisux.mdxlib.lib.world.Worlds;
import com.arisux.mdxlib.lib.world.entity.Entities;
import com.arisux.mdxlib.lib.world.entity.ItemDrop;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.IMob;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public abstract class EntitySpeciesAlien extends EntityMob implements IMob, IRoyalOrganism
{
    private static final DataParameter<Integer> JELLY_LEVEL = EntityDataManager.createKey(EntitySpeciesAlien.class, DataSerializers.VARINT);
    protected XenomorphHive hive;
    private UUID            signature;
    protected boolean       jellyLimitOverride;

    public EntitySpeciesAlien(World world)
    {
        super(world);
        this.jumpMovementFactor = 0.2F;
        this.jellyLimitOverride = false;
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(JELLY_LEVEL, this.getJellyLevelStart());
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        nbt.setString("HiveSignature", signature != null ? this.signature.toString() : "");
        nbt.setInteger("JellyLevel", this.getJellyLevel());
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        this.signature = Worlds.uuidFromNBT(nbt, "HiveSignature");
        this.setJellyLevel(nbt.getInteger("JellyLevel"));
    }

    @Override
    public void onKillEntity(EntityLivingBase entity)
    {
        super.onKillEntity(entity);
        this.setJellyLevel(this.getJellyLevel() + 250);
    }

    @Override
    protected boolean canDespawn()
    {
        return false;
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        if (!this.world.isRemote)
        {
            if (damagesource != DamageSource.onFire && damagesource != DamageSource.inFire && damagesource != DamageSources.flamethrower)
            {
                EntityAcidPool entity = new EntityAcidPool(this.world);
                entity.setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
                this.world.spawnEntity(entity);
            }

            int adjustedLevel = this.getJellyLevel() / 4;

            if (!this.jellyLimitOverride)
            {
                adjustedLevel = adjustedLevel < 64 ? adjustedLevel : 64;
            }

            ItemDrop dynamicJelly = new ItemDrop(100, new ItemStack(AliensVsPredator.items().itemRoyalJelly, adjustedLevel));
            dynamicJelly.tryDrop(this);
        }
    }

    public boolean isReadyToMature(IRoyalOrganism jellyProducer)
    {
        IMaturable maturable = (IMaturable) this;
        IRoyalOrganism ro = (IRoyalOrganism) this;
        return maturable.getMatureState() != null && maturable.getMaturityLevel() > 0 && ro.getJellyLevel() >= maturable.getMaturityLevel();
    }

    public void mature()
    {
        IMaturable maturable = (IMaturable) this;
        EntitySpeciesAlien alien = (EntitySpeciesAlien) Entities.constructEntity(this.world, maturable.getMatureState());
        NBTTagCompound tag = new NBTTagCompound();

        alien.setLocationAndAngles(this.posX, this.posY, this.posZ, 0.0F, 0.0F);
        this.world.spawnEntity(alien);
        this.writeEntityToNBT(tag);
        alien.readEntityFromNBT(tag);
        alien.setJellyLevel(this.getJellyLevel() - maturable.getMaturityLevel());
        // TODO: Create a shell of the original entity.
        this.setDead();
    }

    @SuppressWarnings("unchecked")
    protected void findRoyalJelly()
    {
        if (!this.world.isRemote && this.world.getWorldTime() % 40 == 0)
        {
            ArrayList<EntityItem> entityItemList = (ArrayList<EntityItem>) world.getEntitiesWithinAABB(EntityItem.class, this.getEntityBoundingBox().expand(8, 8, 8));

            for (EntityItem entityItem : entityItemList)
            {
                if (!entityItem.cannotPickup())
                {
                    ItemStack stack = entityItem.getEntityItem();

                    if (stack.getItem() == AliensVsPredator.items().itemRoyalJelly)
                    {
                        if (this.canMoveToJelly())
                        {
                            this.getNavigator().setPath(this.getNavigator().getPathToEntityLiving(entityItem), 1);
                        }

                        if (this.getDistanceToEntity(entityItem) <= 1)
                        {
                            this.onPickupJelly(entityItem);
                        }
                        break;
                    }
                }
            }

            entityItemList.clear();
            entityItemList = null;
        }
    }

    public UUID getHiveSignature()
    {
        return this.signature;
    }

    public void setHiveSignature(UUID signature)
    {
        this.signature = signature;
    }

    public boolean canMoveToJelly()
    {
        return !(this instanceof EntityOvamorph);
    }

    protected void onPickupJelly(EntityItem entityItem)
    {
        this.setJellyLevel(this.getJellyLevel() + (entityItem.getEntityItem().stackSize * 100));
        entityItem.setDead();
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (this.canProduceJelly())
        {
            this.produceJelly();
        }

        if (this instanceof IMaturable)
        {
            IMaturable maturable = (IMaturable) this;

            if (!this.world.isRemote)
            {
                if (this.world.getWorldTime() % 20 == 0)
                {
                    if (maturable.isReadyToMature(this))
                    {
                        maturable.mature();
                    }
                }
            }
        }

        this.identifyHive();
        this.findRoyalJelly();
    }

    @Override
    public boolean canProduceJelly()
    {
        return this.world.getWorldTime() % this.getJellyProductionRate() == 0;
    }

    @Override
    public int getJellyProductionRate()
    {
        return 8 * 20;
    }

    @Override
    public void produceJelly()
    {
        if (!this.world.isRemote)
        {
            if (this.world.getWorldTime() % 20 == 0)
            {
                this.setJellyLevel(this.getJellyLevel() + 20);
            }
        }
    }

    public XenomorphHive getHive()
    {
        return hive;
    }

    public void identifyHive()
    {
        if (!(this instanceof EntityQueen))
        {
            if (this.signature != null)
            {
                this.hive = HiveHandler.instance.getHiveForUUID(this.signature);
            }

            if (this.hive != null)
            {
                this.hive.addMemberToHive(this);
            }
        }
    }

    @Override
    public int getJellyLevel()
    {
        return this.getDataManager().get(JELLY_LEVEL);
    }

    @Override
    public void setJellyLevel(int level)
    {
        this.getDataManager().set(JELLY_LEVEL, level);
    }

    @Override
    public boolean isCreatureType(EnumCreatureType type, boolean forSpawnCount)
    {
        return type == EnumCreatureType.MONSTER ? true : false;
    }

    protected void negateFallDamage()
    {
        this.fallDistance = 0F;
    }

    protected int getJellyLevelStart()
    {
        return 0;
    }
}
