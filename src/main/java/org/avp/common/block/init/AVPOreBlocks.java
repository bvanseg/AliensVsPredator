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
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPOreBlocks implements IPreInitEvent
{
    public static final AVPOreBlocks instance = new AVPOreBlocks();

    private AVPOreBlocks() {}

    // Properties
    public static final BlockProperties INDUSTRIAL_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(5F).setResistance(15F);
    public static final BlockProperties PADDING_PROPS = new BlockProperties(Material.CLOTH)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public static final BlockProperties PLASTIC_PROPS = new BlockProperties(Material.CLAY)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(10F).setResistance(15.0F).setLightOpacity(0);

    // TODO: All of these ores can be combined into a single block.

    // Ores
    public static final Block ORE_SILICON = new BlockOreSilicon().setHardness(2.2F).setResistance(1.4F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("oresilicon");
    public static final Block ORE_LITHIUM = new BlockMaterial(Material.IRON).setHardness(4.2F).setResistance(5.4F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("orelithium");
    public static final Block ORE_COPPER = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("orecopper");
    public static final Block ORE_BAUXITE = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("orebauxite");
    public static final Block ORE_MONAZITE = new BlockOreMonazite().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("oremonazite");
    public static final Block ORE_COBALT = new BlockOreCobalt().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("orecobalt");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.log().info("Registering Ore Blocks");

        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(ORE_BAUXITE);
        BlockRegistryUtil.registerStandardBlock(ORE_COBALT);
        BlockRegistryUtil.registerStandardBlock(ORE_COPPER);
        BlockRegistryUtil.registerStandardBlock(ORE_LITHIUM);
        BlockRegistryUtil.registerStandardBlock(ORE_MONAZITE);
        BlockRegistryUtil.registerStandardBlock(ORE_SILICON);
    }
}
