package org.covenant.client.render.entity.living;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.covenant.client.model.entity.living.ModelKetterBird;
import org.covenant.client.render.layer.LayerKetterBirdEyes;
import org.covenant.common.entity.living.EntityKetterBird;
import org.avp.AVP;
import org.covenant.client.CovenantResources;

/**
 * @author Boston Vanseghi
 */
public class RenderKetterBird extends RenderLivingWrapper<EntityKetterBird, ModelKetterBird> {
    private static final ResourceLocation[] skins = new ResourceLocation[] {
            new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/ketter_bird_1.png"),
            new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/ketter_bird_2.png"),
            new ResourceLocation(AVP.Properties.ID, "textures/mob/paradise/ketter_bird_3.png")
    };

    public RenderKetterBird(RenderManager m) {
        super(m, CovenantResources.Models.KETTER_BIRD);
        this.addLayer(new LayerKetterBirdEyes(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKetterBird entity) {
        return skins[entity.getVariant()];
    }
}
