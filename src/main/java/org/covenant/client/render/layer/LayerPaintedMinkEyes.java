package org.covenant.client.render.layer;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import org.covenant.client.render.entity.living.RenderPaintedMink;
import org.covenant.client.CovenantResources;
import org.covenant.common.entity.living.EntityPaintedMink;

/**
 * @author Boston Vanseghi
 */
public class LayerPaintedMinkEyes implements LayerRenderer<EntityPaintedMink> {
    private final RenderPaintedMink renderer;

    public LayerPaintedMinkEyes(RenderPaintedMink renderer) {
        this.renderer = renderer;
    }

    @Override
    public void doRenderLayer(EntityPaintedMink entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        CovenantResources.Models.PAINTED_MINK_EYES.bindTexture();
        GlStateManager.enableBlend();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entity.isInvisible());
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.renderer.getMainModel().render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        this.renderer.setLightmap(entity);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}