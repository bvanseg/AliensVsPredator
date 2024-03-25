package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.*;
import org.avp.client.render.entity.living.*;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPBaseAlienEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPBaseAlienEntityRenderers {

    private AVPBaseAlienEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.CHESTBURSTER,
                ChestbursterRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.DRONE,
                DroneRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.FACEHUGGER,
                FacehuggerRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL,
                FacehuggerRoyalRenderer::new,
                List.of(
                    new EntityModelLayerData(FacehuggerRoyalModel.LAYER_LOCATION, FacehuggerRoyalModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.OVAMORPH,
                OvamorphRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.PRAETORIAN,
                PraetorianRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.QUEEN,
                QueenRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.WARRIOR,
                WarriorRenderer::new,
                List.of()
            )
        );
    }
}
