package org.avp.common.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPFoodItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPFoodItems INSTANCE = new AVPFoodItems();

    public static AVPFoodItems getInstance() {
        return INSTANCE;
    }

    public static GameObject<Item> DORITOS;

    public static GameObject<Item> DORITOS_COOL_RANCH;

    public static GameObject<Item> RAW_TENTACLE;

    public static GameObject<Item> TRILO_BITE;

    private AVPFoodItems() {}

    private GameObject<Item> registerFood(String registryName, FoodProperties.Builder foodPropertiesBuilder) {
        var foodProperties = foodPropertiesBuilder.build();
        return registerEntry(registryName, () -> new Item(new Item.Properties().food(foodProperties)));
    }

    @Override
    public void register() {
        DORITOS = registerFood(
            "doritos",
            new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(0.2F)
        );
        DORITOS_COOL_RANCH = registerFood(
            "doritos_cool_ranch",
            new FoodProperties.Builder().alwaysEat().nutrition(4).saturationMod(0.2F)
        );

        // Slightly worse than raw beef.
        RAW_TENTACLE = registerFood(
            "raw_tentacle",
            new FoodProperties.Builder().meat().nutrition(2).saturationMod(0.2F)
        );

        // Slightly worse than cooked beef.
        TRILO_BITE = registerFood("trilo_bite", new FoodProperties.Builder().meat().nutrition(7).saturationMod(0.7F));
    }
}
