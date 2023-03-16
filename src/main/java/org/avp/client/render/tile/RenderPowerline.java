package org.avp.client.render.tile;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.Draw;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.tileentity.TileEntity;
import org.avp.AVP;
import org.avp.common.tile.TileEntityPowerline;

import static org.lwjgl.opengl.GL11.GL_CULL_FACE;

public class RenderPowerline extends TileEntitySpecialRenderer<TileEntityPowerline>
{
    @Override
    public void render(TileEntityPowerline tile, double posX, double posY, double posZ, float renderPartialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.disable(GL_CULL_FACE);

            OpenGL.pushMatrix();
            {
                OpenGL.translate(posX + 0.5F, posY + 0.5F, posZ + 0.5F);
                OpenGL.scale(1.0F, -1.0F, 1.0F);
                AVP.resources().models().CABLE.draw(tile);
            }
            OpenGL.popMatrix();

            OpenGL.translate(posX + 0.5F, posY + 1.5F, posZ + 0.5F);

            if (ClientGame.instance.minecraft().objectMouseOver != null && ClientGame.instance.minecraft().objectMouseOver.getBlockPos() != null)
            {
                TileEntity tileOver = ClientGame.instance.minecraft().player.world.getTileEntity(ClientGame.instance.minecraft().objectMouseOver.getBlockPos());

                if (tileOver != null && tileOver == tile)
                {
                    float scale = 0.02F;
                    OpenGL.scale(scale, scale, scale);
                    OpenGL.disableLight();

                    OpenGL.pushMatrix();
                    {
                        OpenGL.rotate(ClientGame.instance.minecraft().player.rotationYaw + 180, 0F, -1F, 0F);

                        OpenGL.pushMatrix();
                        {
                            OpenGL.rotate(ClientGame.instance.minecraft().player.rotationPitch + 180, -1F, 0F, 0F);
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
