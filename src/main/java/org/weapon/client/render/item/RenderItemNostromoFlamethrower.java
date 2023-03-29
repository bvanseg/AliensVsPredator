package org.weapon.client.render.item;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.lwjgl.input.Mouse;
import org.weapon.client.model.item.ModelSevastopolFlamethrower;
import org.weapon.common.item.firearm.ItemFirearm;

public class RenderItemNostromoFlamethrower extends ItemFirearmRenderer<ModelSevastopolFlamethrower>
{
    public RenderItemNostromoFlamethrower()
    {
        super(Resources.instance.models().SEVASTOPOL_FLAMETHROWER);
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

            if (Mouse.isButtonDown(0) && ClientGame.instance.minecraft().inGameHasFocus && !isDualWielding(entity))
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
        ItemStack itemStack =ClientGame.instance.minecraft().player.inventory.getCurrentItem();
        int ammoCount = ((ItemFirearm)itemStack.getItem()).getAmmoCount(itemStack);
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
    }
}
