package org.avp.client.render.tile;

import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.AVP;
import org.avp.common.tile.TileEntityBlastdoor;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderSevastopolBlastdoor extends TileEntitySpecialRenderer<TileEntityBlastdoor>
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
                AVP.resources().models().BLASTDOOR_SEVASTOPOL.draw(tile);

                if (tile.isOperational())
                {
                    OpenGL.disableLight();
                    AVP.resources().models().BLASTDOOR_SEVASTOPOL_ENABLED.draw(tile);

                    if (!tile.isLocked())
                    {
                        AVP.resources().models().BLASTDOOR_SEVASTOPOL_UNLOCKED.draw(tile);
                    }
                    else
                    {
                        AVP.resources().models().BLASTDOOR_SEVASTOPOL_LOCKED.draw(tile);
                    }
                    OpenGL.enableLight();
                }
                else
                {
                    AVP.resources().models().BLASTDOOR_SEVASTOPOL_DISABLED.draw(tile);
                }
            }
            OpenGL.popMatrix();
        }
    }
}
