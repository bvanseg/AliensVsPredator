package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.power.common.tile.TileEntitySolarPanel;

public class RenderSolarPanel extends TileEntitySpecialRenderer<TileEntitySolarPanel>
{
    @Override
    public void render(TileEntitySolarPanel tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            GlStateManager.disableCull();
            OpenGL.translate(x + 0.5, y + 0.5, z + 0.5);

            if (tile != null)
            {
                float angle = tile.getWorld().getCelestialAngle(partialTicks) * 360;
                OpenGL.rotate(angle > 90 && angle < 270 ? 90 : angle, 0, 0, 1);
                OpenGL.translate(0F, -1.4F, 0F);
            }

            Resources.instance.models().SOLAR_PANEL.draw(tile);
        }
        OpenGL.popMatrix();
    }
}
