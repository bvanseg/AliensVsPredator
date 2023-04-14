package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelChestbursterRunner;
import org.alien.client.render.util.AlienGrowthUtil;
import org.alien.common.entity.living.xenomorph.EntityRunnerChestburster;

public class RenderRunnerChestburster extends RenderLivingWrapper<EntityRunnerChestburster, ModelChestbursterRunner>
{
    public RenderRunnerChestburster(RenderManager m)
    {
        super(m, AlienResources.instance.models().CHESTBUSTER_RUNNER);
    }

    @Override
    protected void preRenderCallback(EntityRunnerChestburster entitylivingBase, float partialTicks)
    {
        float additionalScale = AlienGrowthUtil.calculateJellyGrowthFactor(entitylivingBase, 0.005f, 3, partialTicks);
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F + additionalScale, 0.55F + additionalScale, 0.55F + additionalScale);
        OpenGL.translate(0.0f, 0f, -0.6f);
    }
}
