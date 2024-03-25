package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.*;
import org.avp.client.render.entity.living.*;
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
                AVPExoticAlienEntityTypes.DEACON_ADULT_ENGINEER,
                DeaconAdultEngineerRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.DRACOBURSTER,
                DracobursterRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.DRACOMORPH,
                DracomorphRenderer::new,
                List.of()
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
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.ULTRAMORPH,
                UltramorphRenderer::new,
                List.of()
            )
        );
    }
}
