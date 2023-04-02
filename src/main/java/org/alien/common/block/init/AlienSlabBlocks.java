package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.oredict.OreDictionary;
import org.avp.common.block.BlockCustomSlab;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienSlabBlocks implements IPreInitEvent {
    public static final AlienSlabBlocks instance = new AlienSlabBlocks();

    private AlienSlabBlocks() {}

    public static final BlockCustomSlab.Half UNIDENTIFIED_PLANKS_SLAB_HALF = new BlockCustomSlab.Half("unidentified_wood_slab", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final BlockCustomSlab.Half PARADISE_SMALL_LOG_PLANKS_SLAB_HALF = new BlockCustomSlab.Half("paradise_small_log_wood_slab", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final BlockCustomSlab.Half PARADISE_MEDIUM_LOG_PLANKS_SLAB_HALF = new BlockCustomSlab.Half("paradise_medium_log_wood_slab", AlienBlockProperties.WOOD_PLANK_PROPS);
    public static final BlockCustomSlab.Half PARADISE_LARGE_LOG_PLANKS_SLAB_HALF = new BlockCustomSlab.Half("paradise_large_log_wood_slab", AlienBlockProperties.WOOD_PLANK_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardSlabBlock(UNIDENTIFIED_PLANKS_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(PARADISE_SMALL_LOG_PLANKS_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(PARADISE_MEDIUM_LOG_PLANKS_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(PARADISE_LARGE_LOG_PLANKS_SLAB_HALF);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("slabWood", UNIDENTIFIED_PLANKS_SLAB_HALF);
        OreDictionary.registerOre("slabWood", PARADISE_SMALL_LOG_PLANKS_SLAB_HALF);
        OreDictionary.registerOre("slabWood", PARADISE_MEDIUM_LOG_PLANKS_SLAB_HALF);
        OreDictionary.registerOre("slabWood", PARADISE_LARGE_LOG_PLANKS_SLAB_HALF);
    }
}
