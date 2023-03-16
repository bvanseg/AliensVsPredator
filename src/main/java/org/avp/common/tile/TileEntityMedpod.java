package org.avp.common.tile;

import com.asx.mdx.common.minecraft.entity.Entities;
import com.asx.mdx.common.minecraft.tile.IRotatableYAxis;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;
import org.avp.AVP;
import org.avp.common.api.machines.Openable;
import org.avp.common.api.power.VoltageReceiver;
import org.avp.common.entity.EntityMedpod;
import org.avp.common.network.packet.client.PacketOpenable;


public class TileEntityMedpod extends TileEntityElectrical implements Openable, VoltageReceiver, IRotatableYAxis
{
    private EnumFacing direction;
    private boolean        isOpen;
    private EntityMedpod   medpodEntity;
    private float          doorProgress;

    public TileEntityMedpod()
    {
        super(false);
        this.isOpen = false;
        this.doorProgress = -0.01F;
    }

    public EntityMedpod getEntity()
    {
        return this.medpodEntity;
    }

    public void setEntity(Entity entity)
    {
        this.medpodEntity = (EntityMedpod) entity;
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

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }
        nbt.setFloat("DoorProgress", this.doorProgress);
        nbt.setBoolean("Open", this.isOpen);
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        if (EnumFacing.byIndex(nbt.getInteger("Direction")) != null)
        {
            this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
        }
        this.doorProgress = nbt.getFloat("DoorProgress");
        this.isOpen = nbt.getBoolean("Open");
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();

        if (this.getEntity() == null && !this.world.isRemote)
        {
            this.medpodEntity = new EntityMedpod(world);
            this.medpodEntity.setTile(this);
            this.medpodEntity.setLocationAndAngles(this.getPos().getX(), this.getPos().getY(), this.getPos().getZ(), 0F, 0F);
            this.world.spawnEntity(this.medpodEntity);
        }

        if (this.world != null && this.getEntity() != null)
        {
            float rotation = 0F;

            if (this.getRotationYAxis() == EnumFacing.NORTH)
                rotation = 0F;

            if (this.getRotationYAxis() == EnumFacing.SOUTH)
                rotation = 180F;

            if (this.getRotationYAxis() == EnumFacing.EAST)
                rotation = 90F;

            if (this.getRotationYAxis() == EnumFacing.WEST)
                rotation = -90F;

            this.getEntity().setLocationAndAngles(this.getPos().getX() + getEntity().width / 2, this.getPos().getY(), this.getPos().getZ() + getEntity().width / 2, rotation, 0F);
        }

        if (this.isOpen())
        {
            this.doorProgress = this.doorProgress < getMaxDoorProgress() ? this.doorProgress + 0.025F : this.doorProgress;
        }

        if (!this.isOpen())
        {
            this.doorProgress = this.doorProgress > 0.0F ? this.doorProgress - 0.025F : this.doorProgress;
        }
    }

    @Override
    public EnumFacing getRotationYAxis()
    {
        return direction;
    }

    @Override
    public void setRotationYAxis(EnumFacing direction)
    {
        this.direction = direction;
    }

    @Override
    public void setOpen(boolean isOpen)
    {
        if (this.getVoltage() > 0)
        {
            this.isOpen = isOpen;

            if (!this.world.isRemote)
            {
                AVP.network().sendToAll(new PacketOpenable(isOpen, this.getPos().getX(), this.getPos().getY(), this.getPos().getZ()));
            }

            if (this.getEntity() != null)
            {
                Entity riddenBy = Entities.getEntityRiddenBy(this.getEntity());
                if (riddenBy == null)
                {
                    this.getEntity().clearLastRidden();
                }

                if (isOpen && this.getEntity() != null && riddenBy != null)
                {
                    riddenBy.dismountRidingEntity();
                }
            }
        }
    }

    @Override
    public boolean isOpen()
    {
        return isOpen;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 240;
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    public float getDoorProgress()
    {
        return doorProgress;
    }

    public float getMaxDoorProgress()
    {
        return 3.125F;
    }
}
