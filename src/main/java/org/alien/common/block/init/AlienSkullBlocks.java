package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.block.skull.*;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienSkullBlocks implements IPreInitEvent {
    public static final AlienSkullBlocks instance = new AlienSkullBlocks();

    private AlienSkullBlocks() {}

    public static final Block SKULL_ENGINEER = new BlockSkullEngineer().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.engineer");
    public static final Block SKULL_JOCKEY = new BlockSkullSpaceJockey().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.spacejockey");
    public static final Block SKULL_XENO = new BlockSkullXenomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.xenomorph");
    public static final Block SKULL_XENO_WARRIOR = new BlockSkullXenomorphWarrior().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.xenomorph.warrior");
    public static final Block SKULL_MATRIARCH = new BlockSkullMatriarch().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.matriarch");
    public static final Block SKULL_PROTOMORPH = new BlockSkullProtomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.protomorph");
    public static final Block SKULL_NEOMORPH = new BlockSkullNeomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.neomorph");
    public static final Block HEAD_AETHON = new BlockHeadAethon().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("head.aethon");
    public static final Block HEAD_GIGER_ALIEN = new BlockHeadGigerAlien().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("head.gigeralien");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SKULL_ENGINEER);
        BlockRegistryUtil.registerStandardBlock(SKULL_JOCKEY);
        BlockRegistryUtil.registerStandardBlock(SKULL_XENO);
        BlockRegistryUtil.registerStandardBlock(SKULL_XENO_WARRIOR);
        BlockRegistryUtil.registerStandardBlock(SKULL_MATRIARCH);
        BlockRegistryUtil.registerStandardBlock(SKULL_PROTOMORPH);
        BlockRegistryUtil.registerStandardBlock(SKULL_NEOMORPH);
        BlockRegistryUtil.registerStandardBlock(HEAD_AETHON);
        BlockRegistryUtil.registerStandardBlock(HEAD_GIGER_ALIEN);
    }
}
