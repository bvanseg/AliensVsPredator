package org.avp.fabric.service;


import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import org.avp.common.entity.attribute.AVPEntityAttributes;
import org.avp.common.registry.AVPRegistry;

/**
 * @author Boston Vanseghi
 */
public class FabricEntityAttributeRegistry implements AVPRegistry {

    private static final FabricEntityAttributeRegistry INSTANCE = new FabricEntityAttributeRegistry();

    public static FabricEntityAttributeRegistry getInstance() {
        return INSTANCE;
    }

    private FabricEntityAttributeRegistry() {}

    @Override
    public void register() {
        AVPEntityAttributes.getBindings().forEach(binding -> {
            var entityType = binding.getKey().get();
            var attributeSupplier = binding.getValue();
            FabricDefaultAttributeRegistry.register(entityType, attributeSupplier);
        });
    }
}
