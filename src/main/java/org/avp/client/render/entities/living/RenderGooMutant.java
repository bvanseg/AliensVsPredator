package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelGooMutant;
import org.avp.entities.living.EntityGooMutant;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant()
    {
        super(AliensVsPredator.resources().models().GOO_MUTANT);
    }
    
    public RenderGooMutant(TexturedModel<ModelGooMutant> model)
    {
        super(model);
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
