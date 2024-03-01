package org.avp.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.model.entity.living.OvamorphModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Ovamorph;
import org.jetbrains.annotations.NotNull;

/**
 * @author Boston Vanseghi
 */
public class OvamorphRenderer extends MobRenderer<Ovamorph, OvamorphModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("ovamorph");

    public OvamorphRenderer(EntityRendererProvider.Context context) {
        super(context, new OvamorphModel(context.bakeLayer(OvamorphModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    protected void scale(@NotNull Ovamorph entity, @NotNull PoseStack poseStack, float partialTicks) {
        poseStack.scale(1.75F, 1.75F, 1.75F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull Ovamorph entity) {
        return TEXTURE;
    }
}