package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelSpitter;
import org.alien.common.entity.living.xenomorphs.EntitySpitter;
import org.lwjgl.opengl.GL11;

public class RenderSpitter extends RenderLivingWrapper<EntitySpitter, ModelSpitter>
{
    public RenderSpitter(RenderManager m)
    {
        super(m, AVP.resources().models().SPITTER);
//        this.setRenderPassModel(this.getModel().getModel());
    }

    @Override
    protected void preRenderCallback(EntitySpitter entityLivingBase, float shadowSize)
    {
        super.preRenderCallback(entityLivingBase, shadowSize);
    }

    protected int shouldRenderPass(EntitySpitter entityLivingBase, int par2, float par3)
    {
        return this.setRenderPassModelBrightness((EntitySpitter) entityLivingBase, par2);
    }

    protected int setRenderPassModelBrightness(EntitySpitter entity, int brightness)
    {
        if (brightness != 0)
        {
            return -1;
        }
        else
        {
            AVP.resources().models().SPITTER.getTexture().bind();
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

            char light = 61680;
            OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, (light % 65536) / 1.0F, (light / 65536) / 1.0F);
            OpenGL.color(1.0F, 1.0F, 1.0F, 1.0F);
            return 1;
        }
    }
}
