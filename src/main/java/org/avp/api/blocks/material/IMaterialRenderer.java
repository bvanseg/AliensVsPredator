package org.avp.api.blocks.material;

import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

import org.avp.AliensVsPredator;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Screen;

import net.minecraft.block.material.Material;
import net.minecraft.util.math.Vec3d;


public interface IMaterialRenderer
{
    public default void renderMaterialOverlay(Material material)
    {
        OpenGL.pushMatrix();
        OpenGL.enableBlend();
        OpenGL.disableDepthTest();
        OpenGL.depthMask(false);
        OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
        OpenGL.color3i(material.getMaterialMapColor().colorValue);
        OpenGL.disableAlphaTest();
        Draw.bindTexture(AliensVsPredator.resources().RES_UNDERWATER_OVERLAY);
        Draw.drawQuad(0, 0, Screen.scaledDisplayResolution().getScaledWidth(), Screen.scaledDisplayResolution().getScaledHeight());
        OpenGL.depthMask(true);
        OpenGL.enableDepthTest();
        OpenGL.enableAlphaTest();
        OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
        OpenGL.disableBlend();
        OpenGL.popMatrix();
    }
    
    public default Vec3d getFogColor()
    {
        return new Vec3d(1.0, 1.0, 1.0);
    }
    
    public default void renderFog(Material material)
    {
        GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
        GL11.glFogf(GL11.GL_FOG_DENSITY, 0.25F);
    }
}
