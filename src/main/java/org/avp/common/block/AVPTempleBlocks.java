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
public class AVPTempleBlocks implements AVPRegistry {

    private static final AVPTempleBlocks INSTANCE = new AVPTempleBlocks();

    public static AVPTempleBlocks getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Block> TEMPLE_BLOCKS = new DeferredRegister<>(
        ForgeRegistries.BLOCKS,
        AVPConstants.MOD_ID
    );

    private static final DeferredRegister<Item> TEMPLE_BLOCK_ITEMS = new DeferredRegister<>(
        ForgeRegistries.ITEMS,
        AVPConstants.MOD_ID
    );

    private static final Material TEMPLE_BRICK_MATERIAL = Material.ROCK;

    private static final Block.Properties TEMPLE_BRICK_PROPERTIES = Block.Properties.create(TEMPLE_BRICK_MATERIAL);

    public static final RegistryObject<Block> TEMPLE_BRICK = registerBlockWithItem(
        "temple_brick",
        TEMPLE_BRICK_PROPERTIES
    );

    public static final RegistryObject<Block> TEMPLE_BRICK_CHESTBURSTER = registerBlockWithItem(
        "temple_brick_chestburster",
        TEMPLE_BRICK_PROPERTIES
    );

    public static final RegistryObject<Block> TEMPLE_BRICK_FACEHUGGER = registerBlockWithItem(
        "temple_brick_facehugger",
        TEMPLE_BRICK_PROPERTIES
    );

    private static final RegistryObject<Block> TEMPLE_BRICK_SINGLE = registerBlockWithItem(
        "temple_brick_single",
        TEMPLE_BRICK_PROPERTIES
    );

    private static final RegistryObject<Block> TEMPLE_FLOOR = registerBlockWithItem(
        "temple_floor",
        TEMPLE_BRICK_PROPERTIES
    );

    private static final RegistryObject<Block> TEMPLE_TILE = registerBlockWithItem(
        "temple_tile",
        TEMPLE_BRICK_PROPERTIES
    );

    private static final RegistryObject<Block> TEMPLE_WALL_BASE = registerBlockWithItem(
        "temple_wall_base",
        TEMPLE_BRICK_PROPERTIES
    );

    private static RegistryObject<Block> registerBlockWithItem(String name, Block.Properties properties) {
        RegistryObject<Block> blockRegistryObject = TEMPLE_BLOCKS.register(name, () -> new Block(properties));
        TEMPLE_BLOCK_ITEMS.register(
            name,
            () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().group(AVPItemGroups.BLOCK_ITEM_GROUP))
        );
        return blockRegistryObject;
    }

    @Override
    public void register() {
        TEMPLE_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TEMPLE_BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
