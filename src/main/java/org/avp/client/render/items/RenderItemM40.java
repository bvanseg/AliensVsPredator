package org.avp.client.render.items;

import org.avp.client.model.items.ModelM40;

import com.arisux.mdx.lib.client.util.ItemRenderer;
import com.arisux.mdx.lib.client.util.OpenGL;
import com.arisux.mdx.lib.client.util.models.MapModelTexture;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemM40 extends ItemRenderer<ModelM40>
{
    public RenderItemM40(MapModelTexture<ModelM40> model)
    {
        super(model);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.4F;
        OpenGL.translate(0F, 0F, -0.05F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.3F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0F, 0.2F, 0.1F);
            GlStateManager.disableCull();
            OpenGL.scale(glScale, -glScale, glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.1F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        OpenGL.enableBlend();
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -0.5F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
