package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.BelugabursterModel;
import org.avp.client.model.entity.living.BelugamorphModel;
import org.avp.client.render.entity.living.BelugabursterRenderer;
import org.avp.client.render.entity.living.BelugamorphRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPEntityTypes;

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
                List.of(
                    new EntityModelLayerData(BelugabursterModel.LAYER_LOCATION, BelugabursterModel::createBodyLayer)
                )
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
