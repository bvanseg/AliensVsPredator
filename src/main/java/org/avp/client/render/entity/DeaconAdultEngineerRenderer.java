package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.DeaconAdultEngineerModel;
import org.avp.common.entity.DeaconAdultEngineerEntity;

public class DeaconAdultEngineerRenderer extends MobRenderer<DeaconAdultEngineerEntity, DeaconAdultEngineerModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("deacon_adult_engineer");

    public DeaconAdultEngineerRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new DeaconAdultEngineerModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(DeaconAdultEngineerEntity entity) {
        return TEXTURE;
    }
}
