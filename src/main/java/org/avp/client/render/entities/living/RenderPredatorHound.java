package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.predator.client.model.entity.living.ModelPredatorHound;
import org.predator.common.entity.living.EntityPredatorHound;

public class RenderPredatorHound extends RenderLivingWrapper<EntityPredatorHound, ModelPredatorHound>
{
    public RenderPredatorHound(RenderManager m)
    {
        super(m, AVP.resources().models().PREDATOR_HOUND);
    }
    
    @Override
    public void doRender(EntityPredatorHound entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityPredatorHound entityliving, float renderPartialTicks)
    {
        float scale = 1.5F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
