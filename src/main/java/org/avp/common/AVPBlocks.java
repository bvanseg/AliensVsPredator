package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.world.block.BlockMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import org.avp.AliensVsPredator;
import org.avp.common.block.*;
import org.avp.common.block.BlockUnidentifiedTreeLeaves.Type;
import org.avp.common.block.skulls.*;
import org.avp.common.item.ItemBlockSkull;
import org.avp.common.item.supply.chute.SupplyChuteType;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPBlocks implements IInitEvent
{
    public static final AVPBlocks instance = new AVPBlocks();

    private AVPBlocks() {}

    private static final HashMap<Block, ItemBlock> ITEM_BLOCKS = new HashMap<>();

    private static final ArrayList<BlockFluidBase> FLUIDS = new ArrayList<>();
    
    public static final Block NATURAL_RESIN = new BlockHiveResin(Material.WOOD).setRegistryName("hiveresin");
    public static final Block RESIN = new BlockMaterial(Material.WOOD).setHardness(5F).setResistance(10.0F).setRegistryName("hiveresin.standard");
    public static final Block RELIC_OVAMORPH = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tileovamorphdesign");
    public static final Block METAL_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippanel");
    public static final Block METAL_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippannelyautja");
    public static final Block RELIC_FACEHUGGER = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilefacehuggerdesign");
    public static final Block RELIC_ALIEN = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilealiendesign");
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
    public static final Block INDUSTRIAL_WALL = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("industrialwall");
    public static final Block INDUSTRIAL_WALL_STRIPED = new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialwall2");
    public static final Block CEILING = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("ceilingpanel");
    public static final Block CEILING_FAN = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setRegistryName("ceilingfan");
    public static final Block CEILING_VENT = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("ceilingvent");
    public static final Block CEILING_GRILL = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrill");
    public static final Block SKULLS = new BlockMaterial(Material.ROCK).setRegistryName("skulls");
    public static final Block FLOOR_GRILL = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrill");
    public static final Block INDUSTRIAL_GLASS = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglass");
    public static final Block INDUSTRIAL_BRICKS = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("industrialbricks");
    public static final Block METAL_PANEL = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel1");
    public static final Block METAL_COLUMN_0 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel2");
    public static final Block METAL_COLUMN_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel3");
    public static final Block PLASTIC_CIRCLE = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictilecircle");
    public static final Block PLASTIC = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plasticblock");
    public static final Block PADDING_PANEL = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("paddingpanel");
    public static final Block PLASTIC_TRI = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictiletri");
    public static final Block PLASTIC_TILE = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictile");
    public static final Block ORE_SILICON = new BlockOreSilicon().setHardness(2.2F).setResistance(1.4F).setCreativeTab(Tab.MAIN).setRegistryName("oresilicon");
    public static final Block ORE_LITHIUM = new BlockMaterial(Material.IRON).setHardness(4.2F).setResistance(5.4F).setCreativeTab(Tab.MAIN).setRegistryName("orelithium");
    public static final Block ORE_COPPER = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("orecopper");
    public static final Block ORE_BAUXITE = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("orebauxite");
    public static final Block ORE_MONAZITE = new BlockOreMonazite().setCreativeTab(Tab.MAIN).setRegistryName("oremonazite");
    public static final Block ORE_COBALT = new BlockOreCobalt().setCreativeTab(Tab.MAIN).setRegistryName("orecobalt");
    public static final Block MUTHUR_PANEL_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F).setCreativeTab(Tab.MAIN).setRegistryName("mainframepanel.shimmer");
    public static final Block MUTHUR_PANEL_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F).setCreativeTab(Tab.MAIN).setRegistryName("mainframepanel.flicker");
    public static final Block VENT_0 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialvent");
    public static final Block VENT_1 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("vent.wall");
    public static final Block VENT_2 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("vent.ceiling");
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
    public static final Block PADDING_PANEL_ORANGE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("paddingpanel_orange");
    public static final Block PADDING_PIPES_ORANGE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_pipes_orange");
    public static final Block PADDING_PIPES_WHITE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_pipes_white");
    public static final Block PADDING_SQUARE_ORANGE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_square_orange");
    public static final Block PADDING_SQUARE_WHITE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_square_white");
    public static final Block PADDING_TILES_ORANGE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_tiles_orange");
    public static final Block PADDING_TILES_WHITE = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_tiles_white");
    
    /** Dimension Common **/
    public static final Block UNISTONE = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("unistone");
    public static final Block UNISAND = new BlockMaterial(Material.SAND).setHardness(3.5F).setResistance(2.0F).setRegistryName("unisand");
    public static final Block UNIGRAVEL = new BlockMaterial(Material.SAND).setHardness(3.0F).setLightOpacity(255).setRegistryName("unigravel");
    public static final Block UNIDIRT = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("unidirt").setCreativeTab(Tab.BLOCKS);
    public static final Block STALAGMITE = new BlockStalagmite(Material.PLANTS).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("stalagmite");
    
    /** Paradise **/
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
    
    /** Varda **/
    public static final Block GIGER_LOG = new BlockUnidentifiedLog().setHardness(5F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.wood");
    public static final Block GIGER_TENDONS = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.tendons");
    public static final Block GIGER_LEAVES = new BlockUnidentifiedTreeLeaves(Type.TOP).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves");
    public static final Block GIGER_LEAVES_M = new BlockUnidentifiedTreeLeaves(Type.MIDDLE).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves.m");
    public static final Block GIGER_LEAVES_B = new BlockUnidentifiedTreeLeaves(Type.BOTTOM).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves.b");
    public static final Block GIGER_SAPLING = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("unitree.sapling");
    
    /** Acheron **/
    public static final Block LV_426_ROCK = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("lv426rock");
    
    public static final Block SATELLITE_DISH = new BlockSatelliteDish().setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("satellitedish");
    public static final Block EGG_RECEPTACLE = new BlockTempleSpawner(Material.ROCK, false).setCreativeTab(Tab.MAIN).setRegistryName("spawner");
    public static final Block PORTAL_VARDA = new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.varda");
    public static final Block PORTAL_ACHERON = new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.acheron");
    public static final Block ASSEMBLER = new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("assembler");
    public static final Block FLOOR_GRILL_STAIRS = new BlockCustomStairs(FLOOR_GRILL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrillstairs");
    public static final Block CEILING_GRILL_STAIRS = new BlockCustomStairs(CEILING_GRILL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrillstairs");
    public static final Block IRON_BRICKS_STAIRS = new BlockCustomStairs(INDUSTRIAL_BRICKS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialbrickstairs");
    public static final Block WALL_STAIRS = new BlockCustomStairs(INDUSTRIAL_WALL.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialwallstairs");
    public static final Block INDUSTRIAL_GLASS_STAIRS = new BlockCustomStairs(INDUSTRIAL_GLASS.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglassstairs");
    public static final Block FLOOR_GRILL_SLAB = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrillslab");
    public static final Block CEILING_GRILL_SLAB = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrillslab");
    public static final Block WALL_SLAB = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialslab");
    public static final Block IRON_BRICKS_SLAB = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialbrickslab");
    public static final Block INDUSTRIAL_GLASS_SLAB = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglassslab");
    public static final Block BLACK_GOO = createFluidBlock(BlockBlackGoo.fluid, BlockBlackGoo.class, "blackgoo");
    public static final Block MIST = createFluidBlock(BlockMist.fluid, BlockMist.class, "mist");
    public static final Block TURRET = new BlockTurret(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("turret");
    public static final Block TERMINAL = new BlockWorkstation(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("terminal");
    public static final Block STASIS_MECHANISM = new BlockStasisMechanism(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("stasismechanism");
    public static final Block REPULSION_GENERATOR = new BlockGenerator(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("generator");
    public static final Block POWERLINE = new BlockPowerline(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("powerline");
    public static final Block BLAST_DOOR = new BlockBlastdoor(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("blastdoor");
    public static final Block SEVASTOPOL_BLAST_DOOR = new BlockSevastopolBlastDoor().setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("blastdoor.sevastopol");
    public static final Block CRYO_TUBE = new BlockCryostasisTube(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(4).setCreativeTab(Tab.MAIN).setRegistryName("cryostasistube");
    public static final Block LIGHT_PANEL = new BlockLightPanel(Material.IRON).setHardness(1.5F).setResistance(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("lightpanel");
    public static final Block CCFL_TUBE = new BlockCCFLTube(Material.IRON).setHardness(0.5F).setResistance(1.0F).setCreativeTab(Tab.MAIN).setRegistryName("ccfltube");
    public static final Block TESLA_COIL = new BlockTeslaCoil(Material.IRON).setHardness(0.5F).setResistance(1.0F).setCreativeTab(Tab.MAIN).setRegistryName("teslacoil");
    public static final Block NETWORK_RACK = new BlockNetworkRack(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("networkrack");
    public static final Block POWERCELL = new BlockPowercell(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("powercell");
    public static final Block REDSTONE_SENSOR = new BlockRedstoneSensor(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("redstonesensor");
    public static final Block REDSTONE_EMITTER = new BlockRedstoneEmitter(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("redstoneemitter");
    public static final Block UNIVERSAL_GENERATOR = new BlockRedstoneFluxGenerator(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("universalgenerator");
    public static final Block TRANSFORMER = new BlockTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("transformer");
    public static final Block STEPDOWN_TRANSFORMER = new BlockNegativeTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("transformer.stepdown");
    public static final Block SUPPLY_CRATE = new BlockSupplyCrate(SupplyChuteType.UNBRANDED).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock");
    public static final Block CRATE_MARINES = new BlockSupplyCrate(SupplyChuteType.MARINES).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock.marines");
    public static final Block CRATE_SEEGSON = new BlockSupplyCrate(SupplyChuteType.SEEGSON).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock.seegson");
    public static final Block SOLAR_PANEL = new BlockSolarPanel(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("solarpanel");
    public static final Block LOCKER = new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("locker");
    public static final Block MEDPOD = new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("medpod");
    public static final Block GUN_LOCKER = new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("gunlocker");
    public static final Block AMPULE = new BlockAmpule().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("engineership.ampule");
    public static final Block SKULL_ENGINEER = new BlockSkullEngineer().setCreativeTab(Tab.MAIN).setRegistryName("skull.engineer");
    public static final Block SKULL_JOCKEY = new BlockSkullSpaceJockey().setCreativeTab(Tab.MAIN).setRegistryName("skull.spacejockey");
    public static final Block SKULL_XENO = new BlockSkullXenomorph().setCreativeTab(Tab.MAIN).setRegistryName("skull.xenomorph");
    public static final Block SKULL_XENO_WARRIOR = new BlockSkullXenomorphWarrior().setCreativeTab(Tab.MAIN).setRegistryName("skull.xenomorph.warrior");
    public static final Block SKULL_YAUTJA = new BlockSkullYautja().setCreativeTab(Tab.MAIN).setRegistryName("skull.yautja");
    public static final Block SKULL_MATRIARCH = new BlockSkullMatriarch().setCreativeTab(Tab.MAIN).setRegistryName("skull.matriarch");
    public static final Block SKULL_PROTOMORPH = new BlockSkullProtomorph().setCreativeTab(Tab.MAIN).setRegistryName("skull.protomorph");
    public static final Block SKULL_NEOMORPH = new BlockSkullNeomorph().setCreativeTab(Tab.MAIN).setRegistryName("skull.neomorph");
    public static final Block BIOMASK_CLASSIC = new BlockBiomaskClassic().setCreativeTab(Tab.MAIN).setRegistryName("biomask.classic");
    public static final Block BIOMASK_BERSERKER = new BlockBiomaskBerserker().setCreativeTab(Tab.MAIN).setRegistryName("biomask.berserker");
    public static final Block BIOMASK_FALCONER = new BlockBiomaskFalconer().setCreativeTab(Tab.MAIN).setRegistryName("biomask.falconer");
    public static final Block BIOMASK_TRACKER = new BlockBiomaskTracker().setCreativeTab(Tab.MAIN).setRegistryName("biomask.tracker");
    public static final Block HEAD_AETHON = new BlockHeadAethon().setCreativeTab(Tab.MAIN).setRegistryName("head.aethon");
    public static final Block HEAD_GIGER_ALIEN = new BlockHeadGigerAlien().setCreativeTab(Tab.MAIN).setRegistryName("head.gigeralien");
    public static final Block SLOPE = new BlockReflective(Material.CIRCUITS).setRegistryName("slope");
    public static final Block CORNER = new BlockReflective(Material.CIRCUITS).setRegistryName("corner");
    public static final Block INVERTED_CORNER = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedcorner");
    public static final Block RIDGE = new BlockReflective(Material.CIRCUITS).setRegistryName("ridge");
    public static final Block PYRAMID = new BlockReflective(Material.CIRCUITS).setRegistryName("pyramid");
    public static final Block INVERTED_RIDGE = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedridge");
    public static final Block INVERTED_PYRAMID = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedpyramid");

    private static void registerBlock(Object obj) {
        if (obj instanceof Block)
        {
            createItem((Block) obj);
        }

        if (obj instanceof Block)
        {
            // Register block
            Block block = (Block) obj;
            block.setTranslationKey(block.getRegistryName().getNamespace() + ":" + block.getRegistryName().getPath());
            ForgeRegistries.BLOCKS.register(block);

            if (block.getCreativeTab() == null)
            {
                block.setCreativeTab(Tab.BLOCKS);
            }
            registerModel(getItemFromBlock(block));

            // Register item block
            ItemBlock itemblock = getItemFromBlock(block);
            ForgeRegistries.ITEMS.register(itemblock);
            registerModel(itemblock);

            itemblock.setCreativeTab(Tab.BLOCKS);

            if (block.getCreativeTab() != null)
            {
                itemblock.setCreativeTab(block.getCreativeTab());
            }
            else
            {
                itemblock.setCreativeTab(Tab.BLOCKS);
            }

            // Register fluid
            if (obj instanceof BlockFluidBase) {
                BlockFluidBase fluid = (BlockFluidBase) obj;
                FLUIDS.add(fluid);
            }
        }
    }
    
    private static void createItem(Block block)
    {
        ItemBlock itemblock;
        
        if (block instanceof BlockSkull)
            itemblock = new ItemBlockSkull(block);
        else
            itemblock = new ItemBlock(block);
        
        itemblock.setRegistryName(block.getRegistryName());
        itemblock.setTranslationKey(itemblock.getRegistryName().toString());

        ITEM_BLOCKS.put(block, itemblock);
    }
    
    public static ItemBlock getItemFromBlock(Block block)
    {
        return ITEM_BLOCKS.get(block);
    }

    public static ArrayList<BlockFluidBase> getFluids()
    {
        return FLUIDS;
    }

    private static void registerModel(ItemBlock item)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
        }

    }

    private static Block createFluidBlock(Fluid fluid, Class<? extends BlockFluidBase> c, String registryName)
    {
        FluidRegistry.registerFluid(fluid);
        FluidRegistry.addBucketForFluid(fluid);

        try
        {
            Object o = c.getConstructor().newInstance();

            if (o instanceof BlockFluidBase)
            {
                return ((BlockFluidBase) o).setRegistryName(registryName);
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public void init(FMLInitializationEvent event) {
        AliensVsPredator.log().info("Registering Blocks");
        registerBlock(NATURAL_RESIN);
        registerBlock(RESIN);
        registerBlock(RELIC_OVAMORPH);

        registerBlock(METAL_1);
        registerBlock(METAL_2);

        registerBlock(RELIC_FACEHUGGER);
        registerBlock(RELIC_ALIEN);

        registerBlock(SHIP_1);
        registerBlock(SHIP_2);
        registerBlock(SHIP_3);
        registerBlock(SHIP_4);
        registerBlock(SHIP_5);
        registerBlock(SHIP_6);

        registerBlock(TEMPLE_TILES_SINGLE);
        registerBlock(TEMPLE_BRICK);
        registerBlock(TEMPLE_TILE);
        registerBlock(TEMPLE_WALL_1);
        registerBlock(TEMPLE_WALL_2);

        registerBlock(INDUSTRIAL_WALL);
        registerBlock(INDUSTRIAL_WALL_STRIPED);
        registerBlock(CEILING);
        registerBlock(CEILING_FAN);
        registerBlock(CEILING_VENT);
        registerBlock(CEILING_GRILL);

        registerBlock(SKULLS);
        registerBlock(FLOOR_GRILL);
        registerBlock(INDUSTRIAL_GLASS);
        registerBlock(INDUSTRIAL_BRICKS);

        registerBlock(METAL_PANEL);
        registerBlock(METAL_COLUMN_0);
        registerBlock(METAL_COLUMN_1);
        registerBlock(PLASTIC_CIRCLE);
        registerBlock(PLASTIC);

        registerBlock(PADDING_PANEL);
        registerBlock(PLASTIC_TRI);
        registerBlock(PLASTIC_TILE);

        registerBlock(ORE_BAUXITE);
        registerBlock(ORE_COBALT);
        registerBlock(ORE_COPPER);
        registerBlock(ORE_LITHIUM);
        registerBlock(ORE_MONAZITE);
        registerBlock(ORE_SILICON);

        registerBlock(MUTHUR_PANEL_1);
        registerBlock(MUTHUR_PANEL_2);

        registerBlock(VENT_0);
        registerBlock(VENT_1);
        registerBlock(VENT_2);

        registerBlock(ENGINEER_FLOOR);
        registerBlock(ENGINEER_BRICK_0);
        registerBlock(ENGINEER_BRICK_1);
        registerBlock(ENGINEER_BRICK_2);
        registerBlock(ENGINEER_BRICK_3);

        registerBlock(ENGINEER_GRAVEL);

        registerBlock(ENGINEER_WALL_0);
        registerBlock(ENGINEER_WALL_1);
        registerBlock(ENGINEER_WALL_2);
        registerBlock(ENGINEER_WALL_3);
        registerBlock(ENGINEER_WALL_4);

        registerBlock(ENGINEER_ROCK_0);
        registerBlock(ENGINEER_ROCK_1);
        registerBlock(ENGINEER_ROCK_2);
        registerBlock(ENGINEER_ROCK_3);

        registerBlock(ENGINEER_COLUMN_1);
        registerBlock(ENGINEER_COLUMN_2);

        registerBlock(ENGINEER_MATERIAL_0);
        registerBlock(ENGINEER_MATERIAL_1);
        registerBlock(ENGINEER_MATERIAL_2);

        registerBlock(PADDING_PANEL_ORANGE);
        registerBlock(PADDING_PIPES_ORANGE);

        registerBlock(PADDING_PIPES_WHITE);
        registerBlock(PADDING_SQUARE_ORANGE);

        registerBlock(PADDING_SQUARE_WHITE);
        registerBlock(PADDING_TILES_ORANGE);
        registerBlock(PADDING_TILES_WHITE);

        registerBlock(UNISTONE);
        registerBlock(UNISAND);
        registerBlock(UNIGRAVEL);
        registerBlock(UNIDIRT);

        registerBlock(STALAGMITE);

        registerBlock(PARADISE_DIRT);
        registerBlock(PARADISE_DIRT_MOSSY);
        registerBlock(PARADISE_DIRT_PODZOL);
        registerBlock(PARADISE_GRASS);
        registerBlock(PARADISE_LEAVES_LARGE);
        registerBlock(PARADISE_LOG_LARGE);
        registerBlock(PARADISE_LEAVES_MED);
        registerBlock(PARADISE_LOG_MED);
        registerBlock(PARADISE_LEAVES_SMALL);
        registerBlock(PARADISE_LOG_SMALL);
        registerBlock(GROUND_FERN);
        registerBlock(TREE_FERN);
        registerBlock(WHEAT_GRASS);

        registerBlock(GIGER_LOG);
        registerBlock(GIGER_TENDONS);
        registerBlock(GIGER_LEAVES);
        registerBlock(GIGER_LEAVES_M);
        registerBlock(GIGER_LEAVES_B);
        registerBlock(GIGER_SAPLING);

        registerBlock(LV_426_ROCK);

        registerBlock(SATELLITE_DISH);
        registerBlock(EGG_RECEPTACLE);

        registerBlock(PORTAL_VARDA);
        registerBlock(PORTAL_ACHERON);

        registerBlock(ASSEMBLER);
        registerBlock(FLOOR_GRILL_STAIRS);
        registerBlock(CEILING_GRILL_STAIRS);
        registerBlock(IRON_BRICKS_STAIRS);
        registerBlock(WALL_STAIRS);
        registerBlock(INDUSTRIAL_GLASS_STAIRS);
        registerBlock(FLOOR_GRILL_SLAB);
        registerBlock(CEILING_GRILL_SLAB);
        registerBlock(WALL_SLAB);
        registerBlock(IRON_BRICKS_SLAB);
        registerBlock(INDUSTRIAL_GLASS_SLAB);
        registerBlock(BLACK_GOO);
        registerBlock(MIST);
        registerBlock(TURRET);
        registerBlock(TERMINAL);
        registerBlock(STASIS_MECHANISM);
        registerBlock(REPULSION_GENERATOR);
        registerBlock(POWERLINE);
        registerBlock(BLAST_DOOR);
        registerBlock(SEVASTOPOL_BLAST_DOOR);
        registerBlock(CRYO_TUBE);
        registerBlock(LIGHT_PANEL);
        registerBlock(CCFL_TUBE);
        registerBlock(TESLA_COIL);
        registerBlock(NETWORK_RACK);
        registerBlock(POWERCELL);
        registerBlock(REDSTONE_SENSOR);
        registerBlock(REDSTONE_EMITTER);
        registerBlock(UNIVERSAL_GENERATOR);
        registerBlock(TRANSFORMER);
        registerBlock(STEPDOWN_TRANSFORMER);
        registerBlock(SUPPLY_CRATE);
        registerBlock(CRATE_MARINES);
        registerBlock(CRATE_SEEGSON);
        registerBlock(SOLAR_PANEL);
        registerBlock(LOCKER);
        registerBlock(MEDPOD);
        registerBlock(GUN_LOCKER);
        registerBlock(AMPULE);
        registerBlock(SKULL_ENGINEER);
        registerBlock(SKULL_JOCKEY);
        registerBlock(SKULL_XENO);
        registerBlock(SKULL_XENO_WARRIOR);
        registerBlock(SKULL_YAUTJA);
        registerBlock(SKULL_MATRIARCH);
        registerBlock(SKULL_PROTOMORPH);
        registerBlock(SKULL_NEOMORPH);
        registerBlock(BIOMASK_CLASSIC);
        registerBlock(BIOMASK_BERSERKER);
        registerBlock(BIOMASK_FALCONER);
        registerBlock(BIOMASK_TRACKER);
        registerBlock(HEAD_AETHON);
        registerBlock(HEAD_GIGER_ALIEN);

        registerBlock(SLOPE);
        registerBlock(CORNER);
        registerBlock(INVERTED_CORNER);
        registerBlock(RIDGE);
        registerBlock(PYRAMID);
        registerBlock(INVERTED_RIDGE);
        registerBlock(INVERTED_PYRAMID);
    }
}
