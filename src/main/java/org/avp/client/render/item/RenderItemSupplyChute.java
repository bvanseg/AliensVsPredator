package org.avp.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.model.entity.ModelSupplyChute;
import org.avp.common.item.supply.chute.ItemSupplyChute;

public class RenderItemSupplyChute extends ItemRenderer<ModelSupplyChute>
{
    public RenderItemSupplyChute()
    {
        super(null);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.5F, 0.5F, -0.5F);
        OpenGL.rotate(-45F, 0F, 1F, 0F);
        OpenGL.rotate(90F, 1F, 0F, 0F);
        OpenGL.translate(0F, -0.75F, -0.2F);
        GlStateManager.disableCull();
        ((ItemSupplyChute) itemstack.getItem()).getType().getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.5, 0.5, -0.75F);
        OpenGL.scale(0.75F, -0.75F, 0.75F);
        GlStateManager.disableCull();
        ((ItemSupplyChute) itemstack.getItem()).getType().getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.45F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, 0F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        ((ItemSupplyChute) itemstack.getItem()).getType().getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1.5F, 0F);
        GlStateManager.disableCull();
        ((ItemSupplyChute) itemstack.getItem()).getType().getModel().draw();
    }
}
