package org.avp.tile;

import org.avp.AliensVsPredator;
import org.avp.api.power.IVoltageProvider;
import org.avp.packets.client.PacketSyncRF;

import com.asx.mdx.lib.world.tile.IRotatableYAxis;

import cofh.redstoneflux.api.IEnergyReceiver;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.util.EnumFacing;

public class TileEntityRedstoneFluxGenerator extends TileEntityElectrical implements IVoltageProvider, IRotatableYAxis, IEnergyReceiver
{
    private EnumFacing direction;
    protected int rfEnergy;
    protected int rfStoredPerTick;
    protected int rfUsedPerTick;

    public TileEntityRedstoneFluxGenerator()
    {
        super(true);
        this.rfStoredPerTick = 25;
        this.rfUsedPerTick = 20;
        this.direction = EnumFacing.SOUTH;
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();
        this.updateRF();
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double extractVoltage(EnumFacing from, double maxExtract, boolean simulate)
    {
        return super.extractVoltage(from, maxExtract, simulate);
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.voltage;
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 10000;
    }
    
    public void setRfEnergy(int rfEnergy)
    {
        this.rfEnergy = rfEnergy;
    }
    
    public void updateRF()
    {
        if (rfEnergy >= rfUsedPerTick)
        {
            this.setVoltage(240);
            rfEnergy = rfEnergy - rfUsedPerTick;
        }
        else
        {
            this.setVoltage(0);
        }

        if (!this.world.isRemote && this.world.getTotalWorldTime() % 20 == 0)
        {
            AliensVsPredator.network().sendToAll(new PacketSyncRF(this.getEnergyStored(null), this.pos.getX(), this.pos.getY(), this.pos.getZ()));
        }
    }

    @Override
    public boolean canConnectEnergy(EnumFacing from)
    {
        return true;
    }

    @Override
    public int receiveEnergy(EnumFacing from, int maxReceive, boolean simulate)
    {
        int usedRF = 0;
        
        if (maxReceive >= this.rfStoredPerTick && this.rfEnergy < this.getMaxEnergyStored(from))
        {
            this.rfEnergy = this.rfEnergy + rfStoredPerTick;
            usedRF = Math.min(maxReceive, rfStoredPerTick);
        }
        
        return usedRF;
    }

    @Override
    public int getEnergyStored(EnumFacing from)
    {
        return this.rfEnergy;
    }

    @Override
    public int getMaxEnergyStored(EnumFacing from)
    {
        return 10000;
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
        nbt.setInteger("RFEnergy", this.rfEnergy);

        if (this.direction != null)
        {
            nbt.setInteger("Direction", this.direction.ordinal());
        }
        
        return nbt;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);
        this.rfEnergy = nbt.getInteger("RFEnergy");
        this.direction = EnumFacing.byIndex(nbt.getInteger("Direction"));
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
}
