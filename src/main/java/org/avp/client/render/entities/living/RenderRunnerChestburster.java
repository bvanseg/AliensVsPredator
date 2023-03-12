package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelChestbursterRunner;
import org.avp.common.entities.living.species.xenomorphs.EntityRunnerChestburster;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderRunnerChestburster extends RenderLivingWrapper<EntityRunnerChestburster, ModelChestbursterRunner>
{
    public RenderRunnerChestburster(RenderManager m)
    {
        super(m, AVP.resources().models().CHESTBUSTER_RUNNER);
    }

    @Override
    protected void preRenderCallback(EntityRunnerChestburster entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.55F, 0.55F, 0.55F);
        OpenGL.translate(0.0f, 0f, -0.9f);
    }
}
