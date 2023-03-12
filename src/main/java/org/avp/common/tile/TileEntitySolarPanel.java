package org.avp.common.tile;

import org.avp.common.api.power.IVoltageProvider;

import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.EnumSkyBlock;



public class TileEntitySolarPanel extends TileEntityElectrical implements IVoltageProvider
{
    public TileEntitySolarPanel()
    {
        super(true);
    }

    @Override
    public void update()
    {
        if (this.world.provider.hasSkyLight() && !this.world.isRaining() && !this.world.isThundering())
        {
            if (this.world.getTotalWorldTime() % (1000 / this.getUpdateFrequency()) == 0)
            {
                int i = this.world.getLightFor(EnumSkyBlock.SKY, pos) - this.world.getSkylightSubtracted();
                float f = this.world.getCelestialAngleRadians(1.0F);

                if (i > 0)
                {
                    float f1 = f < (float)Math.PI ? 0.0F : ((float)Math.PI * 2F);
                    f = f + (f1 - f) * 0.2F;
                    i = Math.round((float)i * MathHelper.cos(f));
                }

				this.setVoltage(MathHelper.clamp(i*10, 0, 120));
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
