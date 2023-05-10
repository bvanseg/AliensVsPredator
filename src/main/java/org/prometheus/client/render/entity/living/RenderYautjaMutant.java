package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.prometheus.client.model.entity.living.ModelMutantYautja;
import org.prometheus.common.entity.living.EntityYautjaMutant;
import org.prometheus.client.PrometheusResources;

public class RenderYautjaMutant extends RenderLivingWrapper<EntityYautjaMutant, ModelMutantYautja>
{
    public RenderYautjaMutant(RenderManager m)
    {
        super(m, PrometheusResources.Models.MUTANT_YAUTJA);
    }

    @Override
    protected void preRenderCallback(EntityYautjaMutant entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
