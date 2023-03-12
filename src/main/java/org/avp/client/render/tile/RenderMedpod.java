package org.avp.client.render.tile;

import java.util.ArrayList;

import org.avp.AliensVsPredator;
import org.avp.client.render.util.EntityRenderTransforms;
import org.avp.common.tile.TileEntityMedpod;

import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;

public class RenderMedpod extends TileEntitySpecialRenderer<TileEntityMedpod>
{
    public static ArrayList<EntityRenderTransforms> transforms = new ArrayList<EntityRenderTransforms>();

    @Override
    public void render(TileEntityMedpod tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        OpenGL.pushMatrix();
        {
            float newScale = 1.5F;
            OpenGL.translate(x, y, z);
            OpenGL.translate(0.5F, 2.25F, 0.5F);
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.scale(newScale, newScale, newScale);
            OpenGL.disableCullFace();
            OpenGL.rotateOpposite(tile);
            AliensVsPredator.resources().models().MEDPOD.draw(tile);

            OpenGL.enableBlend();
            OpenGL.blendClear();

            if (tile.getVoltage() > 0)
            {
                OpenGL.disableLight();
                OpenGL.disableLightMapping();
            }

            AliensVsPredator.resources().models().MEDPOD_MASK.draw(tile);
            OpenGL.enableLight();
            OpenGL.enableLightMapping();
            OpenGL.blendClear();
            OpenGL.disableBlend();
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
