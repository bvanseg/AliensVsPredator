package org.avp.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.QueenModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Queen;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class QueenRenderer extends MobRenderer<Queen, QueenModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("queen");


    public QueenRenderer(EntityRendererProvider.Context context) {
        super(context, new QueenModel(context.bakeLayer(QueenModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    protected void scale(@NotNull Queen entity, @NotNull PoseStack poseStack, float partialTicks) {
        poseStack.scale(1.75F, 1.75F, 1.75F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Queen entity) {
        return TEXTURE;
    }
}
