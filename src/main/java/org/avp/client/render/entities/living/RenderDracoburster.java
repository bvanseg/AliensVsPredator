package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelDracoburster;
import org.alien.common.entity.living.xenomorphs.EntityDracoburster;

public class RenderDracoburster extends RenderLivingWrapper<EntityDracoburster, ModelDracoburster>
{
    public RenderDracoburster(RenderManager m)
    {
        super(m, AVP.resources().models().DRACOBURSTER);
    }
    
    @Override
    public void doRender(EntityDracoburster entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityDracoburster entityliving, float renderPartialTicks)
    {
        float scale = 0.75F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
