package org.avp.client.model.entity.living;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;

import net.minecraft.resources.ResourceLocation;
import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Engineer;
import org.avp.common.entity.living.Ultramorph;

public class EngineerModel extends GeoModel<Engineer> {

    private static final String ENTITY_NAME = "engineer";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(Engineer entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(Engineer entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(Engineer entity) {
        return ANIMATION_LOCATION;
    }

    public void showHelmet(boolean showHelmet) {
        var helmet = this.getBone("gHelmet");
        helmet.ifPresent(bone -> bone.setHidden(!showHelmet));
    }

    @Override
    public void setCustomAnimations(Engineer entity, long instanceId, AnimationState<Engineer> animationState) {
        BasicAnimationUtils.applyHeadRotations(this, animationState, "gNeck", -0.2F);
        BasicAnimationUtils.applyLimbRotations(
            entity,
            this,
            animationState,
            "gLeftArm",
            "gRightArm",
            "gLeftLeg",
            "gRightLeg",
            -0.35F,
            0F
        );
    }
}
