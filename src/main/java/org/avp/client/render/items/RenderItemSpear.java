package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.ModelSpear;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSpear extends ItemRenderer<ModelSpear>
{
    public RenderItemSpear()
    {
        super(AliensVsPredator.resources().models().SPEAR);
    }   

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(175.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(55.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.25F, 0.75F, 0.065F);
        OpenGL.scale(1F, 1F, 1F);
        OpenGL.enable(GL11.GL_CULL_FACE);
        if (Mouse.isButtonDown(1))
        {
            OpenGL.rotate(90.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.translate(0.25F, -0.2F, 0F);
        }
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(170.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(10.0F, 0.0F, 0.0F, 1.0F);

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.2F, -0.4F, -0.5F);
            OpenGL.rotate(270.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(50.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(9.0F, 0.0F, 0.0F, 1.0F);
        }
        else
        {
            OpenGL.translate(0.45F, 0.0F, 0.0F);
        }

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
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }
}
