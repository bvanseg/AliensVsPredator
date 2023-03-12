package org.avp.client.render.entities.living;

import org.avp.AVP;
import org.avp.client.model.entities.living.ModelDeaconAdult;
import org.avp.common.entities.living.species.species223ode.EntityDeaconAdult;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeaconAdult extends RenderLivingWrapper<EntityDeaconAdult, ModelDeaconAdult>
{
    private float scale = 1.0F;
    
    public RenderDeaconAdult(RenderManager m)
    {
        super(m, AVP.resources().models().DEACON_ADULT);
    }

    @Override
    protected void preRenderCallback(EntityDeaconAdult deacon, float renderPartialTicks)
    {
        OpenGL.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(deacon, renderPartialTicks);
    }
    
    @Override
    public ResourceLocation getEntityTexture(EntityDeaconAdult entity)
    {
        return this.getModel().getTexture();
    }

    public RenderDeaconAdult setScale(float renderScale)
    {
        this.scale = renderScale;
        return this;
    }
}
