package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelAethon;
import org.avp.entities.living.EntityAethon;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderAethon extends RenderLivingWrapper<EntityAethon, ModelAethon>
{
    public RenderAethon(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().AETHON);
    }
    
    @Override
    public void doRender(EntityAethon entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityAethon entityliving, float renderPartialTicks)
    {
        float scale = 1.75F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
