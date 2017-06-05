package org.avp.client.render.tile;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_CULL_FACE;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;

import org.avp.tile.TileEntityAssembler;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderAssembler extends TileEntitySpecialRenderer<TileEntityAssembler>
{
    @Override
    public void renderTileEntityAt(TileEntityAssembler tile, double posX, double posY, double posZ, float renderPartialTicks, int destroy)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);
            OpenGL.enable(GL_BLEND);
            OpenGL.blendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
            OpenGL.translate(posX + 0.5F, posY + 0.95F, posZ + 0.5F);

            OpenGL.rotate(tile.getWorld().getWorldTime() % 360 * 12, 0, 1, 0);

            OpenGL.pushMatrix();
            {
                OpenGL.scale(0.025F, -0.025F, 0.025F);
                OpenGL.disableLight();
                OpenGL.color4i(0xFFFF0000);
                OpenGL.enable(GL_BLEND);
                OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE_MINUS_SRC_COLOR);
                Draw.drawItemIcon(((TileEntityAssembler) tile).getRandomItem(), -8, -32, 16, 16);
                OpenGL.disable(GL_BLEND);
                OpenGL.enableLight();
            }
            OpenGL.popMatrix();

            OpenGL.rotate(-15, 1, 0, 0);
//            GlStateManager.rotate(10, 0, 0, 1);

            OpenGL.pushMatrix();
            {
                OpenGL.scale(0.05F, 0.05F, 0.05F);
                OpenGL.disableLight();
                OpenGL.enable(GL11.GL_BLEND);
                OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_CONSTANT_COLOR);

                for (int x = 32; x > 0; x--)
                {
                    OpenGL.rotate(x * 1, 0, 1, 0);
                    OpenGL.rotate(10, 0, 0, 1);
                    Draw.drawRect(-1, 0, 2, 1 + x / 2, 0x22FF0000);
                }

                OpenGL.enableLight();
            }
            OpenGL.popMatrix();

            OpenGL.disable(GL_BLEND);
        }
        OpenGL.popMatrix();
    }
}
