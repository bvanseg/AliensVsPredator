package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelEngineer;
import org.avp.entities.living.species.SpeciesEngineer;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.asx.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderEngineer extends RenderLivingWrapper<SpeciesEngineer, ModelEngineer>
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
    public void doRender(SpeciesEngineer entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(SpeciesEngineer entityliving, float renderPartialTicks)
    {
        OpenGL.scale(1.25F, 1.25F, 1.25F);
    }
}
