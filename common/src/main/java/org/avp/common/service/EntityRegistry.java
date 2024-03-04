package org.avp.common.service;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;

import java.util.function.Supplier;

import org.avp.common.item.AVPSpawnEggItems;
import org.avp.common.util.GameObject;

/**
 * @author Boston Vanseghi
 */
public interface EntityRegistry {

    <T extends Entity> GameObject<EntityType<T>> register(String registryName, Supplier<EntityType<T>> supplier);

    default <T extends Mob> GameObject<EntityType<T>> registerWithSpawnEgg(
        String registryName,
        Supplier<EntityType<T>> supplier
    ) {
        var gameObject = register(registryName, supplier);
        var spawnEggGameObject = Services.ITEM_REGISTRY.register(
            "spawn_egg_" + registryName,
            () -> new SpawnEggItem(gameObject.get(), 0, 0, new Item.Properties())
        );
        AVPSpawnEggItems.getInstance().ENTRIES.add(spawnEggGameObject);
        return gameObject;
    }
}
