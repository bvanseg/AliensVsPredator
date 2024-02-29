package org.avp.common.service;

import net.minecraft.world.item.Item;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public interface ItemRegistry {
    GameObject<Item> register(String registryName, Supplier<Item> supplier);
}
