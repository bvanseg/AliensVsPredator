package org.avp.client.model.entity.living;

import mod.azure.azurelib.common.api.client.model.GeoModel;
import mod.azure.azurelib.common.internal.common.core.animation.AnimationState;
import net.minecraft.resources.ResourceLocation;

import org.avp.common.AVPResources;
import org.avp.common.entity.living.Belugaburster;

public class BelugabursterModel extends GeoModel<Belugaburster> {

    private static final String ENTITY_NAME = "belugaburster";

    private static final ResourceLocation MODEL_LOCATION = AVPResources.entityGeoLocation(ENTITY_NAME);

    private static final ResourceLocation TEXTURE_LOCATION = AVPResources.entityTextureLocation(ENTITY_NAME);

    private static final ResourceLocation ANIMATION_LOCATION = AVPResources.entityAnimationLocation(ENTITY_NAME);

    @Override
    public ResourceLocation getModelResource(Belugaburster entity) {
        return MODEL_LOCATION;
    }

    @Override
    public ResourceLocation getTextureResource(Belugaburster entity) {
        return TEXTURE_LOCATION;
    }

    @Override
    public ResourceLocation getAnimationResource(Belugaburster entity) {
        return ANIMATION_LOCATION;
    }

    @Override
    public void setCustomAnimations(Belugaburster entity, long instanceId, AnimationState<Belugaburster> animationState) {
        // TODO:
    }
}
