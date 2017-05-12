package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelAqua;
import org.avp.entities.living.EntityAqua;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.RenderLivingWrapper;
import com.arisux.mdxlib.lib.client.render.OpenGL;

import net.minecraft.client.renderer.OpenGlHelper;

public class RenderAqua extends RenderLivingWrapper<EntityAqua, ModelAqua>
{
    public RenderAqua()
    {
        super(AliensVsPredator.resources().models().AQUA_XENOMORPH);
    }

    @Override
    protected void preRenderCallback(EntityAqua entityliving, float partialTicks)
    {
        OpenGL.scale(0.8F, 0.8F, 0.8F);
    }

    protected int setRenderPassModelBrightness(EntityAqua entity, int brightness)
    {
        if (brightness != 0)
        {
            return -1;
        }
        else
        {
            AliensVsPredator.resources().models().AQUA_XENOMORPH_MASK.getTexture().bind();
            float f1;

            boolean isDay = (entity.world.getWorldTime() % 24000L) / 1000L < 14L;

            if (!isDay)
            {
                f1 = 1.0F;
            }
            else
            {
                f1 = 0.0F;
            }

            OpenGL.enable(GL11.GL_BLEND);
            OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE);

            if (entity.isInvisible())
            {
                GL11.glDepthMask(false);
            }
            else
            {
                GL11.glDepthMask(true);
            }

            char c0 = 61680;
            int j = c0 % 65536;
            int k = c0 / 65536;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, j / 1.0F, k / 1.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, f1);

            return 1;
        }
    }
}
