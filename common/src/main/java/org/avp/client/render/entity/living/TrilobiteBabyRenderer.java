package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.TrilobiteBabyModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.TrilobiteBaby;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class TrilobiteBabyRenderer extends MobRenderer<TrilobiteBaby, TrilobiteBabyModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("trilobite_baby");

    public TrilobiteBabyRenderer(EntityRendererProvider.Context context) {
        super(context, new TrilobiteBabyModel(context.bakeLayer(TrilobiteBabyModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull TrilobiteBaby entity) {
        return TEXTURE;
    }
}
