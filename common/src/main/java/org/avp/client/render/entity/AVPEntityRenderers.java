package org.avp.client.render.entity;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import org.avp.client.model.entity.living.DracomorphModel;
import org.avp.client.model.entity.living.OvamorphDracoModel;
import org.avp.client.model.entity.living.OvamorphModel;
import org.avp.client.render.entity.living.DracomorphRenderer;
import org.avp.client.render.entity.living.OvamorphDracoRenderer;
import org.avp.client.render.entity.living.OvamorphRenderer;
import org.avp.client.util.EntityRenderData;
import org.avp.common.entity.AVPEntityTypes;

import java.util.ArrayList;
import java.util.List;

public class AVPEntityRenderers {

    private static final AVPEntityRenderers INSTANCE = new AVPEntityRenderers();

    private static final List<EntityRenderData<? extends Entity>> BINDINGS = new ArrayList<>();

    public static AVPEntityRenderers getInstance() {
        return INSTANCE;
    }

    public static List<EntityRenderData<? extends Entity>> getBindings() {
        return BINDINGS;
    }

    private static <T extends Mob> void addBinding(EntityRenderData<T> entityRenderData) {
        BINDINGS.add(entityRenderData);
    }

    static {
        addBinding(new EntityRenderData<>(AVPEntityTypes.DRACOMORPH, DracomorphRenderer::new, DracomorphModel.LAYER_LOCATION, DracomorphModel::createBodyLayer));
        addBinding(new EntityRenderData<>(AVPEntityTypes.OVAMORPH, OvamorphRenderer::new, OvamorphModel.LAYER_LOCATION, OvamorphModel::createBodyLayer));
        addBinding(new EntityRenderData<>(AVPEntityTypes.OVAMORPH_DRACO, OvamorphDracoRenderer::new, OvamorphDracoModel.LAYER_LOCATION, OvamorphDracoModel::createBodyLayer));
    }
}
