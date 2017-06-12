package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelUrsuidae;
import org.avp.entities.living.EntityUrsuidae;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderUrsuidae extends RenderLivingWrapper<EntityUrsuidae, ModelUrsuidae>
{
    public RenderUrsuidae(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().URSUIDAE);
    }
    
    @Override
    public void doRender(EntityUrsuidae entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityUrsuidae entityliving, float renderPartialTicks)
    {
        float scale = 2.0F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
