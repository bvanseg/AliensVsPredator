package org.alien.client.render.layer;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import org.alien.client.render.entity.living.RenderNauticomorph;
import org.alien.common.entity.living.xenomorph.exotic.EntityNauticomorph;

/**
 * @author Ri5ux
 */
public class LayerPhosphorescent implements LayerRenderer<EntityNauticomorph> {
    private final RenderNauticomorph renderer;
    private final MapModelTexture<?> model;

    public LayerPhosphorescent(RenderNauticomorph renderer, MapModelTexture<?> model) {
        this.renderer = renderer;
        this.model = model;
    }

    public void doRenderLayer(EntityNauticomorph entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        float phosphorescenceLevel = entitylivingbaseIn.phosphorescenceLevel.get();
        boolean glowing = phosphorescenceLevel > 0.05F;

        if (glowing) {
            this.renderer.bindTexture(model.getTexture());
            GlStateManager.enableBlend();
            GlStateManager.enableAlpha();
            GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE_MINUS_CONSTANT_ALPHA);

            OpenGL.disableLight();
            int brightness = 61680;
            int j = brightness % 65536;
            int k = brightness / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);

            float r = 0.5F * phosphorescenceLevel;
            float g = 0.7F * phosphorescenceLevel;
            float b = 1.0F * phosphorescenceLevel;
            float a = 1.0F;

            GlStateManager.color(r, g, b, a);
            Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
            this.renderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
            Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
            brightness = entitylivingbaseIn.getBrightnessForRender();
            j = brightness % 65536;
            k = brightness / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (float) j, (float) k);
            this.renderer.setLightmap(entitylivingbaseIn);
            GlStateManager.disableBlend();
            GlStateManager.enableAlpha();
            OpenGL.enableLight();
        }
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}