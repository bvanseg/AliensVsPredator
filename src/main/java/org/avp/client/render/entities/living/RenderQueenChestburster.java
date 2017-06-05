package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.entity.EntityLivingBase;

public class RenderQueenChestburster extends RenderLivingWrapper
{
    public RenderQueenChestburster()
    {
        super(AliensVsPredator.resources().models().CHESTBUSTER_QUEEN);
    }

    @Override
    protected void preRenderCallback(EntityLivingBase entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
