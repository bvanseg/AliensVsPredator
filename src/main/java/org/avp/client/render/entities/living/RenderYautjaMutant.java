package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelMutantYautja;
import org.predator.common.entity.living.yautja.EntityYautjaMutant;

public class RenderYautjaMutant extends RenderLivingWrapper<EntityYautjaMutant, ModelMutantYautja>
{
    public RenderYautjaMutant(RenderManager m)
    {
        super(m, AVP.resources().models().MUTANT_YAUTJA);
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
