package org.avp.client.render.tile;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.util.EnumFacing;
import org.avp.AVP;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntityCCFLTube;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderCCFLTube extends TileEntitySpecialRenderer<TileEntityCCFLTube>
{
    @Override
    public void render(TileEntityCCFLTube ccfl, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        GlStateManager.pushMatrix();
        OpenGL.disable(GL_CULL_FACE);
        GlStateManager.translate(x + 0.5F, y + 0.5F, z + 0.5F);
        OpenGL.rotate(90F, 0F, 1F, 0F);
        OpenGL.rotate(ccfl);
        
        if (ccfl.getRotationXAxis() == EnumFacing.NORTH)
        {
            GlStateManager.translate(0F, -0.5F, 0F);
        }
        
        OpenGL.translate(0, -0.1F, 0);
        Resources.instance.models().CCFL_BALLAST.draw(ccfl);

        if (ccfl.isOperational())
        {
            OpenGL.disableLight();
            Resources.instance.models().CCFL_TUBE_ON.draw(ccfl);
            OpenGL.enableLight();
        }
        else
        {
            Resources.instance.models().CCFL_TUBE_OFF.draw(ccfl);
        }
        GlStateManager.popMatrix();
    }
}
