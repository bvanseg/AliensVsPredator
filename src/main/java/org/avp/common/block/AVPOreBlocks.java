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
public class AVPOreBlocks implements AVPRegistry {
    private static final AVPOreBlocks INSTANCE = new AVPOreBlocks();

    public static AVPOreBlocks getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Block> ORE_BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, AVPConstants.MOD_ID);

    private static final DeferredRegister<Item> ORE_BLOCK_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    private static final Material ORE_MATERIAL = Material.ROCK;
    private static final Block.Properties ORE_PROPERTIES = Block.Properties.create(ORE_MATERIAL);
    private static final RegistryObject<Block> ORE_BAUXITE = registerBlockWithItem("ore_bauxite", ORE_PROPERTIES);
    private static final RegistryObject<Block> ORE_COBALT = registerBlockWithItem("ore_cobalt", ORE_PROPERTIES);
    private static final RegistryObject<Block> ORE_COPPER = registerBlockWithItem("ore_copper", ORE_PROPERTIES);
    private static final RegistryObject<Block> ORE_LITHIUM = registerBlockWithItem("ore_lithium", ORE_PROPERTIES);
    private static final RegistryObject<Block> ORE_MONAZITE = registerBlockWithItem("ore_monazite", ORE_PROPERTIES);
    private static final RegistryObject<Block> ORE_SILICA = registerBlockWithItem("ore_silica", ORE_PROPERTIES);

    private static RegistryObject<Block> registerBlockWithItem(String name, Block.Properties properties) {
        RegistryObject<Block> blockRegistryObject = ORE_BLOCKS.register(name, () -> new Block(properties));
        ORE_BLOCK_ITEMS.register(name, () -> new BlockItem(blockRegistryObject.get(), new Item.Properties().group(AVPItemGroups.BLOCK_ITEM_GROUP)));
        return blockRegistryObject;
    }

    @Override
    public void register() {
        ORE_BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ORE_BLOCK_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
