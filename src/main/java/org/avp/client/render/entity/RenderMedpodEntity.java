package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.common.entity.EntityMedpod;

public class RenderMedpodEntity extends Render<EntityMedpod>
{
    public RenderMedpodEntity(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityMedpod entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMedpod entity)
    {
        return null;
    }
}
