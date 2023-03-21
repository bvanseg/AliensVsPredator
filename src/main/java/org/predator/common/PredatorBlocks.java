package org.predator.common;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.BlockCustomSlab;
import org.avp.common.block.BlockStasisMechanism;
import org.avp.common.block.skull.*;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PredatorBlocks implements IPreInitEvent {
    public static final PredatorBlocks instance = new PredatorBlocks();

    public static final Block METAL_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippanel");
    public static final Block METAL_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippannelyautja");
    public static final Block SHIP_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipwallbase");
    public static final Block SHIP_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipsupportpillar");
    public static final Block SHIP_3 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor1");
    public static final Block SHIP_4 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipbrick");
    public static final Block SHIP_5 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor2");
    public static final Block SHIP_6 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor3");
    public static final Block TEMPLE_TILES_SINGLE = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("templebricksingle");
    public static final Block TEMPLE_BRICK = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templebrick");
    public static final Block TEMPLE_TILE = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templetile");
    public static final Block TEMPLE_WALL_1 = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templewallbase");
    public static final Block TEMPLE_WALL_2 = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templefloor");
    public static final Block STASIS_MECHANISM = new BlockStasisMechanism(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("stasismechanism");
    public static final Block SKULL_YAUTJA = new BlockSkullYautja().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.yautja");
    public static final Block BIOMASK_CLASSIC = new BlockBiomaskClassic().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.classic");
    public static final Block BIOMASK_BERSERKER = new BlockBiomaskBerserker().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.berserker");
    public static final Block BIOMASK_FALCONER = new BlockBiomaskFalconer().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.falconer");
    public static final Block BIOMASK_TRACKER = new BlockBiomaskTracker().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.tracker");

    public static final BlockProperties TEMPLE_PROPS = new BlockProperties(Material.ROCK).setHardness(5F).setResistance(15.0F);

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
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        this.registerBlocks();
        this.registerItemBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(METAL_1);
        BlockRegistryUtil.registerStandardBlock(METAL_2);

        BlockRegistryUtil.registerStandardBlock(SHIP_1);
        BlockRegistryUtil.registerStandardBlock(SHIP_2);
        BlockRegistryUtil.registerStandardBlock(SHIP_3);
        BlockRegistryUtil.registerStandardBlock(SHIP_4);
        BlockRegistryUtil.registerStandardBlock(SHIP_5);
        BlockRegistryUtil.registerStandardBlock(SHIP_6);

        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILES_SINGLE);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILE);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_WALL_1);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_WALL_2);

        BlockRegistryUtil.registerStandardBlock(SKULL_YAUTJA);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_CLASSIC);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_BERSERKER);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_FALCONER);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_TRACKER);

        BlockRegistryUtil.registerStandardBlock(STASIS_MECHANISM);

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
        BlockRegistryUtil.registerItemBlock(TEMPLE_BRICK_SLAB_HALF, new ItemSlab(TEMPLE_BRICK_SLAB_HALF, TEMPLE_BRICK_SLAB_HALF, TEMPLE_BRICK_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_BRICK_SINGLE_SLAB_HALF, new ItemSlab(TEMPLE_BRICK_SINGLE_SLAB_HALF, TEMPLE_BRICK_SINGLE_SLAB_HALF, TEMPLE_BRICK_SINGLE_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_TILE_SLAB_HALF, new ItemSlab(TEMPLE_TILE_SLAB_HALF, TEMPLE_TILE_SLAB_HALF, TEMPLE_TILE_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_WALL_SLAB_HALF, new ItemSlab(TEMPLE_WALL_SLAB_HALF, TEMPLE_WALL_SLAB_HALF, TEMPLE_WALL_SLAB_DOUBLE));
        BlockRegistryUtil.registerItemBlock(TEMPLE_FLOOR_SLAB_HALF, new ItemSlab(TEMPLE_FLOOR_SLAB_HALF, TEMPLE_FLOOR_SLAB_HALF, TEMPLE_FLOOR_SLAB_DOUBLE));
    }
}
