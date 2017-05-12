package org.avp.tile;

import org.avp.api.power.IVoltageProvider;
import org.avp.api.power.IVoltageReceiver;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;


public class TileEntityPowercell extends TileEntityElectrical implements IVoltageReceiver, IVoltageProvider
{
    public long energyStored;
    public double voltageCapacity;

    public TileEntityPowercell()
    {
        super(true);
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public void update()
    {
        super.update();

        for (EnumFacing direction : EnumFacing.VALUES)
        {
            TileEntity tile = this.world.getTileEntity(this.getPos().offset(direction));

            if (tile != null && tile instanceof TileEntityElectrical)
            {
                TileEntityElectrical electrical = (TileEntityElectrical) tile;

                if (electrical.getVoltage() > this.voltageCapacity)
                {
                    this.voltageCapacity = electrical.getVoltage();
                }

                if (electrical instanceof IVoltageProvider)
                {
                    IVoltageProvider provider = (IVoltageProvider) electrical;

                    if (provider.getCurrentVoltage(direction.getOpposite()) > 0)
                    {
                        if (this.energyStored <= this.getMaxEnergyStored())
                        {
                            this.energyStored++;
                        }
                    }
                }
            }
        }

        if (this.energyStored > 0)
        {
            this.setVoltage(this.voltageCapacity);
            this.energyStored = this.energyStored - 2;
        }
        else
        {
            this.setVoltage(0);
        }
    }

    @Override
    public void readFromNBT(NBTTagCompound nbt)
    {
        super.readFromNBT(nbt);

        this.energyStored = nbt.getLong("energyStored");
        this.voltageCapacity = nbt.getDouble("voltageCapacity");
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound nbt)
    {
        super.writeToNBT(nbt);

        nbt.setLong("energyStored", this.energyStored);
        nbt.setDouble("voltageCapacity", this.voltageCapacity);
        
        return nbt;
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return super.receiveVoltage(from, maxReceive, simulate);
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

    public long getEnergyStored()
    {
        return energyStored;
    }

    public long getMaxEnergyStored()
    {
        return 10000;
    }

    public double getVoltageCapacity()
    {
        return voltageCapacity;
    }
}
