package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelDracoOvamorph;
import org.alien.common.entity.living.EntityDracoEgg;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderDracoEgg extends RenderLivingWrapper<EntityDracoEgg, ModelDracoOvamorph>
{
    public RenderDracoEgg(RenderManager m)
    {
        super(m, Resources.instance.models().DRACO_OVAMORPH);
    }

    @Override
    protected void preRenderCallback(EntityDracoEgg entityLiving, float partialTicks)
    {
        super.preRenderCallback(entityLiving, partialTicks);
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
