package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVPResources;
import org.avp.client.model.entity.BelugabursterModel;
import org.avp.common.entity.BelugabursterEntity;

public class BelugabursterRenderer extends MobRenderer<BelugabursterEntity, BelugabursterModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("belugaburster");

    public BelugabursterRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new BelugabursterModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(BelugabursterEntity entity) {
        return TEXTURE;
    }
}
