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

    public static final Block SKULL_XENO = new BlockSkullXenomorph().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.xenomorph");
    public static final Block SKULL_XENO_WARRIOR = new BlockSkullXenomorphWarrior().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.xenomorph.warrior");
    public static final Block SKULL_MATRIARCH = new BlockSkullMatriarch().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.matriarch");
    public static final Block HEAD_AETHON = new BlockHeadAethon().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("head.aethon");
    public static final Block HEAD_GIGER_ALIEN = new BlockHeadGigerAlien().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("head.gigeralien");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SKULL_XENO);
        BlockRegistryUtil.registerStandardBlock(SKULL_XENO_WARRIOR);
        BlockRegistryUtil.registerStandardBlock(SKULL_MATRIARCH);
        BlockRegistryUtil.registerStandardBlock(HEAD_AETHON);
        BlockRegistryUtil.registerStandardBlock(HEAD_GIGER_ALIEN);
    }
}
