package org.avp.common.tile;

import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.VoltageProvider;
import org.avp.common.api.power.VoltageReceiver;

public class TileEntityPowerline extends TileEntityElectrical implements VoltageProvider, VoltageReceiver
{
    public TileEntityPowerline()
    {
        super(false);
    }

    @Override
    public void update()
    {
        super.update();
        this.updateEnergyAsReceiver();
        this.tryElectricArc();
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
        return 10000;
    }
}
