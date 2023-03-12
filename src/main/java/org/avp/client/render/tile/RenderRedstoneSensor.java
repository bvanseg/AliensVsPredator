package org.avp.client.render.tile;

import org.avp.common.tile.TileEntityRedstoneSensor;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderRedstoneSensor extends TileEntitySpecialRenderer<TileEntityRedstoneSensor>
{
    @Override
    public void render(TileEntityRedstoneSensor tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            GlStateManager.disableCull();
            OpenGL.translate(x, y, z);
            Draw.drawRect(0, 0, 1, 1, 0xFFFF0000);
            OpenGL.translate(0, 0, 1);
            Draw.drawRect(0, 0, 1, 1, 0xFFFF0000);
            OpenGL.rotate(90, 1, 0, 0);
            Draw.drawRect(0, 0, 1, -1, 0xFFFF0000);
            OpenGL.translate(0, 0, -1);
            Draw.drawRect(0, 0, 1, -1, 0xFFFF0000);
            OpenGL.rotate(90, 0, 1, 0);
            Draw.drawRect(0, 0, -1, -1, 0xFFFF0000);
            OpenGL.translate(0, 0, 1);
            Draw.drawRect(0, 0, -1, -1, 0xFFFF0000);
        }
        OpenGL.popMatrix();
    }
}
