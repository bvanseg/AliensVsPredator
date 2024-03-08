package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.TrilobiteModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Trilobite;

/**
 * @author Boston Vanseghi
 */
public class TrilobiteRenderer extends MobRenderer<Trilobite, TrilobiteModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("trilobite");

    public TrilobiteRenderer(EntityRendererProvider.Context context) {
        super(context, new TrilobiteModel(context.bakeLayer(TrilobiteModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Trilobite entity) {
        return TEXTURE;
    }
}
