package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelUrsuidae;
import org.avp.common.entities.living.vardic.EntityUrsuidae;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

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
