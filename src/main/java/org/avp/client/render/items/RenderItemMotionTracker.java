package org.avp.client.render.items;

import org.avp.AVP;
import org.avp.client.model.items.ModelMotionTracker;
import org.lwjgl.opengl.GL11;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemMotionTracker extends ItemRenderer<ModelMotionTracker>
{
    public RenderMotionTrackerScreen motionTracker = new RenderMotionTrackerScreen();

    public RenderItemMotionTracker()
    {
        super(AVP.resources().models().MOTIONTRACKER);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.2F;

        OpenGL.translate(0F, -0.15F, 0.175F);
        GlStateManager.disableCull();
        OpenGL.scale(-glScale, -glScale, -glScale);
        this.getModel().draw();
        this.drawDisplay();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;
        OpenGL.translate(0F, 0.35F, 0.4F);
        GlStateManager.disableCull();
        OpenGL.scale(-glScale, -glScale, -glScale);
        this.getModel().draw();
        OpenGL.scale(-1F, 1F, 1F);
        OpenGL.translate(-0.375F, 0F, 0F);
        this.drawDisplay();
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
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(-1F, 1F, 1F);
        float glScale = 0.8F;
        OpenGL.translate(0F, 0.35F, 0.4F);
        GlStateManager.disableCull();
        OpenGL.scale(-glScale, -glScale, -glScale);
        this.getModel().draw();
        this.drawDisplay();
    }
}
