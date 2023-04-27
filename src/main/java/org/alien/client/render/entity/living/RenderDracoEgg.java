package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelDracoOvamorph;
import org.alien.common.entity.living.xenomorph.ovamorph.EntityDracoEgg;

public class RenderDracoEgg extends RenderLivingWrapper<EntityDracoEgg, ModelDracoOvamorph>
{
    public RenderDracoEgg(RenderManager m)
    {
        super(m, AlienResources.instance.models().DRACO_OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracoEgg entityLiving, float partialTicks)
    {
        super.preRenderCallback(entityLiving, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
