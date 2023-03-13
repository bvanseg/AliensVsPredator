package org.avp.common.api.power;

import net.minecraft.util.EnumFacing;

public interface IVoltageProvider extends IPowerConnection
{

    /**
     * Remove energy from an IEnergyProvider, internal distribution is left entirely to the IEnergyProvider.
     *
     * @param from
     *            Orientation the energy is extracted from.
     * @param maxExtract
     *            Maximum amount of energy to extract.
     * @param simulate
     *            If TRUE, the extraction will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) extracted.
     */
    double extractVoltage(EnumFacing from, double maxExtract, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    double getCurrentVoltage(EnumFacing from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    double getMaxVoltage(EnumFacing from);
}
