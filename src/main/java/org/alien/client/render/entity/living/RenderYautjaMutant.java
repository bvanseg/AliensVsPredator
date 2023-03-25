package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelMutantYautja;
import org.alien.common.entity.living.EntityYautjaMutant;

public class RenderYautjaMutant extends RenderLivingWrapper<EntityYautjaMutant, ModelMutantYautja>
{
    public RenderYautjaMutant(RenderManager m)
    {
        super(m, AlienResources.instance.models().MUTANT_YAUTJA);
    }

    @Override
    protected void preRenderCallback(EntityYautjaMutant entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
