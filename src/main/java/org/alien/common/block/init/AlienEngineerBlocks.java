package org.alien.common.block.init;

import com.asx.mdx.common.mods.IPreInitEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.lib.common.block.BasicBlock;
import org.lib.common.block.BlockProperties;
import org.lib.common.registry.BlockRegistryUtil;

/**
 * @author Boston Vanseghi
 */
public class AlienEngineerBlocks implements IPreInitEvent {
    public static final AlienEngineerBlocks instance = new AlienEngineerBlocks();

    private AlienEngineerBlocks() {}

    private static final BlockProperties ENGINEER_PROPS = new BlockProperties(Material.IRON).setHardness(10F).setResistance(15.0F);

    /* Engineers */
    public static final Block ENGINEER_FLOOR = new BasicBlock("engineershipfloor", ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_0 = new BasicBlock("engineershipbrick", ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_1 = new BasicBlock("engineershipbrick1", ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_2 = new BasicBlock("engineershipbrick2", ENGINEER_PROPS);
    public static final Block ENGINEER_BRICK_3 = new BasicBlock("engineershipbrick3", ENGINEER_PROPS);
    public static final Block ENGINEER_GRAVEL = new BasicBlock("engineershipgravel", ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_0 = new BasicBlock("engineershipwall", ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_1 = new BasicBlock("engineershipwall1", ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_2 = new BasicBlock("engineershipwall2", ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_3 = new BasicBlock("engineershipwall3", ENGINEER_PROPS);
    public static final Block ENGINEER_WALL_4 = new BasicBlock("engineershipwall4", ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_0 = new BasicBlock("engineershiprock", ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_1 = new BasicBlock("engineershiprock1", ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_2 = new BasicBlock("engineershiprock2", ENGINEER_PROPS);
    public static final Block ENGINEER_ROCK_3 = new BasicBlock("engineershiprock3", ENGINEER_PROPS);
    public static final Block ENGINEER_COLUMN_1 = new BasicBlock("engineershipcolumn1", ENGINEER_PROPS);
    public static final Block ENGINEER_COLUMN_2 = new BasicBlock("engineershipcolumn2", ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_0 = new BasicBlock("engineershipmaterial0", ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_1 = new BasicBlock("engineershipmaterial1", ENGINEER_PROPS);
    public static final Block ENGINEER_MATERIAL_2 = new BasicBlock("engineershipmaterial2", ENGINEER_PROPS);

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
