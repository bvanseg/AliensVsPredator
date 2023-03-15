package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.model.entity.living.ModelMutantYautja;
import org.alien.common.entity.living.EntityYautjaMutant;
import org.avp.AVP;
import org.avp.client.Resources;

public class RenderYautjaMutant extends RenderLivingWrapper<EntityYautjaMutant, ModelMutantYautja>
{
    public RenderYautjaMutant(RenderManager m)
    {
        super(m, Resources.instance.models().MUTANT_YAUTJA);
    }

    @Override
    protected void preRenderCallback(EntityYautjaMutant entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
