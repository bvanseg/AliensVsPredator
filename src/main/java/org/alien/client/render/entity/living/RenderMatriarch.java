package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelMatriarch;
import org.alien.common.entity.living.xenomorphs.EntityMatriarch;
import org.avp.AVP;

public class RenderMatriarch extends RenderLivingWrapper<EntityMatriarch, ModelMatriarch>
{
    public RenderMatriarch(RenderManager m)
    {
        super(m, AVP.resources().models().MATRIARCH);
    }

    @Override
    public void doRender(EntityMatriarch entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityMatriarch entityliving, float partialTicks)
    {
        OpenGL.scale(1.75F, 1.75F, 1.75F);
    }
}
