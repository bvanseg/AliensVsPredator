package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.EngineerModel;
import org.avp.common.entity.EngineerEntity;

public class EngineerRenderer extends MobRenderer<EngineerEntity, EngineerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("engineer");

    public EngineerRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new EngineerModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(EngineerEntity entity) {
        return TEXTURE;
    }
}
