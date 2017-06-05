package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderHammerpede extends RenderLivingWrapper
{
    public RenderHammerpede()
    {
        super(AliensVsPredator.resources().models().HAMMERPEDE);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.65F, 0.65F, 0.65F);
    }
}
