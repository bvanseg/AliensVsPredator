package org.avp.common.block;

import net.minecraft.block.BlockFence;
import org.lib.common.block.BlockProperties;

/**
 * @author Boston Vanseghi
 */
public class BlockCustomFence extends BlockFence {

    public BlockCustomFence(String registryName, BlockProperties blockProperties) {
        super(blockProperties.getMaterial(), blockProperties.getMaterial().getMaterialMapColor());
        this.setRegistryName(registryName);

        blockProperties.apply(this);
        this.setLightOpacity(0);

        if (blockProperties.getSoundType() != null) {
            this.setSoundType(blockProperties.getSoundType());
        }
    }
}
