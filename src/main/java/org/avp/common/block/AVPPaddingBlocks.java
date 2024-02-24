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
public class AVPPaddingBlocks implements AVPRegistry {
    private static final AVPPaddingBlocks INSTANCE = new AVPPaddingBlocks();

    public static AVPPaddingBlocks getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Block> PADDING_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AVPConstants.MOD_ID);

    private static final DeferredRegister<Item> PADDING_BLOCK_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    private static final Material PADDING_MATERIAL = Material.WOOL;
    private static final Block.Properties PADDING_PROPERTIES = Block.Properties.create(PADDING_MATERIAL);

    private static final RegistryObject<Block> PADDING_ORANGE_PANEL = registerBlockWithItem("padding_orange_panel", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_ORANGE_PIPES = registerBlockWithItem("padding_orange_pipes", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_ORANGE_SQUARE = registerBlockWithItem("padding_orange_square", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_ORANGE_TILES = registerBlockWithItem("padding_orange_tiles", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_WHITE_PANEL = registerBlockWithItem("padding_white_panel", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_WHITE_PIPES = registerBlockWithItem("padding_white_pipes", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_WHITE_SQUARE = registerBlockWithItem("padding_white_square", PADDING_PROPERTIES);
    private static final RegistryObject<Block> PADDING_WHITE_TILES = registerBlockWithItem("padding_white_tiles", PADDING_PROPERTIES);

    private static RegistryObject<Block> registerBlockWithItem(String name, Block.Properties properties) {
        RegistryObject<Block> blockRegistryObject = PADDING_BLOCKS.register(name, () -> new Block(properties));
        PADDING_BLOCK_ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().group(AVPItemGroups.BLOCK_ITEM_GROUP)));
        return blockRegistryObject;
    }

    @Override
    public void register() {
        PADDING_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        PADDING_BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
