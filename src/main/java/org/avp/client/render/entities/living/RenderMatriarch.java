package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelMatriarch;
import org.avp.entities.living.EntityMatriarch;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderMatriarch extends RenderLivingWrapper<EntityMatriarch, ModelMatriarch>
{
    public RenderMatriarch(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().MATRIARCH);
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
