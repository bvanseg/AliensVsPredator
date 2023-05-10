package org.covenant.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import org.covenant.client.model.entity.living.ModelStripedDevil;
import org.covenant.client.render.layer.LayerStripedDevilEyes;
import org.covenant.client.CovenantResources;
import org.covenant.common.entity.living.EntityStripedDevil;

/**
 * @author Boston Vanseghi
 */
public class RenderStripedDevil extends RenderLivingWrapper<EntityStripedDevil, ModelStripedDevil> {
    public RenderStripedDevil(RenderManager m) {
        super(m, CovenantResources.Models.STRIPED_DEVIL);
        this.addLayer(new LayerStripedDevilEyes(this));
    }
}
