package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelAK47;
import org.avp.common.URLs;
import org.lwjgl.input.Mouse;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.Texture;
import com.asx.mdx.lib.util.Game;
import com.asx.mdx.lib.util.Networks;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemAK47 extends ItemFirearmRenderer<ModelAK47>
{
    public RenderItemAK47()
    {
        super(AliensVsPredator.resources().models().AK47);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.1F, 0.5F, -0.5F);
        OpenGL.scale(1F, -1F, 1F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.1F, 0.2F, 0.4F);
        GlStateManager.disableCull();
        OpenGL.scale(-1.1F, -1.1F, -1.1F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(1F, 0.2F, 0.2F);

            if (Mouse.isButtonDown(0) && Game.minecraft().inGameHasFocus && !isDualWielding(entity))
            {
                OpenGL.translate(-1.735F, 0.24F, 0.8F);
            }

            float glScale = 2.0F;
            OpenGL.scale(glScale, -glScale, -glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.4F, -0.3F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        GlStateManager.disableCull();
        new Texture(Networks.downloadResource(String.format(URLs.SKIN_AK47, Game.session().getPlayerID()), this.getModel().getTexture())).bind();
        this.getModel().getModel().render();
    }
}
