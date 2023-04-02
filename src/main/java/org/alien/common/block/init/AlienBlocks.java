package org.alien.common.block.init;

import com.asx.mdx.common.minecraft.block.BlockMaterial;
import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.AlienDimensions;
import org.alien.common.block.BlockBlackGoo;
import org.alien.common.block.BlockHiveResin;
import org.alien.common.block.BlockMist;
import org.alien.common.block.BlockPortal;
import org.avp.common.AVPCreativeTabs;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienBlocks implements IPreInitEvent {
    public static final AlienBlocks instance = new AlienBlocks();

    private AlienBlocks() {}

    public static final Block NATURAL_RESIN = new BlockHiveResin(Material.WOOD).setRegistryName("hiveresin");
    public static final Block RESIN = new BlockMaterial(Material.WOOD).setHardness(5F).setResistance(10.0F).setRegistryName("hiveresin.standard");
    public static final Block RELIC_OVAMORPH = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tileovamorphdesign");
    public static final Block RELIC_FACEHUGGER = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilefacehuggerdesign");
    public static final Block RELIC_ALIEN = new BlockMaterial(Material.ROCK).setHardness(5F).setResistance(15.0F).setRegistryName("tilealiendesign");

    /* Acheron */
    public static final Block LV_426_ROCK = new BlockMaterial(Material.ROCK).setHardness(1.3F).setResistance(2.0F).setRegistryName("lv426rock");

    /* Misc */
    public static final Block PORTAL_ACHERON = new BlockPortal(AlienDimensions.ACHERON).setHardness(-1.0F).setLightLevel(2.0F).setCreativeTab(AVPCreativeTabs.MAIN).setRegistryName("portal.acheron");

    public static final Block BLACK_GOO = BlockRegistryUtil.createFluidBlock(BlockBlackGoo.fluid, BlockBlackGoo.class, "blackgoo");
    public static final Block MIST = BlockRegistryUtil.createFluidBlock(BlockMist.fluid, BlockMist.class, "mist");

    // Woods
    public static final BlockProperties WOOD_PLANK_PROPS = new BlockProperties(Material.WOOD)
            .setHardness(2.0F).setResistance(5.0F).setSoundType(SoundType.WOOD).setFireInfo(5, 20);


    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();

        AlienEngineerBlocks.instance.pre(event);
        AlienVardaBlocks.instance.pre(event);
        AlienParadiseBlocks.instance.pre(event);
        AlienSlabBlocks.instance.pre(event);
        AlienSkullBlocks.instance.pre(event);
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(NATURAL_RESIN);
        BlockRegistryUtil.registerStandardBlock(RESIN);

        BlockRegistryUtil.registerStandardBlock(RELIC_OVAMORPH);
        BlockRegistryUtil.registerStandardBlock(RELIC_FACEHUGGER);
        BlockRegistryUtil.registerStandardBlock(RELIC_ALIEN);

        BlockRegistryUtil.registerStandardBlock(LV_426_ROCK);

        BlockRegistryUtil.registerStandardBlock(PORTAL_ACHERON);

        BlockRegistryUtil.registerStandardBlock(BLACK_GOO);
        BlockRegistryUtil.registerStandardBlock(MIST);
    }
}
