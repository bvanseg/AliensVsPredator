package org.predator.client.render.entity;

import com.asx.mdx.client.ClientGame;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.predator.common.PredatorItems;
import org.predator.common.entity.EntityShuriken;

public class RenderShuriken extends Render<EntityShuriken>
{
    private static final ItemStack SHURIKEN_STACK = new ItemStack(PredatorItems.ITEM_SHURIKEN);

    public RenderShuriken(RenderManager m)
    {
        super(m);
    }

    @Override
    public void doRender(EntityShuriken entity, double posX, double posY, double posZ, float yaw, float renderPartialTicks)
    {
        GlStateManager.pushMatrix();

        GlStateManager.translate(posX, posY, posZ);
        GlStateManager.rotate(entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * renderPartialTicks, 0.0F, 0.0F, 1.0F);
        GlStateManager.rotate(entity.prevRotationYaw + (entity.rotationYaw - entity.prevRotationYaw) * renderPartialTicks - 90.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();

        if (!entity.isInGround())
            GlStateManager.rotate(360 - (entity.world.getTotalWorldTime() % 360 + ClientGame.instance.partialTicks()) * 60, 0, 1, 0);

        GlStateManager.translate(-0.0F, 0.15F, -0.25F);
        GlStateManager.glNormal3f(0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(90, 1, 0, 0);

        Minecraft.getMinecraft().getItemRenderer().itemRenderer.renderItem(SHURIKEN_STACK, ItemCameraTransforms.TransformType.THIRD_PERSON_RIGHT_HAND);

        GlStateManager.enableCull();

        GlStateManager.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityShuriken entity)
    {
        return null;
    }
}
