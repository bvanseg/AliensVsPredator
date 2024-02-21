package org.avp;

import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

/**
 * @author Boston Vanseghi
 */
public final class AVPFoodItems implements AVPRegistry {
    private static final AVPFoodItems INSTANCE = new AVPFoodItems();

    public static AVPFoodItems getInstance() {
        return INSTANCE;
    }

    private static final DeferredRegister<Item> FOOD_ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, AVPConstants.MOD_ID);

    public static final RegistryObject<Item> DORITOS = registerItem("doritos");
    private static final RegistryObject<Item> DORITOS_COOL_RANCH = registerItem("doritos_cool_ranch");
    private static final RegistryObject<Item> RAW_TENTACLE = registerItem("raw_tentacle");
    private static final RegistryObject<Item> TRILO_BITE = registerItem("trilo_bite");

    private static RegistryObject<Item> registerItem(String name) {
        return FOOD_ITEMS.register(name, () -> new Item(new Item.Properties().group(AVPItemGroups.FOOD_ITEM_GROUP)));
    }

    @Override
    public void register() {
        FOOD_ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
