package org.alien.client.render.entity.living.paradise;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.paradise.ModelStripedDevil;
import org.alien.client.render.layer.LayerStripedDevilEyes;
import org.alien.common.entity.living.paradise.EntityStripedDevil;

/**
 * @author Boston Vanseghi
 */
public class RenderStripedDevil extends RenderLivingWrapper<EntityStripedDevil, ModelStripedDevil> {
    public RenderStripedDevil(RenderManager m) {
        super(m, AlienResources.instance.models().STRIPED_DEVIL);
        this.addLayer(new LayerStripedDevilEyes(this));
    }
}
