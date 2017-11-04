package org.avp.tile;

import org.avp.api.power.IVoltageReceiver;

import net.minecraft.block.state.IBlockState;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.EnumSkyBlock;

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
        this.updateEnergyAsReceiver();

        IBlockState state = world.getBlockState(this.getPos());
        int light = this.isOperational() ? 15 : 0;

        this.world.checkLightFor(EnumSkyBlock.BLOCK, pos);
        this.world.notifyBlockUpdate(pos, state, state, 3);
        this.world.notifyNeighborsOfStateChange(pos, blockType);
    }

    @Override
    public boolean canConnectPower(EnumFacing from)
    {
        return true;
    }

    @Override
    public double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate)
    {
        return super.receiveVoltage(from, maxReceive, simulate);
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
