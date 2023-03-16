package org.predator.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import com.asx.mdx.client.render.model.Model;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.predator.client.model.item.ModelWristBlade;

public class RenderItemWristbracerBlades extends ItemRenderer<ModelWristBlade>
{
    public RenderItemWristbracerBlades()
    {
        super(AVP.resources().models().WRISTBLADES);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(-78.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(-165.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(13.0F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.25F, -0.15F, 0.3F);
        OpenGL.scale(2F, 2F, 2F);
        this.getModel().getTexture().bind();
        this.getModel().getModel().b6.render(Model.DEFAULT_SCALE);
        this.getModel().getModel().bladeLeft.render(Model.DEFAULT_SCALE);
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(186.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(3.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(-35.0F, 0.0F, 0.0F, 1.0F);

        if (firstPersonRenderCheck(entity))
        {
            OpenGL.translate(0.4F, 0.1F, -0.1F);
            OpenGL.rotate(340.0F, 1.0F, 0.0F, 0.0F);
            OpenGL.rotate(-30.0F, 0.0F, 1.0F, 0.0F);
            OpenGL.rotate(-70.0F, 0.0F, 0.0F, 1.0F);
            GlStateManager.disableCull();
        }
        else
        {
            OpenGL.translate(0.45F, 0.0F, 0.0F);
        }

        OpenGL.scale(1.6F, 1.6F, 1.6F);
        this.getModel().getTexture().bind();
        this.getModel().getModel().b6.render(Model.DEFAULT_SCALE);
        this.getModel().getModel().bladeLeft.render(Model.DEFAULT_SCALE);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 2.75F;
        OpenGL.scale(scale, scale, scale);
        OpenGL.translate(-0.375F, -0.25F, 0F);
        OpenGL.rotate(220F, 1F, 0F, 0F);
        OpenGL.rotate(-45F, 0F, 0F, 1F);
        GlStateManager.disableCull();
        this.getModel().getTexture().bind();
        this.getModel().getModel().b6.render(Model.DEFAULT_SCALE);
        this.getModel().getModel().bladeLeft.render(Model.DEFAULT_SCALE);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(-180F, 0F, 0F, 1F);
        OpenGL.translate(-0.3F, 0F, 0F);
        GlStateManager.disableCull();
        this.getModel().getTexture().bind();
        Model.draw(this.getModel().getModel().b6);
        Model.draw(this.getModel().getModel().bladeLeft);
    }
}
