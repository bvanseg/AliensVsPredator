package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelM4;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemM4 extends ItemFirearmRenderer<ModelM4>
{
    public RenderItemM4()
    {
        super(AliensVsPredator.resources().models().M4);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.3F, 1F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.3, 0.9F, -0.15F);
        GlStateManager.disableCull();
        OpenGL.scale(1.2F, -1.2F, -1.2F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            float glScale = 1.0F;
            OpenGL.translate(0F, 0.85F, 0F);

            if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-0.8095F, 0.165F, 0.4F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(-glScale, -glScale, -glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.5F, 0.4F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
