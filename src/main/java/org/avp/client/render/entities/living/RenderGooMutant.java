package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelGooMutant;
import org.avp.common.entities.living.vardic.EntityGooMutant;

public class RenderGooMutant extends RenderLivingWrapper<EntityGooMutant, ModelGooMutant>
{
    public RenderGooMutant(RenderManager m)
    {
        super(m, AVP.resources().models().GOO_MUTANT);
    }
    
    @Override
    public void doRender(EntityGooMutant entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        super.doRender(entity, posX, posY, posZ, yaw, renderPartialTicks);
    }

    @Override
    protected void preRenderCallback(EntityGooMutant entityliving, float renderPartialTicks)
    {
        super.preRenderCallback(entityliving, renderPartialTicks);
    }
}
