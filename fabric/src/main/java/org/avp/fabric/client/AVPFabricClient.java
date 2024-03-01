package org.avp.fabric.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import org.avp.client.model.entity.living.OvamorphModel;
import org.avp.client.render.entity.living.OvamorphRenderer;
import org.avp.common.entity.AVPEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(AVPEntityTypes.OVAMORPH.get(), OvamorphRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(OvamorphModel.LAYER_LOCATION, OvamorphModel::createBodyLayer);
    }
}
