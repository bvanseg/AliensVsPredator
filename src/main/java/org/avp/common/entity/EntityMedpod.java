package org.avp.common.entity;

import com.asx.mdx.common.minecraft.entity.Entities;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.alien.common.entity.living.SpeciesAlien;
import org.alien.common.world.capability.Organism.Provider;
import org.alien.common.world.capability.OrganismImpl;
import org.avp.common.tile.TileEntityMedpod;
import org.lib.common.EntityAccessor;

import java.util.List;
import java.util.UUID;

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
        TileEntity localTileEntity = this.world.getTileEntity(pos);
        this.setTile((TileEntityMedpod) localTileEntity);

        if (this.tile != null && this.tile.getEntity() == null)
        {
            this.tile.setEntity(this);
        }

        if (this.getTileEntity() == null ||
                localTileEntity == null ||
                (this.getTileEntity() != null && this.getTileEntity().getEntity() != this)
        )
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
                this.lastRiddenEntity = EntityAccessor.instance.getEntityByUUID(this.lastRiddenEntityUUID).orElse(null);
            }
        }

        if (Entities.getEntityRiddenBy(this) != null && this.getTileEntity() != null)
        {
            if (this.getTileEntity().getVoltage() > 0 && this.getTileEntity().getDoorProgress() <= 0 && !this.getTileEntity().isOpen() && Entities.getEntityRiddenBy(this) instanceof EntityLivingBase)
            {
                EntityLivingBase living = (EntityLivingBase) Entities.getEntityRiddenBy(this);
                OrganismImpl organism = (OrganismImpl) living.getCapability(Provider.CAPABILITY, null);
                
                organism.heal(living);
            }
        }
    }

    public EntityMedpod setTile(TileEntityMedpod tile)
    {
        this.tile = tile;
        return this;
    }

    public TileEntityMedpod getTileEntity()
    {
        return this.tile;
    }

    private static final String LAST_RIDDEN_ENTITY_UUID_NBT_KEY = "LastRiddenEntityUUID";

    @Override
    protected void readEntityFromNBT(NBTTagCompound nbt)
    {
        String uuidString = nbt.getString(LAST_RIDDEN_ENTITY_UUID_NBT_KEY);

        if (!uuidString.isEmpty())
        {
            // TODO: Get from long bits here instead of string.
            this.lastRiddenEntityUUID = UUID.fromString(uuidString);
        }
    }

    @Override
    protected void writeEntityToNBT(NBTTagCompound nbt)
    {
        if (this.lastRiddenEntityUUID != null)
        {
            // TODO: Set long bits here instead of string.
            nbt.setString(LAST_RIDDEN_ENTITY_UUID_NBT_KEY, this.lastRiddenEntityUUID.toString());
        }
    }

    @Override
    protected void entityInit() { /* Do Nothing */ }

    public void clearLastRidden()
    {
        this.lastRiddenEntity = null;
        this.lastRiddenEntityUUID = null;
    }
}
