package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.block.BlockCustomStairs;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPStairBlocks implements IPreInitEvent
{
    public static final AVPStairBlocks instance = new AVPStairBlocks();

    private AVPStairBlocks() {}

    // Stairs
    public static final Block FLOOR_GRILL_STAIRS = new BlockCustomStairs("floorgrillstairs", AVPBlocks.INDUSTRIAL_PROPS, AVPBlocks.FLOOR_GRILL.getDefaultState()).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false).setLightOpacity(4);
    public static final Block CEILING_GRILL_STAIRS = new BlockCustomStairs("ceilinggrillstairs", AVPBlocks.INDUSTRIAL_PROPS, AVPBlocks.CEILING_GRILL.getDefaultState()).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false).setLightOpacity(4);
    public static final Block IRON_BRICKS_STAIRS = new BlockCustomStairs("industrialbrickstairs", AVPBlocks.INDUSTRIAL_PROPS, AVPBlocks.INDUSTRIAL_BRICKS.getDefaultState()).setLightOpacity(255);
    public static final Block WALL_STAIRS = new BlockCustomStairs("industrialwallstairs", AVPBlocks.INDUSTRIAL_PROPS, AVPBlocks.INDUSTRIAL_WALL.getDefaultState()).setLightOpacity(255);
    public static final Block INDUSTRIAL_GLASS_STAIRS = new BlockCustomStairs("industrialglassstairs", AVPBlocks.INDUSTRIAL_PROPS, AVPBlocks.INDUSTRIAL_GLASS.getDefaultState()).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false).setLightOpacity(0);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.instance.getLogger().info("Registering Stair Blocks");

        this.registerBlocks();
    }

    private void registerBlocks() {
        // Stairs
        BlockRegistryUtil.registerStandardBlock(FLOOR_GRILL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(CEILING_GRILL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(IRON_BRICKS_STAIRS);
        BlockRegistryUtil.registerStandardBlock(WALL_STAIRS);
        BlockRegistryUtil.registerStandardBlock(INDUSTRIAL_GLASS_STAIRS);
    }
}
