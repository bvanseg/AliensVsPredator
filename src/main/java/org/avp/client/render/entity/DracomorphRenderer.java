package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.DracomorphModel;
import org.avp.common.entity.DracomorphEntity;

public class DracomorphRenderer extends MobRenderer<DracomorphEntity, DracomorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("dracomorph");

    public DracomorphRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new DracomorphModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(DracomorphEntity entity) {
        return TEXTURE;
    }
}
