package org.avp;

import java.util.ArrayList;
import java.util.HashMap;

import org.avp.AliensVsPredator.Properties;
import org.avp.block.BlockAmpule;
import org.avp.block.BlockAssembler;
import org.avp.block.BlockBlackGoo;
import org.avp.block.BlockBlastdoor;
import org.avp.block.BlockCCFLTube;
import org.avp.block.BlockCryostasisTube;
import org.avp.block.BlockCustomSlab;
import org.avp.block.BlockCustomStairs;
import org.avp.block.BlockGenerator;
import org.avp.block.BlockGunLocker;
import org.avp.block.BlockHiveResin;
import org.avp.block.BlockLightPanel;
import org.avp.block.BlockLocker;
import org.avp.block.BlockMedpod;
import org.avp.block.BlockMist;
import org.avp.block.BlockNegativeTransformer;
import org.avp.block.BlockNetworkRack;
import org.avp.block.BlockOreCobalt;
import org.avp.block.BlockOreMonazite;
import org.avp.block.BlockParadiseLog;
import org.avp.block.BlockParadiseTreeLeaves;
import org.avp.block.BlockPortal;
import org.avp.block.BlockPowercell;
import org.avp.block.BlockPowerline;
import org.avp.block.BlockRedstoneEmitter;
import org.avp.block.BlockRedstoneFluxGenerator;
import org.avp.block.BlockRedstoneSensor;
import org.avp.block.BlockReflective;
import org.avp.block.BlockSatelliteDish;
import org.avp.block.BlockSevastopolBlastDoor;
import org.avp.block.BlockSolarPanel;
import org.avp.block.BlockStalagmite;
import org.avp.block.BlockStasisMechanism;
import org.avp.block.BlockSupplyCrate;
import org.avp.block.BlockTempleSpawner;
import org.avp.block.BlockTransformer;
import org.avp.block.BlockTurret;
import org.avp.block.BlockUnidentifiedDirt;
import org.avp.block.BlockUnidentifiedLog;
import org.avp.block.BlockUnidentifiedTreeLeaves;
import org.avp.block.BlockUnidentifiedTreeSapling;
import org.avp.block.BlockUnidentifiedTreeTendon;
import org.avp.block.BlockWall;
import org.avp.block.BlockWorkstation;
import org.avp.block.skulls.BlockSkullEngineer;
import org.avp.block.skulls.BlockSkullSpaceJockey;
import org.avp.block.skulls.BlockSkullXenomorph;
import org.avp.block.skulls.BlockSkullXenomorphWarrior;
import org.avp.block.skulls.BlockSkullYautja;
import org.avp.item.ItemSupplyChute.SupplyChuteType;

import com.arisux.mdx.lib.game.IInitEvent;
import com.arisux.mdx.lib.world.block.BlockMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

@GameRegistry.ObjectHolder(Properties.ID)
@Mod.EventBusSubscriber
public class BlockHandler implements IInitEvent
{
    private static HashMap<Block, ItemBlock> ITEMBLOCKS = new HashMap<Block, ItemBlock>();
    
    public static final Block naturalResin          = new BlockHiveResin(Material.WOOD).setLightOpacity(255).setRegistryName("hiveresin");
    public static final Block resin                 = new BlockMaterial(Material.WOOD).setHardness(5F).setResistance(10.0F).setRegistryName("hiveresin.standard");
    public static final Block relicovamorph         = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tileovamorphdesign");
    public static final Block metal1                = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippanel");
    public static final Block metal2                = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shippannelyautja");
    public static final Block relicfacehugger       = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilefacehuggerdesign");
    public static final Block relicalien            = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilealiendesign");
    public static final Block ship1                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipwallbase");
    public static final Block ship2                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipsupportpillar");
    public static final Block ship3                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor1");
    public static final Block ship4                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipbrick");
    public static final Block ship5                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor2");
    public static final Block ship6                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("shipdecor3");
    public static final Block templetilesingle      = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("templebricksingle");
    public static final Block templebrick           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templebrick");
    public static final Block templetile            = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templetile");
    public static final Block templewall1           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templewallbase");
    public static final Block templewall2           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("templefloor");
    public static final Block industrialwall        = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("industrialwall");
    public static final Block industrialwallstriped = new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialwall2");
    public static final Block ceiling               = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("ceilingpanel");
    public static final Block ceilingfan            = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setRegistryName("ceilingfan");
    public static final Block ceilingvent           = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("ceilingvent");
    public static final Block ceilinggrill          = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrill");
    public static final Block skulls                = new BlockMaterial(Material.ROCK).setRegistryName("skulls");
    public static final Block floorgrill            = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrill");
    public static final Block industrialglass       = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglass");
    public static final Block industrialbricks      = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("industrialbricks");
    public static final Block metalpanel            = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel1");
    public static final Block metalcolumn0          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel2");
    public static final Block metalcolumn1          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setRegistryName("metalpanel3");
    public static final Block plasticcircle         = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictilecircle");
    public static final Block plastic               = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plasticblock");
    public static final Block paddingpanel          = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("paddingpanel");
    public static final Block plastictri            = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictiletri");
    public static final Block plastictile           = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("plastictile");
    public static final Block oreSilicon            = new BlockMaterial(Material.ROCK).setHardness(2.2F).setResistance(1.4F).setCreativeTab(Tab.MAIN).setRegistryName("oresilicon");
    public static final Block oreLithium            = new BlockMaterial(Material.IRON).setHardness(4.2F).setResistance(5.4F).setCreativeTab(Tab.MAIN).setRegistryName("orelithium");
    public static final Block oreCopper             = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("orecopper");
    public static final Block oreBauxite            = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("orebauxite");
    public static final Block oreMonazite           = new BlockOreMonazite().setCreativeTab(Tab.MAIN).setRegistryName("oremonazite");
    public static final Block oreCobalt             = new BlockOreCobalt().setCreativeTab(Tab.MAIN).setRegistryName("orecobalt");
    public static final Block muthurPanel1          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F).setCreativeTab(Tab.MAIN).setRegistryName("mainframepanel.shimmer");
    public static final Block muthurPanel2          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F).setCreativeTab(Tab.MAIN).setRegistryName("mainframepanel.flicker");
    public static final Block vent0                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialvent");
    public static final Block vent1                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("vent.wall");
    public static final Block vent2                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("vent.ceiling");
    public static final Block engineerfloor         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipfloor");
    public static final Block engineerbrick0        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick");
    public static final Block engineerbrick1        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick1");
    public static final Block engineerbrick2        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick2");
    public static final Block engineerbrick3        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipbrick3");
    public static final Block engineergravel        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipgravel");
    public static final Block engineerwall0         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall");
    public static final Block engineerwall1         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall1");
    public static final Block engineerwall2         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall2");
    public static final Block engineerwall3         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall3");
    public static final Block engineerwall4         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipwall4");
    public static final Block engineerrock0         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock");
    public static final Block engineerrock1         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock1");
    public static final Block engineerrock2         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock2");
    public static final Block engineerrock3         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershiprock3");
    public static final Block engineercolumn1       = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipcolumn1");
    public static final Block engineercolumn2       = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipcolumn2");
    public static final Block engineermaterial0     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial0");
    public static final Block engineermaterial1     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial1");
    public static final Block engineermaterial2     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setRegistryName("engineershipmaterial2");
    public static final Block paddingPanelOrange    = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("paddingpanel_orange");
    public static final Block paddingPipesOrange    = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_pipes_orange");
    public static final Block paddingPipesWhite     = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_pipes_white");
    public static final Block paddingSquareOrange   = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_square_orange");
    public static final Block paddingSquareWhite    = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_square_white");
    public static final Block paddingTilesOrange    = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_tiles_orange");
    public static final Block paddingTilesWhite     = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setRegistryName("padding_tiles_white");
    
    /** Dimension Common **/
    public static final Block unistone              = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("unistone");
    public static final Block unisand               = new BlockMaterial(Material.SAND).setHardness(3.5F).setResistance(2.0F).setRegistryName("unisand");
    public static final Block unigravel             = new BlockMaterial(Material.SAND).setHardness(3.0F).setLightOpacity(255).setRegistryName("unigravel");
    public static final Block unidirt               = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("unidirt").setCreativeTab(Tab.BLOCKS);
    public static final Block stalagmite            = new BlockStalagmite(Material.PLANTS).setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("stalagmite");
    
    /** Paradise **/
    public static final Block paradiseDirt          = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseDirtMossy     = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_mossy").setCreativeTab(Tab.BLOCKS);
    public static final Block paradisePodzol        = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_dirt_podzol").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseGrass         = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_grass").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLeavesLarge   = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_large").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLogLarge      = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_large").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLeavesMed     = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_med").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLogMed        = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_med").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLeavesSmall   = new BlockParadiseTreeLeaves().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_leaves_small").setCreativeTab(Tab.BLOCKS);
    public static final Block paradiseLogSmall      = new BlockParadiseLog().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255).setRegistryName("paradise_log_small").setCreativeTab(Tab.BLOCKS);
    
    /** Varda **/
    public static final Block gigerLog              = new BlockUnidentifiedLog().setHardness(5F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.wood");
    public static final Block gigerTendons          = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.tendons");
    public static final Block gigerLeaves           = new BlockUnidentifiedTreeLeaves().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.BLOCKS).setRegistryName("unitree.leaves");
    public static final Block gigerSapling          = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("unitree.sapling");
    
    /** Acheron **/
    public static final Block lv426rock             = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("lv426rock");
    
    public static final Block satelliteDish         = new BlockSatelliteDish().setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("satellitedish");
    public static final Block eggReceptacle         = new BlockTempleSpawner(Material.ROCK, false).setCreativeTab(Tab.MAIN).setRegistryName("spawner");
    public static final Block portalVarda           = new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.varda");
    public static final Block portalAcheron         = new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("portal.acheron");
    public static final Block assembler             = new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("assembler");
    public static final Block floorGrillStairs      = new BlockCustomStairs(floorgrill.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrillstairs");
    public static final Block ceilingGrillStairs    = new BlockCustomStairs(ceilinggrill.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrillstairs");
    public static final Block ironBricksStairs      = new BlockCustomStairs(industrialbricks.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialbrickstairs");
    public static final Block wallStairs            = new BlockCustomStairs(industrialwall.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialwallstairs");
    public static final Block industrialGlassStairs = new BlockCustomStairs(industrialglass.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglassstairs");
    public static final Block floorGrillSlab        = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("floorgrillslab");
    public static final Block ceilingGrillSlab      = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4).setRegistryName("ceilinggrillslab");
    public static final Block wallSlab              = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialslab");
    public static final Block ironBricksSlab        = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255).setRegistryName("industrialbrickslab");
    public static final Block industrialGlassSlab   = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(0).setRegistryName("industrialglassslab");
    public static final Block blackgoo              = createFluidBlock(BlockBlackGoo.fluid, BlockBlackGoo.class, "blackgoo");
    public static final Block mist                  = createFluidBlock(BlockMist.fluid, BlockMist.class, "mist");
    public static final Block turret                = new BlockTurret(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("turret");
    public static final Block terminal              = new BlockWorkstation(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("terminal");
    public static final Block stasisMechanism       = new BlockStasisMechanism(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("stasismechanism");
    public static final Block repulsionGenerator    = new BlockGenerator(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("generator");
    public static final Block powerline             = new BlockPowerline(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("powerline");
    public static final Block blastDoor             = new BlockBlastdoor(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("blastdoor");
    public static final Block sevastopolBlastDoor   = new BlockSevastopolBlastDoor().setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(Tab.MAIN).setRegistryName("blastdoor.sevastopol");
    public static final Block cryoTube              = new BlockCryostasisTube(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(4).setCreativeTab(Tab.MAIN).setRegistryName("cryostasistube");
    public static final Block lightPanel            = new BlockLightPanel(Material.IRON).setHardness(1.5F).setResistance(2.0F).setCreativeTab(Tab.MAIN).setRegistryName("lightpanel");
    public static final Block ccflTube              = new BlockCCFLTube(Material.IRON).setHardness(0.5F).setResistance(1.0F).setCreativeTab(Tab.MAIN).setRegistryName("ccfltube");
    public static final Block networkRack           = new BlockNetworkRack(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("networkrack");
    public static final Block powercell             = new BlockPowercell(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("powercell");
    public static final Block redstoneSensor        = new BlockRedstoneSensor(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("redstonesensor");
    public static final Block redstoneEmitter       = new BlockRedstoneEmitter(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("redstoneemitter");
    public static final Block universalGenerator    = new BlockRedstoneFluxGenerator(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(Tab.MAIN).setRegistryName("universalgenerator");
    public static final Block transformer           = new BlockTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("transformer");
    public static final Block stepdownTransformer   = new BlockNegativeTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("transformer.stepdown");
    public static final Block supplyCrate           = new BlockSupplyCrate(SupplyChuteType.UNBRANDED).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock");
    public static final Block crateMarines          = new BlockSupplyCrate(SupplyChuteType.MARINES).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock.marines");
    public static final Block crateSeegson          = new BlockSupplyCrate(SupplyChuteType.SEEGSON).setCreativeTab(Tab.MAIN).setRegistryName("supplychuteblock.seegson");
    public static final Block solarPanel            = new BlockSolarPanel(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("solarpanel");
    public static final Block locker                = new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("locker");
    public static final Block medpod                = new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("medpod");
    public static final Block gunLocker             = new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("gunlocker");
    public static final Block ampule                = new BlockAmpule().setHardness(5.0F).setResistance(10.0F).setCreativeTab(Tab.MAIN).setRegistryName("engineership.ampule");
    public static final Block skullEngineer         = new BlockSkullEngineer().setCreativeTab(Tab.MAIN).setRegistryName("skull.engineer");
    public static final Block skullJockey           = new BlockSkullSpaceJockey().setCreativeTab(Tab.MAIN).setRegistryName("skull.spacejockey");
    public static final Block skullXeno             = new BlockSkullXenomorph().setCreativeTab(Tab.MAIN).setRegistryName("skull.xenomorph");
    public static final Block skullXenoWarrior      = new BlockSkullXenomorphWarrior().setCreativeTab(Tab.MAIN).setRegistryName("skull.xenomorph.warrior");
    public static final Block skullYautja           = new BlockSkullYautja().setCreativeTab(Tab.MAIN).setRegistryName("skull.yautja");
    public static final Block slope                 = new BlockReflective(Material.CIRCUITS).setRegistryName("slope");
    public static final Block corner                = new BlockReflective(Material.CIRCUITS).setRegistryName("corner");
    public static final Block invertedCorner        = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedcorner");
    public static final Block ridge                 = new BlockReflective(Material.CIRCUITS).setRegistryName("ridge");
    public static final Block pyramid               = new BlockReflective(Material.CIRCUITS).setRegistryName("pyramid");
    public static final Block invertedRidge         = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedridge");
    public static final Block invertedPyramid       = new BlockReflective(Material.CIRCUITS).setRegistryName("invertedpyramid");
    
    static
    {
        for (java.lang.reflect.Field field : AliensVsPredator.blocks().getClass().getDeclaredFields())
        {
            try
            {
                field.setAccessible(true);
                Object obj = field.get(AliensVsPredator.blocks());

                if (obj instanceof Block)
                {
                    createItem((Block) obj);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    private static Block createItem(Block block)
    {
        ItemBlock itemblock = new ItemBlock(block);
        itemblock.setRegistryName(block.getRegistryName());
        itemblock.setTranslationKey(itemblock.getRegistryName().toString());
        
        if (ITEMBLOCKS != null)
        {
            if (ITEMBLOCKS.containsKey(block))
            {
                ITEMBLOCKS.remove(block);
            }
            
            ITEMBLOCKS.put(block, itemblock);
        }
        
        return block;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        AliensVsPredator.log().info("Registering Blocks");
        
        for (java.lang.reflect.Field field : AliensVsPredator.blocks().getClass().getDeclaredFields())
        {
            try
            {
                field.setAccessible(true);
                Object obj = field.get(AliensVsPredator.blocks());

                if (obj instanceof Block)
                {
                    Block block = (Block) obj;
                    block.setTranslationKey(block.getRegistryName().getNamespace() + ":" + block.getRegistryName().getPath());
                    event.getRegistry().register(block);
                    
                    if (block.getCreativeTab() == null)
                    {
                        block.setCreativeTab(Tab.BLOCKS);
                    }
                    registerModel(getItemFromBlock(block));
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        AliensVsPredator.log().info("Registering ItemBlocks");
        
        for (java.lang.reflect.Field field : AliensVsPredator.blocks().getClass().getDeclaredFields())
        {
            field.setAccessible(true);

            try
            {
                Object obj = field.get(AliensVsPredator.blocks());

                if (obj instanceof Block)
                {
                    Block block = (Block) obj;
                    ItemBlock itemblock = getItemFromBlock(block);
                    event.getRegistry().register(itemblock);
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
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    public static ItemBlock getItemFromBlock(Block block)
    {
        return ITEMBLOCKS.get(block);
    }

    public static ArrayList<BlockFluidBase> getFluids()
    {
        Class<?> cl = AliensVsPredator.blocks().getClass();
        ArrayList<BlockFluidBase> fluids = new ArrayList<BlockFluidBase>();

        for (java.lang.reflect.Field field : cl.getDeclaredFields())
        {
            field.setAccessible(true);
            
            try
            {
                Object obj = field.get(AliensVsPredator.blocks());

                if (obj instanceof BlockFluidBase)
                {
                    BlockFluidBase fluid = (BlockFluidBase) obj;
                    fluids.add(fluid);
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }

        return fluids;
    }

    private static ItemBlock registerModel(ItemBlock item)
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
        }
        
        return item;
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
}
