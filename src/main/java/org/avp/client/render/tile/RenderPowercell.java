package org.avp.client.render.tile;

import org.avp.AVP;
import org.avp.common.tile.TileEntityPowercell;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderPowercell extends TileEntitySpecialRenderer<TileEntityPowercell>
{
    @Override
    public void render(TileEntityPowercell tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5, y - 0.5, z + 0.5);
            AVP.resources().models().POWERCELL.draw(tile);
            OpenGL.disableLight();
            AVP.resources().models().POWERCELL_LIQUID.draw(tile);
            OpenGL.enableLight();
        }
        OpenGL.popMatrix();
    }
}
