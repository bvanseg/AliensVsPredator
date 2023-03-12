package org.avp.client.render.entities.living;

import org.avp.entities.living.species.SpeciesXenomorph;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.entity.RenderLivingWrapper;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderXenomorph<XENO extends SpeciesXenomorph, MODEL extends Model<? extends SpeciesXenomorph>> extends RenderLivingWrapper<XENO, MODEL>
{
    private float scale;

    public RenderXenomorph(RenderManager m, MapModelTexture<MODEL> modelTexMap)
    {
        this(m, modelTexMap, 1F);
    }

    public RenderXenomorph(RenderManager m, MapModelTexture<MODEL> modelTexMap, float scale)
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
    public ResourceLocation getEntityTexture(SpeciesXenomorph entity)
    {
        return this.getModel().getTexture();
    }

    public RenderXenomorph<XENO, MODEL> setScale(float renderScale)
    {
        this.scale = renderScale;
        return this;
    }
}
