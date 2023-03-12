package org.avp.client.render.tile;

import org.avp.AVP;
import org.avp.common.tile.TileEntityRedstoneFluxGenerator;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderRedstoneFluxGenerator extends TileEntitySpecialRenderer<TileEntityRedstoneFluxGenerator>
{
    @Override
    public void render(TileEntityRedstoneFluxGenerator tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        OpenGL.disableCullFace();
        OpenGL.translate(x, y, z);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0.5F, -1.5F, 0.5F);
        OpenGL.rotate(tile);
        AVP.resources().models().RFGENERATOR.draw();
        OpenGL.enableCullFace();
        OpenGL.popMatrix();
    }
}
