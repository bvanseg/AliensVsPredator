package org.alien.client.render.entity.living;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.ModelNauticomorph;
import org.alien.client.render.layer.LayerPhosphorescent;
import org.alien.common.entity.living.xenomorph.exotic.EntityNauticomorph;

/**
 * @author Ri5ux
 */
public class RenderNauticomorph extends RenderLivingWrapper<EntityNauticomorph, ModelNauticomorph> {


    public RenderNauticomorph(RenderManager m) {
        super(m, AlienResources.instance.models().NAUTICOMORPH_XENOMORPH);
        this.addLayer(new LayerPhosphorescent(this, AlienResources.instance.models().NAUTICOMORPH_XENOMORPH_MASK));
    }

    @Override
    protected void preRenderCallback(EntityNauticomorph entityliving, float partialTicks) {
        OpenGL.scale(0.8F, 0.8F, 0.8F);
    }
}
