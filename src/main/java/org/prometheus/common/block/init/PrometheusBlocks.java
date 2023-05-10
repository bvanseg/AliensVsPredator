package org.prometheus.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lib.common.registry.BlockRegistryUtil;
import org.prometheus.common.block.BlockBlackGoo;

/**
 * @author Boston Vanseghi
 */
public class PrometheusBlocks implements IPreInitEvent {
    public static final PrometheusBlocks instance = new PrometheusBlocks();

    private PrometheusBlocks() {}

    public static final Block BLACK_GOO = BlockRegistryUtil.createFluidBlock(BlockBlackGoo.fluid, BlockBlackGoo.class, "blackgoo");


    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();

        PrometheusEngineerBlocks.instance.pre(event);
        PrometheusVardaBlocks.instance.pre(event);
        PrometheusSkullBlocks.instance.pre(event);
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerBlock(BLACK_GOO);
    }
}
