package org.avp;

import java.util.ArrayList;

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
import org.avp.block.BlockPortal;
import org.avp.block.BlockPowercell;
import org.avp.block.BlockPowerline;
import org.avp.block.BlockRedstoneEmitter;
import org.avp.block.BlockRedstoneFluxGenerator;
import org.avp.block.BlockRedstoneSensor;
import org.avp.block.BlockReflective;
import org.avp.block.BlockSatelliteDish;
import org.avp.block.BlockSatelliteModem;
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
import org.avp.registry.BlockFluidRegistration;
import org.avp.registry.BlockRegistrationAVP;

import com.arisux.mdx.lib.game.BlockRegistrationHandler;
import com.arisux.mdx.lib.game.registry.BlockRegistration;
import com.arisux.mdx.lib.world.block.BlockMaterial;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.util.BlockRenderLayer;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Properties.ID)
@Mod.EventBusSubscriber
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
    public Block sevastopolBlastDoor   = new BlockSevastopolBlastDoor().setHardness(10F).setResistance(15.0F).setLightOpacity(0);
    public Block cryoTube              = new BlockCryostasisTube(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(4);
    public Block lightPanel            = new BlockLightPanel(Material.IRON).setHardness(1.5F).setResistance(2.0F);
    public Block ccflTube              = new BlockCCFLTube(Material.IRON).setHardness(0.5F).setResistance(1.0F);
    public Block satelliteModem        = new BlockSatelliteModem(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block powercell             = new BlockPowercell(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block redstoneSensor        = new BlockRedstoneSensor(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block redstoneEmitter       = new BlockRedstoneEmitter(Material.IRON).setHardness(3.2F).setResistance(2.6F);
    public Block universalGenerator    = new BlockRedstoneFluxGenerator(Material.IRON).setHardness(3.2F).setResistance(2.6F);
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
    public Block slope                 = new BlockReflective(Material.CIRCUITS);
    public Block corner                = new BlockReflective(Material.CIRCUITS);
    public Block invertedCorner        = new BlockReflective(Material.CIRCUITS);
    public Block ridge                 = new BlockReflective(Material.CIRCUITS);
    public Block pyramid               = new BlockReflective(Material.CIRCUITS);
    public Block invertedRidge         = new BlockReflective(Material.CIRCUITS);
    public Block invertedPyramid       = new BlockReflective(Material.CIRCUITS);

    public BlockHandler()
    {
        super(AliensVsPredator.instance());
    }

    @Override
    public void pre(FMLPreInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
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
        register("blastdoor.sevastopol", sevastopolBlastDoor).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock", supplyCrate).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.marines", crateMarines).setCreativeTab(AliensVsPredator.tabMain());
        register("supplychuteblock.seegson", crateSeegson).setCreativeTab(AliensVsPredator.tabMain());
        register("cryostasistube", cryoTube).setCreativeTab(AliensVsPredator.tabMain());
        register("lightpanel", lightPanel).setCreativeTab(AliensVsPredator.tabMain());
        register("ccfltube", ccflTube).setCreativeTab(AliensVsPredator.tabMain());
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
        register("pyramid", pyramid);// smartridge
        register("invertedcorner", invertedCorner);
        register("invertedridge", invertedRidge);
        register("invertedpyramid", invertedPyramid);// smartinvertedridge

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

        BlockReflective.registerCompatBlocks("hiveresin.standard", resin);
        BlockReflective.registerCompatBlocks("unidirt", unidirt);
        BlockReflective.registerCompatBlocks("unistone", unistone);
        BlockReflective.registerCompatBlocks("unisand", unisand);
        BlockReflective.registerCompatBlocks("unigravel", unigravel);
        BlockReflective.registerCompatBlocks("ceilingpanel", ceiling);
        BlockReflective.registerCompatBlocks("ceilingfan", ceilingfan);
        BlockReflective.registerCompatBlocks("ceilingvent", ceilingvent);
        BlockReflective.registerCompatBlocks("ceilinggrill", ceilinggrill);
        BlockReflective.registerCompatBlocks("floorgrill", floorgrill);
        BlockReflective.registerCompatBlocks("industrialwall", industrialwall);
        BlockReflective.registerCompatBlocks("industrialwall2", industrialwallstriped);
        BlockReflective.registerCompatBlocks("industrialvent", vent0);
        BlockReflective.registerCompatBlocks("vent.wall", vent1);
        BlockReflective.registerCompatBlocks("vent.ceiling", vent2);
        BlockReflective.registerCompatBlocks("industrialbricks", industrialbricks);
        BlockReflective.registerCompatBlocks("industrialglass", industrialglass);
        BlockReflective.registerCompatBlocks("metalpanel1", metalpanel);
        BlockReflective.registerCompatBlocks("metalpanel2", metalcolumn0);
        BlockReflective.registerCompatBlocks("metalpanel3", metalcolumn1);
        BlockReflective.registerCompatBlocks("shippanel", metal1);
        BlockReflective.registerCompatBlocks("shippannelyautja", metal2);
        BlockReflective.registerCompatBlocks("tileovamorphdesign", relicovamorph);
        BlockReflective.registerCompatBlocks("tilefacehuggerdesign", relicfacehugger);
        BlockReflective.registerCompatBlocks("tilealiendesign", relicalien);
        BlockReflective.registerCompatBlocks("shipwallbase", ship1);
        BlockReflective.registerCompatBlocks("shipsupportpillar", ship2);
        BlockReflective.registerCompatBlocks("shipdecor1", ship3);
        BlockReflective.registerCompatBlocks("shipdecor2", ship5);
        BlockReflective.registerCompatBlocks("shipdecor3", ship6);
        BlockReflective.registerCompatBlocks("shipbrick", ship4);
        BlockReflective.registerCompatBlocks("templebricksingle", templetilesingle);
        BlockReflective.registerCompatBlocks("templebrick", templebrick);
        BlockReflective.registerCompatBlocks("templetile", templetile);
        BlockReflective.registerCompatBlocks("templewallbase", templewall1);
        BlockReflective.registerCompatBlocks("templefloor", templewall2);
        BlockReflective.registerCompatBlocks("skulls", skulls);
        BlockReflective.registerCompatBlocks("plasticblock", plastic);
        BlockReflective.registerCompatBlocks("paddingpanel", paddingpanel);
        BlockReflective.registerCompatBlocks("plastictile", plastictile);
        BlockReflective.registerCompatBlocks("plastictiletri", plastictri);
        BlockReflective.registerCompatBlocks("plastictilecircle", plasticcircle);
        BlockReflective.registerCompatBlocks("engineershipfloor", engineerfloor);
        BlockReflective.registerCompatBlocks("engineershipbrick", engineerbrick0);
        BlockReflective.registerCompatBlocks("engineershipbrick1", engineerbrick1);
        BlockReflective.registerCompatBlocks("engineershipbrick2", engineerbrick2);
        BlockReflective.registerCompatBlocks("engineershipbrick3", engineerbrick3);
        BlockReflective.registerCompatBlocks("engineershipgravel", engineergravel);
        BlockReflective.registerCompatBlocks("engineershipwall", engineerwall0);
        BlockReflective.registerCompatBlocks("engineershipwall1", engineerwall1);
        BlockReflective.registerCompatBlocks("engineershipwall2", engineerwall2);
        BlockReflective.registerCompatBlocks("engineershipwall3", engineerwall3);
        BlockReflective.registerCompatBlocks("engineershipwall4", engineerwall4);
        BlockReflective.registerCompatBlocks("engineershiprock", engineerrock0);
        BlockReflective.registerCompatBlocks("engineershiprock1", engineerrock1);
        BlockReflective.registerCompatBlocks("engineershiprock2", engineerrock2);
        BlockReflective.registerCompatBlocks("engineershiprock3", engineerrock3);
        BlockReflective.registerCompatBlocks("engineershipcolumn1", engineercolumn1);
        BlockReflective.registerCompatBlocks("engineershipcolumn2", engineercolumn2);
        BlockReflective.registerCompatBlocks("engineershipmaterial0", engineermaterial0);
        BlockReflective.registerCompatBlocks("engineershipmaterial1", engineermaterial1);
        BlockReflective.registerCompatBlocks("engineershipmaterial2", engineermaterial2);
    }

    @Override
    public Block register(String identifier, Block block)
    {
        block.setCreativeTab(AliensVsPredator.tabBlocks());
        return super.register(identifier, block);
    }

    /**
     * Preparation for Minecraft 1.12. Not stable enough for full conversion in
     * 1.10.2
     **/
    private static final ArrayList<BlockRegistration> registrations = new ArrayList<BlockRegistration>();

    public static final BlockFluidClassic             blackgoo      = null;
    public static final BlockFluidClassic             mist          = null;
    public static final Block                         lv426rock     = null;

    public static ArrayList<BlockRegistration> getRegistrations()
    {
        return registrations;
    }

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        registrations.add(new BlockFluidRegistration("blackgoo", BlockBlackGoo.class, BlockBlackGoo.fluid));
        registrations.add(new BlockFluidRegistration("mist", BlockMist.class, BlockMist.fluid));

        registrations.add(new BlockRegistrationAVP("paddingpanel_orange", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_pipes_orange", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_pipes_white", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_square_orange", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_square_white", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_tiles_orange", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("padding_tiles_white", new BlockMaterial(Material.CLOTH)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(10F);
                block.setResistance(15.0F);
                block.setLightOpacity(0);
                return super.applyModifiers(block);
            }
        });

        registrations.add(new BlockRegistrationAVP("lv426rock", new BlockMaterial(Material.ROCK)) {
            @Override
            public Block applyModifiers(Block block)
            {
                block.setHardness(1.3F);
                block.setResistance(2.0F);
                return super.applyModifiers(block);
            }
        });

        for (BlockRegistration registration : registrations)
        {
            registration.registerBlock(event);
        }
    }

    @SubscribeEvent
    public static void registerItemBlocks(RegistryEvent.Register<Item> event)
    {
        for (BlockRegistration registration : registrations)
        {
            registration.registerItemBlock(event).setCreativeTab(AliensVsPredator.tabBlocks());
        }
    }
}
