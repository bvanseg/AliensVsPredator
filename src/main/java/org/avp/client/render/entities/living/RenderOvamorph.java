package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderOvamorph extends RenderLivingWrapper
{
    public RenderOvamorph()
    {
        super(AliensVsPredator.resources().models().OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityLiving, float partialTicks)
    {
        super.preRenderCallback(entityLiving, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
