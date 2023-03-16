package org.avp.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntityAmpule;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class RenderAmpule extends TileEntitySpecialRenderer<TileEntityAmpule>
{
    @Override
    public void render(TileEntityAmpule tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.64F;
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5F, y + 0.955F, z + 0.5F);
            OpenGL.enable(GL12.GL_RESCALE_NORMAL);
            OpenGL.scale(scale, -scale, scale);
            OpenGL.enable(GL11.GL_ALPHA_TEST);
            OpenGL.disableCullFace();
            OpenGL.rotate(tile);
            Resources.instance.models().AMPULE.draw(tile);
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
