package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.power.common.tile.TileEntityRedstoneFluxGenerator;

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
        Resources.instance.models().RFGENERATOR.draw();
        OpenGL.enableCullFace();
        OpenGL.popMatrix();
    }
}
