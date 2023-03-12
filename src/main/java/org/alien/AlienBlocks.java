package org.alien;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.world.block.BlockMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.AliensVsPredator;
import org.avp.common.Tab;
import org.avp.common.block.*;
import org.lib.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienBlocks implements IInitEvent {
    public static final AlienBlocks instance = new AlienBlocks();

    private AlienBlocks() {}

    public static final Block NATURAL_RESIN = new BlockHiveResin(Material.WOOD).setRegistryName("hiveresin");
    public static final Block RESIN = new BlockMaterial(Material.WOOD).setHardness(5F).setResistance(10.0F).setRegistryName("hiveresin.standard");
    public static final Block RELIC_OVAMORPH = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tileovamorphdesign");
    public static final Block RELIC_FACEHUGGER = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilefacehuggerdesign");
    public static final Block RELIC_ALIEN = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilealiendesign");

    /* Engineers */
    public static final Block ENGINEER_FLOOR = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipfloor");
    public static final Block ENGINEER_BRICK_0 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick");
    public static final Block ENGINEER_BRICK_1 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick1");
    public static final Block ENGINEER_BRICK_2 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick2");
    public static final Block ENGINEER_BRICK_3 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick3");
    public static final Block ENGINEER_GRAVEL = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipgravel");
    public static final Block ENGINEER_WALL_0 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall");
    public static final Block ENGINEER_WALL_1 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall1");
    public static final Block ENGINEER_WALL_2 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall2");
    public static final Block ENGINEER_WALL_3 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall3");
    public static final Block ENGINEER_WALL_4 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall4");
    public static final Block ENGINEER_ROCK_0 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock");
    public static final Block ENGINEER_ROCK_1 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock1");
    public static final Block ENGINEER_ROCK_2 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock2");
    public static final Block ENGINEER_ROCK_3 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock3");
    public static final Block ENGINEER_COLUMN_1 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipcolumn1");
    public static final Block ENGINEER_COLUMN_2 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipcolumn2");
    public static final Block ENGINEER_MATERIAL_0 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial0");
    public static final Block ENGINEER_MATERIAL_1 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial1");
    public static final Block ENGINEER_MATERIAL_2 = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial2");

    /* Paradise */
    public static final Block PARADISE_DIRT = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_DIRT_MOSSY = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_mossy").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_DIRT_PODZOL = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_podzol").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_GRASS = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_grass").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LEAVES_LARGE = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_large").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LOG_LARGE = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_large").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LEAVES_MED = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_med").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LOG_MED = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_med").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LEAVES_SMALL = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_small").setCreativeTab(Tab.BLOCKS);
    public static final Block PARADISE_LOG_SMALL = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_small").setCreativeTab(Tab.BLOCKS);
    public static final Block GROUND_FERN = new BlockGroundFern().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.BLOCKS).setRegistryName("paradisian_ground_fern");
    public static final Block TREE_FERN = new BlockTreeFern().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.BLOCKS).setRegistryName("paradisian_tree_fern");
    public static final Block WHEAT_GRASS = new BlockWheatGrass().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.BLOCKS).setRegistryName("paradisian_wheat_grass");

    /* Varda */
    public static final Block GIGER_LOG = new BlockUnidentifiedLog().setHardness(5F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.wood");
    public static final Block GIGER_TENDONS = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.tendons");
    public static final Block GIGER_LEAVES = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.TOP).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves");
    public static final Block GIGER_LEAVES_M = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.MIDDLE).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves.m");
    public static final Block GIGER_LEAVES_B = new BlockUnidentifiedTreeLeaves(BlockUnidentifiedTreeLeaves.Type.BOTTOM).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves.b");
    public static final Block GIGER_SAPLING = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("unitree.sapling");

    /* Acheron */
    public static final Block LV_426_ROCK = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("lv426rock");

    /* Misc */
    public static final Block PORTAL_VARDA = new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.varda");
    public static final Block PORTAL_ACHERON = new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.acheron");

    @Override
    public void init(FMLInitializationEvent fmlInitializationEvent) {
        BlockRegistryUtil.registerBlock(NATURAL_RESIN);
        BlockRegistryUtil.registerBlock(RESIN);
        BlockRegistryUtil.registerBlock(RELIC_OVAMORPH);

        BlockRegistryUtil.registerBlock(RELIC_FACEHUGGER);
        BlockRegistryUtil.registerBlock(RELIC_ALIEN);


        BlockRegistryUtil.registerBlock(ENGINEER_FLOOR);
        BlockRegistryUtil.registerBlock(ENGINEER_BRICK_0);
        BlockRegistryUtil.registerBlock(ENGINEER_BRICK_1);
        BlockRegistryUtil.registerBlock(ENGINEER_BRICK_2);
        BlockRegistryUtil.registerBlock(ENGINEER_BRICK_3);

        BlockRegistryUtil.registerBlock(ENGINEER_GRAVEL);

        BlockRegistryUtil.registerBlock(ENGINEER_WALL_0);
        BlockRegistryUtil.registerBlock(ENGINEER_WALL_1);
        BlockRegistryUtil.registerBlock(ENGINEER_WALL_2);
        BlockRegistryUtil.registerBlock(ENGINEER_WALL_3);
        BlockRegistryUtil.registerBlock(ENGINEER_WALL_4);

        BlockRegistryUtil.registerBlock(ENGINEER_ROCK_0);
        BlockRegistryUtil.registerBlock(ENGINEER_ROCK_1);
        BlockRegistryUtil.registerBlock(ENGINEER_ROCK_2);
        BlockRegistryUtil.registerBlock(ENGINEER_ROCK_3);

        BlockRegistryUtil.registerBlock(ENGINEER_COLUMN_1);
        BlockRegistryUtil.registerBlock(ENGINEER_COLUMN_2);

        BlockRegistryUtil.registerBlock(ENGINEER_MATERIAL_0);
        BlockRegistryUtil.registerBlock(ENGINEER_MATERIAL_1);
        BlockRegistryUtil.registerBlock(ENGINEER_MATERIAL_2);

        BlockRegistryUtil.registerBlock(PARADISE_DIRT);
        BlockRegistryUtil.registerBlock(PARADISE_DIRT_MOSSY);
        BlockRegistryUtil.registerBlock(PARADISE_DIRT_PODZOL);
        BlockRegistryUtil.registerBlock(PARADISE_GRASS);
        BlockRegistryUtil.registerBlock(PARADISE_LEAVES_LARGE);
        BlockRegistryUtil.registerBlock(PARADISE_LOG_LARGE);
        BlockRegistryUtil.registerBlock(PARADISE_LEAVES_MED);
        BlockRegistryUtil.registerBlock(PARADISE_LOG_MED);
        BlockRegistryUtil.registerBlock(PARADISE_LEAVES_SMALL);
        BlockRegistryUtil.registerBlock(PARADISE_LOG_SMALL);
        BlockRegistryUtil.registerBlock(GROUND_FERN);
        BlockRegistryUtil.registerBlock(TREE_FERN);
        BlockRegistryUtil.registerBlock(WHEAT_GRASS);

        BlockRegistryUtil.registerBlock(GIGER_LOG);
        BlockRegistryUtil.registerBlock(GIGER_TENDONS);
        BlockRegistryUtil.registerBlock(GIGER_LEAVES);
        BlockRegistryUtil.registerBlock(GIGER_LEAVES_M);
        BlockRegistryUtil.registerBlock(GIGER_LEAVES_B);
        BlockRegistryUtil.registerBlock(GIGER_SAPLING);

        BlockRegistryUtil.registerBlock(LV_426_ROCK);

        BlockRegistryUtil.registerBlock(PORTAL_VARDA);
        BlockRegistryUtil.registerBlock(PORTAL_ACHERON);
    }
}
