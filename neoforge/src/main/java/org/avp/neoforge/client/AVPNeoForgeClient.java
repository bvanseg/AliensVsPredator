package org.avp.neoforge.client;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import org.avp.client.model.entity.living.OvamorphModel;
import org.avp.client.render.entity.living.OvamorphRenderer;
import org.avp.common.AVPConstants;
import org.avp.common.entity.AVPEntityTypes;

/**
 * @author Boston Vanseghi
 */
@Mod.EventBusSubscriber(modid = AVPConstants.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class AVPNeoForgeClient {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(AVPEntityTypes.OVAMORPH.get(), OvamorphRenderer::new);
    }

    @SubscribeEvent
    public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(OvamorphModel.LAYER_LOCATION, OvamorphModel::createBodyLayer);
    }
}
