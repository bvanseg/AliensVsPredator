package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.UltramorphModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Ultramorph;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class UltramorphRenderer extends MobRenderer<Ultramorph, UltramorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("ultramorph");

    public UltramorphRenderer(EntityRendererProvider.Context context) {
        super(context, new UltramorphModel(context.bakeLayer(UltramorphModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Ultramorph entity) {
        return TEXTURE;
    }
}
