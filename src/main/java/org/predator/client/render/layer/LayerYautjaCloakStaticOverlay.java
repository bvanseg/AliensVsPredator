package org.predator.client.render.layer;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;
import org.predator.client.model.entity.living.ModelYautja;
import org.predator.client.render.entity.living.RenderYautja;
import org.predator.common.entity.living.SpeciesYautja;
import org.predator.common.entity.state.CloakState;

@SideOnly(Side.CLIENT)
public class LayerYautjaCloakStaticOverlay implements LayerRenderer<SpeciesYautja>
{
    private static final ResourceLocation STATIC_TEXTURE = new ResourceLocation("textures/entity/creeper/creeper_armor.png");
    private final RenderYautja yautjaRenderer;
    private final ModelYautja yautjaModel = new ModelYautja();

    public LayerYautjaCloakStaticOverlay(RenderYautja yautjaRendererIn) {
        this.yautjaRenderer = yautjaRendererIn;
    }

    @Override
    public void doRenderLayer(SpeciesYautja entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entitylivingbaseIn.cloakState.get() != CloakState.DECLOAKING_FORCED) return;
    	
    	this.yautjaRenderer.bindTexture(STATIC_TEXTURE);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        float f = (float)entitylivingbaseIn.ticksExisted + partialTicks;
        GlStateManager.translate(f * 0.1F, f * 0.1F, 0.0F);
        GlStateManager.scale(20f, 20f, 20f);
        GlStateManager.matrixMode(5888);
        GlStateManager.enableBlend();
        GlStateManager.color(0.5F, 0.5F, 0.5F, 1.0F);
        GlStateManager.disableLighting();
        GL11.glBlendFunc(GL11.GL_ONE, GL11.GL_ONE);
        this.yautjaModel.setModelAttributes(this.yautjaRenderer.getMainModel());
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.yautjaModel.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        GlStateManager.matrixMode(5890);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(5888);
        GlStateManager.enableLighting();
        OpenGL.blendClear();
        GlStateManager.disableBlend();
    }

    public boolean shouldCombineTextures() {
        return false;
    }
}