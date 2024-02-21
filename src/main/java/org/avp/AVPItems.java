package org.avp;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Boston Vanseghi
 */
public final class AVPItems implements AVPRegistry {
    private static final AVPItems INSTANCE = new AVPItems();

    public static AVPItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    public static final RegistryObject<Item> CPU = ITEMS.register("cpu", () -> new Item(new Item.Properties().group(AVPItemGroups.ITEM_GROUP)));
    private static final RegistryObject<Item> RAM = ITEMS.register("ram", () -> new Item(new Item.Properties()));
    private static final RegistryObject<Item> ROYAL_JELLY = ITEMS.register("royal_jelly", () -> new Item(new Item.Properties()));
    private static final RegistryObject<Item> SILICA = ITEMS.register("silica", () -> new Item(new Item.Properties()));

    @Override
    public void register() {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
