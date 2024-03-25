package org.avp.client.model.entity.living;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;

import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DeaconAdult;

public class DeaconAdultModel extends GeoModel<DeaconAdult> {

    private static final String ENTITY_NAME = "deacon_adult";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(DeaconAdult entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(DeaconAdult entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(DeaconAdult entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(DeaconAdult entity, long instanceId, AnimationState<DeaconAdult> animationState) {
        BasicAnimationUtils.applyHeadRotations(this, animationState, "neck", -0.3F);
        BasicAnimationUtils.applyLimbRotations(
            entity,
            this,
            animationState,
            "gLeftShoulder",
            "gRightShoulder",
            "gLeftThigh",
            "gRightThigh",
            -0.35F,
            0.35F
        );
    }
}
