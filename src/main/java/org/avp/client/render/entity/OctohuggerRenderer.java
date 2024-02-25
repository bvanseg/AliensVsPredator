package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;
import org.avp.AVPResources;
import org.avp.client.model.entity.OctohuggerModel;
import org.avp.common.entity.OctohuggerEntity;

public class OctohuggerRenderer extends MobRenderer<OctohuggerEntity, OctohuggerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("octohugger");

    public OctohuggerRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new OctohuggerModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(OctohuggerEntity entity) {
        return TEXTURE;
    }
}
