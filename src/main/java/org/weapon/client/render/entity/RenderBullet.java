package org.weapon.client.render.entity;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.client.model.entity.ModelBullet;
import org.weapon.common.entity.EntityBullet;

public class RenderBullet extends Render<EntityBullet>
{
    public RenderBullet(RenderManager m)
    {
        super(m);
    }

    public static ModelBullet model = new ModelBullet();

    @Override
    public void doRender(EntityBullet entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBullet entity)
    {
        return null;
    }
}
