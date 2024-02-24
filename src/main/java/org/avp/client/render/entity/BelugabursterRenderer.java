package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.client.model.entity.BelugabursterModel;
import org.avp.common.entity.BelugabursterEntity;

public class BelugabursterRenderer extends LivingRenderer<BelugabursterEntity, BelugabursterModel> {
    public BelugabursterRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new BelugabursterModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(BelugabursterEntity entity)
    {
        return AVP.location("textures/entity/belugaburster.png");
    }
}
