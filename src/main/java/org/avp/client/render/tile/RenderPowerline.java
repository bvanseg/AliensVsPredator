package org.avp.client.render.tile;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityPowerline;

import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;

public class RenderPowerline extends TileEntitySpecialRenderer<TileEntityPowerline>
{
    @Override
    public void renderTileEntityAt(TileEntityPowerline tile, double posX, double posY, double posZ, float renderPartialTicks, int destroyStage)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);

            OpenGL.pushMatrix();
            {
                OpenGL.translate(posX + 0.5F, posY + 0.5F, posZ + 0.5F);
                OpenGL.scale(1.0F, -1.0F, 1.0F);
                AliensVsPredator.resources().models().CABLE.draw(tile);
            }
            OpenGL.popMatrix();

            OpenGL.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);

            if (Game.minecraft().objectMouseOver != null && Game.minecraft().objectMouseOver.getBlockPos() != null)
            {
                TileEntity tileOver = Game.minecraft().thePlayer.worldObj.getTileEntity(Game.minecraft().objectMouseOver.getBlockPos());

                if (tileOver != null && tileOver == tile)
                {
                    float scale = 0.02F;
                    OpenGL.scale(scale, scale, scale);
                    OpenGL.disableLight();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(Game.minecraft().thePlayer.rotationYaw + 180, 0F, -1F, 0F);

                        OpenGL.pushMatrix();
                        {
                            OpenGL.rotate(Game.minecraft().thePlayer.rotationPitch + 180, -1F, 0F, 0F);
                            Draw.drawString(((float) tile.getVoltage()) + "V", -20, 30, tile.getVoltage() <= 0 ? 0xFFFF0000 : 0xFF00FF00);
                            scale = 0.5F;
                            OpenGL.scale(scale, scale, scale);
                            Draw.drawString((tile + "").replace(tile.getClass().getName(), ""), -20, 80, 0xFF00AAFF);
                        }
                        OpenGL.popMatrix();
                    }
                    OpenGL.popMatrix();

                    OpenGL.enableLight();
                }
            }
        }
        OpenGL.popMatrix();
    }
}
