package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.item.ItemStack;
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

    public static final BlockCustomSlab.Half UNIDENTIFIED_PLANKS_SLAB_HALF = new BlockCustomSlab.Half("unidentified_wood_slab", AlienBlocks.WOOD_PLANK_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerOreDictionaryEntries();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardSlabBlock(UNIDENTIFIED_PLANKS_SLAB_HALF);
    }

    private void registerOreDictionaryEntries() {
        OreDictionary.registerOre("slabWood", new ItemStack(UNIDENTIFIED_PLANKS_SLAB_HALF, 1, OreDictionary.WILDCARD_VALUE));
    }
}
