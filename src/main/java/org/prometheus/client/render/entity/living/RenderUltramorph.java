package org.prometheus.client.render.entity.living;

import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.render.entity.living.RenderXenomorph;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelUltramorph;
import org.prometheus.common.entity.living.xenomorph.EntityUltramorph;

public class RenderUltramorph extends RenderXenomorph<EntityUltramorph, ModelUltramorph>
{
    public RenderUltramorph(RenderManager m)
    {
        super(m, PrometheusResources.Models.ULTRAMORPH, 1.5F);
    }
}
