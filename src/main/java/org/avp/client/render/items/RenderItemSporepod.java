package org.avp.client.render.items;

import org.avp.AliensVsPredator;
import org.avp.client.model.entities.ModelSporePod;

import com.arisux.mdx.lib.client.util.ItemRenderer;
import com.arisux.mdx.lib.client.util.OpenGL;
import com.arisux.mdx.lib.client.util.models.MapModelTexture;
import com.arisux.mdx.lib.client.util.models.Model;

import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSporepod extends ItemRenderer<ModelSporePod>
{
    private float              scale;
    private float              x;
    private float              y;
    private MapModelTexture<?> model;

    @SuppressWarnings("all")
    public RenderItemSporepod()
    {
        super(null);
        this.model = AliensVsPredator.resources().models().SPOREPOD.clone();
    }

    public RenderItemSporepod setX(float x)
    {
        this.x = x;
        return this;
    }

    public RenderItemSporepod setY(float y)
    {
        this.y = y;
        return this;
    }

    public RenderItemSporepod setScale(float scale)
    {
        this.scale = scale;
        return this;
    }

    public void renderCachedModel()
    {
        OpenGL.pushMatrix();
        OpenGL.scale(1F, -1F, 1F);
        OpenGL.translate(0F, -1F, 0F);
        OpenGL.rotate(180F, 0F, 0F, 1F);
        OpenGL.rotate(-45F, 0F, 1F, 0F);
        OpenGL.disableCullFace();
        this.model.draw();
        OpenGL.enableCullFace();
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        scale = 0.5F;
        OpenGL.translate(0F, 1.25F, 0.15F);
        OpenGL.scale(scale, -scale, scale);
        this.renderCachedModel();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        float scale = 1F;
        OpenGL.scale(scale, -scale, scale);
        OpenGL.translate(1.75F, -1.4F, -2F);
        OpenGL.rotate(60F, 0, 1, 0);
        this.renderCachedModel();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.translate(x * Model.DEFAULT_SCALE, y * -Model.DEFAULT_SCALE, 0F);
        OpenGL.translate(-0.125F, -1.6F, 0F);
        OpenGL.rotate(45F, 1.0F, 0.0F, 0.0F);
        this.renderCachedModel();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(180F, 0.0F, 0.0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1F, 0F);
        OpenGL.scale(0.25F, 0.25F, 0.25F);
        OpenGL.translate(0F, -2.5F, 0F);
        this.renderCachedModel();
    }
}
