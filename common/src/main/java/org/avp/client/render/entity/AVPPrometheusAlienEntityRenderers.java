package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.DeaconAdultModel;
import org.avp.client.model.entity.living.DeaconModel;
import org.avp.client.model.entity.living.TrilobiteBabyModel;
import org.avp.client.model.entity.living.TrilobiteModel;
import org.avp.client.render.entity.living.DeaconAdultRenderer;
import org.avp.client.render.entity.living.DeaconRenderer;
import org.avp.client.render.entity.living.TrilobiteBabyRenderer;
import org.avp.client.render.entity.living.TrilobiteRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPPrometheusAlienEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPPrometheusAlienEntityRenderers {

    private AVPPrometheusAlienEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPPrometheusAlienEntityTypes.DEACON,
                DeaconRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPPrometheusAlienEntityTypes.DEACON_ADULT,
                DeaconAdultRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPPrometheusAlienEntityTypes.TRILOBITE,
                TrilobiteRenderer::new,
                List.of()
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
