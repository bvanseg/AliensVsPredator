package org.avp.client.render.tile;

import com.asx.mdx.lib.client.util.Draw;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.avp.common.tile.TileEntityTurret;
import org.lwjgl.opengl.GL11;

public class RenderTurret extends TileEntitySpecialRenderer<TileEntityTurret>
{
	
    @Override
    public void render(TileEntityTurret tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5F, y + 1.5F, z + 0.25F);

            OpenGL.scale(1F, -1F, 1F);
            OpenGL.rotate(tile);
            Resources.instance.models().TURRET.draw(tile);

            if (tile.getVoltage() > 0)
            {
                this.renderAmmoDisplay(tile);

                if (!tile.getAttackHelper().isFiring())
                {
                    this.renderBeam(tile, 0, 0, -1, 0, 50, tile.beamColor, 0x00000000, -1);
                }
            }
        }
        OpenGL.popMatrix();
    }

    public void renderAmmoDisplay(TileEntityTurret tile)
    {
        if (tile.getAmmoHelper().isAmmoDisplayEnabled())
        {
            int ammo = (tile.getAmmoHelper().getCurrentRounds() * tile.getAmmoHelper().getMaxAmmo()) + tile.getAmmoHelper().getCurrentAmmo();
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
                OpenGL.rotate(180 + -tile.getLookHelper().getRotationYaw(), 0F, 1F, 0F);
                OpenGL.rotate(tile.getLookHelper().getRotationPitch(), 1F, 0F, 0F);
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

    public void renderBeam(TileEntityTurret tile, int x, int y, int h, int zLevel, int scale, int color1, int color2, int l)
    {
    	int w = tile.getTargetHelper().getRange();
    	float rotationYaw = tile.getLookHelper().getRotationYaw();
    	float rotationPitch = tile.getLookHelper().getRotationPitch();
    	
        w = w * scale / 2;

    	float yawOffset = 0F;
    	
    	switch (tile.getRotationYAxis()) {
        	case SOUTH:
        		yawOffset = 0F;
        		break;
        	case NORTH:
        		yawOffset = 180F;
        		break;
        	case EAST:
        		yawOffset = -90F;
        		break;
        	case WEST:
        		yawOffset = 90F;
        		break;
    		default:
    			break;
    	}

        OpenGL.pushMatrix();
        {
            OpenGL.translate(0F, 0.75F, 0F);
            OpenGL.rotate(-90 + -rotationYaw + yawOffset, 0F, 1F, 0F);
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
