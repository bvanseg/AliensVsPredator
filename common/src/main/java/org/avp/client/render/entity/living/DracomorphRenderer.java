package org.avp.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.DracomorphModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Dracomorph;

/**
 * @author Boston Vanseghi
 */
public class DracomorphRenderer extends MobRenderer<Dracomorph, DracomorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("dracomorph");

    public DracomorphRenderer(EntityRendererProvider.Context context) {
        super(context, new DracomorphModel(context.bakeLayer(DracomorphModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    protected void scale(@NotNull Dracomorph entity, @NotNull PoseStack poseStack, float partialTicks) {
        poseStack.scale(1.75F, 1.75F, 1.75F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Dracomorph entity) {
        return TEXTURE;
    }
}
