package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.BlockAVPOre;
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
    private static final BlockProperties COBALT_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(50F).setResistance(20F);
    public static final BlockProperties COPPER_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(3.2F).setResistance(2.6F);
    private static final BlockProperties LITHIUM_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(4.2F).setResistance(5.4F);
    private static final BlockProperties MONAZITE_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(45F).setResistance(15F);
    private static final BlockProperties SILICON_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(2.2F).setResistance(1.4F);

    // Ores
    public static final Block ORE_SILICON = new BlockAVPOre("oresilicon", SILICON_PROPS);
    public static final Block ORE_LITHIUM = new BlockAVPOre("orelithium", LITHIUM_PROPS);
    public static final Block ORE_COPPER = new BlockAVPOre("orecopper", COPPER_PROPS);
    public static final Block ORE_BAUXITE = new BlockAVPOre("orebauxite", COPPER_PROPS);
    public static final Block ORE_MONAZITE = new BlockAVPOre("oremonazite", MONAZITE_PROPS);
    public static final Block ORE_COBALT = new BlockAVPOre("orecobalt", COBALT_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.instance.getLogger().info("Registering Ore Blocks");

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
