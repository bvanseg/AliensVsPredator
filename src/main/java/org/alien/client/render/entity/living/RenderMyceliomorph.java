package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelMyceliomorph;
import org.alien.common.entity.living.xenomorph.EntityMyceliomorph;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL11;

public class RenderMyceliomorph extends RenderLivingWrapper<EntityMyceliomorph, ModelMyceliomorph>
{
    public RenderMyceliomorph(RenderManager m)
    {
        super(m, Resources.instance.models().MYCELIOMORPH);
//        this.setRenderPassModel(this.getModel().getModel());
    }

    protected int shouldRenderPass(EntityMyceliomorph entityLivingBase, int par2, float par3)
    {
        return this.setRenderPassModelBrightness((EntityMyceliomorph) entityLivingBase, par2);
    }

    protected int setRenderPassModelBrightness(EntityMyceliomorph entity, int brightness)
    {
        if (brightness != 0)
        {
            return -1;
        }
        else
        {
            Resources.instance.models().MYCELIOMORPH_MASK.getTexture().bind();
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
