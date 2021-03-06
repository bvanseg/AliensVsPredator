package org.power.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.Resources;
import org.power.client.model.tile.ModelPowercell;

public class RenderItemPowercell extends ItemRenderer<ModelPowercell>
{
    public RenderItemPowercell()
    {
        super(Resources.instance.models().POWERCELL);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, -1.1F, -0.5F);
        this.getModel().draw();
        Resources.instance.models().POWERCELL_LIQUID.draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(1F, 0F, 0.1F);
        OpenGL.rotate(45.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.disableCull();
        this.getModel().draw();
        Resources.instance.models().POWERCELL_LIQUID.draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.8F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.7F, 0.7F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 0F, 1F);
        OpenGL.rotate(90F + this.getIconRotation(), 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
        Resources.instance.models().POWERCELL_LIQUID.draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        GlStateManager.disableCull();
        this.getModel().draw();
        Resources.instance.models().POWERCELL_LIQUID.draw();
    }
}
