package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelMyceliomorph;
import org.avp.entities.living.EntityMyceliomorph;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMyceliomorph extends RenderLivingWrapper<EntityMyceliomorph, ModelMyceliomorph>
{
    public RenderMyceliomorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().MYCELIOMORPH);
//        this.setRenderPassModel(this.getModel().getModel());
    }

    @Override
    protected void preRenderCallback(EntityMyceliomorph entityLivingBase, float shadowSize)
    {
        super.preRenderCallback(entityLivingBase, shadowSize);
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
            AliensVsPredator.resources().models().MYCELIOMORPH_MASK.getTexture().bind();
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
