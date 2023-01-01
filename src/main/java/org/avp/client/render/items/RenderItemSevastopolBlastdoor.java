package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.tile.ModelSevastopolBlastdoor;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSevastopolBlastdoor extends ItemRenderer<ModelSevastopolBlastdoor>
{
    public RenderItemSevastopolBlastdoor()
    {
        super(AliensVsPredator.resources().models().BLASTDOOR_SEVASTOPOL);
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
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.3F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(-0.45F, 0.15F, 1F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(20F, 0.0F, 1.0F, 0.0F);
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
    }
}
