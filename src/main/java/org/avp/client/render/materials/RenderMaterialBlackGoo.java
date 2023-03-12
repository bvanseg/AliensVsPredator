package org.avp.client.render.materials;

import org.avp.AVP;
import org.avp.common.api.blocks.material.IMaterialRenderer;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Screen;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;


public class RenderMaterialBlackGoo implements IMaterialRenderer
{
    @Override
    public void renderMaterialOverlay(Material material)
    {
        OpenGL.pushMatrix();
        OpenGL.enableBlend();
        OpenGL.disableDepthTest();
        OpenGL.depthMask(false);
        OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.color(1F, 1F, 1F, 0.1F);
        OpenGL.disableAlphaTest();
        Draw.bindTexture(AVP.resources().BLACKGOO);
        Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight());
        OpenGL.depthMask(true);
        OpenGL.enableDepthTest();
        OpenGL.enableAlphaTest();
        OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
        OpenGL.disableBlend();
        OpenGL.popMatrix();
    }

    @Override
    public Vec3d getFogColor()
    {
        return new Vec3d(0.0, 0.0, 0.0);
    }

    @Override
    public void renderFog(Material material)
    {
        GlStateManager.setFog(GlStateManager.FogMode.EXP2);
        GlStateManager.setFogDensity(1.5F);
    }
}
