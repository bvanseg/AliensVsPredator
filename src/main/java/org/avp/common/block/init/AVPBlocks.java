package org.avp.common.block.init;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPBlocks implements IPreInitEvent
{
    public static final AVPBlocks instance = new AVPBlocks();

    private AVPBlocks() {}

    // Properties
    public static final BlockProperties INDUSTRIAL_PROPS = new BlockProperties(Material.IRON)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(5F).setResistance(15F);
    public static final BlockProperties PADDING_PROPS = new BlockProperties(Material.CLOTH)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(10F).setResistance(15.0F);
    public static final BlockProperties PLASTIC_PROPS = new BlockProperties(Material.CLAY)
            .setCreativeTab(AVPCreativeTabs.MAIN).setHardness(10F).setResistance(15.0F);


    // Ceiling
    public static final Block CEILING = new BasicBlock("ceilingpanel", INDUSTRIAL_PROPS);
    public static final Block CEILING_FAN = new BasicBlock("ceilingfan", INDUSTRIAL_PROPS).setLayer(BlockRenderLayer.TRANSLUCENT);
    public static final Block CEILING_VENT = new BasicBlock("ceilingvent", INDUSTRIAL_PROPS);
    public static final Block CEILING_GRILL = new BasicBlock("ceilinggrill", INDUSTRIAL_PROPS).setLayer(BlockRenderLayer.TRANSLUCENT).setLightOpacity(4);

    // Industrial
    public static final Block INDUSTRIAL_WALL = new BasicBlock("industrialwall", INDUSTRIAL_PROPS);
    public static final Block INDUSTRIAL_WALL_STRIPED = new BasicBlock("industrialwall2", INDUSTRIAL_PROPS).setLightOpacity(255);
    public static final Block INDUSTRIAL_GLASS = new BasicBlock("industrialglass", INDUSTRIAL_PROPS).setLayer(BlockRenderLayer.TRANSLUCENT);
    public static final Block INDUSTRIAL_BRICKS = new BasicBlock("industrialbricks", INDUSTRIAL_PROPS);

    // Metal
    public static final Block METAL_PANEL = new BasicBlock("metalpanel1", INDUSTRIAL_PROPS);
    public static final Block METAL_COLUMN_0 = new BasicBlock("metalpanel2", INDUSTRIAL_PROPS);
    public static final Block METAL_COLUMN_1 = new BasicBlock("metalpanel3", INDUSTRIAL_PROPS);

    // Padding
    public static final Block PADDING_PANEL = new BasicBlock("paddingpanel", PADDING_PROPS);
    public static final Block PADDING_PANEL_ORANGE = new BasicBlock("paddingpanel_orange", PADDING_PROPS);
    public static final Block PADDING_PIPES_ORANGE = new BasicBlock("padding_pipes_orange", PADDING_PROPS);
    public static final Block PADDING_PIPES_WHITE = new BasicBlock("padding_pipes_white", PADDING_PROPS);
    public static final Block PADDING_SQUARE_ORANGE = new BasicBlock("padding_square_orange", PADDING_PROPS);
    public static final Block PADDING_SQUARE_WHITE = new BasicBlock("padding_square_white", PADDING_PROPS);
    public static final Block PADDING_TILES_ORANGE = new BasicBlock("padding_tiles_orange", PADDING_PROPS);
    public static final Block PADDING_TILES_WHITE = new BasicBlock("padding_tiles_white", PADDING_PROPS);

    // Plastic
    public static final Block PLASTIC_CIRCLE = new BasicBlock("plastictilecircle", PLASTIC_PROPS);
    public static final Block PLASTIC = new BasicBlock("plasticblock", PLASTIC_PROPS);
    public static final Block PLASTIC_TRI = new BasicBlock("plastictiletri", PLASTIC_PROPS);
    public static final Block PLASTIC_TILE = new BasicBlock("plastictile", PLASTIC_PROPS);

    // Vents
    public static final Block VENT_0 = new BasicBlock("industrialvent", INDUSTRIAL_PROPS).setLightOpacity(0);
    public static final Block VENT_1 = new BasicBlock("vent.wall", INDUSTRIAL_PROPS).setLightOpacity(0);
    public static final Block VENT_2 = new BasicBlock("vent.ceiling", INDUSTRIAL_PROPS).setLightOpacity(0);

    // TODO:
    // Uncategorized
    public static final Block SKULLS = new BlockMaterial(Material.ROCK).setRegistryName("skulls");
    public static final Block FLOOR_GRILL = new BasicBlock("floorgrill", INDUSTRIAL_PROPS).setLayer(BlockRenderLayer.TRANSLUCENT).setLightOpacity(4);
    public static final Block MUTHUR_PANEL_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("mainframepanel.shimmer");
    public static final Block MUTHUR_PANEL_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("mainframepanel.flicker");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.instance.getLogger().info("Registering Blocks");

        this.registerBlocks();

        AVPOreBlocks.instance.pre(event);
        AVPStairBlocks.instance.pre(event);
        AVPSlabBlocks.instance.pre(event);
        AVPTileEntityBlocks.instance.pre(event);
        AVPReflectiveBlocks.instance.pre(event);
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(INDUSTRIAL_WALL);
        BlockRegistryUtil.registerStandardBlock(INDUSTRIAL_WALL_STRIPED);
        BlockRegistryUtil.registerStandardBlock(CEILING);
        BlockRegistryUtil.registerStandardBlock(CEILING_FAN);
        BlockRegistryUtil.registerStandardBlock(CEILING_VENT);
        BlockRegistryUtil.registerStandardBlock(CEILING_GRILL);

        BlockRegistryUtil.registerStandardBlock(SKULLS);
        BlockRegistryUtil.registerStandardBlock(FLOOR_GRILL);
        BlockRegistryUtil.registerStandardBlock(INDUSTRIAL_GLASS);
        BlockRegistryUtil.registerStandardBlock(INDUSTRIAL_BRICKS);

        BlockRegistryUtil.registerStandardBlock(METAL_PANEL);
        BlockRegistryUtil.registerStandardBlock(METAL_COLUMN_0);
        BlockRegistryUtil.registerStandardBlock(METAL_COLUMN_1);
        BlockRegistryUtil.registerStandardBlock(PLASTIC_CIRCLE);
        BlockRegistryUtil.registerStandardBlock(PLASTIC);

        BlockRegistryUtil.registerStandardBlock(PADDING_PANEL);
        BlockRegistryUtil.registerStandardBlock(PLASTIC_TRI);
        BlockRegistryUtil.registerStandardBlock(PLASTIC_TILE);

        BlockRegistryUtil.registerStandardBlock(MUTHUR_PANEL_1);
        BlockRegistryUtil.registerStandardBlock(MUTHUR_PANEL_2);

        BlockRegistryUtil.registerStandardBlock(VENT_0);
        BlockRegistryUtil.registerStandardBlock(VENT_1);
        BlockRegistryUtil.registerStandardBlock(VENT_2);

        BlockRegistryUtil.registerStandardBlock(PADDING_PANEL_ORANGE);
        BlockRegistryUtil.registerStandardBlock(PADDING_PIPES_ORANGE);

        BlockRegistryUtil.registerStandardBlock(PADDING_PIPES_WHITE);
        BlockRegistryUtil.registerStandardBlock(PADDING_SQUARE_ORANGE);

        BlockRegistryUtil.registerStandardBlock(PADDING_SQUARE_WHITE);
        BlockRegistryUtil.registerStandardBlock(PADDING_TILES_ORANGE);
        BlockRegistryUtil.registerStandardBlock(PADDING_TILES_WHITE);
    }
}
