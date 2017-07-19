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
    public Block naturalResin          = new BlockHiveResin(Material.WOOD).setLightOpacity(255);
    public Block resin                 = new BlockMaterial(Material.WOOD).setHardness(5F).setResistance(10.0F);
    public Block relicovamorph         = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block metal1                = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block metal2                = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block relicfacehugger       = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block relicalien            = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block ship1                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ship2                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ship3                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ship4                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ship5                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ship6                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block templebrick           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block templetile            = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block templewall1           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block templewall2           = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F);
    public Block industrialwall        = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block ceiling               = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block ceilingfan            = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F);
    public Block ceilingvent           = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block ceilinggrill          = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block skulls                = new BlockMaterial(Material.ROCK);
    public Block floorgrill            = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block industrialbricks      = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block metalpanel            = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block metalcolumn0          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block metalcolumn1          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F);
    public Block plasticcircle         = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block plastic               = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block paddingpanel          = new BlockMaterial(Material.CLOTH).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block plastictri            = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block plastictile           = new BlockMaterial(Material.CLAY).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block oreSilicon            = new BlockMaterial(Material.ROCK).setHardness(2.2F).setResistance(1.4F);
    public Block oreLithium            = new BlockMaterial(Material.IRON).setHardness(4.2F).setResistance(5.4F);
    public Block oreCopper             = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block oreBauxite            = new BlockMaterial(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block muthurPanel1          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(1F).setLightLevel(0.5F);
    public Block muthurPanel2          = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(10F).setLightLevel(0.5F);
    public Block vent0                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block vent1                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block vent2                 = new BlockMaterial(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block engineerfloor         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerbrick0        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerbrick1        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerbrick2        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerbrick3        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineergravel        = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerwall0         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerwall1         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerwall2         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerwall3         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerwall4         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerrock0         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerrock1         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerrock2         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineerrock3         = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineercolumn1       = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineercolumn2       = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineermaterial1     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block engineermaterial2     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block unistone              = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F);
    public Block unisand               = new BlockMaterial(Material.SAND).setHardness(3.5F).setResistance(2.0F);
    public Block unigravel             = new BlockMaterial(Material.SAND).setHardness(3.0F).setLightOpacity(255);
    public Block satelliteDish         = new BlockSatelliteDish().setHardness(3.2F).setResistance(2.6F);
    public Block engineermaterial0     = new BlockMaterial(Material.IRON).setHardness(10F).setResistance(15.0F);
    public Block eggReceptacle         = new BlockTempleSpawner(Material.ROCK, false);
    public Block portalVarda           = new BlockPortal(AliensVsPredator.dimensions().VARDA).setHardness(-1.0F).setLightLevel(2.0F);
    public Block portalAcheron         = new BlockPortal(AliensVsPredator.dimensions().ACHERON).setHardness(-1.0F).setLightLevel(2.0F);
    public Block assembler             = new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F);
    public Block floorGrillStairs      = new BlockCustomStairs(floorgrill.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block ceilingGrillStairs    = new BlockCustomStairs(ceilinggrill.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block ironBricksStairs      = new BlockCustomStairs(industrialbricks.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block wallStairs            = new BlockCustomStairs(industrialwall.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block unidirt               = new BlockUnidentifiedDirt().setHardness(0.5F).setResistance(2.0F).setLightOpacity(255);
    public Block stalagmite            = new BlockStalagmite(Material.PLANTS).setHardness(0.0F).setLightOpacity(0);
    public Block gigerLog              = new BlockUnidentifiedLog().setHardness(0.0F).setLightOpacity(0);
    public Block gigerTendons          = new BlockUnidentifiedTreeTendon().setHardness(0.0F).setLightOpacity(0);
    public Block gigerLeaves           = new BlockUnidentifiedTreeLeaves().setHardness(0.0F).setLightOpacity(0);
    public Block gigerSapling          = new BlockUnidentifiedTreeSapling().setHardness(0.0F).setLightOpacity(0);
    public Block turret                = new BlockTurret(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block terminal              = new BlockWorkstation(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block stasisMechanism       = new BlockStasisMechanism(Material.IRON).setHardness(5.0F).setResistance(10.0F);
    public Block repulsionGenerator    = new BlockGenerator(Material.IRON).setHardness(5.0F).setResistance(10.0F);
    public Block powerline             = new BlockPowerline(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block blastDoor             = new BlockBlastdoor(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block cryoTube              = new BlockCryostasisTube(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(4);
    public Block lightPanel            = new BlockLightPanel(Material.IRON).setHardness(1.5F).setResistance(2.0F);
    public Block satelliteModem        = new BlockSatelliteModem(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block powercell             = new BlockPowercell(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block redstoneSensor        = new BlockRedstoneSensor(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block redstoneEmitter       = new BlockRedstoneEmitter(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block universalGenerator    = new BlockRedstoneFluxGenerator(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block blackgoo              = new BlockBlackGoo();
    public Block mist                  = new BlockMist();
    public Block transformer           = new BlockTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F);
    public Block stepdownTransformer   = new BlockNegativeTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F);
    public Block supplyCrate           = new BlockSupplyCrate(SupplyChuteType.UNBRANDED);
    public Block crateMarines          = new BlockSupplyCrate(SupplyChuteType.MARINES);
    public Block crateSeegson          = new BlockSupplyCrate(SupplyChuteType.SEEGSON);
    public Block solarPanel            = new BlockSolarPanel(Material.IRON).setHardness(5.0F).setResistance(10.0F);
    public Block locker                = new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F);
    public Block medpod                = new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F);
    public Block gunLocker             = new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F);
    public Block ampule                = new BlockAmpule().setHardness(5.0F).setResistance(10.0F);
    public Block industrialwallstriped = new BlockWall(Material.IRON).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block templetilesingle      = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block industrialglass       = new BlockMaterial(Material.IRON).setLayer(BlockRenderLayer.TRANSLUCENT).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block floorGrillSlab        = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block ceilingGrillSlab      = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(4);
    public Block wallSlab              = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block ironBricksSlab        = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(255);
    public Block industrialGlassSlab   = new BlockCustomSlab(Material.IRON, false).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block industrialGlassStairs = new BlockCustomStairs(industrialglass.getDefaultState()).setHardness(5F).setResistance(15.0F).setLightOpacity(0);
    public Block skullEngineer         = new BlockSkullEngineer();
    public Block skullJockey           = new BlockSkullSpaceJockey();
    public Block skullXeno             = new BlockSkullXenomorph();
    public Block skullXenoWarrior      = new BlockSkullXenomorphWarrior();
    public Block skullYautja           = new BlockSkullYautja();
    public Block slope                 = new BlockReflectiveShape(Material.CIRCUITS);
    public Block corner                = new BlockReflectiveShape(Material.CIRCUITS);
    public Block invertedCorner        = new BlockReflectiveShape(Material.CIRCUITS);
    public Block ridge                 = new BlockReflectiveShape(Material.CIRCUITS);
    public Block pyramid            = new BlockReflectiveShape(Material.CIRCUITS);
    public Block invertedRidge         = new BlockReflectiveShape(Material.CIRCUITS);
    public Block invertedPyramid    = new BlockReflectiveShape(Material.CIRCUITS);

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
        /** Special **/
        register("skull.engineer", skullEngineer).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.spacejockey", skullJockey).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.xenomorph", skullXeno).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.xenomorph.warrior", skullXenoWarrior).setCreativeTab(AliensVsPredator.tabMain());
        register("skull.yautja", skullYautja).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.wood", gigerLog).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.tendons", gigerTendons).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.leaves", gigerLeaves).setCreativeTab(AliensVsPredator.tabMain());
        register("unitree.sapling", gigerSapling).setCreativeTab(AliensVsPredator.tabMain());
        register("stalagmite", stalagmite).setCreativeTab(AliensVsPredator.tabMain());
        register("oresilicon", oreSilicon).setCreativeTab(AliensVsPredator.tabMain());
        register("orecopper", oreCopper).setCreativeTab(AliensVsPredator.tabMain());
        register("orelithium", oreLithium).setCreativeTab(AliensVsPredator.tabMain());
        register("orebauxite", oreBauxite).setCreativeTab(AliensVsPredator.tabMain());
        register("solarpanel", solarPanel).setCreativeTab(AliensVsPredator.tabMain());
        register("satellitemodem", satelliteModem).setCreativeTab(AliensVsPredator.tabMain());
        register("satellitedish", satelliteDish).setCreativeTab(AliensVsPredator.tabMain());
        register("powercell", powercell).setCreativeTab(AliensVsPredator.tabMain());
        register("transformer", transformer).setCreativeTab(AliensVsPredator.tabMain());
        register("transformernegative", stepdownTransformer).setCreativeTab(AliensVsPredator.tabMain());
        register("redstonesensor", redstoneSensor).setCreativeTab(AliensVsPredator.tabMain());
        register("redstoneemitter", redstoneEmitter).setCreativeTab(AliensVsPredator.tabMain());
        register("universalgenerator", universalGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register("spawner", eggReceptacle).setCreativeTab(AliensVsPredator.tabMain());
        register("portal.varda", portalVarda).setCreativeTab(AliensVsPredator.tabMain());
        register("portal.acheron", portalAcheron).setCreativeTab(AliensVsPredator.tabMain());
        register("assembler", assembler).setCreativeTab(AliensVsPredator.tabMain());
        register("turret", turret).setCreativeTab(AliensVsPredator.tabMain());
        register("terminal", terminal).setCreativeTab(AliensVsPredator.tabMain());
        register("stasismechanism", stasisMechanism).setCreativeTab(AliensVsPredator.tabMain());
        register("generator", repulsionGenerator).setCreativeTab(AliensVsPredator.tabMain());
        register("powerline", powerline).setCreativeTab(AliensVsPredator.tabMain());
        register("blastdoor", blastDoor).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock", supplyCrate).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.marines", crateMarines).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.seegson", crateSeegson).setCreativeTab(AliensVsPredator.tabMain());
        register("blackgoo", blackgoo).setCreativeTab(AliensVsPredator.tabMain());
        register("mist", mist).setCreativeTab(AliensVsPredator.tabMain());
        register("cryostasistube", cryoTube).setCreativeTab(AliensVsPredator.tabMain());
        register("lightpanel", lightPanel).setCreativeTab(AliensVsPredator.tabMain());
        register("mainframepanel.shimmer", muthurPanel1).setCreativeTab(AliensVsPredator.tabMain());
        register("mainframepanel.flicker", muthurPanel2).setCreativeTab(AliensVsPredator.tabMain());
        register("engineership.ampule", ampule).setCreativeTab(AliensVsPredator.tabMain());
        register("locker", locker).setCreativeTab(AliensVsPredator.tabMain());
        register("gunlocker", gunLocker).setCreativeTab(AliensVsPredator.tabMain());
        register("medpod", medpod).setCreativeTab(AliensVsPredator.tabMain());

        /** Shaped **/
        register("slope", slope);
        register("corner", corner);
        register("ridge", ridge);
        register("pyramid", pyramid);//smartridge
        register("invertedcorner", invertedCorner);
        register("invertedridge", invertedRidge);
        register("invertedpyramid", invertedPyramid);//smartinvertedridge

        /** Stairs **/
        register("ceilinggrillstairs", ceilingGrillStairs);
        register("floorgrillstairs", floorGrillStairs);
        register("industrialwallstairs", wallStairs);
        register("industrialbrickstairs", ironBricksStairs);
        register("industrialglassstairs", industrialGlassStairs);

        /** Slabs **/
        register("ceilinggrillslab", ceilingGrillSlab);
        register("floorgrillslab", floorGrillSlab);
        register("industrialslab", wallSlab);
        register("industrialbrickslab", ironBricksSlab);
        register("industrialglassslab", industrialGlassSlab);

        /** Building **/
        register("hiveresin", naturalResin);
        register("hiveresin.standard", resin);
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
    }

    @Override
    public Block register(String identifier, Block block)
    {
        block.setCreativeTab(AliensVsPredator.tabBlocks());
        return super.register(identifier, block);
    }
}
