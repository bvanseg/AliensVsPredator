package org.predator.common;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.BlockStasisMechanism;
import org.avp.common.block.skull.*;
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

    @Override
    public void pre(FMLPreInitializationEvent fmlPreInitializationEvent) {
        this.registerBlocks();
        this.registerItemBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerBlock(METAL_1);
        BlockRegistryUtil.registerBlock(METAL_2);

        BlockRegistryUtil.registerBlock(SHIP_1);
        BlockRegistryUtil.registerBlock(SHIP_2);
        BlockRegistryUtil.registerBlock(SHIP_3);
        BlockRegistryUtil.registerBlock(SHIP_4);
        BlockRegistryUtil.registerBlock(SHIP_5);
        BlockRegistryUtil.registerBlock(SHIP_6);

        BlockRegistryUtil.registerBlock(TEMPLE_TILES_SINGLE);
        BlockRegistryUtil.registerBlock(TEMPLE_BRICK);
        BlockRegistryUtil.registerBlock(TEMPLE_TILE);
        BlockRegistryUtil.registerBlock(TEMPLE_WALL_1);
        BlockRegistryUtil.registerBlock(TEMPLE_WALL_2);

        BlockRegistryUtil.registerBlock(SKULL_YAUTJA);
        BlockRegistryUtil.registerBlock(BIOMASK_CLASSIC);
        BlockRegistryUtil.registerBlock(BIOMASK_BERSERKER);
        BlockRegistryUtil.registerBlock(BIOMASK_FALCONER);
        BlockRegistryUtil.registerBlock(BIOMASK_TRACKER);

        BlockRegistryUtil.registerBlock(STASIS_MECHANISM);
    }

    private void registerItemBlocks() {
        BlockRegistryUtil.registerItemBlock(METAL_1);
        BlockRegistryUtil.registerItemBlock(METAL_2);

        BlockRegistryUtil.registerItemBlock(SHIP_1);
        BlockRegistryUtil.registerItemBlock(SHIP_2);
        BlockRegistryUtil.registerItemBlock(SHIP_3);
        BlockRegistryUtil.registerItemBlock(SHIP_4);
        BlockRegistryUtil.registerItemBlock(SHIP_5);
        BlockRegistryUtil.registerItemBlock(SHIP_6);

        BlockRegistryUtil.registerItemBlock(TEMPLE_TILES_SINGLE);
        BlockRegistryUtil.registerItemBlock(TEMPLE_BRICK);
        BlockRegistryUtil.registerItemBlock(TEMPLE_TILE);
        BlockRegistryUtil.registerItemBlock(TEMPLE_WALL_1);
        BlockRegistryUtil.registerItemBlock(TEMPLE_WALL_2);

        BlockRegistryUtil.registerItemBlock(SKULL_YAUTJA);
        BlockRegistryUtil.registerItemBlock(BIOMASK_CLASSIC);
        BlockRegistryUtil.registerItemBlock(BIOMASK_BERSERKER);
        BlockRegistryUtil.registerItemBlock(BIOMASK_FALCONER);
        BlockRegistryUtil.registerItemBlock(BIOMASK_TRACKER);

        BlockRegistryUtil.registerItemBlock(STASIS_MECHANISM);
    }
}
