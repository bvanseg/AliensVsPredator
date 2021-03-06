package org.power.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.power.client.model.tile.ModelBlastdoor;

public class RenderItemBlastDoor extends ItemRenderer<ModelBlastdoor>
{
    public RenderItemBlastDoor()
    {
        super(Resources.instance.models().BLASTDOOR);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;

        OpenGL.rotate(10F, 0F, 0F, 1F);
        OpenGL.rotate(120F, 0F, 1F, 0F);
        OpenGL.translate(-0.9F, 0.7F, 0.1F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();
        GlStateManager.enableCull();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.3F;
        OpenGL.translate(0.2F, 0.4F, 0.5F);
        OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, glScale, glScale);
        this.getModel().draw();
        GlStateManager.enableCull();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.25F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F + this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        OpenGL.translate(-1.5F, 0F, 0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.25F, -0.25F, 0.25F);
        OpenGL.translate(0F, -1.5F, 0F);
        OpenGL.translate(-1.5F, 0F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
        GlStateManager.enableCull();
    }
}
