package org.avp.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.AVP;
import org.avp.client.Resources;
import org.avp.client.model.tile.ModelTurret;

public class RenderItemTurret extends ItemRenderer<ModelTurret>
{
    public RenderItemTurret()
    {
        super(Resources.instance.models().TURRET);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.9F;
        OpenGL.scale(glScale, -glScale, -glScale);
        OpenGL.translate(0F, -0.8F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.5F;
        OpenGL.scale(glScale, -glScale, -glScale);
        OpenGL.translate(0F, -1.6F, -0.5F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.9F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0.25F, 0.75F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(-135F, 0.0F, 1.0F, 0.0F);
        this.getModel().draw();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1.5F, 0F);
        GlStateManager.disableCull();
        this.getModel().draw();
    }
}
