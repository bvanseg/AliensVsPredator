package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.Model;
import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.wavefront.Part;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemAPC extends ItemRenderer<Model>
{
    public RenderItemAPC()
    {
        super(null);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.25F;
            OpenGL.scale(scale, scale, scale);
            OpenGL.translate(6.5F, 1.5F, 0F);
            OpenGL.rotate(15F, 0F, 1F, 1F);
            OpenGL.disable(GL11.GL_CULL_FACE);

            for (Part p : AliensVsPredator.resources().models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.75F;
            OpenGL.scale(scale, scale, scale);
            OpenGL.translate(-0.5F, 4.0F, 0F);
            OpenGL.rotate(110F, 0F, 0F, 1F);
            OpenGL.rotate(16F, 1F, 0F, 0F);
            OpenGL.disable(GL11.GL_CULL_FACE);

            for (Part p : AliensVsPredator.resources().models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float scale = 0.2F;
            OpenGL.scale(scale, scale, scale);
            OpenGL.translate(0F, -1F, 0F);
            OpenGL.rotate(230F, 1F, 0F, 0F);
            OpenGL.rotate(180F, 0F, 0F, 1F);
            OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);

            for (Part p : AliensVsPredator.resources().models().M577_APC.parts.values())
            {
                p.draw();
            }
        }
        OpenGL.popMatrix();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.scale(0.2F, 0.2F, 0.2F);
            OpenGL.translate(0, -1F, 0);
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);

            for (Part p : AliensVsPredator.resources().models().M577_APC.parts.values())
            {
                p.draw();
            }
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
