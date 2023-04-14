package org.lib.common.registry;

import net.minecraft.world.DimensionType;
import net.minecraftforge.common.DimensionManager;
import org.lib.common.dimension.Dimension;

/**
 * @author Boston Vanseghi
 */
public class DimensionRegistryUtil {

    private DimensionRegistryUtil() {}

    public static void registerDimension(Dimension dimension, int id) {
        DimensionType type = DimensionType.register(dimension.getName(), dimension.getSuffix(), id, dimension.getProvider(), dimension.shouldKeepLoaded());
        dimension.setType(type);
        DimensionManager.registerDimension(id, type);
    }
}
