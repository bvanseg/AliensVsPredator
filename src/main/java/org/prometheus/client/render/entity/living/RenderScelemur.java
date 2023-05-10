package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelVardaMonkey;
import org.prometheus.common.entity.living.vardic.EntityScelemur;

public class RenderScelemur extends RenderLivingWrapper<EntityScelemur, ModelVardaMonkey>
{
    public RenderScelemur(RenderManager m)
    {
        super(m, PrometheusResources.Models.VARDA_MONKEY);
    }

    @Override
    protected void preRenderCallback(EntityScelemur entityliving, float renderPartialTicks)
    {
        float scale = 1F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
