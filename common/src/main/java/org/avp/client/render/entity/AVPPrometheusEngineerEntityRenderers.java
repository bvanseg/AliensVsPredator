package org.avp.client.render.entity;

import org.avp.client.render.entity.living.EngineerRenderer;
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
                List.of()
            )
        );
    }
}
