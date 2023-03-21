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

    public static final Block TEMPLE_BRICK_STAIRS = new BlockCustomStairs(PredatorBlocks.TEMPLE_BRICK.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("temple_brick_stairs");
    public static final Block TEMPLE_BRICK_SINGLE_STAIRS = new BlockCustomStairs(PredatorBlocks.TEMPLE_TILES_SINGLE.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("temple_brick_single_stairs");
    public static final Block TEMPLE_TILE_STAIRS = new BlockCustomStairs(PredatorBlocks.TEMPLE_TILE.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("temple_tile_stairs");
    public static final Block TEMPLE_WALL_STAIRS = new BlockCustomStairs(PredatorBlocks.TEMPLE_WALL_BASE.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("temple_wall_stairs");
    public static final Block TEMPLE_FLOOR_STAIRS = new BlockCustomStairs(PredatorBlocks.TEMPLE_FLOOR.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("temple_floor_stairs");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        // Stairs
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK_SINGLE_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILE_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_WALL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_FLOOR_STAIRS);
    }
}
