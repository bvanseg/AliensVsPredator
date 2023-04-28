package org.alien.client.render.entity.living.paradise;

import com.asx.mdx.client.render.entity.RenderLivingWrapper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import org.alien.client.AlienResources;
import org.alien.client.model.entity.living.paradise.ModelKetterBird;
import org.alien.client.render.layer.LayerKetterBirdEyes;
import org.alien.common.entity.living.paradise.EntityKetterBird;
import org.avp.AVP;

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
        super(m, AlienResources.instance.models().KETTER_BIRD);
        this.addLayer(new LayerKetterBirdEyes(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityKetterBird entity) {
        return skins[entity.getVariant()];
    }
}
