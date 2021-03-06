package org.power.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.power.client.model.tile.ModelLightPanel;

public class RenderItemLightPanel extends ItemRenderer<ModelLightPanel>
{
    public RenderItemLightPanel()
    {
        super(Resources.instance.models().LIGHT_PANEL);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;

        OpenGL.translate(0F, 0.75F, -0.25F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.getModel().draw();
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
            GlStateManager.disableCull();
            OpenGL.scale(glScale, glScale, glScale);
            this.getModel().draw();
        }
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.65F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.7F, 0.65F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.disableCullFace();
        OpenGL.rotate(90F + this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.25F;
        OpenGL.scale(glScale, glScale, glScale);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
