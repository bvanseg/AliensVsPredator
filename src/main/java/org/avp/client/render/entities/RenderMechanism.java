package org.avp.client.render.entities;

import org.avp.entities.EntityMechanism;

import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.util.ResourceLocation;

public class RenderMechanism extends Render<EntityMechanism>
{
    public RenderMechanism()
    {
        super(Game.renderManager());
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
