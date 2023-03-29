package org.weapon.client.render.item.firearm;

import com.asx.mdx.client.ClientGame;
import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.model.texture.Texture;
import com.asx.mdx.common.net.Networks;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.common.URLs;
import org.lwjgl.input.Mouse;
import org.weapon.client.model.item.ModelAK47;
import org.weapon.client.render.item.ItemFirearmRenderer;

public class RenderItemAK47 extends ItemFirearmRenderer<ModelAK47>
{
    public RenderItemAK47()
    {
        super(Resources.instance.models().AK47);
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

            if (Mouse.isButtonDown(0) && ClientGame.instance.minecraft().inGameHasFocus && !isDualWielding(entity))
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
        new Texture(Networks.downloadResource(String.format(URLs.SKIN_AK47, ClientGame.instance.session().getPlayerID()), this.getModel().getTexture())).bind();
        this.getModel().getModel().render();
    }
}
