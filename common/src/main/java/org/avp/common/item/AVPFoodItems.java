package org.avp.common.item;

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

    public final GameObject<Item> DORITOS = registerEntry("doritos", () -> new Item(new Item.Properties()));

    private AVPFoodItems() {}

    @Override
    public void register() {
        registerEntry("doritos_cool_ranch", () -> new Item(new Item.Properties()));
        registerEntry("raw_tentacle", () -> new Item(new Item.Properties()));
        registerEntry("trilo_bite", () -> new Item(new Item.Properties()));
    }
}
