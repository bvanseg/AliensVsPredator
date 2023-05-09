package org.power.common.tile;

import net.minecraft.util.EnumFacing;
import org.avp.common.api.power.VoltageReceiver;

public class TileEntityLightPanel extends TileEntityElectrical implements VoltageReceiver
{
    public TileEntityLightPanel()
    {
        super(false);
        this.emitsLightWhenPowered = true;
    }

    @Override
    public void update()
    {
        this.updateEnergyAsReceiver();
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double getCurrentVoltage(EnumFacing from)
    {
        return this.getVoltage();
    }

    @Override
    public double getMaxVoltage(EnumFacing from)
    {
        return 240;
    }
}
