package org.avp.common;

import com.asx.mdx.core.mods.IInitEvent;
import com.asx.mdx.lib.world.block.BlockMaterial;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import org.avp.AliensVsPredator;
import org.avp.common.block.*;
import org.avp.common.block.skulls.*;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.lib.BlockRegistryUtil;

import java.util.List;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPBlocks implements IInitEvent
{
    public static final AVPBlocks instance = new AVPBlocks();

    private AVPBlocks() {}
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
    
    public static final Block SATELLITE_DISH = new BlockSatelliteDish().setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("satellitedish");
    public static final Block EGG_RECEPTACLE = new BlockTempleSpawner(Material.ROCK, false).setCreativeTab(Tab.MAIN).setRegistryName("spawner");
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
    public static final Block BLACK_GOO = BlockRegistryUtil.createFluidBlock(BlockBlackGoo.fluid, BlockBlackGoo.class, "blackgoo");
    public static final Block MIST = BlockRegistryUtil.createFluidBlock(BlockMist.fluid, BlockMist.class, "mist");
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

    @Override
    public void init(FMLInitializationEvent event) {
        AliensVsPredator.log().info("Registering Blocks");

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

        BlockRegistryUtil.registerBlock(INDUSTRIAL_WALL);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_WALL_STRIPED);
        BlockRegistryUtil.registerBlock(CEILING);
        BlockRegistryUtil.registerBlock(CEILING_FAN);
        BlockRegistryUtil.registerBlock(CEILING_VENT);
        BlockRegistryUtil.registerBlock(CEILING_GRILL);

        BlockRegistryUtil.registerBlock(SKULLS);
        BlockRegistryUtil.registerBlock(FLOOR_GRILL);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_GLASS);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_BRICKS);

        BlockRegistryUtil.registerBlock(METAL_PANEL);
        BlockRegistryUtil.registerBlock(METAL_COLUMN_0);
        BlockRegistryUtil.registerBlock(METAL_COLUMN_1);
        BlockRegistryUtil.registerBlock(PLASTIC_CIRCLE);
        BlockRegistryUtil.registerBlock(PLASTIC);

        BlockRegistryUtil.registerBlock(PADDING_PANEL);
        BlockRegistryUtil.registerBlock(PLASTIC_TRI);
        BlockRegistryUtil.registerBlock(PLASTIC_TILE);

        BlockRegistryUtil.registerBlock(ORE_BAUXITE);
        BlockRegistryUtil.registerBlock(ORE_COBALT);
        BlockRegistryUtil.registerBlock(ORE_COPPER);
        BlockRegistryUtil.registerBlock(ORE_LITHIUM);
        BlockRegistryUtil.registerBlock(ORE_MONAZITE);
        BlockRegistryUtil.registerBlock(ORE_SILICON);

        BlockRegistryUtil.registerBlock(MUTHUR_PANEL_1);
        BlockRegistryUtil.registerBlock(MUTHUR_PANEL_2);

        BlockRegistryUtil.registerBlock(VENT_0);
        BlockRegistryUtil.registerBlock(VENT_1);
        BlockRegistryUtil.registerBlock(VENT_2);

        BlockRegistryUtil.registerBlock(PADDING_PANEL_ORANGE);
        BlockRegistryUtil.registerBlock(PADDING_PIPES_ORANGE);

        BlockRegistryUtil.registerBlock(PADDING_PIPES_WHITE);
        BlockRegistryUtil.registerBlock(PADDING_SQUARE_ORANGE);

        BlockRegistryUtil.registerBlock(PADDING_SQUARE_WHITE);
        BlockRegistryUtil.registerBlock(PADDING_TILES_ORANGE);
        BlockRegistryUtil.registerBlock(PADDING_TILES_WHITE);

        BlockRegistryUtil.registerBlock(UNISTONE);
        BlockRegistryUtil.registerBlock(UNISAND);
        BlockRegistryUtil.registerBlock(UNIGRAVEL);
        BlockRegistryUtil.registerBlock(UNIDIRT);

        BlockRegistryUtil.registerBlock(STALAGMITE);

        BlockRegistryUtil.registerBlock(SATELLITE_DISH);
        BlockRegistryUtil.registerBlock(EGG_RECEPTACLE);

        BlockRegistryUtil.registerBlock(ASSEMBLER);
        BlockRegistryUtil.registerBlock(FLOOR_GRILL_STAIRS);
        BlockRegistryUtil.registerBlock(CEILING_GRILL_STAIRS);
        BlockRegistryUtil.registerBlock(IRON_BRICKS_STAIRS);
        BlockRegistryUtil.registerBlock(WALL_STAIRS);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_GLASS_STAIRS);
        BlockRegistryUtil.registerBlock(FLOOR_GRILL_SLAB);
        BlockRegistryUtil.registerBlock(CEILING_GRILL_SLAB);
        BlockRegistryUtil.registerBlock(WALL_SLAB);
        BlockRegistryUtil.registerBlock(IRON_BRICKS_SLAB);
        BlockRegistryUtil.registerBlock(INDUSTRIAL_GLASS_SLAB);
        BlockRegistryUtil.registerBlock(BLACK_GOO);
        BlockRegistryUtil.registerBlock(MIST);
        BlockRegistryUtil.registerBlock(TURRET);
        BlockRegistryUtil.registerBlock(TERMINAL);
        BlockRegistryUtil.registerBlock(STASIS_MECHANISM);
        BlockRegistryUtil.registerBlock(REPULSION_GENERATOR);
        BlockRegistryUtil.registerBlock(POWERLINE);
        BlockRegistryUtil.registerBlock(BLAST_DOOR);
        BlockRegistryUtil.registerBlock(SEVASTOPOL_BLAST_DOOR);
        BlockRegistryUtil.registerBlock(CRYO_TUBE);
        BlockRegistryUtil.registerBlock(LIGHT_PANEL);
        BlockRegistryUtil.registerBlock(CCFL_TUBE);
        BlockRegistryUtil.registerBlock(TESLA_COIL);
        BlockRegistryUtil.registerBlock(NETWORK_RACK);
        BlockRegistryUtil.registerBlock(POWERCELL);
        BlockRegistryUtil.registerBlock(REDSTONE_SENSOR);
        BlockRegistryUtil.registerBlock(REDSTONE_EMITTER);
        BlockRegistryUtil.registerBlock(UNIVERSAL_GENERATOR);
        BlockRegistryUtil.registerBlock(TRANSFORMER);
        BlockRegistryUtil.registerBlock(STEPDOWN_TRANSFORMER);
        BlockRegistryUtil.registerBlock(SUPPLY_CRATE);
        BlockRegistryUtil.registerBlock(CRATE_MARINES);
        BlockRegistryUtil.registerBlock(CRATE_SEEGSON);
        BlockRegistryUtil.registerBlock(SOLAR_PANEL);
        BlockRegistryUtil.registerBlock(LOCKER);
        BlockRegistryUtil.registerBlock(MEDPOD);
        BlockRegistryUtil.registerBlock(GUN_LOCKER);
        BlockRegistryUtil.registerBlock(AMPULE);
        BlockRegistryUtil.registerBlock(SKULL_ENGINEER);
        BlockRegistryUtil.registerBlock(SKULL_JOCKEY);
        BlockRegistryUtil.registerBlock(SKULL_XENO);
        BlockRegistryUtil.registerBlock(SKULL_XENO_WARRIOR);
        BlockRegistryUtil.registerBlock(SKULL_YAUTJA);
        BlockRegistryUtil.registerBlock(SKULL_MATRIARCH);
        BlockRegistryUtil.registerBlock(SKULL_PROTOMORPH);
        BlockRegistryUtil.registerBlock(SKULL_NEOMORPH);
        BlockRegistryUtil.registerBlock(BIOMASK_CLASSIC);
        BlockRegistryUtil.registerBlock(BIOMASK_BERSERKER);
        BlockRegistryUtil.registerBlock(BIOMASK_FALCONER);
        BlockRegistryUtil.registerBlock(BIOMASK_TRACKER);
        BlockRegistryUtil.registerBlock(HEAD_AETHON);
        BlockRegistryUtil.registerBlock(HEAD_GIGER_ALIEN);

        BlockRegistryUtil.registerBlock(SLOPE);
        BlockRegistryUtil.registerBlock(CORNER);
        BlockRegistryUtil.registerBlock(INVERTED_CORNER);
        BlockRegistryUtil.registerBlock(RIDGE);
        BlockRegistryUtil.registerBlock(PYRAMID);
        BlockRegistryUtil.registerBlock(INVERTED_RIDGE);
        BlockRegistryUtil.registerBlock(INVERTED_PYRAMID);
    }
}
