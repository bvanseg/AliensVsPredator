package org.predator.common.block.init;

import net.minecraft.block.material.Material;
import org.lib.common.block.BlockProperties;

/**
 * @author Boston Vanseghi
 */
public class PredatorBlockProperties {
    private PredatorBlockProperties() {}

    public static final BlockProperties YAUTJA_METAL_PROPS = new BlockProperties(Material.IRON).setHardness(5F).setResistance(15.0F);
    public static final BlockProperties TEMPLE_PROPS = new BlockProperties(Material.ROCK).setHardness(5F).setResistance(15.0F);
}
