package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDracoOvamorph;
import org.avp.entities.living.EntityDracoEgg;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

public class RenderDracoEgg extends RenderLivingWrapper<EntityDracoEgg, ModelDracoOvamorph>
{
    public RenderDracoEgg()
    {
        super(AliensVsPredator.resources().models().DRACO_OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracoEgg entityLiving, float partialTicks)
    {
        super.preRenderCallback(entityLiving, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
