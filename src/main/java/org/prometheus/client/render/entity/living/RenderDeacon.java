package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelDeacon;
import org.prometheus.common.entity.living.species223ode.EntityDeacon;

public class RenderDeacon extends RenderLivingWrapper<EntityDeacon, ModelDeacon>
{
    private float scale;

    public RenderDeacon(RenderManager m)
    {
        super(m, PrometheusResources.Models.DEACON);
        this.scale = 1.0F;
    }

    @Override
    protected void preRenderCallback(EntityDeacon xeno, float renderPartialTicks)
    {
        this.scale = 0.65F;
        OpenGL.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(xeno, renderPartialTicks);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityDeacon entity)
    {
        return this.getModel().getTexture();
    }

    public RenderDeacon setScale(float renderScale)
    {
        this.scale = renderScale;
        return this;
    }
}
