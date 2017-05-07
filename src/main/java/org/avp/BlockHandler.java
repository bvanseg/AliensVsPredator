package org.avp;

import org.avp.block.BlockAmpule;
import org.avp.block.BlockAssembler;
import org.avp.block.BlockBlackGoo;
import org.avp.block.BlockBlastdoor;
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
import org.avp.block.BlockPortal;
import org.avp.block.BlockPowercell;
import org.avp.block.BlockPowerline;
import org.avp.block.BlockRedstoneEmitter;
import org.avp.block.BlockRedstoneFluxGenerator;
import org.avp.block.BlockRedstoneSensor;
import org.avp.block.BlockSatelliteDish;
import org.avp.block.BlockSatelliteModem;
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
import org.avp.block.util.ShapedBlocks;
import org.avp.item.ItemSupplyChute.SupplyChuteType;

import com.arisux.mdxlib.lib.game.Game;
import com.arisux.mdxlib.lib.game.IInitEvent;
import com.arisux.mdxlib.lib.world.block.BlockMaterial;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public class BlockHandler implements IInitEvent
{
    public static BlockHandler instance                    = new BlockHandler();

    public Block               terrainHiveResin            = (new BlockHiveResin(Material.WOOD)).setLightOpacity(255);
    public Block               blockStandardHiveResin      = (new BlockMaterial(Material.WOOD)).setHardness(5F).setResistance(10.0F).setLightOpacity(255);
    public Block               blockOvamorph               = (new BlockMaterial(Material.ROCK)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockShipMetal1             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipMetal2             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockFacehuggerRelic        = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockAlienRelic             = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor1             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor2             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor3             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor4             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor5             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockShipDecor6             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockTempleBrick            = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockTempleTile             = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockTempleWall1            = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockTempleWall2            = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockWall                   = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockCeiling                = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockCeilingFan             = (new BlockMaterial(Material.IRON)
                                                           {
                                                               public boolean isOpaqueCube()
                                                               {
                                                                   return false;
                                                               };
                                                           }).setHardness(5F).setResistance(15.0F);
    public Block               blockCeiliingVent           = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockCeilingGrill           = ((new BlockMaterial(Material.IRON)
                                                           {
                                                               public boolean isOpaqueCube()
                                                               {
                                                                   return false;
                                                               };
                                                           }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block               blockSkulls                 = (new BlockMaterial(Material.ROCK));
    public Block               blockFloorGrill             = ((new BlockMaterial(Material.IRON)
                                                           {
                                                               public boolean isOpaqueCube()
                                                               {
                                                                   return false;
                                                               };
                                                           }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block               blockIronBricks             = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockVerticalMetal          = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockColumnMetal1           = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockColumnMetal2           = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockPlasticCircle          = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockPlastic                = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockPaddingPanel           = (new BlockMaterial(Material.CLOTH)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockPlasticTri             = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockPlasticTile            = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               oreSilicon                  = (new BlockMaterial(Material.ROCK)).setHardness(2.2F).setResistance(1.4F).setLightOpacity(255);
    public Block               oreLithium                  = (new BlockMaterial(Material.IRON)).setHardness(4.2F).setResistance(5.4F).setLightOpacity(255);
    public Block               oreCopper                   = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               oreBauxite                  = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               mainframePanelShimmer       = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F));
    public Block               mainframePanelFlicker       = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F));
    public Block               blockVent0                  = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockVent1                  = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockVent2                  = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockEngineerShipFloor      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick0     = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick1     = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick2     = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipBrick3     = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipGravel     = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall0      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall1      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall2      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall3      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipWall4      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock0      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock1      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock2      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipRock3      = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipColumn1    = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipColumn2    = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipMaterial1  = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockEngineerShipMaterial2  = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               terrainUniStone             = (new BlockMaterial(Material.ROCK)).setHardness(1.3F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainUniSand              = (new BlockMaterial(Material.SAND)).setHardness(3.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainUniGravel            = (new BlockMaterial(Material.SAND)).setHardness(3.0F).setLightOpacity(255);
    public Block               blockSatelliteDish          = (new BlockSatelliteDish()).setHardness(3.2F).setResistance(2.6F);
    public Block               blockEngineerShipMaterial0  = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockSacrificialSpawner     = (new BlockTempleSpawner(Material.ROCK, false));
    public Block               blockSpawnerCreative        = (new BlockTempleSpawner(Material.ROCK, true));
    public Block               blockPortalVarda            = (new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockPortalAcheron          = (new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockAssembler              = (new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockFloorGrillStairs       = (new BlockCustomStairs(blockFloorGrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockCeilingGrillStairs     = (new BlockCustomStairs(blockCeilingGrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockIronBricksStairs       = (new BlockCustomStairs(blockIronBricks.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockWallStairs             = (new BlockCustomStairs(blockWall.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               terrainUniDirt              = (new BlockUnidentifiedDirt()).setHardness(0.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainStalagmite           = (new BlockStalagmite(Material.PLANTS)).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLog           = (new BlockUnidentifiedLog()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeTendon        = (new BlockUnidentifiedTreeTendon()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLeaves        = (new BlockUnidentifiedTreeLeaves()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeSapling       = (new BlockUnidentifiedTreeSapling()).setHardness(0.0F).setLightOpacity(0);
    public Block               blockTurret                 = (new BlockTurret(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockWorkstation            = (new BlockWorkstation(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockStasisMechanism        = (new BlockStasisMechanism(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockRepulsionGenerator     = (new BlockGenerator(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockPowerline              = (new BlockPowerline(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlastdoor              = (new BlockBlastdoor(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockCryostasisTube         = (new BlockCryostasisTube(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockLightPanel             = (new BlockLightPanel(Material.IRON)).setHardness(1.5F).setResistance(2.0F);
    public Block               blockSatelliteModem         = (new BlockSatelliteModem(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockPowercell              = (new BlockPowercell(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneSensor              = (new BlockRedstoneSensor(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneEmitter             = (new BlockRedstoneEmitter(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneFluxGenerator       = (new BlockRedstoneFluxGenerator(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlackGoo               = (new BlockBlackGoo());
    public Block               blockMist                   = (new BlockMist());
    public Block               blockTransformer            = (new BlockTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockNegativeTransformer    = (new BlockNegativeTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               supplyCrate                 = (new BlockSupplyCrate(SupplyChuteType.UNBRANDED));
    public Block               supplyCrateMarines          = (new BlockSupplyCrate(SupplyChuteType.MARINES));
    public Block               supplyCrateSeegson          = (new BlockSupplyCrate(SupplyChuteType.SEEGSON));
    public Block               blockSolarPanel             = (new BlockSolarPanel(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockLocker                 = (new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockMedpod                 = (new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockGunLocker              = (new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockAmpule                 = (new BlockAmpule().setHardness(5.0F).setResistance(10.0F));
    public Block               blockWallW                  = (new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockRelicTile              = (new BlockMaterial(Material.ROCK)
                                                           {
                                                           }.setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockIndustrialGlass        = (new BlockMaterial(Material.IRON)
                                                           {
                                                               @Override
                                                               protected BlockStateContainer createBlockState()
                                                               {
                                                                   return new BlockStateContainer(this, new IProperty[0])
                                                                                                                          {
                                                                                                                              @Override
                                                                                                                              protected StateImplementation createState(Block block, ImmutableMap<IProperty<?>, Comparable<?>> properties, ImmutableMap<IUnlistedProperty<?>, Optional<?>> unlistedProperties)
                                                                                                                              {
                                                                                                                                  return new StateImplementation(block, properties)
                                                                                                                                                                                         {
                                                                                                                                                                                             @Override
                                                                                                                                                                                             public boolean isOpaqueCube()
                                                                                                                                                                                             {
                                                                                                                                                                                                 return false;
                                                                                                                                                                                             }
                                                                                                                                                                                         };
                                                                                                                              }
                                                                                                                          };
                                                               }
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockFloorGrillSlab         = (new BlockCustomSlab(Material.IRON, false)
                                                           {
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockCeilingGrillSlab       = (new BlockCustomSlab(Material.IRON, false)
                                                           {
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockWallSlab               = (new BlockCustomSlab(Material.IRON, false)
                                                           {
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockIronBricksSlab         = (new BlockCustomSlab(Material.IRON, false)
                                                           {
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockIndustrialGlassSlab    = (new BlockCustomSlab(Material.IRON, false)
                                                           {
                                                           }).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockIndustrialGlassStairs  = (new BlockCustomStairs(blockIndustrialGlass.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(0);

    public Block               blockSkullEngineer          = new BlockSkullEngineer();
    public Block               blockSkullSpaceJockey       = new BlockSkullSpaceJockey();
    public Block               blockSkullXenomorph         = new BlockSkullXenomorph();
    public Block               blockSkullXenomorphWarrior  = new BlockSkullXenomorphWarrior();
    public Block               blockSkullYautja            = new BlockSkullYautja();

    public Block[]             unidirtShapes               = ShapedBlocks.construct(terrainUniDirt).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             unistoneShapes              = ShapedBlocks.construct(terrainUniStone).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             unisandShapes               = ShapedBlocks.construct(terrainUniSand).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             unigravelShapes             = ShapedBlocks.construct(terrainUniGravel).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ceilingPanelShapes          = ShapedBlocks.construct(blockCeiling).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ceilingFanShapes            = ShapedBlocks.construct(blockCeilingFan).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ceilingVentShapes           = ShapedBlocks.construct(blockCeiliingVent).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ceilingGrillShapes          = ShapedBlocks.construct(blockCeilingGrill).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             floorGrillShapes            = ShapedBlocks.construct(blockFloorGrill).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             industrialWallShapes        = ShapedBlocks.construct(blockWall).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             industrialWallWShapes       = ShapedBlocks.construct(blockWallW).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             industrialVentShapes        = ShapedBlocks.construct(blockVent0).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             wallVentShapes              = ShapedBlocks.construct(blockVent1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ceilingVent2Shapes          = ShapedBlocks.construct(blockVent2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             industrialBrickShapes       = ShapedBlocks.construct(blockIronBricks).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             industrialGlassShapes       = ShapedBlocks.construct(blockIndustrialGlass).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             metalPanel1Shapes           = ShapedBlocks.construct(blockVerticalMetal).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             metalPanel2Shapes           = ShapedBlocks.construct(blockColumnMetal1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             metalPanel3Shapes           = ShapedBlocks.construct(blockColumnMetal2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             hiveResinStandardShapes     = ShapedBlocks.construct(blockStandardHiveResin).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             predatorShipMetal1Shapes    = ShapedBlocks.construct(blockShipMetal1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             predatorShipMetal2Shapes    = ShapedBlocks.construct(blockShipMetal2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             ovamorphShapes              = ShapedBlocks.construct(blockOvamorph).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             facehuggerShapes            = ShapedBlocks.construct(blockFacehuggerRelic).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             alienShapes                 = ShapedBlocks.construct(blockAlienRelic).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor1Shapes            = ShapedBlocks.construct(blockShipDecor1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor2Shapes            = ShapedBlocks.construct(blockShipDecor2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor3Shapes            = ShapedBlocks.construct(blockShipDecor3).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor4Shapes            = ShapedBlocks.construct(blockShipDecor4).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor5Shapes            = ShapedBlocks.construct(blockShipDecor5).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             shipDecor6Shapes            = ShapedBlocks.construct(blockShipDecor6).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             templeBrickSingleShapes     = ShapedBlocks.construct(blockRelicTile, 0, blockSacrificialSpawner).setCreativeTab(AliensVsPredator.tabBlocks()).array();;
    public Block[]             templeBrickShapes           = ShapedBlocks.construct(blockTempleBrick).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             templeTileShapes            = ShapedBlocks.construct(blockTempleTile).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             templeWall1Shapes           = ShapedBlocks.construct(blockTempleWall1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             templeWall2Shapes           = ShapedBlocks.construct(blockTempleWall2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             skullShapes                 = ShapedBlocks.construct(blockSkulls).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             plasticShapes               = ShapedBlocks.construct(blockPlastic).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             paddingPanelShapes          = ShapedBlocks.construct(blockPaddingPanel).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             plasticTileShapes           = ShapedBlocks.construct(blockPlasticTile).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             plasticTriShapes            = ShapedBlocks.construct(blockPlasticTri).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             plasticCircleShapes         = ShapedBlocks.construct(blockPlasticCircle).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipFloorShapes     = ShapedBlocks.construct(blockEngineerShipFloor).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipBrick0Shapes    = ShapedBlocks.construct(blockEngineerShipBrick0).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipBrick1Shapes    = ShapedBlocks.construct(blockEngineerShipBrick1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipBrick2Shapes    = ShapedBlocks.construct(blockEngineerShipBrick2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipBrick3Shapes    = ShapedBlocks.construct(blockEngineerShipBrick3).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipGravelShapes    = ShapedBlocks.construct(blockEngineerShipGravel).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipWall0Shapes     = ShapedBlocks.construct(blockEngineerShipWall0).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipWall1Shapes     = ShapedBlocks.construct(blockEngineerShipWall1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipWall2Shapes     = ShapedBlocks.construct(blockEngineerShipWall2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipWall3Shapes     = ShapedBlocks.construct(blockEngineerShipWall3).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipWall4Shapes     = ShapedBlocks.construct(blockEngineerShipWall4).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipRock0Shapes     = ShapedBlocks.construct(blockEngineerShipRock0).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipRock1Shapes     = ShapedBlocks.construct(blockEngineerShipRock1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipRock2Shapes     = ShapedBlocks.construct(blockEngineerShipRock2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipRock3Shapes     = ShapedBlocks.construct(blockEngineerShipRock3).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipColumn1Shapes   = ShapedBlocks.construct(blockEngineerShipColumn1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipColumn2Shapes   = ShapedBlocks.construct(blockEngineerShipColumn2).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipMaterial0Shapes = ShapedBlocks.construct(blockEngineerShipMaterial0).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipMaterial1Shapes = ShapedBlocks.construct(blockEngineerShipMaterial1).setCreativeTab(AliensVsPredator.tabBlocks()).array();
    public Block[]             engineerShipMaterial2Shapes = ShapedBlocks.construct(blockEngineerShipMaterial2).setCreativeTab(AliensVsPredator.tabBlocks()).array();

    @Override
    public void init(FMLInitializationEvent event)
    {
        this.registerStandard();
        this.registerShaped();
    }

    private void registerStandard()
    {
        Game.register(AliensVsPredator.ID, blockSkullEngineer, "skull.engineer").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSkullSpaceJockey, "skull.spacejockey").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSkullXenomorph, "skull.xenomorph").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSkullXenomorphWarrior, "skull.xenomorph.warrior").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSkullYautja, "skull.yautja").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, terrainUniTreeLog, "unitree.wood").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, terrainUniTreeTendon, "unitree.tendons").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, terrainUniTreeLeaves, "unitree.leaves").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, terrainUniTreeSapling, "unitree.sapling").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, terrainStalagmite, "stalagmite").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, oreSilicon, "oresilicon").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, oreCopper, "orecopper").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, oreLithium, "orelithium").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, oreBauxite, "orebauxite").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSolarPanel, "solarpanel").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSatelliteModem, "satellitemodem").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSatelliteDish, "satellitedish").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockPowercell, "powercell").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockTransformer, "transformer").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockNegativeTransformer, "transformernegative").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockCeilingGrillStairs, "ceilinggrillstairs").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockCeilingGrillSlab, "ceilinggrillslab").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockFloorGrillStairs, "floorgrillstairs").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockFloorGrillSlab, "floorgrillslab").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, redstoneSensor, "redstonesensor").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, redstoneEmitter, "redstoneemitter").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, redstoneFluxGenerator, "redstonefluxgenerator").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockWallStairs, "industrialwallstairs").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockWallSlab, "industrialslab").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockIronBricksStairs, "industrialbrickstairs").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockIronBricksSlab, "industrialbrickslab").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockIndustrialGlassStairs, "industrialglassstairs").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, blockIndustrialGlassSlab, "industrialglassslab").setCreativeTab(AliensVsPredator.tabBlocks());
        Game.register(AliensVsPredator.ID, terrainHiveResin, "hiveresin");
        Game.register(AliensVsPredator.ID, blockSacrificialSpawner, "spawner").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockSpawnerCreative, "spawnerc").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockPortalVarda, "portal.varda").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockPortalAcheron, "portal.acheron").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockAssembler, "assembler").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockTurret, "turret").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockWorkstation, "terminal").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockStasisMechanism, "stasismechanism").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockRepulsionGenerator, "generator").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockPowerline, "powerline").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockBlastdoor, "blastdoor").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, supplyCrate, "supplychuteblock").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, supplyCrateMarines, "supplychuteblock.marines").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, supplyCrateSeegson, "supplychuteblock.seegson").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockBlackGoo, "blackgoo").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockMist, "mist").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockCryostasisTube, "cryostasistube").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockLightPanel, "lightpanel").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, mainframePanelShimmer, "mainframepanel.shimmer").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, mainframePanelFlicker, "mainframepanel.flicker").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockAmpule, "engineership.ampule").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockLocker, "locker").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockGunLocker, "gunlocker").setCreativeTab(AliensVsPredator.tabMain());
        Game.register(AliensVsPredator.ID, blockMedpod, "medpod").setCreativeTab(AliensVsPredator.tabMain());
    }

    private void registerShaped()
    {
        ShapedBlocks.register(AliensVsPredator.ID, unidirtShapes, "unidirt");
        ShapedBlocks.register(AliensVsPredator.ID, unistoneShapes, "unistone");
        ShapedBlocks.register(AliensVsPredator.ID, unisandShapes, "unisand");
        ShapedBlocks.register(AliensVsPredator.ID, unigravelShapes, "unigravel");
        ShapedBlocks.register(AliensVsPredator.ID, ceilingPanelShapes, "ceilingpanel");
        ShapedBlocks.register(AliensVsPredator.ID, ceilingFanShapes, "ceilingfan");
        ShapedBlocks.register(AliensVsPredator.ID, ceilingVentShapes, "ceilingvent");
        ShapedBlocks.register(AliensVsPredator.ID, ceilingGrillShapes, "ceilinggrill");
        ShapedBlocks.register(AliensVsPredator.ID, floorGrillShapes, "floorgrill");
        ShapedBlocks.register(AliensVsPredator.ID, industrialWallShapes, "industrialwall");
        ShapedBlocks.register(AliensVsPredator.ID, industrialWallWShapes, "industrialwall2");
        ShapedBlocks.register(AliensVsPredator.ID, industrialVentShapes, "industrialvent");
        ShapedBlocks.register(AliensVsPredator.ID, wallVentShapes, "vent.wall");
        ShapedBlocks.register(AliensVsPredator.ID, ceilingVent2Shapes, "vent.ceiling");
        ShapedBlocks.register(AliensVsPredator.ID, industrialBrickShapes, "industrialbricks");
        ShapedBlocks.register(AliensVsPredator.ID, industrialGlassShapes, "industrialglass");
        ShapedBlocks.register(AliensVsPredator.ID, metalPanel1Shapes, "metalpanel1");
        ShapedBlocks.register(AliensVsPredator.ID, metalPanel2Shapes, "metalpanel2");
        ShapedBlocks.register(AliensVsPredator.ID, metalPanel3Shapes, "metalpanel3");
        ShapedBlocks.register(AliensVsPredator.ID, hiveResinStandardShapes, "hiveresin.standard");
        ShapedBlocks.register(AliensVsPredator.ID, predatorShipMetal1Shapes, "shippanel");
        ShapedBlocks.register(AliensVsPredator.ID, predatorShipMetal2Shapes, "shippannelyautja");
        ShapedBlocks.register(AliensVsPredator.ID, ovamorphShapes, "tileovamorphdesign");
        ShapedBlocks.register(AliensVsPredator.ID, facehuggerShapes, "tilefacehuggerdesign");
        ShapedBlocks.register(AliensVsPredator.ID, alienShapes, "tilealiendesign");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor1Shapes, "shipwallbase");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor2Shapes, "shipsupportpillar");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor3Shapes, "shipdecor1");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor5Shapes, "shipdecor2");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor6Shapes, "shipdecor3");
        ShapedBlocks.register(AliensVsPredator.ID, shipDecor4Shapes, "shipbrick");
        ShapedBlocks.register(AliensVsPredator.ID, templeBrickSingleShapes, "templebricksingle");
        ShapedBlocks.register(AliensVsPredator.ID, templeBrickShapes, "templebrick");
        ShapedBlocks.register(AliensVsPredator.ID, templeTileShapes, "templetile");
        ShapedBlocks.register(AliensVsPredator.ID, templeWall1Shapes, "templewallbase");
        ShapedBlocks.register(AliensVsPredator.ID, templeWall2Shapes, "templefloor");
        ShapedBlocks.register(AliensVsPredator.ID, skullShapes, "skulls");
        ShapedBlocks.register(AliensVsPredator.ID, plasticShapes, "plasticblock");
        ShapedBlocks.register(AliensVsPredator.ID, paddingPanelShapes, "paddingpanel");
        ShapedBlocks.register(AliensVsPredator.ID, plasticTileShapes, "plastictile");
        ShapedBlocks.register(AliensVsPredator.ID, plasticTriShapes, "plastictiletri");
        ShapedBlocks.register(AliensVsPredator.ID, plasticCircleShapes, "plastictilecircle");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipFloorShapes, "engineershipfloor");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipBrick0Shapes, "engineershipbrick");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipBrick1Shapes, "engineershipbrick1");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipBrick2Shapes, "engineershipbrick2");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipBrick3Shapes, "engineershipbrick3");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipGravelShapes, "engineershipgravel");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipWall0Shapes, "engineershipwall");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipWall1Shapes, "engineershipwall1");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipWall2Shapes, "engineershipwall2");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipWall3Shapes, "engineershipwall3");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipWall4Shapes, "engineershipwall4");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipRock0Shapes, "engineershiprock");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipRock1Shapes, "engineershiprock1");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipRock2Shapes, "engineershiprock2");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipRock3Shapes, "engineershiprock3");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipColumn1Shapes, "engineershipcolumn1");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipColumn2Shapes, "engineershipcolumn2");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipMaterial0Shapes, "engineershipmaterial0");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipMaterial1Shapes, "engineershipmaterial1");
        ShapedBlocks.register(AliensVsPredator.ID, engineerShipMaterial2Shapes, "engineershipmaterial2");
    }
}
