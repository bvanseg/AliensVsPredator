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
public class AVPYautjaShipBlocks implements AVPRegistry {
    private static final AVPYautjaShipBlocks INSTANCE = new AVPYautjaShipBlocks();

    public static AVPYautjaShipBlocks getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Block> YAUTJA_SHIP_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AVPConstants.MOD_ID);

    private static final DeferredRegister<Item> YAUTJA_SHIP_BLOCK_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    private static final Material YAUTJA_SHIP_MATERIAL = Material.IRON;
    private static final Block.Properties YAUTJA_SHIP_PROPERTIES = Block.Properties.create(YAUTJA_SHIP_MATERIAL);
    private static final RegistryObject<Block> YAUTJA_SHIP_BRICK = registerBlockWithItem("yautja_ship_brick", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_DECOR_1 = registerBlockWithItem("yautja_ship_decor_1", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_DECOR_2 = registerBlockWithItem("yautja_ship_decor_2", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_DECOR_3 = registerBlockWithItem("yautja_ship_decor_3", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_PANEL = registerBlockWithItem("yautja_ship_panel", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_SUPPORT_PILLAR = registerBlockWithItem("yautja_ship_support_pillar", YAUTJA_SHIP_PROPERTIES);
    private static final RegistryObject<Block> YAUTJA_SHIP_WALL_BASE = registerBlockWithItem("yautja_ship_wall_base", YAUTJA_SHIP_PROPERTIES);

    private static RegistryObject<Block> registerBlockWithItem(String name, Block.Properties properties) {
        RegistryObject<Block> blockRegistryObject = YAUTJA_SHIP_BLOCKS.register(name, () -> new Block(properties));
        YAUTJA_SHIP_BLOCK_ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().group(AVPItemGroups.BLOCK_ITEM_GROUP)));
        return blockRegistryObject;
    }

    @Override
    public void register() {
        YAUTJA_SHIP_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        YAUTJA_SHIP_BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
