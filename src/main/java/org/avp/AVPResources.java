package org.avp;

import net.minecraft.util.ResourceLocation;

/**
 * @author Boston Vanseghi
 */
public class AVPResources {

    public static ResourceLocation location(String name) {
        return new ResourceLocation(AVPConstants.MOD_ID, name);
    }

    public static ResourceLocation entityTextureLocation(String entityName) {
        return new ResourceLocation(AVPConstants.MOD_ID, String.format("textures/entity/%s.png", entityName));
    }

    private AVPResources() { throw new UnsupportedOperationException(); }
}
