package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelBabyhead;
import org.avp.common.entities.living.vardic.EntityBabyhead;

public class RenderBabyhead extends RenderLivingWrapper<EntityBabyhead, ModelBabyhead>
{
    public RenderBabyhead(RenderManager m)
    {
        super(m, AVP.resources().models().BABYHEAD);
    }
    
    public void doRender(EntityBabyhead entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityBabyhead entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
