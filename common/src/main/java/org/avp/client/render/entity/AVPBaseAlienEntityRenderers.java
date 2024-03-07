package org.avp.client.render.entity;

import org.avp.client.model.entity.living.*;
import org.avp.client.render.entity.living.*;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPBaseAlienEntityTypes;
import org.avp.common.entity.AVPEngineerEntityTypes;
import org.avp.common.entity.AVPExoticAlienEntityTypes;

import java.util.List;

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
                List.of(
                    new EntityModelLayerData(ChestbursterModel.LAYER_LOCATION, ChestbursterModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.DRONE,
                DroneRenderer::new,
                List.of(
                    new EntityModelLayerData(DroneModel.LAYER_LOCATION, DroneModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.FACEHUGGER,
                FacehuggerRenderer::new,
                List.of(
                    new EntityModelLayerData(FacehuggerModel.LAYER_LOCATION, FacehuggerModel::createBodyLayer)
                )
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
                List.of(
                    new EntityModelLayerData(OvamorphModel.LAYER_LOCATION, OvamorphModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.PRAETORIAN,
                PraetorianRenderer::new,
                List.of(
                    new EntityModelLayerData(PraetorianModel.LAYER_LOCATION, PraetorianModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.QUEEN,
                QueenRenderer::new,
                List.of(
                    new EntityModelLayerData(QueenModel.LAYER_LOCATION, QueenModel::createBodyLayer)
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.WARRIOR,
                WarriorRenderer::new,
                List.of(
                    new EntityModelLayerData(WarriorModel.LAYER_LOCATION, WarriorModel::createBodyLayer)
                )
            )
        );
    }
}
