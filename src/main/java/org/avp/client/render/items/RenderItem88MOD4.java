package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.Model88MOD4;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

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
        OpenGL.translate(0.37F, 0.25F, 0.25F);
        OpenGL.rotate(20, 1F, 0F, 0F);
        OpenGL.rotate(10, 0F, 0F, 1F);
        OpenGL.rotate(15, 0F, 1F, 0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.scale(1.2F, -1.2F, -1.2F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                OpenGL.translate(1.7F, 1.5F, -0.885F);
                OpenGL.rotate(100.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(122.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(81.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0F, 0F, -0.45F);
            }
            else
            {
                OpenGL.translate(2F, 0.95F, 0.9F);
                OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
            }

            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(2.0F, 2.0F, -2.0F);
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
