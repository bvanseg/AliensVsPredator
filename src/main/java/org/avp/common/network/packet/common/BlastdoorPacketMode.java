package org.avp.common.network.packet.common;

/**
 * @author Ri5ux
 */
public enum BlastdoorPacketMode {
    NONE(0), AUTH(1), SETPSWD(2), SETAUTOLOCK(3), BIND(4);

    private final int id;

    BlastdoorPacketMode(int id) {
        this.id = id;
    }

    public static BlastdoorPacketMode byId(int id) {
        for (BlastdoorPacketMode mode : values()) {
            if (mode.id == id) {
                return mode;
            }
        }

        return NONE;
    }

    public int getId() {
        return this.id;
    }
}