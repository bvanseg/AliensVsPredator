package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.avp.common.block.BlockCustomFence;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienFenceBlocks implements IPreInitEvent {
    public static final AlienFenceBlocks instance = new AlienFenceBlocks();

    private AlienFenceBlocks() {}

    public static final Block UNIDENTIFIED_FENCE = new BlockCustomFence("unidentified_wood_fence", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final Block PARADISE_SMALL_LOG_FENCE = new BlockCustomFence("paradise_small_log_wood_fence", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final Block PARADISE_MEDIUM_LOG_FENCE = new BlockCustomFence("paradise_medium_log_wood_fence", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final Block PARADISE_LARGE_LOG_FENCE = new BlockCustomFence("paradise_large_log_wood_fence", AlienBlockProperties.WOOD_PLANK_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(UNIDENTIFIED_FENCE);
        BlockRegistryUtil.registerStandardBlock(PARADISE_SMALL_LOG_FENCE);
        BlockRegistryUtil.registerStandardBlock(PARADISE_MEDIUM_LOG_FENCE);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LARGE_LOG_FENCE);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("fenceWood", UNIDENTIFIED_FENCE);
        OreDictionary.registerOre("fenceWood", PARADISE_SMALL_LOG_FENCE);
        OreDictionary.registerOre("fenceWood", PARADISE_MEDIUM_LOG_FENCE);
        OreDictionary.registerOre("fenceWood", PARADISE_LARGE_LOG_FENCE);
    }
}
