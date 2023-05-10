package org.prometheus.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.prometheus.client.PrometheusResources;
import org.prometheus.client.model.entity.living.ModelDeaconShark;
import org.prometheus.common.entity.living.vardic.EntityDeaconShark;

public class RenderDeaconShark extends RenderLivingWrapper<EntityDeaconShark, ModelDeaconShark>
{
    public RenderDeaconShark(RenderManager m)
    {
        super(m, PrometheusResources.Models.DEACON_SHARK);
    }

    @Override
    protected void preRenderCallback(EntityDeaconShark entitylivingBase, float partialTicks)
    {
        super.preRenderCallback(entitylivingBase, shadowSize);
        float scale = 1.7F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0, 1, 0);
    }
}
