package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.avp.common.block.BlockCustomStairs;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienStairsBlocks implements IPreInitEvent {
    public static final AlienStairsBlocks instance = new AlienStairsBlocks();

    public static final Block UNIDENTIFIED_WOOD_STAIRS = new BlockCustomStairs(AlienVardaBlocks.UNIDENTIFIED_PLANKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("unidentified_wood_stairs");
    public static final Block PARADISE_SMALL_LOG_WOOD_STAIRS = new BlockCustomStairs(AlienParadiseBlocks.PARADISE_SMALL_LOG_PLANKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("paradise_small_log_wood_stairs");
    public static final Block PARADISE_MEDIUM_LOG_WOOD_STAIRS = new BlockCustomStairs(AlienParadiseBlocks.PARADISE_MEDIUM_LOG_PLANKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("paradise_medium_log_wood_stairs");
    public static final Block PARADISE_LARGE_LOG_WOOD_STAIRS = new BlockCustomStairs(AlienParadiseBlocks.PARADISE_LARGE_LOG_PLANKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("paradise_large_log_wood_stairs");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(UNIDENTIFIED_WOOD_STAIRS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_SMALL_LOG_WOOD_STAIRS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_MEDIUM_LOG_WOOD_STAIRS);
        BlockRegistryUtil.registerStandardBlock(PARADISE_LARGE_LOG_WOOD_STAIRS);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("stairWood", UNIDENTIFIED_WOOD_STAIRS);
        OreDictionary.registerOre("stairWood", PARADISE_SMALL_LOG_WOOD_STAIRS);
        OreDictionary.registerOre("stairWood", PARADISE_MEDIUM_LOG_WOOD_STAIRS);
        OreDictionary.registerOre("stairWood", PARADISE_LARGE_LOG_WOOD_STAIRS);
    }
}
