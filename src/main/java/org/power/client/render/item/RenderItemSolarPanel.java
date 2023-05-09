package org.power.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.power.client.model.tile.ModelSolarPanel;

public class RenderItemSolarPanel extends ItemRenderer<ModelSolarPanel>
{
    public RenderItemSolarPanel()
    {
        super(Resources.instance.models().SOLAR_PANEL);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, -1.6F, -0.3F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(1.5F, -0.3F, 0.2F);
        OpenGL.rotate(45.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;
        OpenGL.scale(-glScale, -glScale, -glScale);
        OpenGL.rotate(135F, 1F, 0F, 0F);
        OpenGL.rotate(-25F, 0F, 0F, 1F);
        OpenGL.rotate(45F - this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        OpenGL.translate(0F, -1.45F, 0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(0, -1F, 0);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
