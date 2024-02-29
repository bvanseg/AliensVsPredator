package org.avp.neoforge.service;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.avp.common.AVPConstants;
import org.avp.common.service.EntityRegistry;
import org.avp.common.util.GameObject;
import org.avp.neoforge.util.NeoForgeEntityGameObject;

import java.util.function.Supplier;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeEntityRegistry implements EntityRegistry {

    public static final DeferredRegister<EntityType<? extends Entity>> ENTITY_TYPES = DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE,  AVPConstants.MOD_ID);

    @Override
    public <T extends Entity> GameObject<EntityType<T>> register(String registryName, Supplier<EntityType<T>> supplier) {
        return new NeoForgeEntityGameObject<>(ENTITY_TYPES, registryName, supplier);
    }
}
