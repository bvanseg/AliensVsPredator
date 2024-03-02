package org.avp.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.avp.client.render.entity.AVPEntityRenderers;

/**
 * @author Boston Vanseghi
 */
public class AVPFabricClient implements ClientModInitializer {

    @Override
    @SuppressWarnings("unchecked")
    public void onInitializeClient() {
        AVPEntityRenderers.getBindings().forEach(binding -> {
            var entityType = (EntityType<Entity>) binding.entityTypeGameObject().get();
            var provider = (EntityRendererProvider<Entity>) binding.entityRendererProvider();
            EntityRendererRegistry.register(entityType, provider);

            var layerDataList = binding.entityModelLayerData();
            layerDataList.forEach(layerData -> EntityModelLayerRegistry.registerModelLayer(layerData.modelLayerLocation(), layerData.layerDefinitionSupplier()::get));
        });
    }
}
