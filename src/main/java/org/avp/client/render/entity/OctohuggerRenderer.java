package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.LivingRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.client.model.entity.OctohuggerModel;
import org.avp.common.entity.OctohuggerEntity;

public class OctohuggerRenderer extends LivingRenderer<OctohuggerEntity, OctohuggerModel> {
    public OctohuggerRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new OctohuggerModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(OctohuggerEntity entity)
    {
        return AVP.location("textures/entity/octohugger.png");
    }
}
