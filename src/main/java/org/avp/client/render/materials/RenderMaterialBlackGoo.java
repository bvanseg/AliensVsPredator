package org.avp.client.render.materials;

import org.avp.AliensVsPredator;
import org.avp.api.blocks.material.IMaterialRenderer;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.Screen;

import net.minecraft.block.material.Material;
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
        Draw.bindTexture(AliensVsPredator.resources().BLACKGOO);
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
        GL11.glFogi(GL11.GL_FOG_MODE, GL11.GL_EXP);
        GL11.glFogf(GL11.GL_FOG_DENSITY, 1.5F);
    }
}
