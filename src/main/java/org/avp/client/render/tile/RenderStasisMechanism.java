package org.avp.client.render.tile;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.AVP;
import org.avp.common.tile.TileEntityStasisMechanism;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderStasisMechanism extends TileEntitySpecialRenderer<TileEntityStasisMechanism>
{
    @Override
    public void render(TileEntityStasisMechanism te, double posX, double posY, double posZ, float renderPartialTicks, int destroyStage, float alpha)
    {
        TileEntityStasisMechanism tile = (TileEntityStasisMechanism) te;

        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);
            OpenGL.translate(posX + 0.5F, posY, posZ + 0.5F);
            OpenGL.rotate(tile.getDirection() * (-90F), 0F, 1F, 0F);
            OpenGL.scale(1.0F, -1.0F, 1.0F);

            AVP.resources().models().STASIS_MECHANISM.draw(tile);

            if (Game.minecraft().gameSettings.fancyGraphics)
            {
                OpenGL.disableLight();
                AVP.resources().models().STASIS_MECHANISM_MASK.draw(tile);
                OpenGL.enableLight();
            }
        }
        OpenGL.popMatrix();
    }
}
