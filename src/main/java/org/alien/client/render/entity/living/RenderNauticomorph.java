package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import org.alien.client.model.entity.living.ModelNauticomorph;
import org.alien.common.entity.living.xenomorphs.EntityNauticomorph;
import org.avp.AVP;

public class RenderNauticomorph<N extends EntityNauticomorph> extends RenderLivingWrapper<N, ModelNauticomorph>
{
    public static class LayerPhosphorescent<T extends EntityNauticomorph> implements LayerRenderer<T>
    {
        private final RenderNauticomorph<T> renderer;
        private final MapModelTexture<?>    model;

        public LayerPhosphorescent(RenderNauticomorph<T> renderer, MapModelTexture<?> model)
        {
            this.renderer = renderer;
            this.model = model;
        }

        public void doRenderLayer(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
        {
            float phosphorescenceLevel = entitylivingbaseIn.getPhosphorescenceLevel();
            boolean glowing = phosphorescenceLevel > 0.05F;

            if (glowing)
            {
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

        public boolean shouldCombineTextures()
        {
            return false;
        }
    }

    public RenderNauticomorph(RenderManager m)
    {
        super(m, AVP.resources().models().NAUTICOMORPH_XENOMORPH);
        this.addLayer(new LayerPhosphorescent<N>(this, AVP.resources().models().NAUTICOMORPH_XENOMORPH_MASK));
    }

    @Override
    protected void preRenderCallback(EntityNauticomorph entityliving, float partialTicks)
    {
        OpenGL.scale(0.8F, 0.8F, 0.8F);
    }

    // protected int setRenderPassModelBrightness(EntityAqua entity, int brightness)
    // {
    //// if (brightness != 0)
    //// {
    //// return -1;
    //// }
    //// else
    //// {
    // AliensVsPredator.resources().models().NAUTICOMORPH_XENOMORPH_MASK.getTexture().bind();
    // float f1;
    //
    // boolean isDay = (entity.world.getWorldTime() % 24000L) / 1000L < 14L;
    //
    // if (!isDay)
    // {
    // f1 = 1.0F;
    // }
    // else
    // {
    // f1 = 0.0F;
    // }
    //
    // f1 = 1.0F;
    //
    // OpenGL.enable(GL11.GL_BLEND);
    // OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
    // OpenGL.disableLight();
    //
    //// if (entity.isInvisible())
    //// {
    //// GL11.glDepthMask(false);
    //// }
    //// else
    //// {
    //// GL11.glDepthMask(true);
    //// }
    //
    // char c0 = 61680;
    // int j = c0 % 65536;
    // int k = c0 / 65536;
    // OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
    // OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
    // OpenGL.color(1.0F, 1.0F, 1.0F, f1);
    //
    // return 1;
    //// }
    // }
}
