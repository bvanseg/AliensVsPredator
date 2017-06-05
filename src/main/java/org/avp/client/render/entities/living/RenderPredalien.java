package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderPredalien extends RenderLivingWrapper
{
    public RenderPredalien()
    {
        super(AliensVsPredator.resources().models().PREDALIEN);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase living, float renderPartialTicks)
    {
        OpenGL.scale(0.75F, 0.75F, 0.75F);
    }
}
