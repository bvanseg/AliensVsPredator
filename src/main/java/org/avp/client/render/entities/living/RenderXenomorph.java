package org.avp.client.render.entities.living;

import org.avp.entities.living.EntityXenomorph;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.util.ResourceLocation;

public class RenderXenomorph<MODEL extends Model> extends RenderLivingWrapper<EntityXenomorph, MODEL>
{
    private float renderScale;

    public RenderXenomorph(TexturedModel<MODEL> modelTexMap)
    {
        this(modelTexMap, 1F);
    }

    public RenderXenomorph(TexturedModel<MODEL> modelTexMap, float renderScale)
    {
        super(modelTexMap);
        this.renderScale = renderScale;
    }

    @Override
    protected void preRenderCallback(EntityXenomorph entity, float renderPartialTicks)
    {
        OpenGL.scale(this.renderScale, this.renderScale, this.renderScale);
        super.preRenderCallback(entity, renderPartialTicks);
    }
    
    @Override
    public ResourceLocation getEntityTexture(EntityXenomorph entity)
    {
        return this.getModel().getTexture();
    }

    public RenderXenomorph<MODEL> setScale(float renderScale)
    {
        this.renderScale = renderScale;
        return this;
    }
}
