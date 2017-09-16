package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntityTurret;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.Draw;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderTurret extends TileEntitySpecialRenderer<TileEntityTurret>
{
    @Override
    public void renderTileEntityAt(TileEntityTurret tile, double x, double y, double z, float partialTicks, int destroyStage)
    {
        OpenGL.pushMatrix();
        {
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5F, y + 1.5F, z + 0.25F);
//            OpenGL.rotate(tile.getDirection() * (-90F), 0F, 1F, 0F);

            OpenGL.scale(1F, -1F, 1F);
            AliensVsPredator.resources().models().TURRET.draw(tile);

            if (tile.getVoltage() > 0)
            {
//                OpenGL.rotate(tile.getDirection() * 90F, 0F, 1F, 0F);
                this.renderAmmoDisplay(tile);

                if (!tile.isFiring())
                {
                    this.renderBeam(0, 0, tile.getRange(), -1, 0, 50, tile.beamColor, 0x00000000, tile.getRotationYaw(), tile.getRotationPitch(), -1);
                }
            }
        }
        OpenGL.popMatrix();
    }

    public void renderAmmoDisplay(TileEntityTurret tile)
    {
        if (tile.isAmmoDisplayEnabled())
        {
            int ammo = (tile.getCurRounds() * tile.getMaxAmmo()) + tile.getCurAmmo();
            String displayText = ammo >= 0 ? ammo < 10 ? "000" + ammo : ammo < 100 ? "00" + ammo : ammo < 1000 ? "0" + ammo : "" + ammo : "----";

            OpenGL.pushMatrix();
            {
                // Reposition to the turret head's rotation point
                OpenGL.disableLight();
                OpenGL.disable(GL11.GL_LIGHTING);
                float displayScale = 0.005F;
                OpenGL.scale(displayScale, displayScale, displayScale);
                OpenGL.translate(0F, 137.5F, 0F);

                // Rotate & Reposition Display
                OpenGL.rotate(180 + -tile.getRotationYaw(), 0F, 1F, 0F);
                OpenGL.rotate(tile.getRotationPitch(), 1F, 0F, 0F);
                OpenGL.translate(-12.5F, -23.5F, 43.76F);

                // Display itself
                Draw.drawRect(-5, -3, 35, 14, 0xFF000000);
                Draw.drawRect(-5, -3, 35, 14, 0xFF000000);
                OpenGL.translate(0.0F, 0.0F, 0.001F);
                Draw.drawString(displayText, 0, 0, tile.beamColor);
                OpenGL.enable(GL11.GL_LIGHTING);
                OpenGL.enableLight();
            }
            OpenGL.popMatrix();
        }
    }

    public void renderBeam(int x, int y, int w, int h, int zLevel, int scale, int color1, int color2, float rotationYaw, float rotationPitch, int l)
    {
        w = w * scale / 2;

        OpenGL.pushMatrix();
        {
            OpenGL.translate(0F, 0.75F, 0F);
            OpenGL.rotate(-90 + -rotationYaw, 0F, 1F, 0F);
            OpenGL.rotate(rotationPitch, 0F, 0F, 1F);
            OpenGL.scale(1F / scale, 1F / scale, 1F / scale);
            OpenGL.disable(GL11.GL_TEXTURE_2D);
            OpenGL.disable(GL11.GL_LIGHTING);
            OpenGL.disableLight();
            OpenGL.enable(GL11.GL_BLEND);
            OpenGL.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE);
            GL11.glShadeModel(GL11.GL_SMOOTH);
            Draw.startQuadsColored();
            Draw.vertex(w, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, y, zLevel).color((color2 >> 16 & 255) / 255.0F, (color2 >> 8 & 255) / 255.0F, (color2 & 255) / 255.0F, (color2 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(x, l, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.vertex(w, h, zLevel).color((color1 >> 16 & 255) / 255.0F, (color1 >> 8 & 255) / 255.0F, (color1 & 255) / 255.0F, (color1 >> 24 & 255) / 255.0F).endVertex();
            Draw.tessellate();
            GL11.glShadeModel(GL11.GL_FLAT);
            OpenGL.enable(GL11.GL_LIGHTING);
            OpenGL.enableLight();
            OpenGL.enable(GL11.GL_TEXTURE_2D);
            OpenGL.disable(GL11.GL_BLEND);
        }
        OpenGL.popMatrix();
    }
}
