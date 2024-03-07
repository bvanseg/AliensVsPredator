package org.avp.client.render.entity;

import org.avp.client.model.entity.living.EngineerModel;
import org.avp.client.render.entity.living.EngineerRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPEngineerEntityTypes;

import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class AVPPrometheusEngineerEntityRenderers {

    private AVPPrometheusEngineerEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPEngineerEntityTypes.ENGINEER,
                EngineerRenderer::new,
                List.of(
                    new EntityModelLayerData(EngineerModel.LAYER_LOCATION, EngineerModel::createBodyLayer),
                    new EntityModelLayerData(EngineerModel.ARMOR_LAYER_LOCATION, EngineerModel::createBodyLayer)
                )
            )
        );
    }
}
