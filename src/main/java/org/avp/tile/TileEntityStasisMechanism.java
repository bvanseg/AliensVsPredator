package org.avp.tile;

import org.avp.entities.EntityMechanism;
import org.avp.item.ItemEntitySummoner;

import com.arisux.mdx.lib.world.entity.Entities;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ITickable;
import net.minecraft.world.World;

public class TileEntityStasisMechanism extends TileEntity implements ITickable
{
    private int direction;
    public EntityMechanism dummyEntity;
    private Entity stasisEntity;
    public ItemStack itemstack;
    private String readOnlyDmmyEntityUUID;
    private int readOnlyStasisEntityID;

    public TileEntityStasisMechanism()
    {
        super();
    }

    @Override
    public void update()
    {
        if (this.dummyEntity == null && this.world.getWorldTime() % 20 == 0)
        {
            this.dummyEntity = (EntityMechanism) getEntityForUUID(this.world, this.readOnlyDmmyEntityUUID);

            if (this.dummyEntity != null)
            {
                this.stasisEntity = Entities.getEntityRiddenBy(this.dummyEntity);
            }
        }

        if (this.dummyEntity == null && !this.world.isRemote)
        {
            this.dummyEntity = new EntityMechanism(this.world);
            this.dummyEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);
            this.world.spawnEntity(this.dummyEntity);
        }

        if (this.dummyEntity != null && this.itemstack != null && this.stasisEntity == null && !this.world.isRemote)
        {
            ItemEntitySummoner summoner = (ItemEntitySummoner) this.itemstack.getItem();
            this.stasisEntity = summoner.createNewEntity(this.world);
            this.stasisEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);
            this.world.spawnEntity(this.stasisEntity);
        }

        if (this.dummyEntity != null)
        {
            this.dummyEntity.setLocationAndAngles(this.getPos().getX() + 0.5, this.getPos().getY(), this.getPos().getZ() + 0.5, 0, 0);

            Entity riddenBy = Entities.getEntityRiddenBy(this.dummyEntity);
            
            if (riddenBy == null)
            {
                this.itemstack = null;
            }

            if (riddenBy != null && riddenBy instanceof EntityLivingBase)
            {
                ((EntityLivingBase) riddenBy).rotationYawHead = direction * 90;
            }
        }

        if (this.stasisEntity != null)
        {
            this.stasisEntity.startRiding(this.dummyEntity);
        }
    }

    public void setDirection(byte direction)
    {
        this.direction = direction;
    }

    public int getDirection()
    {
        return direction;
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket()
    {
        return new SPacketUpdateTileEntity(this.getPos(), 1, this.getUpdateTag());
    }

    @Override
    public NBTTagCompound getUpdateTag()
    {
        return this.writeToNBT(new NBTTagCompound());
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet)
    {
        this.readFromNBT(packet.getNbtCompound());
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);
        nbt.setInteger("Direction", this.direction);

        if (this.dummyEntity != null)
        {
            nbt.setString("DummyEntity", this.dummyEntity.getUniqueID().toString());

            Entity riddenBy = Entities.getEntityRiddenBy(this.dummyEntity);
            
            if (riddenBy != null)
            {
                nbt.setInteger("StasisEntity", riddenBy.getEntityId());
            }
        }

        if (this.itemstack != null)
        {
            NBTTagCompound nbtStack = new NBTTagCompound();
            this.itemstack.writeToNBT(nbtStack);
            nbt.setTag("StasisItemstack", nbtStack);
        }
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.direction = nbt.getInteger("Direction");
        this.readOnlyDmmyEntityUUID = nbt.getString("DummyEntity");
        this.readOnlyStasisEntityID = nbt.getInteger("StasisEntity");
        this.itemstack = ItemStack.loadItemStackFromNBT(nbt.getCompoundTag("StasisItemstack"));
    }

    public static Entity getEntityForUUID(World world, String uuid)
    {
        for (Object o : world.loadedEntityList)
        {
            Entity e = (Entity) o;

            if (e.getUniqueID().toString().equals(uuid))
            {
                return e;
            }
        }

        return null;
    }

    public Entity getStasisEntity()
    {
        return stasisEntity;
    }

    public String getReadOnlyDmmyEntityUUID()
    {
        return readOnlyDmmyEntityUUID;
    }

    public int getReadOnlyStasisEntityID()
    {
        return readOnlyStasisEntityID;
    }
}
