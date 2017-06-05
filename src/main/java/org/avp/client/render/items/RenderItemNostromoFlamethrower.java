package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelNostromoFlamethrower;
import org.avp.item.ItemFirearm;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemNostromoFlamethrower extends ItemRenderer<ModelNostromoFlamethrower>
{
    public RenderItemNostromoFlamethrower()
    {
        super(AliensVsPredator.resources().models().FLAMETHROWER_NOSTROMO);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        
        OpenGL.translate(0F, 0.5F, 0F);
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        OpenGL.scale(0.5F, -0.5F, 0.5F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(15.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(15.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(190.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.5F, -0.27F, 1.2F);
        float glScale = 1.0F;
        OpenGL.scale(glScale, glScale, -glScale);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.rotate(10.0F, 1.0F, 0.0F, 0.0F);

            if (Mouse.isButtonDown(0) && mc.inGameHasFocus)
            {
                OpenGL.translate(0.8F, 0.7F, -0.76F);
                OpenGL.rotate(94.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(117.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(77.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(-0.26F, 0F, 0F);
            }
            else
            {
                OpenGL.translate(0.9F, 0.95F, -0.6F);
                OpenGL.rotate(70.0F, 1.0F, 0.0F, 0.0F);
                OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
                OpenGL.rotate(100.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.translate(0.2F, 0F, 0F);
            }

            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(glScale, glScale, -glScale);
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
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().draw();
    }

    public String getAmmoCountDisplayString()
    {
        int ammoCount = ((ItemFirearm) mc.player.inventory.getCurrentItem().getItem()).getAmmoCount();
        return (ammoCount < 10 ? "0" + ammoCount : String.valueOf(ammoCount));
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
