package org.avp.tile;

import org.avp.api.power.IVoltageProvider;

import net.minecraft.util.EnumFacing;



public class TileEntitySolarPanel extends TileEntityElectrical implements IVoltageProvider
{
    public TileEntitySolarPanel()
    {
        super(true);
    }

    @Override
    public void update()
    {
        if (this.world.getWorldTime() < 12300 || this.world.getWorldTime() > 23850)
        {
            if (this.getWorld().getTotalWorldTime() % (1000 / this.getUpdateFrequency()) == 0)
            {
                this.setVoltage(120);
            }
        }
        else
        {
            this.setVoltage(0);
        }
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
}
