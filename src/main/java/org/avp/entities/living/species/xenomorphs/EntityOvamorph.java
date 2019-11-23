package org.avp.entities.living.species.xenomorphs;

import java.util.ArrayList;
import java.util.List;

import org.avp.AliensVsPredator;
import org.avp.EntityItemDrops;
import org.avp.entities.living.species.EntityParasitoid;
import org.avp.entities.living.species.SpeciesAlien;
import org.avp.entities.living.species.xenomorphs.parasites.EntityFacehugger;
import org.avp.packets.client.PacketOvamorphContainsFacehugger;

import com.asx.mdx.lib.world.Pos;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityOvamorph extends SpeciesAlien implements IMob
{
    protected int hatchingTime;
    protected boolean hasHatched;
    protected boolean acceleratedHatching;
    protected int openProgress;
    protected int hatchWaitTimer;
    protected final int maxOpenProgress = 21;
    protected boolean containsFacehugger;
    protected boolean sendUpdates;

    public EntityOvamorph(World par1World)
    {
        super(par1World);
        this.setSize(1F, 1F);
        this.hatchingTime = 20 * 30 + (10 * rand.nextInt(24));
        this.experienceValue = 10;
        this.openProgress = -maxOpenProgress;
        this.hatchWaitTimer = 20 * 3 + (20 * rand.nextInt(5));
        this.containsFacehugger = true;
        this.sendUpdates = true;
    }

    @Override
    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(8.0D);
    }

    @Override
    protected void entityInit()
    {
        super.entityInit();
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound nbt)
    {
        super.readEntityFromNBT(nbt);

        this.containsFacehugger = nbt.getBoolean("containsFacehugger");
        this.openProgress = nbt.getInteger("openProgress");
        this.sendUpdates = true;
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound nbt)
    {
        super.writeEntityToNBT(nbt);

        nbt.setBoolean("containsFacehugger", this.containsFacehugger);
        nbt.setInteger("openProgress", this.openProgress);
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
            AliensVsPredator.network().sendToAll(new PacketOvamorphContainsFacehugger(this.containsFacehugger, this.getEntityId()));
            this.sendUpdates = false;
        }

        if (this.getHealth() < this.getMaxHealth())
        {
            this.acceleratedHatching = true;
        }

        if (!this.containsFacehugger)
        {
            this.openProgress = this.getMaxOpenProgress();
        }

        if (this.containsFacehugger)
        {
            if (this.world.getBlockState(this.getPosition()).getMaterial() != AliensVsPredator.materials().mist || this.acceleratedHatching)
            {
                int hatchAcceleration = this.acceleratedHatching ? 20 : 1;
                List<EntityLivingBase> potentialHosts = Entities.getEntitiesInCoordsRange(this.world, EntityLivingBase.class, new Pos(this), 8);

                for (EntityLivingBase living : new ArrayList<EntityLivingBase>(potentialHosts))
                {
                    if (!EntityParasitoid.impregnationSelector.apply(living))
                    {
                        potentialHosts.remove(living);
                    }
                }

                if (this.hasHatched || potentialHosts.size() > 0)
                {
                    if (this.acceleratedHatching || this.hatchingTime <= 0)
                    {
                        this.openProgress = this.openProgress < (maxOpenProgress) ? openProgress + 1 : this.openProgress;
                    }

                    if ((this.hatchingTime -= hatchAcceleration) <= 1 || this.hasHatched)
                    {
                        if (this.hatchWaitTimer-- <= 0)
                        {
                            this.hatch();
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void collideWithEntity(Entity entity)
    {
        super.collideWithEntity(entity);
        if((entity instanceof EntityPlayer) && !((EntityPlayer)entity).capabilities.isCreativeMode || !(entity instanceof SpeciesAlien) && !(entity instanceof EntityPlayer))
        {
            this.hatchingTime = 0;
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
            Pos pos = new Pos(this).findSafePosAround(this.world);

            facehugger.setLocationAndAngles(pos.x, pos.y, pos.z, 0F, 0F);
            world.spawnEntity(facehugger);
            facehugger.motionY = 0.75F;

            this.setContainsFacehugger(false);
        }
    }

    public void setHatched(boolean hasHatched)
    {
        this.hasHatched = hasHatched;
    }

    public int getOpenProgress()
    {
        return this.openProgress;
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
}
