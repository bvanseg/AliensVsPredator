package org.avp.client.render.item;

import com.asx.mdx.client.render.OpenGL;
import com.asx.mdx.client.render.item.ItemRenderer;
import com.asx.mdx.client.render.model.MapModelTexture;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import org.avp.client.model.entity.ModelSupplyChute;
import org.avp.common.item.supply.chute.SupplyChuteType;

public class RenderItemSupplyCrate extends ItemRenderer<ModelSupplyChute>
{
    public RenderItemSupplyCrate()
    {
        super(null);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(-0.6F, -0.6F, 0.6F);
        OpenGL.translate(0F, -1F, -0.2F);
        GlStateManager.disableCull();

        MapModelTexture<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
        texturedModel.bindTexture();
        texturedModel.getModel().drawCrate();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 0.5F;
        OpenGL.scale(scale, -scale, scale);
        OpenGL.translate(0, -1.75F, 0.1F);
        GlStateManager.disableCull();

        MapModelTexture<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
        texturedModel.bindTexture();
        texturedModel.getModel().drawCrate();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.75F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, 0.75F, 0F);
        OpenGL.rotate(230F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);

        MapModelTexture<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
        texturedModel.bindTexture();
        texturedModel.getModel().drawCrate();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1.5F, 0F);
        GlStateManager.disableCull();

        MapModelTexture<ModelSupplyChute> texturedModel = SupplyChuteType.get(Block.getBlockFromItem(itemstack.getItem())).getModel();
        texturedModel.bindTexture();
        texturedModel.getModel().drawCrate();
    }
}
