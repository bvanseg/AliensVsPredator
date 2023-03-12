package org.avp.client.render.item;

import com.asx.mdx.lib.client.util.ItemRenderer;
import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSummoner extends ItemRenderer<Model>
{
    private float            scale;
    private float            x;
    private float            y;
    private MapModelTexture<?> model;

    @SuppressWarnings("all")
    public RenderItemSummoner(MapModelTexture<?> model)
    {
        super(null);
        this.model = model.clone();
    }

    public RenderItemSummoner setX(float x)
    {
        this.x = x;
        return this;
    }

    public RenderItemSummoner setY(float y)
    {
        this.y = y;
        return this;
    }

    public RenderItemSummoner setScale(float scale)
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
        float s = 0.5F;
        OpenGL.pushMatrix();
        OpenGL.rotate(195F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(180F, 0.0F, 1.0F, 0.0F);
        OpenGL.rotate(30F, 0.0F, 0.0F, 1.0F);
        OpenGL.translate(-0.5F, 0F, 0F);
        OpenGL.scale(s, s, s);
        this.renderCachedModel();
        OpenGL.popMatrix();
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        OpenGL.scale(scale, -scale, scale);
        OpenGL.translate(1.75F, -1.3F, -2F);
        OpenGL.rotate(60F, 0, 1, 0);
        this.renderCachedModel();
        OpenGL.popMatrix();
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        OpenGL.translate(x * Model.DEFAULT_SCALE, y * -Model.DEFAULT_SCALE, 0F);
        OpenGL.translate(0F, 0.9F, 0F);
        OpenGL.scale(scale * Model.DEFAULT_SCALE, scale * Model.DEFAULT_SCALE, scale * Model.DEFAULT_SCALE);
        OpenGL.rotate(45F, 1.0F, 0.0F, 0.0F);
        OpenGL.rotate(180F, 0.0F, 0.0F, 1.0F);
        OpenGL.rotate(90F, 0.0F, 1.0F, 0.0F);
        this.renderCachedModel();
        OpenGL.popMatrix();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        OpenGL.rotate(180F, 0.0F, 0.0F, 1F);
        OpenGL.rotate(90F, 0.0F, 1F, 0F);
        OpenGL.scale(0.25F, 0.25F, 0.25F);
        OpenGL.translate(0F, -2.5F, 0F);
        this.renderCachedModel();
        OpenGL.popMatrix();
    }
}
