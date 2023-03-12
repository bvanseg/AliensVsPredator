package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelBelugaburster;
import org.avp.common.entities.living.vardic.EntityBelugaburster;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

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
