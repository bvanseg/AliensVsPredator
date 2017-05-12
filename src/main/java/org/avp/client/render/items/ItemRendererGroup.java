package org.avp.client.render.items;

import org.lwjgl.opengl.GL11;

import com.arisux.mdxlib.lib.client.Model;
import com.arisux.mdxlib.lib.client.TexturedModel;
import com.arisux.mdxlib.lib.client.render.Draw;
import com.arisux.mdxlib.lib.client.render.ItemRenderer;
import com.arisux.mdxlib.lib.client.render.OpenGL;
import com.arisux.mdxlib.lib.game.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class ItemRendererGroup<MODEL extends Model> extends ItemRenderer<MODEL>
{
    private ModelRenderer[] modelRenderers;

    public ItemRendererGroup(TexturedModel<MODEL> model, ModelRenderer... modelRenderers)
    {
        super(model);
        this.modelRenderers = modelRenderers;
    }
    
    private ItemRendererGroup(TexturedModel<MODEL> model)
    {
        super(model);
    }

    public void renderPart()
    {
        OpenGL.blendClear();
        OpenGL.enable(GL11.GL_BLEND);
        OpenGL.disable(GL11.GL_CULL_FACE);
        this.getModel().bindTexture();
        Model.draw(this.modelRenderers);
    }

    public static void drawMarker(int size)
    {
        OpenGL.pushMatrix();
        Draw.drawRect(-(size / 2), 0, size, 1, 0xFFFF0000);
        OpenGL.rotate(90F, 0F, 0F, 1F);
        Draw.drawRect(-(size / 2), 0, size, 1, 0xFFFF0000);
        OpenGL.rotate(90F, 0F, 1F, 0F);
        OpenGL.translate(0F, 0F, 0.5F);
        Draw.drawRect(-(size / 2), 0, size, 1, 0xFFFF0000);
        OpenGL.popMatrix();
    }

    @Override
    public void renderThirdPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        this.renderPart();
    }

    @Override
    public void renderThirdPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        this.renderPart();        
    }

    @Override
    public void renderFirstPersonLeft(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        this.renderPart();        
    }

    @Override
    public void renderFirstPersonRight(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        this.renderPart();        
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate(45F, 0.0F, 1.0F, 0.0F);
        OpenGL.translate(0F, 0F, 2F);
        this.renderPart();
    }

    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
        this.renderPart();
    }
}
