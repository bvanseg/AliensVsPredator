package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelChestbursterRunner;
import org.alien.common.entity.living.xenomorph.EntityRunnerChestburster;
import org.avp.AVP;

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