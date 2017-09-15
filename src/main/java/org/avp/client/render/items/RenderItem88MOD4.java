package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.Model88MOD4;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItem88MOD4 extends ItemRenderer<Model88MOD4>
{
    public RenderItem88MOD4()
    {
        super(AliensVsPredator.resources().models()._88MOD4);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.1F, -0.2F);
        OpenGL.disable(GL11.GL_CULL_FACE);
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

            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                OpenGL.translate(-0.77F, 0.25F, 0.35F);
            }

            OpenGL.disable(GL11.GL_CULL_FACE);
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
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.3F, 1F, 0F);
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

    }
}
