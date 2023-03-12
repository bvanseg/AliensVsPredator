package org.avp.client.render.items;

import org.avp.AVP;
import org.avp.client.model.tile.ModelLocker;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemLocker extends ItemRenderer<ModelLocker>
{
    public RenderItemLocker()
    {
        super(AVP.resources().models().LOCKER);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.6F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(0F, -0.5F, -0.5F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.5F;
        OpenGL.rotate(90, 0, 1, 0);
        OpenGL.translate(0.2F, 0.2F, 0.3F);
        OpenGL.scale(scale, scale, scale);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.45F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.35F, 0.275F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F + this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1.5F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
