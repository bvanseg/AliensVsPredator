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
        Services.ITEM_REGISTRY.register("royal_jelly", () -> new Item(new Item.Properties()));
    }
}
