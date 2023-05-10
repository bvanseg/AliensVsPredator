package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelTrilobite;
import org.prometheus.common.entity.living.species223ode.EntityTrilobite;

public class RenderTrilobite extends RenderLivingWrapper<EntityTrilobite, ModelTrilobite>
{
    public RenderTrilobite(RenderManager m)
    {
        super(m, PrometheusResources.Models.TRILOBITE);
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
