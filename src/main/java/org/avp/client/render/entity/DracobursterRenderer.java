package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVPResources;
import org.avp.client.model.entity.DracobursterModel;
import org.avp.common.entity.DracobursterEntity;

public class DracobursterRenderer extends MobRenderer<DracobursterEntity, DracobursterModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("dracoburster");

    public DracobursterRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new DracobursterModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(DracobursterEntity entity) {
        return TEXTURE;
    }
}
