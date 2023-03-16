package org.avp.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.AVP;
import org.avp.common.tile.TileEntityLightPanel;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderLightPanel extends TileEntitySpecialRenderer<TileEntityLightPanel>
{
    @Override
    public void render(TileEntityLightPanel tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);
            OpenGL.translate(x + 0.5F, y - 0.5, z + 0.5F);
            OpenGL.rotate(0F, 0F, 1F, 0F);
            OpenGL.scale(1.0F, 1.0F, 1.0F);
            AVP.resources().models().LIGHT_PANEL.draw(tile);
        }
        OpenGL.popMatrix();
    }
}
