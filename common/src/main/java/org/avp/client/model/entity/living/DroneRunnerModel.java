package org.avp.client.model.entity.living;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;
import org.avp.client.util.BasicAnimationUtils;
import org.avp.common.AVPResources;
import org.avp.common.entity.living.DroneRunner;

public class DroneRunnerModel extends GeoModel<DroneRunner> {

    private static final String ENTITY_NAME = "drone_runner";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(DroneRunner entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(DroneRunner entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(DroneRunner entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(DroneRunner entity, long instanceId, AnimationState<DroneRunner> animationState) {
        BasicAnimationUtils.applyHeadRotations(this, animationState, "gNeck", 0.4F);
        BasicAnimationUtils.applyLimbRotations(
            entity,
            this,
            animationState,
            "gLeftArm",
            "gRightArm",
            "gLeftLeg",
            "gRightLeg",
            -0.35F,
            0.35F
        );
    }
}
