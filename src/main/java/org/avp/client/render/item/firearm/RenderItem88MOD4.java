package org.avp.client.render.item.firearm;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.model.item.Model88MOD4;
import org.avp.client.render.item.ItemFirearmRenderer;
import org.lwjgl.input.Mouse;

public class RenderItem88MOD4 extends ItemFirearmRenderer<Model88MOD4>
{
    public RenderItem88MOD4()
    {
        super(AVP.resources().models()._88MOD4);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.1F, -0.2F);
        GlStateManager.disableCull();
        OpenGL.scale(0.8F, -0.8F, 0.8F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            float glScale = 1F;
            OpenGL.translate(0.25F, 0.16F, -0.5F);

            if (Mouse.isButtonDown(0) && ClientGame.instance.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-0.77F, 0.25F, 0.35F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(-glScale, -glScale, glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(220, 0F, 1F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.3F, 1F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
