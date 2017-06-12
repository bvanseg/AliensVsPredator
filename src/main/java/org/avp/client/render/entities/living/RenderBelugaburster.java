package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelBelugaburster;
import org.avp.entities.living.EntityBelugaburster;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderBelugaburster extends RenderLivingWrapper<EntityBelugaburster, ModelBelugaburster>
{
    public RenderBelugaburster(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().BELUGABURSTER);
    }

    @Override
    protected void preRenderCallback(EntityBelugaburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
