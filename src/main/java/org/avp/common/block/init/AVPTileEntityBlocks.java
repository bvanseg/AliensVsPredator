package org.avp.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.block.BlockTempleSpawner;
import org.avp.AVP;
import org.avp.common.AVPCreativeTabs;
import org.avp.common.block.*;
import org.avp.common.item.supply.chute.SupplyChuteType;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Ri5ux
 * @author Boston Vanseghi
 */
public class AVPTileEntityBlocks implements IPreInitEvent
{
    public static final AVPTileEntityBlocks instance = new AVPTileEntityBlocks();

    private AVPTileEntityBlocks() {}

    // Tile entities
    public static final Block SATELLITE_DISH = new BlockSatelliteDish().setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("satellitedish");
    public static final Block EGG_RECEPTACLE = new BlockTempleSpawner(Material.ROCK, false).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("spawner");
    public static final Block ASSEMBLER = new BlockAssembler(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("assembler");
    public static final Block TURRET = new BlockTurret(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("turret");
    public static final Block TERMINAL = new BlockWorkstation(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("terminal");
    public static final Block REPULSION_GENERATOR = new BlockGenerator(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("generator");
    public static final Block POWERLINE = new BlockPowerline(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("powerline");
    public static final Block BLAST_DOOR = new BlockBlastdoor(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("blastdoor");
    public static final Block SEVASTOPOL_BLAST_DOOR = new BlockSevastopolBlastDoor().setHardness(10F).setResistance(15.0F).setLightOpacity(0).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("blastdoor.sevastopol");
    public static final Block CRYO_TUBE = new BlockCryostasisTube(Material.IRON).setHardness(10F).setResistance(15.0F).setLightOpacity(4).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("cryostasistube");
    public static final Block LIGHT_PANEL = new BlockLightPanel(Material.IRON).setHardness(1.5F).setResistance(2.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("lightpanel");
    public static final Block CCFL_TUBE = new BlockCCFLTube(Material.IRON).setHardness(0.5F).setResistance(1.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("ccfltube");
    public static final Block TESLA_COIL = new BlockTeslaCoil(Material.IRON).setHardness(0.5F).setResistance(1.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("teslacoil");
    public static final Block NETWORK_RACK = new BlockNetworkRack(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("networkrack");
    public static final Block POWERCELL = new BlockPowercell(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("powercell");
    public static final Block REDSTONE_SENSOR = new BlockRedstoneSensor(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("redstonesensor");
    public static final Block REDSTONE_EMITTER = new BlockRedstoneEmitter(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("redstoneemitter");
    public static final Block UNIVERSAL_GENERATOR = new BlockRedstoneFluxGenerator(Material.IRON).setHardness(3.2F).setResistance(2.6F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("universalgenerator");
    public static final Block TRANSFORMER = new BlockTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("transformer");
    public static final Block STEPDOWN_TRANSFORMER = new BlockNegativeTransformer(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("transformer.stepdown");
    public static final Block SUPPLY_CRATE = new BlockSupplyCrate(SupplyChuteType.UNBRANDED).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("supplychuteblock");
    public static final Block CRATE_MARINES = new BlockSupplyCrate(SupplyChuteType.MARINES).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("supplychuteblock.marines");
    public static final Block CRATE_SEEGSON = new BlockSupplyCrate(SupplyChuteType.SEEGSON).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("supplychuteblock.seegson");
    public static final Block SOLAR_PANEL = new BlockSolarPanel(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("solarpanel");
    public static final Block LOCKER = new BlockLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("locker");
    public static final Block MEDPOD = new BlockMedpod(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("medpod");
    public static final Block GUN_LOCKER = new BlockGunLocker(Material.IRON).setHardness(1.5F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("gunlocker");
    public static final Block AMPULE = new BlockAmpule().setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("engineership.ampule");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        AVP.instance.getLogger().info("Registering Tile Entity Blocks");

        this.registerBlocks();
    }

    private void registerBlocks() {
        // Tile entities
        BlockRegistryUtil.registerStandardBlock(SATELLITE_DISH);
        BlockRegistryUtil.registerStandardBlock(EGG_RECEPTACLE);
        BlockRegistryUtil.registerStandardBlock(ASSEMBLER);
        BlockRegistryUtil.registerStandardBlock(TURRET);
        BlockRegistryUtil.registerStandardBlock(TERMINAL);
        BlockRegistryUtil.registerStandardBlock(REPULSION_GENERATOR);
        BlockRegistryUtil.registerStandardBlock(POWERLINE);
        BlockRegistryUtil.registerStandardBlock(BLAST_DOOR);
        BlockRegistryUtil.registerStandardBlock(SEVASTOPOL_BLAST_DOOR);
        BlockRegistryUtil.registerStandardBlock(CRYO_TUBE);
        BlockRegistryUtil.registerStandardBlock(LIGHT_PANEL);
        BlockRegistryUtil.registerStandardBlock(CCFL_TUBE);
        BlockRegistryUtil.registerStandardBlock(TESLA_COIL);
        BlockRegistryUtil.registerStandardBlock(NETWORK_RACK);
        BlockRegistryUtil.registerStandardBlock(POWERCELL);
        BlockRegistryUtil.registerStandardBlock(REDSTONE_SENSOR);
        BlockRegistryUtil.registerStandardBlock(REDSTONE_EMITTER);
        BlockRegistryUtil.registerStandardBlock(UNIVERSAL_GENERATOR);
        BlockRegistryUtil.registerStandardBlock(TRANSFORMER);
        BlockRegistryUtil.registerStandardBlock(STEPDOWN_TRANSFORMER);
        BlockRegistryUtil.registerStandardBlock(SUPPLY_CRATE);
        BlockRegistryUtil.registerStandardBlock(CRATE_MARINES);
        BlockRegistryUtil.registerStandardBlock(CRATE_SEEGSON);
        BlockRegistryUtil.registerStandardBlock(SOLAR_PANEL);
        BlockRegistryUtil.registerStandardBlock(LOCKER);
        BlockRegistryUtil.registerStandardBlock(MEDPOD);
        BlockRegistryUtil.registerStandardBlock(GUN_LOCKER);
        BlockRegistryUtil.registerStandardBlock(AMPULE);
    }
}
