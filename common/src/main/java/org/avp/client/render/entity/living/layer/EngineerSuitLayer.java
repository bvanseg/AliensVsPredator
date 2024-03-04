package org.avp.client.render.entity.living.layer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

import org.avp.client.model.entity.living.EngineerModel;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Engineer;

/**
 * @author Boston Vanseghi
 */
public class EngineerSuitLayer extends RenderLayer<Engineer, EngineerModel> {

    private static final ResourceLocation SUIT_TEXTURE = AVPResources.entityTextureLocation("engineer_suit");

    private static final ResourceLocation JOCKEY_TEXTURE = AVPResources.entityTextureLocation("engineer_jockey");

    private final EngineerModel model;

    public EngineerSuitLayer(RenderLayerParent<Engineer, EngineerModel> $$0, EntityModelSet $$1) {
        super($$0);
        this.model = new EngineerModel($$1.bakeLayer(EngineerModel.ARMOR_LAYER_LOCATION));
    }

    @Override
    public void render(
        PoseStack poseStack,
        MultiBufferSource multiBufferSource,
        int i,
        Engineer engineer,
        float v,
        float v1,
        float v2,
        float v3,
        float v4,
        float v5
    ) {
        if (engineer.isInvisible()) {
            return;
        }

        model.showHelmet(engineer.hasHelmet());

        if (engineer.getSuitType() == 0) {
            renderColoredCutoutModel(model, SUIT_TEXTURE, poseStack, multiBufferSource, i, engineer, 1.0F, 1.0F, 1.0F);
        } else {
            renderColoredCutoutModel(
                model,
                JOCKEY_TEXTURE,
                poseStack,
                multiBufferSource,
                i,
                engineer,
                1.0F,
                1.0F,
                1.0F
            );
        }
    }
}
