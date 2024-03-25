package org.avp.client.render.entity;

import org.avp.client.render.entity.living.BelugabursterRenderer;
import org.avp.client.render.entity.living.BelugamorphRenderer;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPEntityTypes;

import java.util.List;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityRenderers {

    private AVPEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPEntityTypes.BELUGABURSTER,
                BelugabursterRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPEntityTypes.BELUGAMORPH,
                BelugamorphRenderer::new,
                List.of()
            )
        );
    }
}
