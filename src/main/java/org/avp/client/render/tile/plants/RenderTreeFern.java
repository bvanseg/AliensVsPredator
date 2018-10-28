package org.avp.client.render.tile.plants;

import org.avp.AliensVsPredator;
import org.avp.tile.plants.TileEntityTreeFern;
import org.lwjgl.opengl.GL12;

import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

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
            AliensVsPredator.resources().models().TREE_FERN.draw(tile);
            OpenGL.color(1F, 1F, 1F);
        }
        OpenGL.popMatrix();
    }
}
