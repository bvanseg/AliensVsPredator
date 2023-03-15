package org.alien.client.render.tile.plant;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.AVP;
import org.avp.common.tile.plant.TileEntityTreeFern;
import org.lwjgl.opengl.GL12;

public class RenderTreeFern extends TileEntitySpecialRenderer<TileEntityTreeFern>
{
    @Override
    public void render(TileEntityTreeFern tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate(x + 0.5F, y, z + 0.5F);
            OpenGL.scale(tile.getPlantSize().getScale(), tile.getPlantSize().getScale(), tile.getPlantSize().getScale());
            OpenGL.translate(tile.getOffset().x, 1.455F, tile.getOffset().z);
            OpenGL.enable(GL12.GL_RESCALE_NORMAL);
            OpenGL.rotate(180F, 1, 0, 0);
            OpenGL.rotate(tile);
            OpenGL.color(tile.getPlantColor().r(), tile.getPlantColor().g(), tile.getPlantColor().b());
            AVP.resources().models().TREE_FERN.draw(tile);
            OpenGL.color(1F, 1F, 1F);
        }
        OpenGL.popMatrix();
    }
}