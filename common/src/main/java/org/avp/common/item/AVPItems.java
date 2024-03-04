package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPItems INSTANCE = new AVPItems();

    public static AVPItems getInstance() {
        return INSTANCE;
    }

    public final GameObject<Item> ROYAL_JELLY = registerEntry("royal_jelly", () -> new Item(new Item.Properties()));

    private AVPItems() {}

    @Override
    public void register() {
        registerEntry("carbon", () -> new Item(new Item.Properties()));
        registerEntry("cobalt", () -> new Item(new Item.Properties()));
        registerEntry("ingot_aluminum", () -> new Item(new Item.Properties()));
        registerEntry("ingot_lithium", () -> new Item(new Item.Properties()));
        registerEntry("laser_mine", () -> new Item(new Item.Properties()));
        registerEntry("nbt_drive", () -> new Item(new Item.Properties()));
        registerEntry("neodymium", () -> new Item(new Item.Properties()));
        registerEntry("neodymium_magnet", () -> new Item(new Item.Properties()));
        registerEntry("polycarbonate", () -> new Item(new Item.Properties()));
        registerEntry("raw_bauxite", () -> new Item(new Item.Properties()));
        registerEntry("shuriken", () -> new Item(new Item.Properties()));
        registerEntry("silica", () -> new Item(new Item.Properties()));
        registerEntry("smart_disc", () -> new Item(new Item.Properties()));
    }
}
