package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelHammerpede;
import org.prometheus.common.entity.living.vardic.EntityHammerpede;

public class RenderHammerpede extends RenderLivingWrapper<EntityHammerpede, ModelHammerpede>
{
    public RenderHammerpede(RenderManager m)
    {
        super(m, PrometheusResources.Models.HAMMERPEDE);
    }

    @Override
    protected void preRenderCallback(EntityHammerpede entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        OpenGL.scale(0.65F, 0.65F, 0.65F);
    }
}
