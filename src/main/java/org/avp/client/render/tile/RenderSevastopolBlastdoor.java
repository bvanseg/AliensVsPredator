package org.avp.client.render.tile;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityBlastdoor;

import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderSevastopolBlastdoor extends TileEntitySpecialRenderer<TileEntityBlastdoor>
{
    @Override
    public void renderTileEntityAt(TileEntityBlastdoor tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        if (tile != null && !tile.isChild())
        {
            OpenGL.pushMatrix();
            {
                OpenGL.disable(GL_CULL_FACE);
                OpenGL.translate(x + 0.5F, y + 1.5F, z + 0.5F);
                OpenGL.scale(1.0F, -1.0F, 1.0F);
                OpenGL.rotate(tile);
                AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL.draw(tile);

                if (tile.isOperational())
                {
                    OpenGL.disableLight();
                    AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL_ENABLED.draw(tile);

                    if (!tile.isLocked())
                    {
                        AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL_UNLOCKED.draw(tile);
                    }
                    else
                    {
                        AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL_LOCKED.draw(tile);
                    }
                    OpenGL.enableLight();
                }
                else
                {
                    AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL_DISABLED.draw(tile);
                }
            }
            OpenGL.popMatrix();
        }
    }
}
