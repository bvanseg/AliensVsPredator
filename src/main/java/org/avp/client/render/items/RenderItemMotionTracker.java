package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelMotionTracker;
import org.lwjgl.opengl.GL11;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.game.Game;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemMotionTracker extends ItemRenderer<ModelMotionTracker>
{
    public RenderMotionTrackerScreen motionTracker = new RenderMotionTrackerScreen();

    public RenderItemMotionTracker()
    {
        super(AliensVsPredator.resources().models().MOTIONTRACKER);
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
        this.drawDisplay();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(-0.1F, 0.6F, -1.4F);
            OpenGL.rotate(102F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(115.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(79F, 0.0F, 0.0F, 1.0F);
            OpenGL.translate(0.027F, 0F, 0F);
            OpenGL.disable(GL11.GL_CULL_FACE);
            OpenGL.scale(glScale, glScale, glScale);
            this.getModel().draw();
            this.drawDisplay();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(-0.2F, -0.15F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    private void drawDisplay()
    {
        float displayScale = 0.004F;
        OpenGL.disable(GL11.GL_LIGHTING);
        OpenGL.scale(displayScale, displayScale, displayScale);
        OpenGL.rotate(90F, 0F, 1F, 0F);
        OpenGL.translate(-89.122F, -35F, 21F);
        OpenGL.rotate(-90F, 0F, 1F, 0F);
        OpenGL.scale(0.4F, 0.4F, 0.4F);
        OpenGL.disableLight();
        motionTracker.draw(0, 0, 128, 96);
        OpenGL.enableLight();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
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
