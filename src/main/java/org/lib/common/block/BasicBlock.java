package org.lib.common.block;

import com.asx.mdx.common.minecraft.block.BlockMaterial;

/**
 * @author Boston Vanseghi
 */
public class BasicBlock extends BlockMaterial {

    public BasicBlock(String registryName, BlockProperties properties) {
        super(properties.getMaterial());
        this.setRegistryName(registryName);
        this.setHardness(properties.getHardness());
        this.setResistance(properties.getResistance());
        this.setLightOpacity(properties.getLightOpacity());
    }
}
