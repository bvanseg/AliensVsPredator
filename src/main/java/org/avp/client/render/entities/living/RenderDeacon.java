package org.avp.client.render.entities.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.avp.AVP;
import org.avp.client.model.entities.living.ModelDeacon;
import org.avp.common.entities.living.species.species223ode.EntityDeacon;

public class RenderDeacon extends RenderLivingWrapper<EntityDeacon, ModelDeacon>
{
    private float scale;

    public RenderDeacon(RenderManager m)
    {
        super(m, AVP.resources().models().DEACON);
        this.scale = 1.0F;
    }

    @Override
    protected void preRenderCallback(EntityDeacon xeno, float renderPartialTicks)
    {
        this.scale = 0.65F;
        OpenGL.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(xeno, renderPartialTicks);
    }

    @Override
    public ResourceLocation getEntityTexture(EntityDeacon entity)
    {
        return this.getModel().getTexture();
    }

    public RenderDeacon setScale(float renderScale)
    {
        this.scale = renderScale;
        return this;
    }
}
