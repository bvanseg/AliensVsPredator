package org.predator.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.block.BlockCustomSlab;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PredatorSlabBlocks implements IPreInitEvent {
    public static final PredatorSlabBlocks instance = new PredatorSlabBlocks();

    public static final BlockProperties YAUTJA_METAL_PROPS = new BlockProperties(Material.IRON).setHardness(5F).setResistance(15.0F);
    public static final BlockProperties TEMPLE_PROPS = new BlockProperties(Material.ROCK).setHardness(5F).setResistance(15.0F);

    // Ship
    public static final BlockCustomSlab SHIP_PANEL_SLAB_HALF = new BlockCustomSlab.Half("ship_panel_slab", YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab SHIP_PANEL_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ship_panel_slab", YAUTJA_METAL_PROPS);

    public static final BlockCustomSlab SHIP_PANEL_YAUTJA_SLAB_HALF = new BlockCustomSlab.Half("ship_panel_yautja_slab", YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab SHIP_PANEL_YAUTJA_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ship_panel_yautja_slab", YAUTJA_METAL_PROPS);

    public static final BlockCustomSlab SHIP_BRICK_SLAB_HALF = new BlockCustomSlab.Half("ship_brick_slab", YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab SHIP_BRICK_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ship_brick_slab", YAUTJA_METAL_PROPS);

    public static final BlockCustomSlab SHIP_SUPPORT_PILLAR_SLAB_HALF = new BlockCustomSlab.Half("ship_support_pillar_slab", YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab SHIP_SUPPORT_PILLAR_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ship_support_pillar_slab", YAUTJA_METAL_PROPS);

    public static final BlockCustomSlab SHIP_DECOR_3_SLAB_HALF = new BlockCustomSlab.Half("ship_decor_3_slab", YAUTJA_METAL_PROPS);
    public static final BlockCustomSlab SHIP_DECOR_3_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ship_decor_3_slab", YAUTJA_METAL_PROPS);

    // Temple
    public static final BlockCustomSlab TEMPLE_BRICK_SLAB_HALF = new BlockCustomSlab.Half("temple_brick_slab", TEMPLE_PROPS);
    public static final BlockCustomSlab TEMPLE_BRICK_SLAB_DOUBLE = new BlockCustomSlab.Double("double_temple_brick_slab", TEMPLE_PROPS);

    public static final BlockCustomSlab TEMPLE_BRICK_SINGLE_SLAB_HALF = new BlockCustomSlab.Half("temple_brick_single_slab", TEMPLE_PROPS);
    public static final BlockCustomSlab TEMPLE_BRICK_SINGLE_SLAB_DOUBLE = new BlockCustomSlab.Double("double_temple_brick_single_slab", TEMPLE_PROPS);

    public static final BlockCustomSlab TEMPLE_TILE_SLAB_HALF = new BlockCustomSlab.Half("temple_tile_slab", TEMPLE_PROPS);
    public static final BlockCustomSlab TEMPLE_TILE_SLAB_DOUBLE = new BlockCustomSlab.Double("double_temple_tile_slab", TEMPLE_PROPS);

    public static final BlockCustomSlab TEMPLE_WALL_SLAB_HALF = new BlockCustomSlab.Half("temple_wall_slab", TEMPLE_PROPS);
    public static final BlockCustomSlab TEMPLE_WALL_SLAB_DOUBLE = new BlockCustomSlab.Double("double_temple_wall_slab", TEMPLE_PROPS);

    public static final BlockCustomSlab TEMPLE_FLOOR_SLAB_HALF = new BlockCustomSlab.Half("temple_floor_slab", TEMPLE_PROPS);
    public static final BlockCustomSlab TEMPLE_FLOOR_SLAB_DOUBLE = new BlockCustomSlab.Double("double_temple_floor_slab", TEMPLE_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
        this.registerItemBlocks();
    }

    private void registerBlocks() {
        // Slabs
        BlockRegistryUtil.registerBlock(SHIP_PANEL_SLAB_HALF);
        BlockRegistryUtil.registerBlock(SHIP_PANEL_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(SHIP_PANEL_YAUTJA_SLAB_HALF);
        BlockRegistryUtil.registerBlock(SHIP_PANEL_YAUTJA_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(SHIP_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerBlock(SHIP_BRICK_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(SHIP_SUPPORT_PILLAR_SLAB_HALF);
        BlockRegistryUtil.registerBlock(SHIP_SUPPORT_PILLAR_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(SHIP_DECOR_3_SLAB_HALF);
        BlockRegistryUtil.registerBlock(SHIP_DECOR_3_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(TEMPLE_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerBlock(TEMPLE_BRICK_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(TEMPLE_BRICK_SINGLE_SLAB_HALF);
        BlockRegistryUtil.registerBlock(TEMPLE_BRICK_SINGLE_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(TEMPLE_TILE_SLAB_HALF);
        BlockRegistryUtil.registerBlock(TEMPLE_TILE_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(TEMPLE_WALL_SLAB_HALF);
        BlockRegistryUtil.registerBlock(TEMPLE_WALL_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(TEMPLE_FLOOR_SLAB_HALF);
        BlockRegistryUtil.registerBlock(TEMPLE_FLOOR_SLAB_DOUBLE);
    }

    private void registerItemBlocks() {
        BlockRegistryUtil.registerItemBlock(SHIP_PANEL_SLAB_HALF, new ItemSlab(SHIP_PANEL_SLAB_HALF, SHIP_PANEL_SLAB_HALF, SHIP_PANEL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(SHIP_PANEL_YAUTJA_SLAB_HALF, new ItemSlab(SHIP_PANEL_YAUTJA_SLAB_HALF, SHIP_PANEL_YAUTJA_SLAB_HALF, SHIP_PANEL_YAUTJA_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(SHIP_BRICK_SLAB_HALF, new ItemSlab(SHIP_BRICK_SLAB_HALF, SHIP_BRICK_SLAB_HALF, SHIP_BRICK_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(SHIP_SUPPORT_PILLAR_SLAB_HALF, new ItemSlab(SHIP_SUPPORT_PILLAR_SLAB_HALF, SHIP_SUPPORT_PILLAR_SLAB_HALF, SHIP_SUPPORT_PILLAR_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(SHIP_DECOR_3_SLAB_HALF, new ItemSlab(SHIP_DECOR_3_SLAB_HALF, SHIP_DECOR_3_SLAB_HALF, SHIP_DECOR_3_SLAB_DOUBLE));

        BlockRegistryUtil.registerItemBlock(TEMPLE_BRICK_SLAB_HALF, new ItemSlab(TEMPLE_BRICK_SLAB_HALF, TEMPLE_BRICK_SLAB_HALF, TEMPLE_BRICK_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_BRICK_SINGLE_SLAB_HALF, new ItemSlab(TEMPLE_BRICK_SINGLE_SLAB_HALF, TEMPLE_BRICK_SINGLE_SLAB_HALF, TEMPLE_BRICK_SINGLE_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_TILE_SLAB_HALF, new ItemSlab(TEMPLE_TILE_SLAB_HALF, TEMPLE_TILE_SLAB_HALF, TEMPLE_TILE_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_WALL_SLAB_HALF, new ItemSlab(TEMPLE_WALL_SLAB_HALF, TEMPLE_WALL_SLAB_HALF, TEMPLE_WALL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_FLOOR_SLAB_HALF, new ItemSlab(TEMPLE_FLOOR_SLAB_HALF, TEMPLE_FLOOR_SLAB_HALF, TEMPLE_FLOOR_SLAB_DOUBLE));
    }
}
