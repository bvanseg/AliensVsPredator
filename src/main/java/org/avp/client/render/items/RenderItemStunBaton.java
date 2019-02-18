package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.items.ModelStunBaton;

import com.arisux.mdx.lib.client.util.ItemRenderer;
import com.arisux.mdx.lib.client.util.OpenGL;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemStunBaton extends ItemRenderer<ModelStunBaton>
{
    public RenderItemStunBaton()
    {
        super(AliensVsPredator.resources().models().STUNBATON);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.1F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.1F, 0.1F);
        OpenGL.rotate(180.0F, 1.0F, 0.0F, 1.0F);
        OpenGL.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
        AliensVsPredator.resources().models().STUNBATON.draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.25F, 0.2F);
        OpenGL.rotate(180.0F, 1.0F, 0F, 0F);
        OpenGL.rotate(-15.0F, 0.0F, 1F, 0F);
        OpenGL.rotate(-25.0F, 1.0F, 0F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
        AliensVsPredator.resources().models().STUNBATON.draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.3F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(-0.1F, -0.1F, 0F);
        OpenGL.rotate(180F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        this.getModel().draw();
        AliensVsPredator.resources().models().STUNBATON.draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        GlStateManager.disableCull();
        this.getModel().draw();
        AliensVsPredator.resources().models().STUNBATON.draw();
    }
}
