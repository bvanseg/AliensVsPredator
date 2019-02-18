package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelMutantYautja;
import org.avp.entities.living.EntityYautjaMutant;

import com.arisux.mdx.lib.client.util.OpenGL;
import com.arisux.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;

public class RenderYautjaMutant extends RenderLivingWrapper<EntityYautjaMutant, ModelMutantYautja>
{
    public RenderYautjaMutant(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().MUTANT_YAUTJA);
    }

    @Override
    public void doRender(EntityYautjaMutant entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityYautjaMutant entityliving, float renderPartialTicks)
    {
        float scale = 1.25F;
        OpenGL.scale(scale, scale, scale);
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
