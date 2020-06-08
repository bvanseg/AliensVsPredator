package org.avp.entities;

import java.util.List;
import java.util.UUID;

import org.avp.entities.living.species.SpeciesAlien;
import org.avp.tile.TileEntityMedpod;
import org.avp.world.capabilities.IOrganism.Organism;
import org.avp.world.capabilities.IOrganism.Provider;

import com.asx.mdx.lib.world.Worlds;
import com.asx.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class EntityMedpod extends Entity
{
    private TileEntityMedpod tile;
    private Entity           lastRiddenEntity;
    private UUID             lastRiddenEntityUUID;

    public EntityMedpod(World world)
    {
        super(world);
        this.setSize(1.0F, 1.0F);
    }

    @SuppressWarnings("all")
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        BlockPos pos = new BlockPos((int) Math.floor(this.posX), ((int) this.posY), ((int) Math.floor(this.posZ)));

        if (this.tile == null && this.world.isRemote)
        {
            TileEntity tile = this.world.getTileEntity(pos);

            if (tile != null)
            {
                this.setTile((TileEntityMedpod) tile);
            }
        }

        if (this.tile != null && this.tile.getEntity() == null)
        {
            this.tile.setEntity(this);
        }

        if (this.getTileEntity() == null || this.getTileEntity() != null && this.getTileEntity().getEntity() != this)
        {
            this.setDead();
        }

        if (!this.world.isRemote && Entities.getEntityRiddenBy(this) == null && this.getTileEntity() != null)
        {
            List<Entity> entities = this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox().expand(this.motionX, this.motionY, this.motionZ));

            if (entities != null && !entities.isEmpty())
            {
                Entity entity = entities.get(0);

                if (!entity.isRiding() && !entity.isSneaking() && !(entity instanceof SpeciesAlien))
                {
                    lastRiddenEntity = entity;

                    if (this.getTileEntity().isOpen())
                    {
                        entity.startRiding(this);
                    }
                }
            }
        }

        if (lastRiddenEntity != null)
        {
            lastRiddenEntityUUID = lastRiddenEntity.getPersistentID();
        }

        if (this.lastRiddenEntity == null)
        {
            if (this.lastRiddenEntityUUID != null)
            {
                this.lastRiddenEntity = Worlds.getEntityByUUID(this.world, this.lastRiddenEntityUUID);
            }
        }

        if (Entities.getEntityRiddenBy(this) != null && this.getTileEntity() != null)
        {
            if (this.getTileEntity().getVoltage() > 0 && this.getTileEntity().getDoorProgress() <= 0 && !this.getTileEntity().isOpen() && Entities.getEntityRiddenBy(this) instanceof EntityLivingBase)
            {
                EntityLivingBase living = (EntityLivingBase) Entities.getEntityRiddenBy(this);
                Organism organism = (Organism) living.getCapability(Provider.CAPABILITY, null);
                
                organism.heal(living);
            }
        }
    }

    @Override
    public AxisAlignedBB getCollisionBox(Entity entity)
    {
        return super.getCollisionBox(entity);
    }

    public EntityMedpod setTile(TileEntityMedpod tile)
    {
        this.tile = tile;
        return this;
    }

    public TileEntityMedpod getTileEntity()
    {
        return tile;
    }

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        String uuidString = nbt.getString("LastRiddenEntityUUID");

        if (!uuidString.isEmpty())
        {
            this.lastRiddenEntityUUID = UUID.fromString(uuidString);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        if (this.lastRiddenEntityUUID != null)
        {
            nbt.setString("LastRiddenEntityUUID", this.lastRiddenEntityUUID.toString());
        }
    }

    @Override
    protected void entityInit()
    {
        ;
    }

    public Entity getLastRiddenEntity()
    {
        return lastRiddenEntity;
    }

    public UUID getLastRiddenEntityUUID()
    {
        return lastRiddenEntityUUID;
    }

    public void clearLastRidden()
    {
        this.lastRiddenEntity = null;
        this.lastRiddenEntityUUID = null;
    }
}
