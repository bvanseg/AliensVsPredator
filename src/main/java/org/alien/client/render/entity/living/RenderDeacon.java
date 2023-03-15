package org.alien.client.render.entity.living;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.model.entity.living.ModelDeacon;
import org.alien.common.entity.living.species223ode.EntityDeacon;
import org.avp.AVP;

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