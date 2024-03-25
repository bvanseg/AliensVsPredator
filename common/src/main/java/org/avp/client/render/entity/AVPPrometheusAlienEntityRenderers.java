package org.avp.client.render.entity;

import org.avp.client.render.entity.living.DeaconAdultRenderer;
import org.avp.client.render.entity.living.DeaconRenderer;
import org.avp.client.render.entity.living.TrilobiteBabyRenderer;
import org.avp.client.render.entity.living.TrilobiteRenderer;
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
                List.of()
            )
        );
    }
}
