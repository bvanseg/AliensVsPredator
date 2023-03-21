package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import com.asx.mdx.client.render.model.MapModelTexture;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.common.api.parasitoidic.Maturable;
import org.alien.common.entity.living.SpeciesXenomorph;

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
        float additionalScale = 0F;
        float jellyLevelPrev = xeno.growthProgress;
        xeno.growthProgress = xeno.getJellyLevel();
        xeno.growthProgress = jellyLevelPrev + ((xeno.growthProgress - jellyLevelPrev) * renderPartialTicks * 0.005f);

        if (xeno instanceof Maturable) {
            additionalScale = xeno.growthProgress / (((Maturable) xeno).getMaturityLevel() * 2);
        }

        OpenGL.scale(this.scale + additionalScale, this.scale + additionalScale, this.scale + additionalScale);
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
