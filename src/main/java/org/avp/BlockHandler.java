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

import com.arisux.mdx.lib.game.BlockRegistrationHandler;
import com.arisux.mdx.lib.world.block.BlockMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BlockHandler extends BlockRegistrationHandler<AliensVsPredator>
{
    public static final BlockHandler instance                   = new BlockHandler();

    public Block                     terrainHiveResin           = (new BlockHiveResin(Material.WOOD)).setLightOpacity(255);
    public Block                     resin                      = (new BlockMaterial(Material.WOOD)).setHardness(5F).setResistance(10.0F).setLightOpacity(255);
    public Block                     relicovamorph              = (new BlockMaterial(Material.ROCK)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     metal1                     = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     metal2                     = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     relicfacehugger            = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     relicalien                 = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship1                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship2                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship3                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship4                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship5                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     ship6                      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     templebrick                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     templetile                 = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     templewall1                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     templewall2                = (new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     industrialwall             = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     ceiling                    = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     ceilingfan                 = (new BlockMaterial(Material.IRON)
                                                                {
                                                                    @Override
                                                                    public BlockRenderLayer getBlockLayer()
                                                                    {
                                                                        return BlockRenderLayer.TRANSLUCENT;
                                                                    }
                                                                }).setHardness(5F).setResistance(15.0F);
    public Block                     ceilingvent                = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     ceilinggrill               = ((new BlockMaterial(Material.IRON)
                                                                {
                                                                    @Override
                                                                    public BlockRenderLayer getBlockLayer()
                                                                    {
                                                                        return BlockRenderLayer.TRANSLUCENT;
                                                                    }
                                                                }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block                     skulls                     = (new BlockMaterial(Material.ROCK));
    public Block                     floorgrill                 = ((new BlockMaterial(Material.IRON)
                                                                {
                                                                    @Override
                                                                    public BlockRenderLayer getBlockLayer()
                                                                    {
                                                                        return BlockRenderLayer.TRANSLUCENT;
                                                                    }
                                                                }).setHardness(5F).setResistance(15.0F)).setLightOpacity(4);
    public Block                     industrialbricks           = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     metalpanel                 = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     metalcolumn0               = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     metalcolumn1               = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     plasticcircle              = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     plastic                    = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     paddingpanel               = (new BlockMaterial(Material.CLOTH)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     plastictri                 = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     plastictile                = (new BlockMaterial(Material.CLAY)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     oreSilicon                 = (new BlockMaterial(Material.ROCK)).setHardness(2.2F).setResistance(1.4F).setLightOpacity(255);
    public Block                     oreLithium                 = (new BlockMaterial(Material.IRON)).setHardness(4.2F).setResistance(5.4F).setLightOpacity(255);
    public Block                     oreCopper                  = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block                     oreBauxite                 = (new BlockMaterial(Material.IRON)).setHardness(3.2F).setResistance(2.6F).setLightOpacity(255);
    public Block                     mainframePanelShimmer      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F));
    public Block                     mainframePanelFlicker      = (new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F));
    public Block                     vent0                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     vent1                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     vent2                      = (new BlockMaterial(Material.IRON)).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     engineerfloor              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerbrick0             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerbrick1             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerbrick2             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerbrick3             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineergravel             = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerwall0              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerwall1              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerwall2              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerwall3              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerwall4              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerrock0              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerrock1              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerrock2              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineerrock3              = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineercolumn1            = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineercolumn2            = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineermaterial1          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     engineermaterial2          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     unistone                   = (new BlockMaterial(Material.ROCK)).setHardness(1.3F).setResistance(2.0F).setLightOpacity(255);
    public Block                     unisand                    = (new BlockMaterial(Material.SAND)).setHardness(3.5F).setResistance(2.0F).setLightOpacity(255);
    public Block                     unigravel                  = (new BlockMaterial(Material.SAND)).setHardness(3.0F).setLightOpacity(255);
    public Block                     blockSatelliteDish         = (new BlockSatelliteDish()).setHardness(3.2F).setResistance(2.6F);
    public Block                     engineermaterial0          = (new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(255));
    public Block                     blockSacrificialSpawner    = (new BlockTempleSpawner(Material.ROCK, false));
    public Block                     blockSpawnerCreative       = (new BlockTempleSpawner(Material.ROCK, true));
    public Block                     blockPortalVarda           = (new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F));
    public Block                     blockPortalAcheron         = (new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F));
    public Block                     blockAssembler             = (new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block                     blockFloorGrillStairs      = (new BlockCustomStairs(floorgrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block                     blockCeilingGrillStairs    = (new BlockCustomStairs(ceilinggrill.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block                     blockIronBricksStairs      = (new BlockCustomStairs(industrialbricks.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     blockWallStairs            = (new BlockCustomStairs(industrialwall.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     unidirt                    = (new BlockUnidentifiedDirt()).setHardness(0.5F).setResistance(2.0F).setLightOpacity(255);
    public Block                     terrainStalagmite          = (new BlockStalagmite(Material.PLANTS)).setHardness(0.0F).setLightOpacity(0);
    public Block                     terrainUniTreeLog          = (new BlockUnidentifiedLog()).setHardness(0.0F).setLightOpacity(0);
    public Block                     terrainUniTreeTendon       = (new BlockUnidentifiedTreeTendon()).setHardness(0.0F).setLightOpacity(0);
    public Block                     terrainUniTreeLeaves       = (new BlockUnidentifiedTreeLeaves()).setHardness(0.0F).setLightOpacity(0);
    public Block                     terrainUniTreeSapling      = (new BlockUnidentifiedTreeSapling()).setHardness(0.0F).setLightOpacity(0);
    public Block                     blockTurret                = (new BlockTurret(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     blockWorkstation           = (new BlockWorkstation(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     blockStasisMechanism       = (new BlockStasisMechanism(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block                     blockRepulsionGenerator    = (new BlockGenerator(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block                     blockPowerline             = (new BlockPowerline(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     blockBlastdoor             = (new BlockBlastdoor(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block                     blockCryostasisTube        = (new BlockCryostasisTube(Material.IRON)).setHardness(10F).setResistance(15.0F).setLightOpacity(4);
    public Block                     blockLightPanel            = (new BlockLightPanel(Material.IRON)).setHardness(1.5F).setResistance(2.0F);
    public Block                     blockSatelliteModem        = (new BlockSatelliteModem(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     blockPowercell             = (new BlockPowercell(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     redstoneSensor             = (new BlockRedstoneSensor(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     redstoneEmitter            = (new BlockRedstoneEmitter(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     redstoneFluxGenerator      = (new BlockRedstoneFluxGenerator(Material.IRON)).setHardness(3.2F).setResistance(2.6F);
    public Block                     blockBlackGoo              = (new BlockBlackGoo());
    public Block                     blockMist                  = (new BlockMist());
    public Block                     blockTransformer           = (new BlockTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block                     blockNegativeTransformer   = (new BlockNegativeTransformer(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block                     supplyCrate                = (new BlockSupplyCrate(SupplyChuteType.UNBRANDED));
    public Block                     supplyCrateMarines         = (new BlockSupplyCrate(SupplyChuteType.MARINES));
    public Block                     supplyCrateSeegson         = (new BlockSupplyCrate(SupplyChuteType.SEEGSON));
    public Block                     blockSolarPanel            = (new BlockSolarPanel(Material.IRON)).setHardness(5.0F).setResistance(10.0F);
    public Block                     blockLocker                = (new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block                     blockMedpod                = (new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block                     blockGunLocker             = (new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F));
    public Block                     blockAmpule                = (new BlockAmpule().setHardness(5.0F).setResistance(10.0F));
    public Block                     industrialwallstriped      = (new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     templetilesingle           = (new BlockMaterial(Material.ROCK)
                                                                {
                                                                }.setHardness(5F).setResistance(15.0F).setLightOpacity(255));
    public Block                     industrialglass            = (new BlockMaterial(Material.IRON)
                                                                {
                                                                    @Override
                                                                    public BlockRenderLayer getBlockLayer()
                                                                    {
                                                                        return BlockRenderLayer.TRANSLUCENT;
                                                                    }
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     blockFloorGrillSlab        = (new BlockCustomSlab(Material.IRON, false)
                                                                {
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block                     blockCeilingGrillSlab      = (new BlockCustomSlab(Material.IRON, false)
                                                                {
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block                     blockWallSlab              = (new BlockCustomSlab(Material.IRON, false)
                                                                {
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     blockIronBricksSlab        = (new BlockCustomSlab(Material.IRON, false)
                                                                {
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block                     blockIndustrialGlassSlab   = (new BlockCustomSlab(Material.IRON, false)
                                                                {
                                                                }).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block                     blockIndustrialGlassStairs = (new BlockCustomStairs(industrialglass.getDefaultState())).setHardness(5F).setResistance(15.0F).setLightOpacity(0);

    public Block                     blockSkullEngineer         = new BlockSkullEngineer();
    public Block                     blockSkullSpaceJockey      = new BlockSkullSpaceJockey();
    public Block                     blockSkullXenomorph        = new BlockSkullXenomorph();
    public Block                     blockSkullXenomorphWarrior = new BlockSkullXenomorphWarrior();
    public Block                     blockSkullYautja           = new BlockSkullYautja();

    public Block                     slope                      = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     corner                     = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     invertedCorner             = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     ridge                      = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     smartRidge                 = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     invertedRidge              = new BlockReflectiveShape(Material.CIRCUITS);
    public Block                     smartInvertedRidge         = new BlockReflectiveShape(Material.CIRCUITS);

    public BlockHandler()
    {
        super(AliensVsPredator.instance());
    }

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        this.register();
    }

    private void register()
    {
        register("skull.engineer", blockSkullEngineer).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.spacejockey", blockSkullSpaceJockey).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.xenomorph", blockSkullXenomorph).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.xenomorph.warrior", blockSkullXenomorphWarrior).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.yautja", blockSkullYautja).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.wood", terrainUniTreeLog).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.tendons", terrainUniTreeTendon).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.leaves", terrainUniTreeLeaves).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.sapling", terrainUniTreeSapling).setCreativeTab(AliensVsPredator.tabMain());
        register("stalagmite", terrainStalagmite).setCreativeTab(AliensVsPredator.tabMain());
        register("oresilicon", oreSilicon).setCreativeTab(AliensVsPredator.tabMain());
        register("orecopper", oreCopper).setCreativeTab(AliensVsPredator.tabMain());
        register("orelithium", oreLithium).setCreativeTab(AliensVsPredator.tabMain());
        register("orebauxite", oreBauxite).setCreativeTab(AliensVsPredator.tabMain());
        register("solarpanel", blockSolarPanel).setCreativeTab(AliensVsPredator.tabMain());
        register("satellitemodem", blockSatelliteModem).setCreativeTab(AliensVsPredator.tabMain());
        register("satellitedish", blockSatelliteDish).setCreativeTab(AliensVsPredator.tabMain());
        register("powercell", blockPowercell).setCreativeTab(AliensVsPredator.tabMain());
        register("transformer", blockTransformer).setCreativeTab(AliensVsPredator.tabMain());
        register("transformernegative", blockNegativeTransformer).setCreativeTab(AliensVsPredator.tabMain());
        register("ceilinggrillstairs", blockCeilingGrillStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register("ceilinggrillslab", blockCeilingGrillSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register("floorgrillstairs", blockFloorGrillStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register("floorgrillslab", blockFloorGrillSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register("redstonesensor", redstoneSensor).setCreativeTab(AliensVsPredator.tabMain());
        register("redstoneemitter", redstoneEmitter).setCreativeTab(AliensVsPredator.tabMain());
        register("redstonefluxgenerator", redstoneFluxGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register("industrialwallstairs", blockWallStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register("industrialslab", blockWallSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register("industrialbrickstairs", blockIronBricksStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register("industrialbrickslab", blockIronBricksSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register("industrialglassstairs", blockIndustrialGlassStairs).setCreativeTab(AliensVsPredator.tabBlocks());
        register("industrialglassslab", blockIndustrialGlassSlab).setCreativeTab(AliensVsPredator.tabBlocks());
        register("hiveresin", terrainHiveResin);
        register("spawner", blockSacrificialSpawner).setCreativeTab(AliensVsPredator.tabMain());
        register("spawnerc", blockSpawnerCreative).setCreativeTab(AliensVsPredator.tabMain());
        register("portal.varda", blockPortalVarda).setCreativeTab(AliensVsPredator.tabMain());
        register("portal.acheron", blockPortalAcheron).setCreativeTab(AliensVsPredator.tabMain());
        register("assembler", blockAssembler).setCreativeTab(AliensVsPredator.tabMain());
        register("turret", blockTurret).setCreativeTab(AliensVsPredator.tabMain());
        register("terminal", blockWorkstation).setCreativeTab(AliensVsPredator.tabMain());
        register("stasismechanism", blockStasisMechanism).setCreativeTab(AliensVsPredator.tabMain());
        register("generator", blockRepulsionGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register("powerline", blockPowerline).setCreativeTab(AliensVsPredator.tabMain());
        register("blastdoor", blockBlastdoor).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock", supplyCrate).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.marines", supplyCrateMarines).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.seegson", supplyCrateSeegson).setCreativeTab(AliensVsPredator.tabMain());
        register("blackgoo", blockBlackGoo).setCreativeTab(AliensVsPredator.tabMain());
        register("mist", blockMist).setCreativeTab(AliensVsPredator.tabMain());
        register("cryostasistube", blockCryostasisTube).setCreativeTab(AliensVsPredator.tabMain());
        register("lightpanel", blockLightPanel).setCreativeTab(AliensVsPredator.tabMain());
        register("mainframepanel.shimmer", mainframePanelShimmer).setCreativeTab(AliensVsPredator.tabMain());
        register("mainframepanel.flicker", mainframePanelFlicker).setCreativeTab(AliensVsPredator.tabMain());
        register("engineership.ampule", blockAmpule).setCreativeTab(AliensVsPredator.tabMain());
        register("locker", blockLocker).setCreativeTab(AliensVsPredator.tabMain());
        register("gunlocker", blockGunLocker).setCreativeTab(AliensVsPredator.tabMain());
        register("medpod", blockMedpod).setCreativeTab(AliensVsPredator.tabMain());

        register("unidirt", unidirt);
        register("unistone", unistone);
        register("unisand", unisand);
        register("unigravel", unigravel);
        register("ceilingpanel", ceiling);
        register("ceilingfan", ceilingfan);
        register("ceilingvent", ceilingvent);
        register("ceilinggrill", ceilinggrill);
        register("floorgrill", floorgrill);
        register("industrialwall", industrialwall);
        register("industrialwall2", industrialwallstriped);
        register("industrialvent", vent0);
        register("vent.wall", vent1);
        register("vent.ceiling", vent2);
        register("industrialbricks", industrialbricks);
        register("industrialglass", industrialglass);
        register("metalpanel1", metalpanel);
        register("metalpanel2", metalcolumn0);
        register("metalpanel3", metalcolumn1);
        register("hiveresin.standard", resin);
        register("shippanel", metal1);
        register("shippannelyautja", metal2);
        register("tileovamorphdesign", relicovamorph);
        register("tilefacehuggerdesign", relicfacehugger);
        register("tilealiendesign", relicalien);
        register("shipwallbase", ship1);
        register("shipsupportpillar", ship2);
        register("shipdecor1", ship3);
        register("shipdecor2", ship5);
        register("shipdecor3", ship6);
        register("shipbrick", ship4);
        register("templebricksingle", templetilesingle);
        register("templebrick", templebrick);
        register("templetile", templetile);
        register("templewallbase", templewall1);
        register("templefloor", templewall2);
        register("skulls", skulls);
        register("plasticblock", plastic);
        register("paddingpanel", paddingpanel);
        register("plastictile", plastictile);
        register("plastictiletri", plastictri);
        register("plastictilecircle", plasticcircle);
        register("engineershipfloor", engineerfloor);
        register("engineershipbrick", engineerbrick0);
        register("engineershipbrick1", engineerbrick1);
        register("engineershipbrick2", engineerbrick2);
        register("engineershipbrick3", engineerbrick3);
        register("engineershipgravel", engineergravel);
        register("engineershipwall", engineerwall0);
        register("engineershipwall1", engineerwall1);
        register("engineershipwall2", engineerwall2);
        register("engineershipwall3", engineerwall3);
        register("engineershipwall4", engineerwall4);
        register("engineershiprock", engineerrock0);
        register("engineershiprock1", engineerrock1);
        register("engineershiprock2", engineerrock2);
        register("engineershiprock3", engineerrock3);
        register("engineershipcolumn1", engineercolumn1);
        register("engineershipcolumn2", engineercolumn2);
        register("engineershipmaterial0", engineermaterial0);
        register("engineershipmaterial1", engineermaterial1);
        register("engineershipmaterial2", engineermaterial2);

        register("slope", slope);
        register("corner", corner);
        register("invertedcorner", invertedCorner);
        register("ridge", ridge);
        register("smartridge", smartRidge);
        register("invertedridge", invertedRidge);
        register("smartinvertedridge", smartInvertedRidge);
    }

    @Override
    public Block register(String identifier, Block block)
    {
        block.setCreativeTab(AliensVsPredator.tabBlocks());
        return super.register(identifier, block);
    }
}
