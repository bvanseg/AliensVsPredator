package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.TrilobiteBabyModel;
import org.avp.common.entity.TrilobiteBabyEntity;

public class TrilobiteBabyRenderer extends MobRenderer<TrilobiteBabyEntity, TrilobiteBabyModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("trilobite_baby");

    public TrilobiteBabyRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new TrilobiteBabyModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(TrilobiteBabyEntity entity) {
        return TEXTURE;
    }
}
