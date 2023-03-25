package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelBelugaburster;
import org.alien.common.entity.living.vardic.EntityBelugaburster;

public class RenderBelugaburster extends RenderLivingWrapper<EntityBelugaburster, ModelBelugaburster>
{
    public RenderBelugaburster(RenderManager m)
    {
        super(m, AlienResources.instance.models().BELUGABURSTER);
    }

    @Override
    protected void preRenderCallback(EntityBelugaburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
