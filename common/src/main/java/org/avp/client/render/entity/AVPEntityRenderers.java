package org.avp.client.render.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

import java.util.ArrayList;
import java.util.List;

import org.avp.client.model.entity.living.*;
import org.avp.client.render.entity.living.*;
import org.avp.client.util.EntityModelLayerData;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPBaseAlienEntityTypes;
import org.avp.common.entity.AVPEngineerEntityTypes;
import org.avp.common.entity.AVPExoticAlienEntityTypes;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityRenderers {

    private static final AVPEntityRenderers INSTANCE = new AVPEntityRenderers();

    private static final List<EntityRenderData<? extends Entity>> BINDINGS = new ArrayList<>();

    public static AVPEntityRenderers getInstance() {
        return INSTANCE;
    }

    public static List<EntityRenderData<? extends Entity>> getBindings() {
        return BINDINGS;
    }

    private AVPEntityRenderers() {}

    private static <T extends Mob> void addBinding(EntityRenderData<T> entityRenderData) {
        BINDINGS.add(entityRenderData);
    }

    static {
        addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.DRACOMORPH,
                DracomorphRenderer::new,
                List.of(
                    new EntityModelLayerData(DracomorphModel.LAYER_LOCATION, DracomorphModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.DRONE,
                DroneRenderer::new,
                List.of(
                    new EntityModelLayerData(DroneModel.LAYER_LOCATION, DroneModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPEngineerEntityTypes.ENGINEER,
                EngineerRenderer::new,
                List.of(
                    new EntityModelLayerData(EngineerModel.LAYER_LOCATION, EngineerModel::createBodyLayer),
                    new EntityModelLayerData(EngineerModel.ARMOR_LAYER_LOCATION, EngineerModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.FACEHUGGER,
                FacehuggerRenderer::new,
                List.of(
                    new EntityModelLayerData(FacehuggerModel.LAYER_LOCATION, FacehuggerModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.FACEHUGGER_ROYAL,
                FacehuggerRoyalRenderer::new,
                List.of(
                    new EntityModelLayerData(FacehuggerRoyalModel.LAYER_LOCATION, FacehuggerRoyalModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.OVAMORPH,
                OvamorphRenderer::new,
                List.of(
                    new EntityModelLayerData(OvamorphModel.LAYER_LOCATION, OvamorphModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPExoticAlienEntityTypes.OVAMORPH_DRACO,
                OvamorphDracoRenderer::new,
                List.of(
                    new EntityModelLayerData(OvamorphDracoModel.LAYER_LOCATION, OvamorphDracoModel::createBodyLayer)
                )
            )
        );
        addBinding(
            new EntityRenderData<>(
                AVPBaseAlienEntityTypes.PRAETORIAN,
                PraetorianRenderer::new,
                List.of(
                    new EntityModelLayerData(PraetorianModel.LAYER_LOCATION, PraetorianModel::createBodyLayer)
                )
            )
        );
        addBinding(
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
