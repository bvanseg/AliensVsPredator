package org.prometheus.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.alien.common.block.init.AlienBlockProperties;
import org.avp.common.block.BlockCustomStairs;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PrometheusStairsBlocks implements IPreInitEvent {
    public static final PrometheusStairsBlocks instance = new PrometheusStairsBlocks();

    public static final Block UNIDENTIFIED_WOOD_STAIRS = new BlockCustomStairs("unidentified_wood_stairs", AlienBlockProperties.WOOD_PLANK_PROPS, PrometheusVardaBlocks.UNIDENTIFIED_PLANKS.getDefaultState()).setLightOpacity(4);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(UNIDENTIFIED_WOOD_STAIRS);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("stairWood", UNIDENTIFIED_WOOD_STAIRS);
    }
}
