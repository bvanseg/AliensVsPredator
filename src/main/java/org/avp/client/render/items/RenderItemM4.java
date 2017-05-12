package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelM4;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemM4 extends ItemRenderer<ModelM4>
{
    public RenderItemM4()
    {
        super(AliensVsPredator.resources().models().M4);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(0.3F, 1F, 0F);
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.2F, 1.15F, 0.25F);
        OpenGL.rotate(97.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(130.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.scale(1.2F, 1.2F, 1.2F);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                OpenGL.translate(0.3F, 2.0F, -0.409F);
                OpenGL.rotate(103.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(114.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(78.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0.0F, 0.0F, -0.46F);
            }
            else
            {
                OpenGL.translate(0.6F, 1.85F, 0.9F);
                OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(80.0F, 0.0F, 0.0F, 1.0F);
            }

            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(2.0F, 2.0F, 2.0F);
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
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub

    }
}
