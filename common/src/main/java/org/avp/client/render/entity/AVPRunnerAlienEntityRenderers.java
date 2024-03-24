package org.avp.client.render.entity;

import java.util.List;

import org.avp.client.model.entity.living.ChestbursterRunnerModel;
import org.avp.client.model.entity.living.CrusherModel;
import org.avp.client.model.entity.living.DroneRunnerModel;
import org.avp.client.model.entity.living.WarriorRunnerModel;
import org.avp.client.render.entity.living.ChestbursterRunnerRenderer;
import org.avp.client.render.entity.living.CrusherRenderer;
import org.avp.client.render.entity.living.DroneRunnerRenderer;
import org.avp.client.render.entity.living.WarriorRunnerRenderer;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPRunnerAlienEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPRunnerAlienEntityRenderers {

    private AVPRunnerAlienEntityRenderers() {}

    public static void addBindings() {
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPRunnerAlienEntityTypes.CHESTBURSTER_RUNNER,
                ChestbursterRunnerRenderer::new,
                List.of(
                    new EntityModelLayerData(
                        ChestbursterRunnerModel.LAYER_LOCATION,
                        ChestbursterRunnerModel::createBodyLayer
                    )
                )
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPRunnerAlienEntityTypes.CRUSHER,
                CrusherRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPRunnerAlienEntityTypes.DRONE_RUNNER,
                DroneRunnerRenderer::new,
                List.of()
            )
        );
        AVPEntityRenderRegistry.addBinding(
            new EntityRenderData<>(
                AVPRunnerAlienEntityTypes.WARRIOR_RUNNER,
                WarriorRunnerRenderer::new,
                List.of()
            )
        );
    }
}
