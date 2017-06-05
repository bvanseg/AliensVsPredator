package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDracomorph;
import org.avp.entities.living.EntityDracomorph;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

public class RenderDracomorph extends RenderLivingWrapper<EntityDracomorph, ModelDracomorph>
{
    public RenderDracomorph()
    {
        super(AliensVsPredator.resources().models().DRACOMORPH);
    }
    
    public RenderDracomorph(TexturedModel<ModelDracomorph> model)
    {
        super(model);
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
