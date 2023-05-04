package org.power.common.tile;

import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.VoltageReceiver;


public class TileEntitySatelliteDish extends TileEntityElectrical implements VoltageReceiver
{
    public TileEntitySatelliteDish()
    {
        super(false);
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return maxReceive;
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
}
