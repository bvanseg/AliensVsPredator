package org.lib.common.block;

import com.asx.mdx.common.minecraft.block.BlockMaterial;

/**
 * @author Boston Vanseghi
 */
public class BasicBlock extends BlockMaterial {

    public BasicBlock(String registryName, BlockProperties properties) {
        super(properties.getMaterial());

        this.setRegistryName(registryName);

        // Applies a majority of the properties.
        properties.apply(this);

        if (properties.getSoundType() != null) {
            this.setSoundType(properties.getSoundType());
        }
    }
}
