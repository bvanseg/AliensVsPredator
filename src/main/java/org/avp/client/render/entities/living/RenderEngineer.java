package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelEngineer;
import org.avp.entities.living.EntitySpeciesEngineer;

import com.arisux.mdx.lib.client.util.OpenGL;
import com.arisux.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.arisux.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEngineer extends RenderLivingWrapper<EntitySpeciesEngineer, ModelEngineer>
{
    public RenderEngineer(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().ENGINEER);
    }
    
    public RenderEngineer(RenderManager m, MapModelTexture<ModelEngineer> model)
    {
        super(m, model);
    }

    @Override
    public void doRender(EntitySpeciesEngineer entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntitySpeciesEngineer entityliving, float renderPartialTicks)
    {
        OpenGL.scale(1.25F, 1.25F, 1.25F);
    }
}
