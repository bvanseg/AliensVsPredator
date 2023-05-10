package org.prometheus.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.alien.common.block.init.AlienBlockProperties;
import org.lib.common.block.BasicBlock;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class PrometheusEngineerBlocks implements IPreInitEvent {
    public static final PrometheusEngineerBlocks instance = new PrometheusEngineerBlocks();

    private PrometheusEngineerBlocks() {}

    /* Engineers */
    public static final Block ENGINEER_FLOOR = new BasicBlock("engineershipfloor", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_0 = new BasicBlock("engineershipbrick", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_1 = new BasicBlock("engineershipbrick1", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_2 = new BasicBlock("engineershipbrick2", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_3 = new BasicBlock("engineershipbrick3", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_GRAVEL = new BasicBlock("engineershipgravel", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_0 = new BasicBlock("engineershipwall", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_1 = new BasicBlock("engineershipwall1", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_2 = new BasicBlock("engineershipwall2", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_3 = new BasicBlock("engineershipwall3", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_4 = new BasicBlock("engineershipwall4", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_0 = new BasicBlock("engineershiprock", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_1 = new BasicBlock("engineershiprock1", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_2 = new BasicBlock("engineershiprock2", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_3 = new BasicBlock("engineershiprock3", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_COLUMN_1 = new BasicBlock("engineershipcolumn1", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_COLUMN_2 = new BasicBlock("engineershipcolumn2", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_0 = new BasicBlock("engineershipmaterial0", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_1 = new BasicBlock("engineershipmaterial1", AlienBlockProperties.ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_2 = new BasicBlock("engineershipmaterial2", AlienBlockProperties.ENGINEER_PROPS);

    @Override
    public void pre(FMLPreInitializationEvent event) {
        this.registerBlocks();
    }

    private void registerBlocks() {
        BlockRegistryUtil.registerStandardBlock(ENGINEER_FLOOR);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_BRICK_0);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_BRICK_1);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_BRICK_2);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_BRICK_3);

        BlockRegistryUtil.registerStandardBlock(ENGINEER_GRAVEL);

        BlockRegistryUtil.registerStandardBlock(ENGINEER_WALL_0);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_WALL_1);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_WALL_2);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_WALL_3);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_WALL_4);

        BlockRegistryUtil.registerStandardBlock(ENGINEER_ROCK_0);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_ROCK_1);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_ROCK_2);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_ROCK_3);

        BlockRegistryUtil.registerStandardBlock(ENGINEER_COLUMN_1);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_COLUMN_2);

        BlockRegistryUtil.registerStandardBlock(ENGINEER_MATERIAL_0);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_MATERIAL_1);
        BlockRegistryUtil.registerStandardBlock(ENGINEER_MATERIAL_2);
    }
}
