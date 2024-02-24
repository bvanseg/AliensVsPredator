package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.client.model.entity.OvamorphModel;
import org.avp.common.entity.OvamorphEntity;

public class OvamorphRenderer extends LivingRenderer<OvamorphEntity, OvamorphModel> {
    public OvamorphRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new OvamorphModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(OvamorphEntity entity)
    {
        return AVP.location("textures/entity/ovamorph.png");
    }
}
