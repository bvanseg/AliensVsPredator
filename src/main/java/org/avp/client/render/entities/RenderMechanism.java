package org.avp.client.render.entities;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.predator.common.entity.EntityMechanism;

public class RenderMechanism extends Render<EntityMechanism>
{
    public RenderMechanism(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityMechanism entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        ;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMechanism entity)
    {
        return null;
    }
}
