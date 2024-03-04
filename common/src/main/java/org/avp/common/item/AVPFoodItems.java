package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPFoodItems implements AVPRegistry {

    private static final AVPFoodItems INSTANCE = new AVPFoodItems();

    public static AVPFoodItems getInstance() {
        return INSTANCE;
    }

    private AVPFoodItems() {}

    @Override
    public void register() {
        Services.ITEM_REGISTRY.register("doritos", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("doritos_cool_ranch", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("raw_tentacle", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("trilo_bite", () -> new Item(new Item.Properties()));
    }
}
