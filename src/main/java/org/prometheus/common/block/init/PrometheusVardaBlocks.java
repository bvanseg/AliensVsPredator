package org.prometheus.common.block.init;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.block.*;
import org.alien.common.block.init.AlienBlockProperties;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.BlockStalagmite;
import org.lib.common.block.BasicBlock;
import org.lib.common.registry.BlockRegistryUtil;
import org.prometheus.common.PrometheusDimensions;
import org.prometheus.common.block.*;

/**
 * @author Boston Vanseghi
 */
public class PrometheusVardaBlocks implements IPreInitEvent {
    public static final PrometheusVardaBlocks instance = new PrometheusVardaBlocks();

    private PrometheusVardaBlocks() {}

    /* Varda */
    public static final Block PORTAL_VARDA = new BlockPortal(PrometheusDimensions.VARDA).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("portal.varda");
    public static final Block GIGER_LOG = new BlockUnidentifiedLog().setHardness(5F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.log");
    public static final Block GIGER_TENDONS = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.tendons");
    public static final Block GIGER_LEAVES = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.TOP).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves");
    public static final Block GIGER_LEAVES_M = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.MIDDLE).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves.m");
    public static final Block GIGER_LEAVES_B = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.BOTTOM).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves.b");
    public static final Block GIGER_SAPLING = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("unitree.sapling");
    public static final Block UNISTONE = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("unistone");
    public static final Block UNISAND = new BlockMaterial(Material.SAND).setHardness(3.5F).setResistance(2.0F).setRegistryName("unisand");
    public static final Block UNIGRAVEL = new BlockMaterial(Material.SAND).setHardness(3.0F).setLightOpacity(255).setRegistryName("unigravel");
    public static final Block UNIDIRT = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("unidirt").setCreativeTab(AVPCreativeTabs.BLOCKS);
    public static final Block STALAGMITE = new BlockStalagmite(Material.PLANTS).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("stalagmite");

    public static final Block UNIDENTIFIED_PLANKS = new BasicBlock("unidentified_planks", AlienBlockProperties.WOOD_PLANK_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(PORTAL_VARDA);
        BlockRegistryUtil.registerStandardBlock(GIGER_LOG);
        BlockRegistryUtil.registerStandardBlock(GIGER_TENDONS);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES_M);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES_B);
        BlockRegistryUtil.registerStandardBlock(GIGER_SAPLING);

        BlockRegistryUtil.registerStandardBlock(UNISTONE);
        BlockRegistryUtil.registerStandardBlock(UNISAND);
        BlockRegistryUtil.registerStandardBlock(UNIGRAVEL);
        BlockRegistryUtil.registerStandardBlock(UNIDIRT);
        BlockRegistryUtil.registerStandardBlock(STALAGMITE);

        BlockRegistryUtil.registerStandardBlock(UNIDENTIFIED_PLANKS);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("plankWood", UNIDENTIFIED_PLANKS);
    }
}
