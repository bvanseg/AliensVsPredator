package org.avp.client.render.entities.living;

import org.avp.entities.living.EntityXenomorph;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.RenderLivingWrapper;
import com.arisux.mdx.lib.client.TexturedModel;
import com.arisux.mdx.lib.client.render.OpenGL;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderXenomorph<XENO extends EntityXenomorph, MODEL extends Model> extends RenderLivingWrapper<XENO, MODEL>
{
    private float scale;

    public RenderXenomorph(RenderManager m, TexturedModel<MODEL> modelTexMap)
    {
        this(m, modelTexMap, 1F);
    }

    public RenderXenomorph(RenderManager m, TexturedModel<MODEL> modelTexMap, float scale)
    {
        super(m, modelTexMap);
        this.scale = scale;
    }

    @Override
    protected void preRenderCallback(XENO xeno, float renderPartialTicks)
    {
        OpenGL.scale(this.scale, this.scale, this.scale);
        super.preRenderCallback(xeno, renderPartialTicks);
    }
    
    @Override
    public ResourceLocation getEntityTexture(EntityXenomorph entity)
    {
        return this.getModel().getTexture();
    }

    public RenderXenomorph<XENO, MODEL> setScale(float renderScale)
    {
        this.scale = renderScale;
        return this;
    }
}
