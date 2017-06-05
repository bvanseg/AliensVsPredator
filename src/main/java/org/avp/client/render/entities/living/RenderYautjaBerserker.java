package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderYautjaBerserker extends RenderYautja
{
    public RenderYautjaBerserker()
    {
        super(AliensVsPredator.resources().models().YAUTJA_BERSERKER);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entityliving, float renderPartialTicks)
    {
        OpenGL.scale(0.85F, 0.85F, 0.85F);
    }
}
