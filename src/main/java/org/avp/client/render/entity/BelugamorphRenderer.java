package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.BelugamorphModel;
import org.avp.common.entity.BelugamorphEntity;

public class BelugamorphRenderer extends MobRenderer<BelugamorphEntity, BelugamorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("belugamorph");

    public BelugamorphRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new BelugamorphModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(BelugamorphEntity entity) {
        return TEXTURE;
    }
}
