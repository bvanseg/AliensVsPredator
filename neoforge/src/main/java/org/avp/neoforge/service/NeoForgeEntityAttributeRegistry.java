package org.avp.neoforge.service;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import org.avp.common.entity.attribute.*;
import org.avp.common.util.GameObject;

import java.util.Map;
import java.util.function.Consumer;

/**
 * @author Boston Vanseghi
 */
public class NeoForgeEntityAttributeRegistry {

    private static final NeoForgeEntityAttributeRegistry INSTANCE = new NeoForgeEntityAttributeRegistry();

    public static NeoForgeEntityAttributeRegistry getInstance() {
        return INSTANCE;
    }

    private NeoForgeEntityAttributeRegistry() {}

    public void createEntityAttributes(EntityAttributeCreationEvent event) {
        AVPEntityAttributesBindingRegistry.getBindings().forEach(binding -> {
            var entityType = binding.getKey().get();
            var attributeSupplier = binding.getValue();
            event.put(entityType, attributeSupplier);
        });
    }
}
