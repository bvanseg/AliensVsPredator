package org.avp.client.render.entity;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.OvamorphDracoModel;
import org.avp.common.entity.OvamorphDracoEntity;

public class OvamorphDracoRenderer extends MobRenderer<OvamorphDracoEntity, OvamorphDracoModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("ovamorph_draco");

    public OvamorphDracoRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new OvamorphDracoModel(), 0F);
    }

    @Override
    protected void preRenderCallback(OvamorphDracoEntity ovamorphDracoEntity, float partialTicks) {
        super.preRenderCallback(ovamorphDracoEntity, partialTicks);
        GlStateManager.scalef(1.75f, 1.75f, 1.75f);
    }

    @Override
    protected ResourceLocation getEntityTexture(OvamorphDracoEntity entity) {
        return TEXTURE;
    }
}
