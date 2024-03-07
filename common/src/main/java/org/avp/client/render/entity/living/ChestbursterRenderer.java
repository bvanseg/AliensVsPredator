package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.ChestbursterModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Chestburster;

/**
 * @author Boston Vanseghi
 */
public class ChestbursterRenderer extends MobRenderer<Chestburster, ChestbursterModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("chestburster");

    public ChestbursterRenderer(EntityRendererProvider.Context context) {
        super(context, new ChestbursterModel(context.bakeLayer(ChestbursterModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Chestburster entity) {
        return TEXTURE;
    }
}
