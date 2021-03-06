package org.power.client.render.tile;

import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import org.avp.client.Resources;
import org.avp.client.render.util.EntityRenderTransforms;
import org.power.common.tile.TileEntityMedpod;

import java.util.ArrayList;

public class RenderMedpod extends TileEntitySpecialRenderer<TileEntityMedpod>
{
    public static ArrayList<EntityRenderTransforms> transforms = new ArrayList<>();

    @Override
    public void render(TileEntityMedpod tile, double x, double y, double z, float partialTicks, int destroyStage, float alpha)
    {
        if (tile.isOpen())
        {
            tile.doorProgress = tile.doorProgress < tile.getMaxDoorProgress() ? tile.doorProgress + 0.025F : tile.doorProgress;
        }

        if (!tile.isOpen())
        {
            tile.doorProgress = tile.doorProgress > 0.0F ? tile.doorProgress - 0.025F : tile.doorProgress;
        }

        OpenGL.pushMatrix();
        {
            float newScale = 1.5F;
            OpenGL.translate(x, y, z);
            OpenGL.translate(0.5F, 2.25F, 0.5F);
            OpenGL.scale(1F, -1F, 1F);
            OpenGL.scale(newScale, newScale, newScale);
            OpenGL.disableCullFace();
            OpenGL.rotateOpposite(tile);
            Resources.instance.models().MEDPOD.draw(tile);

            OpenGL.enableBlend();
            OpenGL.blendClear();

            if (tile.getVoltage() > 0) {
                OpenGL.disableLight();
                OpenGL.disableLightMapping();
            }

            Resources.instance.models().MEDPOD_MASK.draw(tile);

            if (tile.getVoltage() > 0) {
                OpenGL.enableLight();
                OpenGL.enableLightMapping();
            }
            OpenGL.blendClear();
            OpenGL.disableBlend();
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }
}
