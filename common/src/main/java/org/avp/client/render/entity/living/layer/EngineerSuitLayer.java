package org.avp.client.render.entity.living.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.renderer.layer.GeoRenderLayer;
import mod.azure.azurelib.common.internal.client.renderer.GeoRenderer;
import mod.azure.azurelib.common.internal.common.cache.object.BakedGeoModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;

import org.avp.client.model.entity.living.EngineerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Engineer;

/**
 * @author Boston Vanseghi
 */
public class EngineerSuitLayer extends GeoRenderLayer<Engineer> {

    private static final ResourceLocation SUIT_TEXTURE = AVPResources.entityTextureLocation("engineer_suit");

    private static final ResourceLocation JOCKEY_TEXTURE = AVPResources.entityTextureLocation("engineer_jockey");

    private final EngineerModel model;

    public EngineerSuitLayer(GeoRenderer<Engineer> entityRendererIn) {
        super(entityRendererIn);
        this.model = new EngineerModel();
    }

    @Override
    public void render(
        PoseStack poseStack,
        Engineer entity,
        BakedGeoModel bakedModel,
        RenderType renderType,
        MultiBufferSource bufferSource,
        VertexConsumer buffer,
        float partialTick,
        int packedLight,
        int packedOverlay
    ) {
        if (entity.isInvisible()) {
            return;
        }

        model.showHelmet(entity.hasHelmet());
        var suitRenderType = RenderType.entityCutout(entity.getSuitType() == 0 ? SUIT_TEXTURE : JOCKEY_TEXTURE);

        renderer.reRender(
            getDefaultBakedModel(entity),
            poseStack,
            bufferSource,
            entity,
            suitRenderType,
            buffer,
            partialTick,
            packedLight,
            packedOverlay,
            1F,
            1F,
            1F,
            1F
        );

        super.render(poseStack, entity, bakedModel, renderType, bufferSource, buffer, partialTick, packedLight, packedOverlay);
    }
}
