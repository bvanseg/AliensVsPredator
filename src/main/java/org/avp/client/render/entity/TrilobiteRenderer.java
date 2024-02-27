package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.TrilobiteModel;
import org.avp.common.entity.TrilobiteEntity;

public class TrilobiteRenderer extends MobRenderer<TrilobiteEntity, TrilobiteModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("trilobite");

    public TrilobiteRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new TrilobiteModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(TrilobiteEntity entity) {
        return TEXTURE;
    }
}
