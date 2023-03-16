package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelEngineer;
import org.alien.common.entity.living.SpeciesEngineer;
import org.avp.client.Resources;

public class RenderEngineer extends RenderLivingWrapper<SpeciesEngineer, ModelEngineer>
{
    public RenderEngineer(RenderManager m)
    {
        super(m, Resources.instance.models().ENGINEER);
    }
    
    public RenderEngineer(RenderManager m, MapModelTexture<ModelEngineer> model)
    {
        super(m, model);
    }

    @Override
    protected void preRenderCallback(SpeciesEngineer entityliving, float renderPartialTicks)
    {
        OpenGL.scale(1.25F, 1.25F, 1.25F);
    }
}
