package org.avp.client.render.items;

import org.avp.block.BlockSkull;

import com.arisux.mdx.lib.client.render.ItemRenderer;
import com.arisux.mdx.lib.client.render.OpenGL;
import com.arisux.mdx.lib.client.render.model.Model;

import net.minecraft.block.Block;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class RenderItemSkull extends ItemRenderer<Model>
{
    private BlockSkull skull;

    public RenderItemSkull()
    {
        super(null);
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.scale(0.35F, -0.35F, 0.35F);
        OpenGL.translate(0F, 0.75F, 0.25F);
        GlStateManager.disableCull();
        this.draw(itemstack.getItem());
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.25F;
        OpenGL.scale(glScale, -glScale, glScale);
        OpenGL.translate(0.5F, -0.25, 0.5F);
        GlStateManager.disableCull();
        this.draw(itemstack.getItem());
        GlStateManager.enableCull();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.6F;
        OpenGL.scale(glScale, glScale, glScale);
        OpenGL.translate(0F, -0.5F, 0F);
        OpenGL.rotate(200F, 1F, 0F, 0F);
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        this.draw(itemstack.getItem());
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float glScale = 0.53F;
        GlStateManager.disableCull();
        OpenGL.scale(glScale, -glScale, glScale);
        this.draw(itemstack.getItem());
    }

    private void draw(Item item)
    {
        if (this.skull == null)
        {
            this.skull = (BlockSkull) Block.getBlockFromItem(item);
        }

        if (skull.getSkullTexture() != null)
        {
            skull.getSkullTexture().bind();
        }

        skull.preRenderTransforms();

        for (ModelRenderer renderer : skull.getSkullModelRenderers())
        {
            renderer.render(Model.DEFAULT_SCALE);
        }
    }
}
