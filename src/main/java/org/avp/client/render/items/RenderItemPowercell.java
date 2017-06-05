package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.tile.ModelPowercell;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemPowercell extends ItemRenderer<ModelPowercell>
{
    public RenderItemPowercell()
    {
        super(AliensVsPredator.resources().models().POWERCELL);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.6F;
        OpenGL.pushMatrix();
        {
            OpenGL.scale(glScale, glScale, glScale);
            OpenGL.rotate(90F, 0F, 0F, 1F);
            OpenGL.translate(0F, -1.3F, 0.4F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
            AliensVsPredator.resources().models().POWERCELL_LIQUID.draw();

        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;
        OpenGL.pushMatrix();
        {
            if (firstPersonRenderCheck(entity))
            {
                OpenGL.scale(glScale, glScale, glScale);
                OpenGL.translate(1.5F, -0.3F, 0.2F);
                OpenGL.rotate(45.0F, 0.0F, 0.0F, 1.0F);
                OpenGL.disable(GL11.GL_CULL_FACE);
                this.getModel().draw();
                AliensVsPredator.resources().models().POWERCELL_LIQUID.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.7F, 0.5F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
        AliensVsPredator.resources().models().POWERCELL_LIQUID.draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

        OpenGL.pushMatrix();
        {
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();
            AliensVsPredator.resources().models().POWERCELL_LIQUID.draw();
        }
        OpenGL.popMatrix();
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
