package org.avp.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.client.model.tile.ModelWorkstation;

public class RenderItemWorkstation extends ItemRenderer<ModelWorkstation>
{
    public RenderItemWorkstation()
    {
        super(Resources.instance.models().WORKSTATION);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1F;

        OpenGL.rotate(10F, 0F, 0F, 1F);
        OpenGL.rotate(12F, 0F, 1F, 0F);
        OpenGL.translate(-0.1F, 0.3F, -0.2F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;

        OpenGL.translate(-0.1F, 0.5F, 0.1F);
        OpenGL.rotate(115.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(110.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(75.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, glScale, glScale);
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.2F, 0F);
        OpenGL.rotate(210F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
