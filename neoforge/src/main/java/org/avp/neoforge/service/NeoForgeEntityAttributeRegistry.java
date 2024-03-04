package org.avp.neoforge.service;

import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

import org.avp.common.entity.attribute.AVPEntityAttributes;

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
        AVPEntityAttributes.getBindings().forEach(binding -> {
            var entityType = binding.getKey().get();
            var attributeSupplier = binding.getValue();
            event.put(entityType, attributeSupplier);
        });
    }
}
