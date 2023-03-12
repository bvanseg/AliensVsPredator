package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelVardaMonkey;
import org.alien.common.entity.living.vardic.EntityScelemur;

public class RenderScelemur extends RenderLivingWrapper<EntityScelemur, ModelVardaMonkey>
{
    public RenderScelemur(RenderManager m)
    {
        super(m, AVP.resources().models().VARDA_MONKEY);
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
