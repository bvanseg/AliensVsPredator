package org.avp.client.render.entity;

import org.avp.client.render.entity.living.BelugabursterRenderer;
import org.avp.client.render.entity.living.BelugamorphRenderer;
import org.avp.common.entity.AVPEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityRenderers {

    private AVPEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(AVPEntityTypes.BELUGABURSTER, BelugabursterRenderer::new);
        AVPEntityRenderRegistry.addBinding(AVPEntityTypes.BELUGAMORPH, BelugamorphRenderer::new);
    }
}
