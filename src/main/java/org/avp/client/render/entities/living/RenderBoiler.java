package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelBoiler;
import org.alien.common.entity.living.xenomorphs.EntityBoiler;
import org.lwjgl.opengl.GL11;

public class RenderBoiler extends RenderLivingWrapper<EntityBoiler, ModelBoiler>
{
    public RenderBoiler(RenderManager m)
    {
        super(m, AVP.resources().models().BOILER);
    }

    @Override
    protected void preRenderCallback(EntityBoiler entityLivingBase, float shadowSize)
    {
        super.preRenderCallback(entityLivingBase, shadowSize);
    }

    protected int setRenderPassModelBrightness(EntityBoiler entity, int brightness)
    {
        if (brightness != 0)
        {
            return -1;
        }
        else
        {
            char light = 61680;
            AVP.resources().models().BOILER_MASK.getTexture().bind();
            OpenGL.enableBlend();
            OpenGL.blendFunc(GL11.GL_ONE, GL11.GL_ONE);
            GL11.glDepthMask(!entity.isInvisible());
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (light % 65536) / 1.0F, (light / 65536) / 1.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }
}
