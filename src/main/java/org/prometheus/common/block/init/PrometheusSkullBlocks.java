package org.prometheus.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.registry.BlockRegistryUtil;
import org.prometheus.common.block.skull.BlockSkullEngineer;
import org.prometheus.common.block.skull.BlockSkullSpaceJockey;

/**
 * @author Boston Vanseghi
 */
public class PrometheusSkullBlocks implements IPreInitEvent {
    public static final PrometheusSkullBlocks instance = new PrometheusSkullBlocks();

    private PrometheusSkullBlocks() {}

    public static final Block SKULL_ENGINEER = new BlockSkullEngineer().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.engineer");
    public static final Block SKULL_JOCKEY = new BlockSkullSpaceJockey().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.spacejockey");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SKULL_ENGINEER);
        BlockRegistryUtil.registerStandardBlock(SKULL_JOCKEY);
    }
}
