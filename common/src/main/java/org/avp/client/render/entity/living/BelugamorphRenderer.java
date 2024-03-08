package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.BelugamorphModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Belugamorph;

/**
 * @author Boston Vanseghi
 */
public class BelugamorphRenderer extends MobRenderer<Belugamorph, BelugamorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("belugamorph");

    public BelugamorphRenderer(EntityRendererProvider.Context context) {
        super(context, new BelugamorphModel(context.bakeLayer(BelugamorphModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Belugamorph entity) {
        return TEXTURE;
    }
}
