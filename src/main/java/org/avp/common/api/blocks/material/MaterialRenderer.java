package org.avp.common.api.blocks.material;

import com.asx.mdx.client.Screen;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.math.Vec3d;
import org.avp.client.Resources;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;


public interface MaterialRenderer
{
    default void renderMaterialOverlay(Material material)
    {
        OpenGL.pushMatrix();
        OpenGL.enableBlend();
        OpenGL.disableDepthTest();
        OpenGL.depthMask(false);
        OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.color3i(material.getMaterialMapColor().colorValue);
        OpenGL.disableAlphaTest();
        Draw.bindTexture(Resources.instance.RES_UNDERWATER_OVERLAY);
        Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight());
        OpenGL.depthMask(true);
        OpenGL.enableDepthTest();
        OpenGL.enableAlphaTest();
        OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
        OpenGL.disableBlend();
        OpenGL.popMatrix();
    }
    
    default Vec3d getFogColor()
    {
        return new Vec3d(1.0, 1.0, 1.0);
    }
    
    default void renderFog(Material material)
    {
        GlStateManager.setFog(GlStateManager.FogMode.EXP);
        GlStateManager.setFogDensity(0.25F);
    }
}
