package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelWristBlade;
import org.avp.item.ItemWristbracer;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class RenderItemWristbracer extends ItemRenderer<ModelWristBlade>
{
    public RenderItemWristbracer()
    {
        super(AliensVsPredator.resources().models().WRISTBLADES);
    }
    
    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        EntityPlayer playerToRender = (EntityPlayer) entity;
        OpenGL.rotate(186.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(3.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(-35.0F, 0.0F, 0.0F, 1.0F);

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.4F, 0.1F, -0.1F);
            OpenGL.rotate(340.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(-30.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(-70.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
        }
        else
        {
            OpenGL.translate(0.45F, 0.0F, 0.0F);
        }

        OpenGL.scale(1.6F, 1.6F, 1.6F);
        this.getModel().draw();

        if (playerToRender != null && ItemWristbracer.equippedHasBlades(playerToRender))
        {
            Model.draw(this.getModel().getModel().b6);
            Model.draw(this.getModel().getModel().bladeLeft);
        }
        OpenGL.enableCullFace();
    }
    
    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        EntityPlayer playerToRender = (EntityPlayer) entity;

        OpenGL.rotate(-78.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(-165.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(13.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.25F, -0.15F, 0.3F);
        OpenGL.scale(2F, 2F, 2F);
        this.getModel().draw();

        if (playerToRender != null && ItemWristbracer.equippedHasBlades(playerToRender))
        {
            Model.draw(this.getModel().getModel().b6);
            Model.draw(this.getModel().getModel().bladeLeft);
        }
    }
    
    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 2F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(-0.25F, -0.15F, 0F);
        OpenGL.rotate(220F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.disableCullFace();
        this.getModel().draw();
        Model.draw(this.getModel().getModel().b6);
        Model.draw(this.getModel().getModel().bladeLeft);
        OpenGL.enableCullFace();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        
        OpenGL.pushMatrix();
        {
            OpenGL.rotate(((mc.world.getWorldTime() % 360) + Game.partialTicks()) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
            Model.draw(this.getModel().getModel().b6);
            Model.draw(this.getModel().getModel().bladeLeft);
            OpenGL.enableCullFace();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        super.renderThirdPersonLeft(itemstack, entity, cameraTransformType);
    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        // TODO Auto-generated method stub
        
    }
}
