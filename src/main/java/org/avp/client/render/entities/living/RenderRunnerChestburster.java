package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelChestbursterRunner;
import org.avp.entities.living.EntityRunnerChestburster;

import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRunnerChestburster extends RenderLivingWrapper<EntityRunnerChestburster, ModelChestbursterRunner>
{
    public RenderRunnerChestburster(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().CHESTBUSTER_RUNNER);
    }

    @Override
    protected void preRenderCallback(EntityRunnerChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
    }
}
