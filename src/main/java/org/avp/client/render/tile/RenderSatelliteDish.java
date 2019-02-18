package org.avp.client.render.tile;

import org.avp.AliensVsPredator;
import org.avp.tile.TileEntitySatelliteDish;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

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
            AliensVsPredator.resources().models().SATELLITE_DISH.draw(tile);
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
