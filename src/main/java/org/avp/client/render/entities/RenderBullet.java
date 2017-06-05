package org.avp.client.render.entities;

import org.avp.client.model.entities.ModelBullet;
import org.avp.entities.EntityBullet;

import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.ResourceLocation;

public class RenderBullet extends Render<EntityBullet>
{
    public RenderBullet()
    {
        super(Game.renderManager());
    }

    public static ModelBullet model = new ModelBullet();

    @Override
    public void doRender(EntityBullet entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        ;
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityBullet entity)
    {
        return null;
    }
}
