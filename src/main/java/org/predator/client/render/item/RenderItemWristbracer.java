package org.predator.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.predator.client.model.item.ModelWristBlade;
import org.predator.common.item.ItemWristbracer;

public class RenderItemWristbracer extends ItemRenderer<ModelWristBlade>
{
    public RenderItemWristbracer()
    {
        super(Resources.instance.models().WRISTBLADES);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        if (firstPersonRenderCheck(entity))
        {
            boolean shouldRenderBlades = ItemWristbracer.hasBlades(itemstack);

            OpenGL.translate(0.4F, -0.1F, 0.2F);
            OpenGL.rotate(186.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(-120.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(-55.0F, 0.0F, 0.0F, 1.0F);

            GlStateManager.disableCull();
            OpenGL.scale(1.6F, 1.6F, 1.6F);
            this.getModel().draw();

            if (shouldRenderBlades)
            {
                this.getModel().getModel().renderBlades();
            }
            GlStateManager.enableCull();
        }
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        boolean shouldRenderBlades = ItemWristbracer.hasBlades(itemstack);

        OpenGL.rotate(-90.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(0.35F, 0.1F, -0.1F);
        OpenGL.scale(-1.5F, -1.5F, 1.5F);
        this.getModel().draw();

        if (shouldRenderBlades)
        {
            this.getModel().getModel().renderBlades();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        boolean shouldRenderBlades = ItemWristbracer.hasBlades(itemstack);
        float bladeXOffset = shouldRenderBlades ? 0F : 0.125F;
        float bladeYOffset = shouldRenderBlades ? 0F : 0.035F;

        float scale = 2F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(-0.25F + bladeXOffset, -0.15F + bladeYOffset, 0F);
        OpenGL.rotate(220F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        OpenGL.disableCullFace();
        this.getModel().draw();

        if (shouldRenderBlades)
        {
            this.getModel().getModel().renderBlades();
        }

        OpenGL.enableCullFace();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        boolean shouldRenderBlades = ItemWristbracer.hasBlades(itemstack);
        OpenGL.rotate(-180F, 0F, 0F, 1F);
        OpenGL.translate(shouldRenderBlades ? -0.3F : -0.12F, 0F, -0.07F);
        GlStateManager.disableCull();
        this.getModel().draw();

        if (shouldRenderBlades)
        {
            this.getModel().getModel().renderBlades();
        }

        OpenGL.enableCullFace();
    }
}
