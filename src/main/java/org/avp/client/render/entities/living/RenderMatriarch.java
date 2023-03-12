package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelMatriarch;
import org.avp.common.entities.living.species.xenomorphs.EntityMatriarch;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

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
