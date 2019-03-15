package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDracomorph;
import org.avp.entities.living.species.xenomorphs.EntityDracomorph;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDracomorph extends RenderLivingWrapper<EntityDracomorph, ModelDracomorph>
{
    public RenderDracomorph(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DRACOMORPH);
    }
    
    @Override
    public void doRender(EntityDracomorph entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityDracomorph entityliving, float renderPartialTicks)
    {
        float scale = 3.0F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
