package org.avp.common.block.init;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.*;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPReflectiveBlocks implements IPreInitEvent
{
    public static final AVPReflectiveBlocks instance = new AVPReflectiveBlocks();

    private AVPReflectiveBlocks() {}

    // Reflective
    public static final Block SLOPE = new BlockReflective(Material.CIRCUITS).setRegistryName("slope");
    public static final Block CORNER = new BlockReflective(Material.CIRCUITS).setRegistryName("corner");
    public static final Block INVERTED_CORNER = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedcorner");
    public static final Block RIDGE = new BlockReflective(Material.CIRCUITS).setRegistryName("ridge");
    public static final Block PYRAMID = new BlockReflective(Material.CIRCUITS).setRegistryName("pyramid");
    public static final Block INVERTED_RIDGE = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedridge");
    public static final Block INVERTED_PYRAMID = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedpyramid");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.log().info("Registering Reflective Blocks");

        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SLOPE);
        BlockRegistryUtil.registerStandardBlock(CORNER);
        BlockRegistryUtil.registerStandardBlock(INVERTED_CORNER);
        BlockRegistryUtil.registerStandardBlock(RIDGE);
        BlockRegistryUtil.registerStandardBlock(PYRAMID);
        BlockRegistryUtil.registerStandardBlock(INVERTED_RIDGE);
        BlockRegistryUtil.registerStandardBlock(INVERTED_PYRAMID);
    }
}
