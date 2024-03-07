package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.BelugabursterModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Belugaburster;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class BelugabursterRenderer extends MobRenderer<Belugaburster, BelugabursterModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("belugaburster");

    public BelugabursterRenderer(EntityRendererProvider.Context context) {
        super(context, new BelugabursterModel(context.bakeLayer(BelugabursterModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Belugaburster entity) {
        return TEXTURE;
    }
}
