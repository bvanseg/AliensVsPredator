package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelDracoburster;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.xenomorph.EntityDracoburster;

public class RenderDracoburster extends RenderLivingWrapper<EntityDracoburster, ModelDracoburster>
{
    public RenderDracoburster(RenderManager m)
    {
        super(m, AlienResources.instance.models().DRACOBURSTER);
    }

    @Override
    protected void preRenderCallback(EntityDracoburster entityliving, float renderPartialTicks)
    {
        float additionalScale = AlienGrowthUtil.calculateJellyGrowthFactor(entityliving, 0.005f, 3, renderPartialTicks);
        OpenGL.scale(0.75F + additionalScale, 0.75F + additionalScale, 0.75F + additionalScale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
