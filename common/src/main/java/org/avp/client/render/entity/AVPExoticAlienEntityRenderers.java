package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.DracomorphModel;
import org.avp.client.model.entity.living.OctohuggerModel;
import org.avp.client.model.entity.living.OvamorphDracoModel;
import org.avp.client.model.entity.living.UltramorphModel;
import org.avp.client.render.entity.living.DracomorphRenderer;
import org.avp.client.render.entity.living.OctohuggerRenderer;
import org.avp.client.render.entity.living.OvamorphDracoRenderer;
import org.avp.client.render.entity.living.UltramorphRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPExoticAlienEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPExoticAlienEntityRenderers {

    private AVPExoticAlienEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.DRACOMORPH,
                DracomorphRenderer::new,
                List.of(
                    new EntityModelLayerData(DracomorphModel.LAYER_LOCATION, DracomorphModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.OCTOHUGGER,
                OctohuggerRenderer::new,
                List.of(
                    new EntityModelLayerData(OctohuggerModel.LAYER_LOCATION, OctohuggerModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.OVAMORPH_DRACO,
                OvamorphDracoRenderer::new,
                List.of(
                    new EntityModelLayerData(OvamorphDracoModel.LAYER_LOCATION, OvamorphDracoModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.ULTRAMORPH,
                UltramorphRenderer::new,
                List.of(
                    new EntityModelLayerData(UltramorphModel.LAYER_LOCATION, UltramorphModel::createBodyLayer)
                )
            )
        );
    }
}
