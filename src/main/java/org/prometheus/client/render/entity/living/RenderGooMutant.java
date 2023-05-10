package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelGooMutant;
import org.prometheus.common.entity.living.vardic.EntityGooMutant;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant(RenderManager m)
    {
        super(m, PrometheusResources.Models.GOO_MUTANT);
    }
}
