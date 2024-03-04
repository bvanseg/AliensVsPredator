package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPRegistry;
import org.avp.common.service.Services;

/**
 * @author Boston Vanseghi
 */
public class AVPItems implements AVPRegistry {

    private static final AVPItems INSTANCE = new AVPItems();

    public static AVPItems getInstance() {
        return INSTANCE;
    }

    private AVPItems() {}

    @Override
    public void register() {
        Services.ITEM_REGISTRY.register("carbon", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("cobalt", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ingot_aluminum", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("ingot_lithium", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("laser_mine", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("nbt_drive", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("neodymium", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("neodymium_magnet", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("polycarbonate", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("raw_bauxite", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("royal_jelly", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("shuriken", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("silica", () -> new Item(new Item.Properties()));
        Services.ITEM_REGISTRY.register("smart_disc", () -> new Item(new Item.Properties()));
    }
}
