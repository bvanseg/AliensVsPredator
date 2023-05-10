package org.predator.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienDimensions;
import org.alien.common.block.BlockPortal;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.block.BasicBlock;
import org.lib.common.registry.BlockRegistryUtil;
import org.predator.common.PredatorDimensions;
import org.predator.common.block.BlockStasisMechanism;
import org.predator.common.block.skull.*;

/**
 * @author Boston Vanseghi
 */
public class PredatorBlocks implements IPreInitEvent {
    public static final PredatorBlocks instance = new PredatorBlocks();

    public static final Block SHIP_PANEL = new BasicBlock("shippanel", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_PANEL_YAUTJA = new BasicBlock("shippannelyautja", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_WALL_BASE = new BasicBlock("shipwallbase", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_SUPPORT_PILLAR = new BasicBlock("shipsupportpillar", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_BRICK = new BasicBlock("shipbrick", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_DECOR_1 = new BasicBlock("shipdecor1", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_DECOR_2 = new BasicBlock("shipdecor2", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block SHIP_DECOR_3 = new BasicBlock("shipdecor3", PredatorBlockProperties.YAUTJA_METAL_PROPS);
    public static final Block TEMPLE_TILES_SINGLE = new BasicBlock("templebricksingle", PredatorBlockProperties.TEMPLE_PROPS);
    public static final Block TEMPLE_BRICK = new BasicBlock("templebrick", PredatorBlockProperties.TEMPLE_PROPS);
    public static final Block TEMPLE_TILE = new BasicBlock("templetile", PredatorBlockProperties.TEMPLE_PROPS);
    public static final Block TEMPLE_WALL_BASE = new BasicBlock("templewallbase", PredatorBlockProperties.TEMPLE_PROPS);
    public static final Block TEMPLE_FLOOR = new BasicBlock("templefloor", PredatorBlockProperties.TEMPLE_PROPS);
    public static final Block STASIS_MECHANISM = new BlockStasisMechanism(Material.IRON).setHardness(5.0F).setResistance(10.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("stasismechanism");
    public static final Block SKULL_YAUTJA = new BlockSkullYautja().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("skull.yautja");
    public static final Block BIOMASK_CLASSIC = new BlockBiomaskClassic().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.classic");
    public static final Block BIOMASK_BERSERKER = new BlockBiomaskBerserker().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.berserker");
    public static final Block BIOMASK_FALCONER = new BlockBiomaskFalconer().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.falconer");
    public static final Block BIOMASK_TRACKER = new BlockBiomaskTracker().setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("biomask.tracker");

    public static final Block PORTAL_PRESERVE = new BlockPortal(PredatorDimensions.PRESERVE).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("portal.preserve");

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();

        PredatorStairsBlocks.instance.pre(event);
        PredatorSlabBlocks.instance.pre(event);
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(SHIP_PANEL);
        BlockRegistryUtil.registerStandardBlock(SHIP_PANEL_YAUTJA);

        BlockRegistryUtil.registerStandardBlock(SHIP_WALL_BASE);
        BlockRegistryUtil.registerStandardBlock(SHIP_SUPPORT_PILLAR);
        BlockRegistryUtil.registerStandardBlock(SHIP_DECOR_1);
        BlockRegistryUtil.registerStandardBlock(SHIP_BRICK);
        BlockRegistryUtil.registerStandardBlock(SHIP_DECOR_2);
        BlockRegistryUtil.registerStandardBlock(SHIP_DECOR_3);

        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILES_SINGLE);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_BRICK);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_TILE);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_WALL_BASE);
        BlockRegistryUtil.registerStandardBlock(TEMPLE_FLOOR);

        BlockRegistryUtil.registerStandardBlock(SKULL_YAUTJA);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_CLASSIC);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_BERSERKER);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_FALCONER);
        BlockRegistryUtil.registerStandardBlock(BIOMASK_TRACKER);

        BlockRegistryUtil.registerStandardBlock(STASIS_MECHANISM);

        BlockRegistryUtil.registerStandardBlock(PORTAL_PRESERVE);
    }
}
