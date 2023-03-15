package org.avp.client.render.tile;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import org.avp.AVP;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntityTeslaCoil;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderTeslaCoil extends TileEntitySpecialRenderer<TileEntityTeslaCoil>
{
    @Override
    public void render(TileEntityTeslaCoil teslaCoil, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.pushMatrix();
        OpenGL.disable(GL_CULL_FACE);
        GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.5F);
        OpenGL.rotate(90F, 0F, 1F, 0F);
        OpenGL.rotate(teslaCoil);
        
        if (teslaCoil.getRotationXAxis() == EnumFacing.NORTH)
        {
            GlStateManager.rotate(90, 0, 0, 1);
        }
        
        OpenGL.translate(0, -1F, 0);
        Resources.instance.models().TESLA_COIL.draw(teslaCoil);
        GlStateManager.popMatrix();
    }
}
