package org.predator.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.block.BlockCustomStairs;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PredatorStairsBlocks implements IPreInitEvent {
    public static final PredatorStairsBlocks instance = new PredatorStairsBlocks();

    // Ship
    public static final Block SHIP_BRICK_STAIRS = new BlockCustomStairs("ship_brick_stairs", PredatorBlockProperties.YAUTJA_METAL_PROPS, PredatorBlocks.SHIP_BRICK.getDefaultState()).setLightOpacity(4);
    public static final Block SHIP_PANEL_STAIRS = new BlockCustomStairs("ship_panel_stairs", PredatorBlockProperties.YAUTJA_METAL_PROPS, PredatorBlocks.SHIP_PANEL.getDefaultState()).setLightOpacity(4);
    public static final Block SHIP_PANEL_YAUTJA_STAIRS = new BlockCustomStairs("ship_panel_yautja_stairs", PredatorBlockProperties.YAUTJA_METAL_PROPS, PredatorBlocks.SHIP_PANEL_YAUTJA.getDefaultState()).setLightOpacity(4);
    public static final Block SHIP_SUPPORT_PILLAR_STAIRS = new BlockCustomStairs("ship_support_pillar_stairs", PredatorBlockProperties.YAUTJA_METAL_PROPS, PredatorBlocks.SHIP_SUPPORT_PILLAR.getDefaultState()).setLightOpacity(4);
    public static final Block SHIP_DECOR_3_STAIRS = new BlockCustomStairs("ship_decor_3_stairs", PredatorBlockProperties.YAUTJA_METAL_PROPS, PredatorBlocks.SHIP_DECOR_3.getDefaultState()).setLightOpacity(4);


    // Temple
    public static final Block TEMPLE_BRICK_STAIRS = new BlockCustomStairs("temple_brick_stairs", PredatorBlockProperties.TEMPLE_PROPS, PredatorBlocks.TEMPLE_BRICK.getDefaultState()).setLightOpacity(4);
    public static final Block TEMPLE_BRICK_SINGLE_STAIRS = new BlockCustomStairs("temple_brick_single_stairs", PredatorBlockProperties.TEMPLE_PROPS, PredatorBlocks.TEMPLE_TILES_SINGLE.getDefaultState()).setLightOpacity(4);
    public static final Block TEMPLE_TILE_STAIRS = new BlockCustomStairs("temple_tile_stairs", PredatorBlockProperties.TEMPLE_PROPS, PredatorBlocks.TEMPLE_TILE.getDefaultState()).setLightOpacity(4);
    public static final Block TEMPLE_WALL_STAIRS = new BlockCustomStairs("temple_wall_stairs", PredatorBlockProperties.TEMPLE_PROPS, PredatorBlocks.TEMPLE_WALL_BASE.getDefaultState()).setLightOpacity(4);
    public static final Block TEMPLE_FLOOR_STAIRS = new BlockCustomStairs("temple_floor_stairs", PredatorBlockProperties.TEMPLE_PROPS, PredatorBlocks.TEMPLE_FLOOR.getDefaultState()).setLightOpacity(4);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        // Ship
        BlockRegistryUtil.registerStandardBlock(SHIP_BRICK_STAIRS);
        BlockRegistryUtil.registerStandardBlock(SHIP_PANEL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(SHIP_PANEL_YAUTJA_STAIRS);
        BlockRegistryUtil.registerStandardBlock(SHIP_SUPPORT_PILLAR_STAIRS);
        BlockRegistryUtil.registerStandardBlock(SHIP_DECOR_3_STAIRS);

        // Temple
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK_SINGLE_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILE_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_WALL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_FLOOR_STAIRS);
    }
}
