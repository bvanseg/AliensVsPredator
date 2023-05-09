package org.predator.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.block.BlockCustomSlab;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PredatorSlabBlocks implements IPreInitEvent {
    public static final PredatorSlabBlocks instance = new PredatorSlabBlocks();

    // Ship
    public static final BlockCustomSlab.Half SHIP_PANEL_SLAB_HALF = new BlockCustomSlab.Half("ship_panel_slab", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab.Half SHIP_PANEL_YAUTJA_SLAB_HALF = new BlockCustomSlab.Half("ship_panel_yautja_slab", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab.Half SHIP_BRICK_SLAB_HALF = new BlockCustomSlab.Half("ship_brick_slab", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab.Half SHIP_SUPPORT_PILLAR_SLAB_HALF = new BlockCustomSlab.Half("ship_support_pillar_slab", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab.Half SHIP_DECOR_3_SLAB_HALF = new BlockCustomSlab.Half("ship_decor_3_slab", PredatorBlockProperties.YAUTJA_METAL_PROPS);

    // Temple
    public static final BlockCustomSlab.Half TEMPLE_BRICK_SLAB_HALF = new BlockCustomSlab.Half("temple_brick_slab", PredatorBlockProperties.TEMPLE_PROPS);
    public static final BlockCustomSlab.Half TEMPLE_BRICK_SINGLE_SLAB_HALF = new BlockCustomSlab.Half("temple_brick_single_slab", PredatorBlockProperties.TEMPLE_PROPS);
    public static final BlockCustomSlab.Half TEMPLE_TILE_SLAB_HALF = new BlockCustomSlab.Half("temple_tile_slab", PredatorBlockProperties.TEMPLE_PROPS);
    public static final BlockCustomSlab.Half TEMPLE_WALL_SLAB_HALF = new BlockCustomSlab.Half("temple_wall_slab", PredatorBlockProperties.TEMPLE_PROPS);
    public static final BlockCustomSlab.Half TEMPLE_FLOOR_SLAB_HALF = new BlockCustomSlab.Half("temple_floor_slab", PredatorBlockProperties.TEMPLE_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        // Slabs
        BlockRegistryUtil.registerStandardSlabBlock(SHIP_PANEL_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(SHIP_PANEL_YAUTJA_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(SHIP_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(SHIP_SUPPORT_PILLAR_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(SHIP_DECOR_3_SLAB_HALF);

        BlockRegistryUtil.registerStandardSlabBlock(TEMPLE_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(TEMPLE_BRICK_SINGLE_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(TEMPLE_TILE_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(TEMPLE_WALL_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(TEMPLE_FLOOR_SLAB_HALF);
    }
}
