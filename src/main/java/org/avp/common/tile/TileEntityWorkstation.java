package org.avp.common.tile;

import org.avp.common.api.machines.INetworkDevice;
import org.avp.common.api.power.IVoltageReceiver;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityWorkstation extends TileEntityElectrical implements INetworkDevice, IVoltageReceiver
{
    public int rotation;

    public TileEntityWorkstation()
    {
        super(false);
        this.setThresholdVoltage(105);
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
        nbt.setInteger("rotation", this.rotation);

        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.rotation = nbt.getInteger("rotation");
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();
    }

    public void setDirection(byte direction)
    {
        this.rotation = direction;
    }

    @Override
    public void sendData()
    {
        ;
    }

    @Override
    public void receiveData()
    {
        ;
    }

    @Override
    public INetworkDevice getHostDevice()
    {
        return null;
    }

    @Override
    public String getChannel()
    {
        return "default";
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 120;
    }
}
