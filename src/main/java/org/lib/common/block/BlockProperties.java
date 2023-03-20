package org.lib.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * @author Boston Vanseghi
 */
public class BlockProperties {

    private final Material material;
    private CreativeTabs creativeTab;
    private float hardness;
    private float resistance;
    private int lightOpacity;

    public BlockProperties(Material material) {
        this.material = material;
        this.lightOpacity = 255;
    }

    public BlockProperties setCreativeTab(CreativeTabs creativeTab) {
        this.creativeTab = creativeTab;
        return this;
    }

    public BlockProperties setHardness(float hardness) {
        this.hardness = hardness;
        return this;
    }

    public BlockProperties setResistance(float resistance) {
        this.resistance = resistance;
        return this;
    }

    public BlockProperties setLightOpacity(int lightOpacity) {
        this.lightOpacity = lightOpacity;
        return this;
    }

    public CreativeTabs getCreativeTab() {
        return this.creativeTab;
    }

    public Material getMaterial() {
        return this.material;
    }

    public float getHardness() {
        return this.hardness;
    }

    public float getResistance() {
        return this.resistance;
    }

    public int getLightOpacity() {
        return this.lightOpacity;
    }

    public void apply(Block block) {
        block.setHardness(this.getHardness());
        block.setResistance(this.getResistance());
        block.setLightOpacity(this.getLightOpacity());
    }
}
