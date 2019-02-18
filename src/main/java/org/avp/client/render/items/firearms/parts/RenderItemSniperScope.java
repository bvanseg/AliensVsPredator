package org.avp.client.render.items.firearms.parts;

import org.avp.client.model.items.ModelSniper;
import org.avp.client.render.items.ItemRendererGroup;

import com.asx.mdx.lib.client.util.OpenGL;
import com.asx.mdx.lib.client.util.models.MapModelTexture;
import com.asx.mdx.lib.client.util.models.Model;
import com.asx.mdx.lib.util.Game;

import net.minecraft.client.model.ModelRenderer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;

public class RenderItemSniperScope extends ItemRendererGroup<ModelSniper>
{
    public RenderItemSniperScope(MapModelTexture<ModelSniper> model, ModelRenderer... modelRenderers)
    {
        super(model, modelRenderers);
    }

    @Override
    public void renderInInventory(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            float glScale = 38F * Model.DEFAULT_SCALE;
            OpenGL.rotate(45, 1F, 0F, 0F);
            OpenGL.scale(glScale, -glScale, glScale);
            OpenGL.rotate(45F, -1F, 1F, 0F);
            OpenGL.translate(0F, 0F, 0.1F);
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
    
    @Override
    public void renderInWorld(ItemStack itemstack, EntityLivingBase entity, TransformType cameraTransformType)
    {
        OpenGL.pushMatrix();
        {
            OpenGL.rotate((Game.minecraft().world.getWorldTime() + Game.partialTicks() % 360) * 10, 0.0F, 1.0F, 0.0F);
            GlStateManager.disableCull();
            this.renderPart();
        }
        OpenGL.popMatrix();
    }
}
