package org.avp.client.render.entities.living;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.living.ModelDeacon;
import org.avp.entities.living.EntityDeacon;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDeacon extends RenderLivingWrapper<EntityDeacon, ModelDeacon>
{
    private float scale;

    public RenderDeacon(RenderManager m)
    {
        super(m, AliensVsPredator.resources().models().DEACON);
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
