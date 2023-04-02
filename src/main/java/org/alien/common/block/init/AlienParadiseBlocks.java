package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.block.*;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.block.BasicBlock;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienParadiseBlocks implements IPreInitEvent {
    public static final AlienParadiseBlocks instance = new AlienParadiseBlocks();

    private AlienParadiseBlocks() {}

    /* Paradise */
    public static final Block PARADISE_DIRT = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_DIRT_MOSSY = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_mossy").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_DIRT_PODZOL = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_podzol").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_GRASS = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_grass").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LEAVES_LARGE = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_large").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LOG_LARGE = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_large").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LEAVES_MED = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_med").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LOG_MED = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_med").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LEAVES_SMALL = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_small").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block PARADISE_LOG_SMALL = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_small").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block GROUND_FERN = new BlockGroundFern().setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("paradisian_ground_fern");
    public static final Block TREE_FERN = new BlockTreeFern().setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("paradisian_tree_fern");
    public static final Block WHEAT_GRASS = new BlockWheatGrass().setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("paradisian_wheat_grass");

    public static final Block PARADISE_SMALL_LOG_PLANKS = new BasicBlock("paradise_small_log_planks", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final Block PARADISE_MEDIUM_LOG_PLANKS = new BasicBlock("paradise_medium_log_planks", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final Block PARADISE_LARGE_LOG_PLANKS = new BasicBlock("paradise_large_log_planks", AlienBlockProperties.WOOD_PLANK_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(PARADISE_DIRT);
        BlockRegistryUtil.registerStandardBlock(PARADISE_DIRT_MOSSY);
        BlockRegistryUtil.registerStandardBlock(PARADISE_DIRT_PODZOL);
        BlockRegistryUtil.registerStandardBlock(PARADISE_GRASS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LEAVES_LARGE);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LOG_LARGE);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LEAVES_MED);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LOG_MED);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LEAVES_SMALL);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LOG_SMALL);
        BlockRegistryUtil.registerStandardBlock(GROUND_FERN);
        BlockRegistryUtil.registerStandardBlock(TREE_FERN);
        BlockRegistryUtil.registerStandardBlock(WHEAT_GRASS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_SMALL_LOG_PLANKS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_MEDIUM_LOG_PLANKS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LARGE_LOG_PLANKS);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("plankWood", PARADISE_SMALL_LOG_PLANKS);
        OreDictionary.registerOre("plankWood", PARADISE_MEDIUM_LOG_PLANKS);
        OreDictionary.registerOre("plankWood", PARADISE_LARGE_LOG_PLANKS);
    }
}
