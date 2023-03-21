package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
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
    public static final Block FLOOR_GRILL_STAIRS = new BlockCustomStairs(AVPBlocks.FLOOR_GRILL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrillstairs");
    public static final Block CEILING_GRILL_STAIRS = new BlockCustomStairs(AVPBlocks.CEILING_GRILL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrillstairs");
    public static final Block IRON_BRICKS_STAIRS = new BlockCustomStairs(AVPBlocks.INDUSTRIAL_BRICKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialbrickstairs");
    public static final Block WALL_STAIRS = new BlockCustomStairs(AVPBlocks.INDUSTRIAL_WALL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialwallstairs");
    public static final Block INDUSTRIAL_GLASS_STAIRS = new BlockCustomStairs(AVPBlocks.INDUSTRIAL_GLASS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglassstairs");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.log().info("Registering Stair Blocks");

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
