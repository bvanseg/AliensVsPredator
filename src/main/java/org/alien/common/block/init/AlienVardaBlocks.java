package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.block.BlockUnidentifiedLog;
import org.alien.common.block.BlockUnidentifiedTreeLeaves;
import org.alien.common.block.BlockUnidentifiedTreeSapling;
import org.alien.common.block.BlockUnidentifiedTreeTendon;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.BlockCustomSlab;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienVardaBlocks implements IPreInitEvent {
    public static final AlienVardaBlocks instance = new AlienVardaBlocks();

    private AlienVardaBlocks() {}

    /* Varda */
    public static final Block GIGER_LOG = new BlockUnidentifiedLog().setHardness(5F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.log");
    public static final Block GIGER_TENDONS = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.tendons");
    public static final Block GIGER_LEAVES = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.TOP).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves");
    public static final Block GIGER_LEAVES_M = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.MIDDLE).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves.m");
    public static final Block GIGER_LEAVES_B = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.BOTTOM).setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.BLOCKS).setRegistryName("unitree.leaves.b");
    public static final Block GIGER_SAPLING = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("unitree.sapling");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(GIGER_LOG);
        BlockRegistryUtil.registerStandardBlock(GIGER_TENDONS);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES_M);
        BlockRegistryUtil.registerStandardBlock(GIGER_LEAVES_B);
        BlockRegistryUtil.registerStandardBlock(GIGER_SAPLING);
    }
}
