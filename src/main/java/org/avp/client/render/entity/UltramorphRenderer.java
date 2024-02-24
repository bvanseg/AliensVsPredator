package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.client.model.entity.UltramorphModel;
import org.avp.common.entity.UltramorphEntity;

public class UltramorphRenderer extends LivingRenderer<UltramorphEntity, UltramorphModel> {
    public UltramorphRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new UltramorphModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(UltramorphEntity entity)
    {
        return AVP.location("textures/entity/ultramorph.png");
    }
}
