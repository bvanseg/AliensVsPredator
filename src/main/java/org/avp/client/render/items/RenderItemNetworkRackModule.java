package org.avp.client.render.items;

import org.avp.common.item.ItemNetworkRackModule;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.Model;

import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemNetworkRackModule extends ItemRenderer<Model>
{
    public RenderItemNetworkRackModule()
    {
        super(null);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 1F;

        OpenGL.rotate(10F, 0F, 0F, 1F);
        OpenGL.rotate(12F, 0F, 1F, 0F);
        OpenGL.translate(0.1F, -0.1F, 0F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.cacheModel(itemstack);
        this.getModel().draw();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.25F;
        OpenGL.translate(-0.2F, 0.5F, 0.2F);
        OpenGL.rotate(95.0F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(120.0F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(79.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.disableCull();
        OpenGL.scale(glScale, glScale, glScale);
        this.cacheModel(itemstack);
        this.getModel().draw();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0F, 1F, 0F);
        OpenGL.translate(0F, -0.25F, -0.25F);
        this.cacheModel(itemstack);
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1F, 0F);
        GlStateManager.disableCull();
        this.cacheModel(itemstack);
        this.getModel().draw();
    }

    private void cacheModel(ItemStack itemstack)
    {
        if (this.getModel() == null && itemstack != null && itemstack.getItem() instanceof ItemNetworkRackModule)
        {
            ItemNetworkRackModule module = (ItemNetworkRackModule) itemstack.getItem();
            // FIXME: Uncontrollable super typing, big no no.
//            this.model = module.getModel();
        }

        if (this.getModel() != null)
        {
            this.getModel().draw();
        }
    }
}
