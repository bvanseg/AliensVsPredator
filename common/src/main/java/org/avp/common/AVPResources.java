package org.avp.common;

import net.minecraft.resources.ResourceLocation;

/**
 * @author Boston Vanseghi
 */
public class AVPResources {

    public static ResourceLocation location(String location) {
        return new ResourceLocation(AVPConstants.MOD_ID, location);
    }

    private AVPResources() { throw new UnsupportedOperationException(); }
}
