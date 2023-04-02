package org.lib.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;

import java.util.function.Consumer;

/**
 * @author Boston Vanseghi
 */
public class BlockProperties {

    private final Material material;
    private CreativeTabs creativeTab;
    private float hardness;
    private float resistance;
    private int lightOpacity;
    private SoundType soundType;

    private Consumer<Block> fireInfoConsumer;

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

    public BlockProperties setSoundType(SoundType soundType) {
        this.soundType = soundType;
        return this;
    }

    public BlockProperties setFireInfo(int encouragement, int flammability) {
        this.fireInfoConsumer = block -> Blocks.FIRE.setFireInfo(block, encouragement, flammability);
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

    public SoundType getSoundType() {
        return this.soundType;
    }

    public void apply(Block block) {
        block.setHardness(this.getHardness());
        block.setResistance(this.getResistance());
        block.setLightOpacity(this.getLightOpacity());

        if (this.getCreativeTab() != null) {
            block.setCreativeTab(this.getCreativeTab());
        }

        if (this.fireInfoConsumer != null) {
            this.fireInfoConsumer.accept(block);
        }
    }
}
