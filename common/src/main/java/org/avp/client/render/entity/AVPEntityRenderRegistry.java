package org.avp.client.render.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;

import java.util.ArrayList;
import java.util.List;

import org.avp.client.util.EntityRenderData;

/**
 * @author Boston Vanseghi
 */
public class AVPEntityRenderRegistry {

    private static final List<EntityRenderData<? extends Entity>> BINDINGS = new ArrayList<>();

    public static List<EntityRenderData<? extends Entity>> getBindings() {
        return BINDINGS;
    }

    protected static <T extends Mob> void addBinding(EntityRenderData<T> entityRenderData) {
        BINDINGS.add(entityRenderData);
    }

    static {
        AVPBaseAlienEntityRenderers.addBindings();
        AVPEntityRenderers.addBindings();
        AVPExoticAlienEntityRenderers.addBindings();
        AVPPrometheusAlienEntityRenderers.addBindings();
        AVPPrometheusEngineerEntityRenderers.addBindings();
    }

    private AVPEntityRenderRegistry() {
        throw new UnsupportedOperationException();
    }
}
