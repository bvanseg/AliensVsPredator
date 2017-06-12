package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelVardaMonkey;
import org.avp.entities.living.EntityScelemur;

import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderScelemur extends RenderLivingWrapper<EntityScelemur, ModelVardaMonkey>
{
    public RenderScelemur(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().VARDA_MONKEY);
    }
    
    @Override
    public void doRender(EntityScelemur entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityScelemur entityliving, float renderPartialTicks)
    {
        float scale = 1F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
