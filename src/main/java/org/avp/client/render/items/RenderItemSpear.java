package org.avp.client.render.items;

import org.avp.AVP;
import org.avp.client.model.entities.ModelSpear;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSpear extends ItemRenderer<ModelSpear>
{
    public RenderItemSpear()
    {
        super(AVP.resources().models().SPEAR);
    }   

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        super.renderThirdPersonLeft(itemstack, entity, cameraTransformType);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(90.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(55.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.scale(1F, 1F, 1F);
        OpenGL.enable(GL11.GL_CULL_FACE);
        
        if (Mouse.isButtonDown(1))
        {
            OpenGL.rotate(-55.0F, 0.0F, 0.0F, 1.0F);
        }
        
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.rotate(70.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(-0.5F, -0.2F, 0.4F);
        OpenGL.scale(1.6F, 1.6F, 1.6F);
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.6F, 0.6F, 0.6F);
        OpenGL.translate(0F, 0F, 0F);
        OpenGL.rotate(90F, 1F, 0F, 1F);
        OpenGL.rotate(-10F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
