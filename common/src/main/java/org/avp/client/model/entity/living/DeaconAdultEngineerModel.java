package org.avp.client.model.entity.living;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DeaconAdultEngineer;

public class DeaconAdultEngineerModel extends GeoModel<DeaconAdultEngineer> {

    private static final String ENTITY_NAME = "deacon_adult_engineer";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(DeaconAdultEngineer entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(DeaconAdultEngineer entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(DeaconAdultEngineer entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(DeaconAdultEngineer entity, long instanceId, AnimationState<DeaconAdultEngineer> animationState) {
        BasicAnimationUtils.applyHeadRotations(this, animationState, "gNeck", -0.4F);
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
