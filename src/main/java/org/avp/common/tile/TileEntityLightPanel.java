package org.avp.common.tile;

import net.minecraft.util.EnumFacing;
import net.minecraft.world.EnumSkyBlock;
import org.avp.common.api.power.IVoltageReceiver;

public class TileEntityLightPanel extends TileEntityElectrical implements IVoltageReceiver
{
    public TileEntityLightPanel()
    {
        super(false);
    }

    @Override
    public void update()
    {
        super.update();

        boolean previouslyOperational = this.isOperational();

        this.updateEnergyAsReceiver();

        if (previouslyOperational != this.isOperational())
        {
            this.world.checkLightFor(EnumSkyBlock.BLOCK, pos);
        }
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
