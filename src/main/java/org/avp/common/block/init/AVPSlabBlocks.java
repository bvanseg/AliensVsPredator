package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.material.Material;
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
    public static final BlockCustomSlab.Half FLOOR_GRILL_SLAB_HALF = (BlockCustomSlab.Half) new BlockCustomSlab.Half("floor_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);
    public static final BlockCustomSlab.Half CEILING_GRILL_SLAB_HALF = (BlockCustomSlab.Half) new BlockCustomSlab.Half("ceiling_grill_slab", GRILL_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);
    public static final BlockCustomSlab.Half INDUSTRIAL_SLAB_HALF = new BlockCustomSlab.Half("industrial_slab", WALL_PROPS);
    public static final BlockCustomSlab.Half INDUSTRIAL_BRICK_SLAB_HALF = new BlockCustomSlab.Half("industrial_brick_slab", WALL_PROPS);
    public static final BlockCustomSlab.Half INDUSTRIAL_GLASS_SLAB_HALF = (BlockCustomSlab.Half) new BlockCustomSlab.Half("industrial_glass_slab", INDUSTRIAL_GLASS_PROPS).setRenderLayer(BlockRenderLayer.TRANSLUCENT).setDoesSideRendering(false);

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        AVP.log().info("Registering AVP Slab Blocks");

        this.registerBlocks();
    }

    private void registerBlocks() {
        // Slabs
        BlockRegistryUtil.registerStandardSlabBlock(FLOOR_GRILL_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(CEILING_GRILL_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(INDUSTRIAL_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(INDUSTRIAL_BRICK_SLAB_HALF);
        BlockRegistryUtil.registerStandardSlabBlock(INDUSTRIAL_GLASS_SLAB_HALF);
    }
}
