package org.avp.client.render.entity.living;

import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.ChestbursterRunnerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.ChestbursterRunner;

/**
 * @author Boston Vanseghi
 */
public class ChestbursterRunnerRenderer extends MobRenderer<ChestbursterRunner, ChestbursterRunnerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("chestburster_runner");

    public ChestbursterRunnerRenderer(EntityRendererProvider.Context context) {
        super(context, new ChestbursterRunnerModel(context.bakeLayer(ChestbursterRunnerModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull ChestbursterRunner entity) {
        return TEXTURE;
    }
}
