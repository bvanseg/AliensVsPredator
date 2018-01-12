package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelGooMutant;
import org.avp.entities.living.EntityGooMutant;

import com.arisux.mdx.lib.client.render.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().GOO_MUTANT);
    }
    
    @Override
    public void doRender(EntityGooMutant entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityGooMutant entityliving, float renderPartialTicks)
    {
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
