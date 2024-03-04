package org.avp.client.render.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

import org.avp.client.model.entity.living.OvamorphDracoModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.OvamorphDraco;

/**
 * @author Boston Vanseghi
 */
public class OvamorphDracoRenderer extends MobRenderer<OvamorphDraco, OvamorphDracoModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("ovamorph_draco");

    public OvamorphDracoRenderer(EntityRendererProvider.Context context) {
        super(context, new OvamorphDracoModel(context.bakeLayer(OvamorphDracoModel.LAYER_LOCATION)), 0.5f);
    }

    @Override
    protected void scale(@NotNull OvamorphDraco entity, @NotNull PoseStack poseStack, float partialTicks) {
        poseStack.scale(1.75F, 1.75F, 1.75F);
    }

    @Override
    public @NotNull ResourceLocation getTextureLocation(@NotNull OvamorphDraco entity) {
        return TEXTURE;
    }
}
