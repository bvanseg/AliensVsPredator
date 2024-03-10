package org.avp.common.item;

import net.minecraft.world.item.Item;

import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.registry.AVPRegistry;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public class AVPToolItems extends AVPItemBindingRegistry implements AVPRegistry {

    private static final AVPToolItems INSTANCE = new AVPToolItems();

    public static AVPToolItems getInstance() {
        return INSTANCE;
    }

    public GameObject<Item> CELTIC_PICKAXE;

    private AVPToolItems() {}

    @Override
    public void register() {
        registerEntry("tool_celtic_axe", () -> new Item(new Item.Properties()));
        registerEntry("tool_celtic_hoe", () -> new Item(new Item.Properties()));
        CELTIC_PICKAXE = registerEntry("tool_celtic_pickaxe", () -> new Item(new Item.Properties()));
        registerEntry("tool_celtic_shovel", () -> new Item(new Item.Properties()));
        registerEntry("tool_celtic_sword", () -> new Item(new Item.Properties()));
    }
}
