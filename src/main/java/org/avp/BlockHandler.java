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
import org.avp.block.BlockReflectiveShape;
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
import org.avp.item.ItemSupplyChute.SupplyChuteType;

import com.arisux.mdx.lib.game.IPreInitEvent;
import com.arisux.mdx.lib.world.block.BlockMaterial;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableMap;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.BlockRenderLayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.property.IUnlistedProperty;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;

public class BlockHandler implements IPreInitEvent
{
    public static BlockHandler instance                   = new BlockHandler();

    public Block               terrainHiveResin           = (new BlockHiveResin(Material.WOOD)).setLightOpacity(255);
    public Block               resin                      = (new BlockMaterial(Material.WOOD)).setHardness(5F).setResistance(10.0F).setLightOpacity(255);
    public Block               relicovamorph              = (new BlockMaterial(Material.ROCK)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               metal1                     = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               metal2                     = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               relicfacehugger            = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               relicalien                 = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship1                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship2                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship3                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship4                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship5                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               ship6                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               templebrick                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               templetile                 = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               templewall1                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               templewall2                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               industrialwall             = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               ceiling                    = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               ceilingfan                 = (new BlockMaterial(Material.IRON)
                                                          {
                                                              public boolean isOpaqueCube()
                                                              {
                                                                  return false;
                                                              };
                                                          }).setHardness(5F).setResistance(15.0F);
    public Block               ceilingvent                = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               ceilinggrill               = ((new BlockMaterial(Material.IRON)
                                                          {
                                                              @Override
                                                              public BlockRenderLayer getBlockLayer()
                                                              {
                                                                  return BlockRenderLayer.TRANSLUCENT;
                                                              }
                                                          }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block               skulls                     = (new BlockMaterial(Material.ROCK));
    public Block               floorgrill                 = ((new BlockMaterial(Material.IRON)
                                                          {
                                                              public boolean isOpaqueCube()
                                                              {
                                                                  return false;
                                                              };
                                                          }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block               industrialbricks           = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               metalpanel                 = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               metalcolumn0               = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               metalcolumn1               = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               plasticcircle              = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               plastic                    = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               paddingpanel               = (new BlockMaterial(Material.CLOTH)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               plastictri                 = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               plastictile                = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               oreSilicon                 = (new BlockMaterial(Material.ROCK)).setHardness(2.2F).setResistance(1.4F).setLightOpacity(255);
    public Block               oreLithium                 = (new BlockMaterial(Material.IRON)).setHardness(4.2F).setResistance(5.4F).setLightOpacity(255);
    public Block               oreCopper                  = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               oreBauxite                 = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block               mainframePanelShimmer      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F));
    public Block               mainframePanelFlicker      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F));
    public Block               vent0                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               vent1                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               vent2                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               engineerfloor              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerbrick0             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerbrick1             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerbrick2             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerbrick3             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineergravel             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerwall0              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerwall1              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerwall2              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerwall3              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerwall4              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerrock0              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerrock1              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerrock2              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineerrock3              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineercolumn1            = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineercolumn2            = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineermaterial1          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               engineermaterial2          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               unistone                   = (new BlockMaterial(Material.ROCK)).setHardness(1.3F).setResistance(2.0F).setLightOpacity(255);
    public Block               unisand                    = (new BlockMaterial(Material.SAND)).setHardness(3.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               unigravel                  = (new BlockMaterial(Material.SAND)).setHardness(3.0F).setLightOpacity(255);
    public Block               blockSatelliteDish         = (new BlockSatelliteDish()).setHardness(3.2F).setResistance(2.6F);
    public Block               engineermaterial0          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block               blockSacrificialSpawner    = (new BlockTempleSpawner(Material.ROCK, false));
    public Block               blockSpawnerCreative       = (new BlockTempleSpawner(Material.ROCK, true));
    public Block               blockPortalVarda           = (new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockPortalAcheron         = (new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F));
    public Block               blockAssembler             = (new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockFloorGrillStairs      = (new BlockCustomStairs(floorgrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockCeilingGrillStairs    = (new BlockCustomStairs(ceilinggrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockIronBricksStairs      = (new BlockCustomStairs(industrialbricks.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockWallStairs            = (new BlockCustomStairs(industrialwall.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               unidirt                    = (new BlockUnidentifiedDirt()).setHardness(0.5F).setResistance(2.0F).setLightOpacity(255);
    public Block               terrainStalagmite          = (new BlockStalagmite(Material.PLANTS)).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLog          = (new BlockUnidentifiedLog()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeTendon       = (new BlockUnidentifiedTreeTendon()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeLeaves       = (new BlockUnidentifiedTreeLeaves()).setHardness(0.0F).setLightOpacity(0);
    public Block               terrainUniTreeSapling      = (new BlockUnidentifiedTreeSapling()).setHardness(0.0F).setLightOpacity(0);
    public Block               blockTurret                = (new BlockTurret(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockWorkstation           = (new BlockWorkstation(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockStasisMechanism       = (new BlockStasisMechanism(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockRepulsionGenerator    = (new BlockGenerator(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockPowerline             = (new BlockPowerline(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlastdoor             = (new BlockBlastdoor(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockCryostasisTube        = (new BlockCryostasisTube(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockLightPanel            = (new BlockLightPanel(Material.IRON)).setHardness(1.5F).setResistance(2.0F);
    public Block               blockSatelliteModem        = (new BlockSatelliteModem(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockPowercell             = (new BlockPowercell(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneSensor             = (new BlockRedstoneSensor(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneEmitter            = (new BlockRedstoneEmitter(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               redstoneFluxGenerator      = (new BlockRedstoneFluxGenerator(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block               blockBlackGoo              = (new BlockBlackGoo());
    public Block               blockMist                  = (new BlockMist());
    public Block               blockTransformer           = (new BlockTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockNegativeTransformer   = (new BlockNegativeTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               supplyCrate                = (new BlockSupplyCrate(SupplyChuteType.UNBRANDED));
    public Block               supplyCrateMarines         = (new BlockSupplyCrate(SupplyChuteType.MARINES));
    public Block               supplyCrateSeegson         = (new BlockSupplyCrate(SupplyChuteType.SEEGSON));
    public Block               blockSolarPanel            = (new BlockSolarPanel(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block               blockLocker                = (new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockMedpod                = (new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockGunLocker             = (new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block               blockAmpule                = (new BlockAmpule().setHardness(5.0F).setResistance(10.0F));
    public Block               industrialwallstriped      = (new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               templetilesingle           = (new BlockMaterial(Material.ROCK)
                                                          {
                                                          }.setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block               industrialglass            = (new BlockMaterial(Material.IRON)
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
    public Block               blockFloorGrillSlab        = (new BlockCustomSlab(Material.IRON, false)
                                                          {
                                                          }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockCeilingGrillSlab      = (new BlockCustomSlab(Material.IRON, false)
                                                          {
                                                          }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block               blockWallSlab              = (new BlockCustomSlab(Material.IRON, false)
                                                          {
                                                          }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockIronBricksSlab        = (new BlockCustomSlab(Material.IRON, false)
                                                          {
                                                          }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block               blockIndustrialGlassSlab   = (new BlockCustomSlab(Material.IRON, false)
                                                          {
                                                          }).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block               blockIndustrialGlassStairs = (new BlockCustomStairs(industrialglass.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(0);

    public Block               blockSkullEngineer         = new BlockSkullEngineer();
    public Block               blockSkullSpaceJockey      = new BlockSkullSpaceJockey();
    public Block               blockSkullXenomorph        = new BlockSkullXenomorph();
    public Block               blockSkullXenomorphWarrior = new BlockSkullXenomorphWarrior();
    public Block               blockSkullYautja           = new BlockSkullYautja();

    public Block               slope                      = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               corner                     = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               invertedCorner             = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               ridge                      = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               smartRidge                 = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               invertedRidge              = new BlockReflectiveShape(Material.CIRCUITS);
    public Block               smartInvertedRidge         = new BlockReflectiveShape(Material.CIRCUITS);

    private void register()
    {
        register(AliensVsPredator.ID, "skull.engineer", blockSkullEngineer).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "skull.spacejockey", blockSkullSpaceJockey).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "skull.xenomorph", blockSkullXenomorph).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "skull.xenomorph.warrior", blockSkullXenomorphWarrior).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "skull.yautja", blockSkullYautja).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "unitree.wood", terrainUniTreeLog).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "unitree.tendons", terrainUniTreeTendon).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "unitree.leaves", terrainUniTreeLeaves).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "unitree.sapling", terrainUniTreeSapling).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "stalagmite", terrainStalagmite).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "oresilicon", oreSilicon).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "orecopper", oreCopper).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "orelithium", oreLithium).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "orebauxite", oreBauxite).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "solarpanel", blockSolarPanel).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "satellitemodem", blockSatelliteModem).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "satellitedish", blockSatelliteDish).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "powercell", blockPowercell).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "transformer", blockTransformer).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "transformernegative", blockNegativeTransformer).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "ceilinggrillstairs", blockCeilingGrillStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "ceilinggrillslab", blockCeilingGrillSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "floorgrillstairs", blockFloorGrillStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "floorgrillslab", blockFloorGrillSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "redstonesensor", redstoneSensor).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "redstoneemitter", redstoneEmitter).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "redstonefluxgenerator", redstoneFluxGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "industrialwallstairs", blockWallStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "industrialslab", blockWallSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "industrialbrickstairs", blockIronBricksStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "industrialbrickslab", blockIronBricksSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "industrialglassstairs", blockIndustrialGlassStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "industrialglassslab", blockIndustrialGlassSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register(AliensVsPredator.ID, "hiveresin", terrainHiveResin);
        register(AliensVsPredator.ID, "spawner", blockSacrificialSpawner).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "spawnerc", blockSpawnerCreative).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "portal.varda", blockPortalVarda).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "portal.acheron", blockPortalAcheron).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "assembler", blockAssembler).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "turret", blockTurret).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "terminal", blockWorkstation).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "stasismechanism", blockStasisMechanism).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "generator", blockRepulsionGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "powerline", blockPowerline).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "blastdoor", blockBlastdoor).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "supplychuteblock", supplyCrate).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "supplychuteblock.marines", supplyCrateMarines).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "supplychuteblock.seegson", supplyCrateSeegson).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "blackgoo", blockBlackGoo).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "mist", blockMist).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "cryostasistube", blockCryostasisTube).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "lightpanel", blockLightPanel).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "mainframepanel.shimmer", mainframePanelShimmer).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "mainframepanel.flicker", mainframePanelFlicker).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "engineership.ampule", blockAmpule).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "locker", blockLocker).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "gunlocker", blockGunLocker).setCreativeTab(AliensVsPredator.tabMain());
        register(AliensVsPredator.ID, "medpod", blockMedpod).setCreativeTab(AliensVsPredator.tabMain());

        register(AliensVsPredator.ID, "unidirt", unidirt);
        register(AliensVsPredator.ID, "unistone", unistone);
        register(AliensVsPredator.ID, "unisand", unisand);
        register(AliensVsPredator.ID, "unigravel", unigravel);
        register(AliensVsPredator.ID, "ceilingpanel", ceiling);
        register(AliensVsPredator.ID, "ceilingfan", ceilingfan);
        register(AliensVsPredator.ID, "ceilingvent", ceilingvent);
        register(AliensVsPredator.ID, "ceilinggrill", ceilinggrill);
        register(AliensVsPredator.ID, "floorgrill", floorgrill);
        register(AliensVsPredator.ID, "industrialwall", industrialwall);
        register(AliensVsPredator.ID, "industrialwall2", industrialwallstriped);
        register(AliensVsPredator.ID, "industrialvent", vent0);
        register(AliensVsPredator.ID, "vent.wall", vent1);
        register(AliensVsPredator.ID, "vent.ceiling", vent2);
        register(AliensVsPredator.ID, "industrialbricks", industrialbricks);
        register(AliensVsPredator.ID, "industrialglass", industrialglass);
        register(AliensVsPredator.ID, "metalpanel1", metalpanel);
        register(AliensVsPredator.ID, "metalpanel2", metalcolumn0);
        register(AliensVsPredator.ID, "metalpanel3", metalcolumn1);
        register(AliensVsPredator.ID, "hiveresin.standard", resin);
        register(AliensVsPredator.ID, "shippanel", metal1);
        register(AliensVsPredator.ID, "shippannelyautja", metal2);
        register(AliensVsPredator.ID, "tileovamorphdesign", relicovamorph);
        register(AliensVsPredator.ID, "tilefacehuggerdesign", relicfacehugger);
        register(AliensVsPredator.ID, "tilealiendesign", relicalien);
        register(AliensVsPredator.ID, "shipwallbase", ship1);
        register(AliensVsPredator.ID, "shipsupportpillar", ship2);
        register(AliensVsPredator.ID, "shipdecor1", ship3);
        register(AliensVsPredator.ID, "shipdecor2", ship5);
        register(AliensVsPredator.ID, "shipdecor3", ship6);
        register(AliensVsPredator.ID, "shipbrick", ship4);
        register(AliensVsPredator.ID, "templebricksingle", templetilesingle);
        register(AliensVsPredator.ID, "templebrick", templebrick);
        register(AliensVsPredator.ID, "templetile", templetile);
        register(AliensVsPredator.ID, "templewallbase", templewall1);
        register(AliensVsPredator.ID, "templefloor", templewall2);
        register(AliensVsPredator.ID, "skulls", skulls);
        register(AliensVsPredator.ID, "plasticblock", plastic);
        register(AliensVsPredator.ID, "paddingpanel", paddingpanel);
        register(AliensVsPredator.ID, "plastictile", plastictile);
        register(AliensVsPredator.ID, "plastictiletri", plastictri);
        register(AliensVsPredator.ID, "plastictilecircle", plasticcircle);
        register(AliensVsPredator.ID, "engineershipfloor", engineerfloor);
        register(AliensVsPredator.ID, "engineershipbrick", engineerbrick0);
        register(AliensVsPredator.ID, "engineershipbrick1", engineerbrick1);
        register(AliensVsPredator.ID, "engineershipbrick2", engineerbrick2);
        register(AliensVsPredator.ID, "engineershipbrick3", engineerbrick3);
        register(AliensVsPredator.ID, "engineershipgravel", engineergravel);
        register(AliensVsPredator.ID, "engineershipwall", engineerwall0);
        register(AliensVsPredator.ID, "engineershipwall1", engineerwall1);
        register(AliensVsPredator.ID, "engineershipwall2", engineerwall2);
        register(AliensVsPredator.ID, "engineershipwall3", engineerwall3);
        register(AliensVsPredator.ID, "engineershipwall4", engineerwall4);
        register(AliensVsPredator.ID, "engineershiprock", engineerrock0);
        register(AliensVsPredator.ID, "engineershiprock1", engineerrock1);
        register(AliensVsPredator.ID, "engineershiprock2", engineerrock2);
        register(AliensVsPredator.ID, "engineershiprock3", engineerrock3);
        register(AliensVsPredator.ID, "engineershipcolumn1", engineercolumn1);
        register(AliensVsPredator.ID, "engineershipcolumn2", engineercolumn2);
        register(AliensVsPredator.ID, "engineershipmaterial0", engineermaterial0);
        register(AliensVsPredator.ID, "engineershipmaterial1", engineermaterial1);
        register(AliensVsPredator.ID, "engineershipmaterial2", engineermaterial2);

        registerOnly(AliensVsPredator.ID, "slope", slope).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "corner", corner).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "invertedcorner", invertedCorner).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "ridge", ridge).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "smartridge", smartRidge).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "invertedridge", invertedRidge).setCreativeTab(AliensVsPredator.tabMain());
        registerOnly(AliensVsPredator.ID, "smartinvertedridge", smartInvertedRidge).setCreativeTab(AliensVsPredator.tabMain());
    }

    public Block register(String modid, String identifier, Block block)
    {
        // resourceGenerator.generate(ResourceType.BLOCKSTATE_FORGE_CUBE, identifier);
        block.setUnlocalizedName(String.format("%s:%s", modid, identifier));
        block.setCreativeTab(AliensVsPredator.tabBlocks());

        GameRegistry.register(block, new ResourceLocation(modid, identifier));
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
        }

        return block;
    }

    public Block registerOnly(String modid, String identifier, Block block)
    {
        block.setUnlocalizedName(String.format("%s:%s", modid, identifier));

        GameRegistry.register(block, new ResourceLocation(modid, identifier));
        GameRegistry.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));

        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            Item item = Item.getItemFromBlock(block);
            ModelResourceLocation modelResource = new ModelResourceLocation(item.getRegistryName(), "inventory");
            ModelLoader.setCustomModelResourceLocation(item, 0, modelResource);
        }

        return block;
    }

    // private JsonResourceGenerator resourceGenerator;

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        // resourceGenerator = new JsonResourceGenerator(AliensVsPredator.ID);
        // resourceGenerator.pre(event);

        this.register();
    }
}
