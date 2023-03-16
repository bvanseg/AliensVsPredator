package org.avp.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.avp.client.model.item.ModelStunBaton;

public class RenderItemStunBaton extends ItemRenderer<ModelStunBaton>
{
    public RenderItemStunBaton()
    {
        super(Resources.instance.models().STUNBATON);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1.1F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.12F, 0.1F);
        OpenGL.rotate(180.0F, 1.0F, 0.0F, 1.0F);
        OpenGL.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
        Resources.instance.models().STUNBATON.draw();
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
        Resources.instance.models().STUNBATON.draw();
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
        Resources.instance.models().STUNBATON.draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        GlStateManager.disableCull();
        this.getModel().draw();
        Resources.instance.models().STUNBATON.draw();
    }
}
