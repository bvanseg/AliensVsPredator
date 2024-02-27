package org.avp.client.render.entity;

import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

import org.avp.AVPResources;
import org.avp.client.model.entity.DeaconAdultModel;
import org.avp.common.entity.DeaconAdultEntity;

public class DeaconAdultRenderer extends MobRenderer<DeaconAdultEntity, DeaconAdultModel> {

    private static final ResourceLocation TEXTURE = AVPResources.entityTextureLocation("deacon_adult");

    public DeaconAdultRenderer(EntityRendererManager entityRendererManager) {
        super(entityRendererManager, new DeaconAdultModel(), 0F);
    }

    @Override
    protected ResourceLocation getEntityTexture(DeaconAdultEntity entity) {
        return TEXTURE;
    }
}
