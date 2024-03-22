package org.avp.common.item;

import net.minecraft.world.item.Item;
import org.avp.common.registry.AVPItemBindingRegistry;
import org.avp.common.util.GameObject;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class AVPSpawnEggItems extends AVPItemBindingRegistry {

    public static final List<GameObject<Item>> ENTRIES = new ArrayList<>();

    private AVPSpawnEggItems() {}
}
