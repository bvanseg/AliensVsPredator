package org.avp.client.render.entity;

import org.avp.client.model.entity.living.TrilobiteBabyModel;
import org.avp.client.model.entity.living.TrilobiteModel;
import org.avp.client.render.entity.living.TrilobiteBabyRenderer;
import org.avp.client.render.entity.living.TrilobiteRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPPrometheusAlienEntityTypes;

import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class AVPPrometheusAlienEntityRenderers {

    private AVPPrometheusAlienEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPPrometheusAlienEntityTypes.TRILOBITE,
                TrilobiteRenderer::new,
                List.of(
                    new EntityModelLayerData(TrilobiteModel.LAYER_LOCATION, TrilobiteModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPPrometheusAlienEntityTypes.TRILOBITE_BABY,
                TrilobiteBabyRenderer::new,
                List.of(
                    new EntityModelLayerData(TrilobiteBabyModel.LAYER_LOCATION, TrilobiteBabyModel::createBodyLayer)
                )
            )
        );
    }
}
