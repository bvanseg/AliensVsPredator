package org.avp.client.render.entity.layer;

import com.asx.mdx.client.ClientGame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.item.ItemStack;
import org.avp.common.AVPItems;
import org.avp.common.entity.living.EntityMarine;

/**
 * @author Boston Vanseghi
 */
public class LayerFollowIcon implements LayerRenderer<EntityMarine> {
    @Override
    public void doRenderLayer(EntityMarine entityMarine, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
        if (entityMarine.getSquadLeaderID().isPresent() && entityMarine.getSquadLeaderID().get().equals(ClientGame.instance.minecraft().player.getUniqueID())) {
            GlStateManager.pushMatrix();
            GlStateManager.translate(0.0F, -0.9F, 0.0F);
            GlStateManager.rotate(-180.0F, 1.0F, 0.0F, 0.0F);
            GlStateManager.scale(0.8F, 0.8F, 0.8F);
            Minecraft.getMinecraft().getItemRenderer().renderItemSide(entityMarine, new ItemStack(AVPItems.HELM_MARINE), ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND, false);
            GlStateManager.popMatrix();
        }
    }

    @Override
    public boolean shouldCombineTextures() {
        return true;
    }
}