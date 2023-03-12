package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDracoOvamorph;
import org.avp.common.entities.living.EntityDracoEgg;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderDracoEgg extends RenderLivingWrapper<EntityDracoEgg, ModelDracoOvamorph>
{
    public RenderDracoEgg(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DRACO_OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracoEgg entityLiving, float partialTicks)
    {
        super.preRenderCallback(entityLiving, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
