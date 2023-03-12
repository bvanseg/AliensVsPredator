package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelSevastopolFlamethrower;
import org.avp.item.firearms.ItemFirearm;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemNostromoFlamethrower extends ItemFirearmRenderer<ModelSevastopolFlamethrower>
{
    public RenderItemNostromoFlamethrower()
    {
        super(AliensVsPredator.resources().models().SEVASTOPOL_FLAMETHROWER);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.5F, 0F);
        OpenGL.scale(0.5F, -0.5F, 0.5F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.2F, -0.4F);
        float glScale = 0.45F;
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0F, 0.35F, -0.9F);

            if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-0.5595F, 0F, 0F);
            }

            GlStateManager.disableCull();
            OpenGL.scale(glScale, -glScale, glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.45F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(-0.4F, -0.4F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    public String getAmmoCountDisplayString()
    {
        int ammoCount = ((ItemFirearm) Game.minecraft().player.inventory.getCurrentItem().getItem()).getAmmoCount();
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
    }
}
