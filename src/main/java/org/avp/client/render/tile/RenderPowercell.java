package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityPowercell;

import com.arisux.mdx.lib.client.render.OpenGL;

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
            AliensVsPredator.resources().models().POWERCELL.draw(tile);
            OpenGL.disableLight();
            AliensVsPredator.resources().models().POWERCELL_LIQUID.draw(tile);
            OpenGL.enableLight();
        }
        OpenGL.popMatrix();
    }
}
