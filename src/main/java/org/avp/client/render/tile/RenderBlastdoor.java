package org.avp.client.render.tile;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

import org.avp.AliensVsPredator;
import org.avp.common.tile.TileEntityBlastdoor;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderBlastdoor extends TileEntitySpecialRenderer<TileEntityBlastdoor>
{
    @Override
    public void render(TileEntityBlastdoor tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (tile != null && !tile.isChild())
        {
            OpenGL.pushMatrix();
            {
                OpenGL.disable(GL_CULL_FACE);
                OpenGL.translate(x + 0.5F, y + 1.5F, z + 0.5F);
                OpenGL.scale(1.0F, -1.0F, 1.0F);
                OpenGL.rotate(tile);
                AliensVsPredator.resources().models().BLASTDOOR.draw(tile);
            }
            OpenGL.popMatrix();
        }
    }
}
