package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.alien.client.model.entity.living.ModelDeaconAdult;
import org.alien.common.entity.living.species223ode.EntityDeaconAdult;

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
