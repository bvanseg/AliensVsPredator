package org.alien.common.entity.living.xenomorph;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import org.alien.common.AlienItems;
import org.alien.common.entity.ai.selector.EntitySelectorParasitoid;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.entity.living.xenomorph.parasite.EntityFacehugger;
import org.alien.common.entity.living.xenomorph.parasite.EntityRoyalFacehugger;
import org.avp.AVP;
import org.avp.common.EntityItemDrops;
import org.avp.common.network.packet.client.PacketOvamorphContainsFacehugger;
import org.avp.common.world.hive.HiveMember;

import java.util.ArrayList;
import java.util.List;

public class EntityOvamorph extends SpeciesAlien implements IMob, HiveMember
{
    protected boolean                           hasHatched;
    protected boolean                           acceleratedHatching;
    protected int                               hatchWaitTimer;
    protected final int                         maxOpenProgress  = 21;
    protected boolean                           containsFacehugger;
    protected boolean                           sendUpdates;

    private static final DataParameter<Byte>    OPEN_PROGRESS    = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.BYTE);
    private static final DataParameter<Integer> HATCHING_TIME    = EntityDataManager.createKey(EntityOvamorph.class, DataSerializers.VARINT);
    private int                                 timeSinceHatched = 0;

    public EntityOvamorph(World par1World)
    {
        super(par1World);
        this.setSize(1F, 1F);
        this.experienceValue = 10;
        this.hatchWaitTimer = 20 * 3 + (20 * rand.nextInt(5));
        this.containsFacehugger = true;
        this.sendUpdates = true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
        this.getDataManager().register(OPEN_PROGRESS, (byte) -this.maxOpenProgress);
        this.getDataManager().register(HATCHING_TIME, 20 * 30 + (10 * rand.nextInt(24)));
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        this.containsFacehugger = nbt.getBoolean("containsFacehugger");
        this.timeSinceHatched = nbt.getInteger("timeHatched");
        this.setOpenProgress(nbt.getInteger("openProgress"));
        this.sendUpdates = true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        nbt.setBoolean("containsFacehugger", this.containsFacehugger);
        nbt.setInteger("openProgress", this.getOpenProgress());
        nbt.setInteger("timeHatched", this.timeSinceHatched);
    }

    @Override
    public void onLivingUpdate()
    {
        super.onLivingUpdate();
    }

    @Override
    public void onDeath(DamageSource damagesource)
    {
        super.onDeath(damagesource);

        EntityItemDrops.ROYAL_JELLY_GENERIC.tryDrop(this);
    }

    @Override
    public boolean canBreatheUnderwater()
    {
        return true;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();

        if (!this.world.isRemote && this.ticksExisted >= 20 && this.sendUpdates)
        {
            AVP.network().sendToAll(new PacketOvamorphContainsFacehugger(this.containsFacehugger, this.getEntityId()));
            this.sendUpdates = false;
        }

        if (this.getHealth() < this.getMaxHealth())
        {
            this.acceleratedHatching = true;
        }

        if (!this.containsFacehugger)
        {
            this.setOpenProgress(this.getMaxOpenProgress());
            this.hasHatched = true;

            this.timeSinceHatched++;

            if (this.timeSinceHatched >= 20 * 60 * 5)
                this.setDead();
        }

        if (this.containsFacehugger)
        {
            if (this.world.getBlockState(this.getPosition()).getMaterial() != AVP.materials().mist || this.acceleratedHatching)
            {
                int hatchAcceleration = this.acceleratedHatching ? 20 : 1;
                List<EntityLivingBase> potentialHosts = Entities.getEntitiesInCoordsRange(this.world, EntityLivingBase.class, new Pos(this), 8);

                for (EntityLivingBase living : new ArrayList<EntityLivingBase>(potentialHosts))
                {
                    if (!EntitySelectorParasitoid.instance.apply(living))
                    {
                        potentialHosts.remove(living);
                    }
                }

                if (this.hasHatched || potentialHosts.size() > 0)
                {
                    if (this.acceleratedHatching || this.getHatchingTime() <= 0)
                    {
                        this.setOpenProgress(this.getOpenProgress() < (maxOpenProgress) ? this.getOpenProgress() + 1 : this.getOpenProgress());
                    }

                    this.setHatchingTime(this.getHatchingTime() - hatchAcceleration);

                    if (this.getHatchingTime() <= 1 || this.hasHatched)
                    {
                        if (this.hatchWaitTimer-- <= 0)
                        {
                            this.hatch();
                        }
                    }
                }
            }
        }
        else
        {
            if (this.hasHatched)
            {
                this.setOpenProgress(this.getMaxOpenProgress());
            }
        }
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
        if ((entity instanceof EntityPlayer) && !((EntityPlayer) entity).capabilities.isCreativeMode || !(entity instanceof SpeciesAlien) && !(entity instanceof EntityPlayer))
        {
            this.setHatchingTime(0);
        }
    }

    @Override
    protected void damageEntity(DamageSource source, float amount)
    {
        super.damageEntity(source, amount);

        EntityItemDrops.ROYAL_JELLY_SINGLE.tryDrop(this);
    }

    protected void hatch()
    {
        if (!this.world.isRemote)
        {
            EntityFacehugger facehugger = new EntityFacehugger(this.world);
            ;
            Pos pos = new Pos(this).findSafePosAround(this.world);

            if (Entities.getEntitiesInCoordsRange(this.world, EntityMatriarch.class, pos, 50, 50).size() == 0 && Entities.getEntitiesInCoordsRange(this.world, EntityRoyalFacehugger.class, pos, 50, 50).size() == 0 && Entities.getEntitiesInCoordsRange(this.world, EntityQueenChestburster.class, pos, 50, 50).size() == 0)
            {
                if (this.rand.nextInt(3) == 0)
                {
                    facehugger = new EntityRoyalFacehugger(this.world);
                }
            }

            facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, 0F, 0F);
            world.spawnEntity(facehugger);
            facehugger.motionY = 0.75F;
            this.hasHatched = true;
            this.setContainsFacehugger(false);
        }
    }

    public void setHatched(boolean hasHatched)
    {
        this.hasHatched = hasHatched;
    }

    public boolean hasHatched()
    {
        return hasHatched;
    }

    public int getOpenProgress()
    {
        return this.getDataManager().get(OPEN_PROGRESS);
    }

    public void setOpenProgress(int progress)
    {
        this.getDataManager().set(OPEN_PROGRESS, (byte) progress);
    }

    public int getHatchingTime()
    {
        return this.getDataManager().get(HATCHING_TIME);
    }

    public void setHatchingTime(int hatchingTime)
    {
        this.getDataManager().set(HATCHING_TIME, hatchingTime);
    }

    public int getMaxOpenProgress()
    {
        return maxOpenProgress;
    }

    public boolean hasFacehugger()
    {
        return containsFacehugger;
    }

    public void setContainsFacehugger(boolean containsFacehugger)
    {
        this.containsFacehugger = containsFacehugger;
    }

    @Override
    public ItemStack getPickedResult(RayTraceResult target)
    {
        return new ItemStack(AlienItems.SUMMONER_OVAMORPH);
    }
}
