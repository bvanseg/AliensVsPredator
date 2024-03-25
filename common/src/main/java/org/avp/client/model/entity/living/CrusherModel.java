package org.avp.client.model.entity.living;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;

import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.Crusher;

public class CrusherModel extends GeoModel<Crusher> {

    private static final String ENTITY_NAME = "crusher";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(Crusher entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(Crusher entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(Crusher entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(Crusher entity, long instanceId, AnimationState<Crusher> animationState) {
        BasicAnimationUtils.applyHeadRotations(this, animationState, "gNeck", -1.8F);
        BasicAnimationUtils.applyLimbRotations(
            entity,
            this,
            animationState,
            "gLeftArm",
            "gRightArm",
            "gLeftLeg",
            "gRightLeg",
            -0.38F,
            0.35F
        );
    }
}
