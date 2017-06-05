package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.tile.ModelCryostasisTube;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemCryostasisTube extends ItemRenderer<ModelCryostasisTube>
{
    public RenderItemCryostasisTube()
    {
        super(AliensVsPredator.resources().models().CRYOSTASIS_TUBE);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.6F;

        OpenGL.rotate(10F, 0F, 0F, 1F);
        OpenGL.rotate(12F, 0F, 1F, 0F);
        OpenGL.translate(0.4F, -0.1F, 0F);
        OpenGL.disable(GL11.GL_CULL_FACE);
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();

        OpenGL.pushMatrix();
        {
            AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK.draw();
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.1F, 1.0F, 0.2F);
            OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(79.0F, 0.0F, 0.0F, 1.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(glScale, glScale, glScale);
            this.getModel().draw();

            OpenGL.pushMatrix();
            {
                AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK.draw();
            }
            OpenGL.popMatrix();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.25F, 0.1F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(230F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
        AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK.draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {

        OpenGL.pushMatrix();
        {
            OpenGL.scale(0.5F, -0.5F, 0.5F);
            OpenGL.translate(0F, -1.5F, 0F);
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            this.getModel().draw();

            OpenGL.pushMatrix();
            {
                OpenGL.enable(GL11.GL_BLEND);
                AliensVsPredator.resources().models().CRYOSTASIS_TUBE_MASK.draw();
            }
            OpenGL.popMatrix();
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
