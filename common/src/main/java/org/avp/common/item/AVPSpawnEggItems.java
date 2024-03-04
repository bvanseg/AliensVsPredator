package org.avp.common.item;

import org.avp.common.registry.AVPItemBindingRegistry;

/**
 * @author Boston Vanseghi
 */
public class AVPSpawnEggItems extends AVPItemBindingRegistry {

    private static final AVPSpawnEggItems INSTANCE = new AVPSpawnEggItems();

    public static AVPSpawnEggItems getInstance() {
        return INSTANCE;
    }

    private AVPSpawnEggItems() {}
}
