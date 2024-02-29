package org.avp.neoforge.util;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.avp.common.util.GameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeEntityGameObject<T extends Entity> extends GameObject<EntityType<T>> {
    public NeoForgeEntityGameObject(DeferredRegister<EntityType<?>> deferredRegister, String registryName, Supplier<EntityType<T>> supplier) {
        super(deferredRegister.register(registryName, supplier));
    }
}
