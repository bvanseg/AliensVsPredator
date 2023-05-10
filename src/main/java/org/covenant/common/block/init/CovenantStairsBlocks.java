package org.covenant.common.block.init;

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
public class CovenantStairsBlocks implements IPreInitEvent {
    public static final CovenantStairsBlocks instance = new CovenantStairsBlocks();

    public static final Block PARADISE_SMALL_LOG_WOOD_STAIRS = new BlockCustomStairs("paradise_small_log_wood_stairs", AlienBlockProperties.WOOD_PLANK_PROPS, CovenantParadiseBlocks.PARADISE_SMALL_LOG_PLANKS.getDefaultState()).setLightOpacity(4);
    public static final Block PARADISE_MEDIUM_LOG_WOOD_STAIRS = new BlockCustomStairs("paradise_medium_log_wood_stairs", AlienBlockProperties.WOOD_PLANK_PROPS, CovenantParadiseBlocks.PARADISE_MEDIUM_LOG_PLANKS.getDefaultState()).setLightOpacity(4);
    public static final Block PARADISE_LARGE_LOG_WOOD_STAIRS = new BlockCustomStairs("paradise_large_log_wood_stairs", AlienBlockProperties.WOOD_PLANK_PROPS, CovenantParadiseBlocks.PARADISE_LARGE_LOG_PLANKS.getDefaultState()).setLightOpacity(4);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(PARADISE_SMALL_LOG_WOOD_STAIRS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_MEDIUM_LOG_WOOD_STAIRS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LARGE_LOG_WOOD_STAIRS);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("stairWood", PARADISE_SMALL_LOG_WOOD_STAIRS);
        OreDictionary.registerOre("stairWood", PARADISE_MEDIUM_LOG_WOOD_STAIRS);
        OreDictionary.registerOre("stairWood", PARADISE_LARGE_LOG_WOOD_STAIRS);
    }
}
