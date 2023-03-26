package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.AVP;
import org.avp.common.block.BlockCustomSlab;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPSlabBlocks implements IPreInitEvent
{
    public static final AVPSlabBlocks instance = new AVPSlabBlocks();

    private AVPSlabBlocks() {}

    public static final BlockProperties GRILL_PROPS = new BlockProperties(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public static final BlockProperties WALL_PROPS = new BlockProperties(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255);

    public static final BlockProperties INDUSTRIAL_GLASS_PROPS = new BlockProperties(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);

    // Slabs
    public static final BlockCustomSlab FLOOR_GRILL_SLAB_HALF = new BlockCustomSlab.Half("floor_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);
    public static final BlockCustomSlab FLOOR_GRILL_SLAB_DOUBLE = new BlockCustomSlab.Double("double_floor_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);

    public static final BlockCustomSlab CEILING_GRILL_SLAB_HALF = new BlockCustomSlab.Half("ceiling_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);
    public static final BlockCustomSlab CEILING_GRILL_SLAB_DOUBLE = new BlockCustomSlab.Double("double_ceiling_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);

    public static final BlockCustomSlab INDUSTRIAL_SLAB_HALF = new BlockCustomSlab.Half("industrial_slab", WALL_PROPS);
    public static final BlockCustomSlab INDUSTRIAL_SLAB_DOUBLE = new BlockCustomSlab.Double("double_industrial_slab", WALL_PROPS);

    public static final BlockCustomSlab INDUSTRIAL_BRICK_SLAB_HALF = new BlockCustomSlab.Half("industrial_brick_slab", WALL_PROPS);
    public static final BlockCustomSlab INDUSTRIAL_BRICK_SLAB_DOUBLE = new BlockCustomSlab.Double("double_industrial_brick_slab", WALL_PROPS);

    public static final BlockCustomSlab INDUSTRIAL_GLASS_SLAB_HALF = new BlockCustomSlab.Half("industrial_glass_slab", INDUSTRIAL_GLASS_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);
    public static final BlockCustomSlab INDUSTRIAL_GLASS_SLAB_DOUBLE = new BlockCustomSlab.Double("double_industrial_glass_slab", INDUSTRIAL_GLASS_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        AVP.log().info("Registering Slab Blocks");

        this.registerBlocks();
        this.registerItemBlocks();
    }

    private void registerBlocks() {
        // Slabs
        BlockRegistryUtil.registerBlock(FLOOR_GRILL_SLAB_HALF);
        BlockRegistryUtil.registerBlock(FLOOR_GRILL_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(CEILING_GRILL_SLAB_HALF);
        BlockRegistryUtil.registerBlock(CEILING_GRILL_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(INDUSTRIAL_SLAB_HALF);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(INDUSTRIAL_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_BRICK_SLAB_DOUBLE);

        BlockRegistryUtil.registerBlock(INDUSTRIAL_GLASS_SLAB_HALF);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_GLASS_SLAB_DOUBLE);
    }

    private void registerItemBlocks() {
        // Slabs
        BlockRegistryUtil.registerItemBlock(FLOOR_GRILL_SLAB_HALF, new ItemSlab(FLOOR_GRILL_SLAB_HALF, FLOOR_GRILL_SLAB_HALF, FLOOR_GRILL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(CEILING_GRILL_SLAB_HALF, new ItemSlab(CEILING_GRILL_SLAB_HALF, CEILING_GRILL_SLAB_HALF, CEILING_GRILL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(INDUSTRIAL_SLAB_HALF, new ItemSlab(INDUSTRIAL_SLAB_HALF, INDUSTRIAL_SLAB_HALF, INDUSTRIAL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(INDUSTRIAL_BRICK_SLAB_HALF, new ItemSlab(INDUSTRIAL_BRICK_SLAB_HALF, INDUSTRIAL_BRICK_SLAB_HALF, INDUSTRIAL_BRICK_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(INDUSTRIAL_GLASS_SLAB_HALF, new ItemSlab(INDUSTRIAL_GLASS_SLAB_HALF, INDUSTRIAL_GLASS_SLAB_HALF, INDUSTRIAL_GLASS_SLAB_DOUBLE));
    }
}
