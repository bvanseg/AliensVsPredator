package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelTrilobite;
import org.alien.common.entity.living.species223ode.EntityTrilobite;
import org.avp.client.Resources;

public class RenderTrilobite extends RenderLivingWrapper<EntityTrilobite, ModelTrilobite>
{
    public RenderTrilobite(RenderManager m)
    {
        super(m, Resources.instance.models().TRILOBITE);
    }

    @Override
    protected void preRenderCallback(EntityTrilobite trilobite, float partialTicks)
    {
        super.preRenderCallback(trilobite, shadowSize);
        float scale = 2.75F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0F, 0F);
    }
}
