package org.avp.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.avp.AVPConstants;
import org.avp.AVPItemGroups;
import org.avp.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPEngineerShipBlocks implements AVPRegistry {
    private static final AVPEngineerShipBlocks INSTANCE = new AVPEngineerShipBlocks();

    public static AVPEngineerShipBlocks getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Block> ENGINEER_SHIP_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AVPConstants.MOD_ID);

    private static final DeferredRegister<Item> ENGINEER_SHIP_BLOCK_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    private static final Material ENGINEER_SHIP_MATERIAL = Material.IRON;
    private static final Block.Properties ENGINEER_SHIP_PROPERTIES = Block.Properties.create(ENGINEER_SHIP_MATERIAL);
    private static final RegistryObject<Block> ENGINEER_SHIP_BRICK = registerBlockWithItem("engineer_ship_brick", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_BRICK_1 = registerBlockWithItem("engineer_ship_brick_1", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_BRICK_2 = registerBlockWithItem("engineer_ship_brick_2", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_BRICK_3 = registerBlockWithItem("engineer_ship_brick_3", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_COLUMN_1 = registerBlockWithItem("engineer_ship_column_1", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_COLUMN_2 = registerBlockWithItem("engineer_ship_column_2", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_FLOOR = registerBlockWithItem("engineer_ship_floor", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_GRAVEL = registerBlockWithItem("engineer_ship_gravel", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_MATERIAL_0 = registerBlockWithItem("engineer_ship_material_0", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_MATERIAL_1 = registerBlockWithItem("engineer_ship_material_1", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_MATERIAL_2 = registerBlockWithItem("engineer_ship_material_2", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_ROCK = registerBlockWithItem("engineer_ship_rock", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_ROCK_1 = registerBlockWithItem("engineer_ship_rock_1", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_ROCK_2 = registerBlockWithItem("engineer_ship_rock_2", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_ROCK_3 = registerBlockWithItem("engineer_ship_rock_3", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_WALL = registerBlockWithItem("engineer_ship_wall", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_WALL_1 = registerBlockWithItem("engineer_ship_wall_1", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_WALL_2 = registerBlockWithItem("engineer_ship_wall_2", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_WALL_3 = registerBlockWithItem("engineer_ship_wall_3", ENGINEER_SHIP_PROPERTIES);
    private static final RegistryObject<Block> ENGINEER_SHIP_WALL_4 = registerBlockWithItem("engineer_ship_wall_4", ENGINEER_SHIP_PROPERTIES);

    private static RegistryObject<Block> registerBlockWithItem(String name, Block.Properties properties) {
        RegistryObject<Block> blockRegistryObject = ENGINEER_SHIP_BLOCKS.register(name, () -> new Block(properties));
        ENGINEER_SHIP_BLOCK_ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().group(AVPItemGroups.BLOCK_ITEM_GROUP)));
        return blockRegistryObject;
    }

    @Override
    public void register() {
        ENGINEER_SHIP_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ENGINEER_SHIP_BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
