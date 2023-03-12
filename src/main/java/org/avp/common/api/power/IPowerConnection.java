package org.avp.common.api.power;

import net.minecraft.util.EnumFacing;

public interface IPowerConnection
{
    /**
     * Returns TRUE if the TileEntity can connect on a given side.
     */
    boolean canConnectPower(EnumFacing from);
}
