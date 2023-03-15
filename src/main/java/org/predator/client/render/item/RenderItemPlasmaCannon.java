package org.predator.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.lwjgl.opengl.GL11;
import org.predator.client.model.item.ModelPlasmaCannon;

public class RenderItemPlasmaCannon extends ItemRenderer<ModelPlasmaCannon>
{
    public RenderItemPlasmaCannon()
    {
        super(Resources.instance.models().PLASMACANNON);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0.1F, 0.2F, -0.7F);
        OpenGL.rotate(10.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.disableCullFace();
        OpenGL.scale(0.8F, -0.8F, 0.8F);
        this.getModel().draw();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0F, 0.2F, -0.45F);
        OpenGL.scale(0.75F, -0.75F, 0.75F);
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(-0.35F, -0.25F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        OpenGL.enable(GL11.GL_BLEND);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
