package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.power.common.tile.TileEntitySatelliteDish;

public class RenderSatelliteDish extends TileEntitySpecialRenderer<TileEntitySatelliteDish>
{
    @Override
    public void render(TileEntitySatelliteDish tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.translate(x, y, z);
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.translate(0.5F, -1.525F, 0.5F);
            OpenGL.disableCullFace();
            Resources.instance.models().SATELLITE_DISH.draw(tile);
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
