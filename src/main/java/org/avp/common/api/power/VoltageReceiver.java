package org.avp.common.api.power;

import net.minecraft.util.EnumFacing;

public interface VoltageReceiver extends PowerConnection
{
    /**
     * Add energy to an IEnergyReceiver, internal distribution is left entirely to the IEnergyReceiver.
     *
     * @param from
     *            Orientation the energy is received from.
     * @param maxReceive
     *            Maximum amount of energy to receive.
     * @param simulate
     *            If TRUE, the charge will only be simulated.
     * @return Amount of energy that was (or would have been, if simulated) received.
     */
    double receiveVoltage(EnumFacing from, double maxReceive, boolean simulate);

    /**
     * Returns the amount of energy currently stored.
     */
    double getCurrentVoltage(EnumFacing from);

    /**
     * Returns the maximum amount of energy that can be stored.
     */
    double getMaxVoltage(EnumFacing from);
}
