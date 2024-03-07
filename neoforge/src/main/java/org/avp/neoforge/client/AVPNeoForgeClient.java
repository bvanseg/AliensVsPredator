package org.avp.neoforge.client;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.avp.client.render.entity.AVPEntityRenderRegistry;
import org.avp.common.AVPConstants;

/**
 * @author Boston Vanseghi
 */
@Mod.EventBusSubscriber(modid = AVPConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AVPNeoForgeClient {

    @SubscribeEvent
    @SuppressWarnings("unchecked")
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        AVPEntityRenderRegistry.getBindings().forEach(binding -> {
            var entityType = (EntityType<Entity>) binding.entityTypeGameObject().get();
            var provider = (EntityRendererProvider<Entity>) binding.entityRendererProvider();
            event.registerEntityRenderer(entityType, provider);
        });
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        AVPEntityRenderRegistry.getBindings().forEach(binding -> {
            binding.entityModelLayerData().forEach(modelLayerData -> {
                event.registerLayerDefinition(
                    modelLayerData.modelLayerLocation(),
                    modelLayerData.layerDefinitionSupplier()
                );
            });
        });
    }
}
